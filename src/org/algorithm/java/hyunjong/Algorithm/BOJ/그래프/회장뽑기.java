package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.그래프
 * fileName       : 회장뽑기
 * author         : leehyunjong
 * date           : 2025/02/12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/12        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 회장뽑기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] friends = new List[N+1];
        int[][] relations = new int[N+1][N+1];

        for(int i=1;i<N+1;i++) {
            Arrays.fill(relations[i], Integer.MAX_VALUE);
            friends[i] = new ArrayList<>();
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1) {
                break;
            }

            friends[a].add(b);
            friends[b].add(a);
        }

        for(int i=1;i<=N;i++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, 0});

            while(!queue.isEmpty()) {
                int[] q = queue.poll();
                int f = q[0];
                int r = q[1];

                if(relations[i][f] <= r) {
                    continue;
                }

                relations[i][f] = r;

                for(int friend : friends[f]) {
                    queue.offer(new int[]{friend, r+1});
                }
            }
        }

        int minRelation = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int h=1;h<=N;h++) {
            int maxR = 0;

            for(int i=1;i<=N;i++) {
                maxR = Math.max(maxR, relations[h][i]);
            }

            if(maxR < minRelation) {
                list = new ArrayList<>();
                list.add(h);
                minRelation = maxR;
            }
            else if(maxR == minRelation) {
                list.add(h);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minRelation).append(" ").append(list.size()).append("\n");

        for(int l : list) {
            sb.append(l).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}
