package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 체인
 * author         : leehyunjong
 * date           : 2025/02/02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/02        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 체인 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] chains = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            chains[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        //체인 길이를 오름차순으로 정렬한 값을 저장
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.sort(chains);
        for(int chain : chains) {
            dq.offer(chain);
        }

        //길이가 가장 작은 체인
        int temp = dq.pollFirst();

        /*
        가장 작은 체인을 하나 뺸 후 가장 큰 체인(dq의 last)에 걸어준다.
        걸었다는 의미는 그 다음으로 큰 체인과 연결해주는 의미.
        그렇기 때문에 dq에 하나가 남을때까지 작은 체인들을 빼주는 것을 반복
         */
        while(dq.size() > 1) {
            result++;
            temp--;
            dq.pollLast();

            if(temp == 0) {
                temp = dq.pollFirst();
            }
        }

        //temp가 남았다면 dq에 남은 마지막 체인과 연결해야하기 때문에 +1
        //이때 dq가 남아있지 않다면 마지막 남은 체인이 temp이 된것이기 때문에 조건문에 추가
        if(!dq.isEmpty() && temp > 0) {
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
