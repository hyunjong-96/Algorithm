package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 한줄로서기
 * author         : leehyunjong
 * date           : 2025/01/31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/01/31        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 한줄로서기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] counts = new int[N];

        for(int i=0;i<N;i++){
            counts[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for(int i=N-1;i>=0;i--) {
            int count = counts[i];

            if(count == 0) {
                stack.push(i);
            }
            else {
                int cnt = 0;
                while(!stack.isEmpty()) {
                    int f = stack.pop();
                    temp.push(f);
                    if(f > i) {
                        cnt++;
                    }

                    if(cnt >= count) {
                        stack.push(i);
                        while(!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop()+1).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}
