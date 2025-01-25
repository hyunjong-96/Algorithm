package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 뒤집기
 * author         : leehyunjong
 * date           : 2025/01/25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/01/25        leehyunjong       최초 생성
 */
import java.io.*;
public class 뒤집기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = 0;
        if(s.length() != 0) {
            int[] arr = new int[2];
            char prev = s.charAt(0);
            int idx = Integer.parseInt(String.valueOf(prev));

            arr[idx]++;
            for(int i=1;i<s.length();i++){
                char current = s.charAt(i);

                if(prev != current) {
                    idx = Integer.parseInt(String.valueOf(current));
                    arr[idx]++;
                    prev = current;
                }
            }

            result = Math.min(arr[0],arr[1]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
