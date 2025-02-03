package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 주유소
 * author         : leehyunjong
 * date           : 2025/01/25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/01/25        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;

public class 주유소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] distances = new int[N-1];

        for(int i=0;i<N-1;i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] costs = new int[N];
        for(int i=0;i<N;i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        long[] sumDistances = new long[N-1];
        sumDistances[N-2] = distances[N-2];
        for(int i=N-3;i>=0;i--) {
            sumDistances[i] = sumDistances[i+1] + distances[i];
        }

        List<Costs> costList = new ArrayList<>();

        for(int i=0;i<N-1;i++){
            costList.add(new Costs(i, costs[i], sumDistances[i]));
        }

        Collections.sort(costList);

        Costs prev = costList.get(0);
        long result = prev.cost * prev.totalDistance;

        if(prev.idx != 0) {

            for(int i=1;i<N-1;i++) {
                Costs current = costList.get(i);

                if(current.idx < prev.idx) {
                    result += current.cost * (current.totalDistance - prev.totalDistance);

                    if(current.idx == 0) break;

                    prev = current;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
        static class Costs implements Comparable<Costs>{
            int idx;
            int cost;
            long totalDistance;

            public Costs(int idx, int cost, long totalDistance) {
                this.idx = idx;
                this.cost = cost;
                this.totalDistance = totalDistance;
            }

            @Override
            public int compareTo(Costs c) {
                return this.cost - c.cost;
            }
        }
}
