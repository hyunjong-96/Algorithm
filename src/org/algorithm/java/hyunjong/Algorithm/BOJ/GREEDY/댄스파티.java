package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 댄스파티
 * author         : leehyunjong
 * date           : 2025/02/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/03        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 댄스파티 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusManQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> minusManQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> plusWomanQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> minusWomanQueue = new PriorityQueue<>(Comparator.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        /*
        -남자는 +여자와 만날수 있고 +남자는 -여자를 만날 수 있다.
        -인 사람은 내림차순 (-1, -2, -3 ...)으로 정렬한다.
        +인 사람은 오름차순 (1, 2, 3 ..)으로 정렬한다.
        깔끔한 정렬을 위해 우선순위큐를 사용한다.
         */
        for(int i=0;i<N;i++){
            int m = Integer.parseInt(st.nextToken());

            if(m > 0) {
                plusManQueue.offer(m);
            }
            else {
                minusManQueue.offer(m);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            int w = Integer.parseInt(st.nextToken());

            if(w > 0) {
                plusWomanQueue.offer(w);
            }
            else {
                minusWomanQueue.offer(w);
            }
        }

        int result = 0;

        /*
        +남자는 -여자와 비교한다.
        +남자 >= -여자인 경우 다음 여자를 확인한다. (이 이후의 남자는 모두 남자 > 여자 이기 때문에 남자 < 여자가 되기 위해 다음 여자를 확인해야한다.)
        +남자 < -여자인 경우 남여가 매칭된다. 남,여 모두를 빼고 다음 남자를 확인한다.
         */
        while(!plusManQueue.isEmpty()) {
            int m = Math.abs(plusManQueue.poll());

            while(!minusWomanQueue.isEmpty()) {
                int w = Math.abs(minusWomanQueue.peek());

                if(m >= w) {
                    minusWomanQueue.poll();
                    continue;
                }
                else {
                    minusWomanQueue.poll();
                    result++;
                    break;
                }
            }
        }

        /*
        -남자는 +여자와 비교한다.
        -남자 > +여자 인 경우 남자와 여자가 매칭된다. 남,여 모두를 빼고 다음 남자를 확인한다.
        -남자 <= +여자 인 경우 다음 남자를 확인한다. (이 이후의 여자는 모두 남자 < 여자 이기 때문에 남자 > 여자가 되기 위해 다음 남자를 확인해야한다.)
         */
        while(!minusManQueue.isEmpty()) {
            int m = Math.abs(minusManQueue.poll());

            while(!plusWomanQueue.isEmpty()) {
                int w = Math.abs(plusWomanQueue.peek());

                if(m <= w) {
                    break;
                }
                else {
                    plusWomanQueue.poll();
                    result++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    }
}
