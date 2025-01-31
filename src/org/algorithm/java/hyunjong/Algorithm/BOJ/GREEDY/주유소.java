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
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        long[] distances = new long[N-1];

        long[] sumDistance = new long[N-1];

        for(int i=0;i<N-1;i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        sumDistance[sumDistance.length-1] = distances[distances.length-1];
        for(int i= sumDistance.length-2;i>=0;i--){
            sumDistance[i] += sumDistance[i+1]+distances[i];
        }

        long[] costs = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        List<Cost> list = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            list.add(new Cost(i, costs[i], sumDistance[i]));
        }

        Collections.sort(list);

        Cost prev = list.get(0);
        long result = prev.cost * prev.distance;

        if(prev.idx != 0) {
            for(int i=1;i<list.size();i++){
                Cost current = list.get(i);

                if(current.idx == 0){
                    result += current.cost * (current.distance - prev.distance);
                    break;
                }

                if(prev.idx > current.idx) {
                    result +=current.cost * (current.distance - prev.distance);

                    prev = current;
                }

            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static class Cost implements Comparable<Cost>{
        int idx;
        long cost;
        long distance;

        public Cost(int idx, long cost, long distance) {
            this.idx = idx;
            this.cost = cost;
            this.distance = distance;
        }

        @Override
        public int compareTo(Cost c) {
            return (int)(this.cost - c.cost);
        }
    }
}
