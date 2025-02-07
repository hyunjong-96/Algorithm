package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 문자열복사
 * author         : leehyunjong
 * date           : 2025/02/07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/07        leehyunjong       최초 생성
 */
import java.io.*;
public class 문자열복사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String P = br.readLine();

        int result = 0;

        /*
        시간복잡도 = N*N
        P를 반복하면서 S에 단어가 포함되어있으면 포함된 만큼 P를 찾는 시작점을 이동하기 때문에 N*N

        S의 문자가 P에 최대한 길게 포함되어있는 것을 찾아야 copy함수를 최소한으로 사용할 수 있다.
        P에서 찾을 단어의 시작 인덱스를 i
        i부터 시작해서 S의 부분 문자열의 경우의 수를 찾는다. 이때 부분 문자열 중 길이가 가장 긴것을 기억하고 있는다.
        그리고 P의 문자를 찾는 시작점인 i를 그 길이만큼 더해서 다음 P의 시작점을 점프해서 시간을 단축시킨다.
         */
        int i=0;
        while(i < P.length()) {
            int maxLen = 0;

            for(int j=0;j<S.length();j++){
                int len = 0;

                while(i+len < P.length() && j+len < S.length() && P.charAt(i+len) == S.charAt(j+len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }

            result++;
            i += maxLen;
        }

        //다른 사람 풀이
        //S.indexOf에서 P의 부분문자열이 존재하는지 찾는데 약 N만큼을 사용하기 때문에 N*N의 시간복잡도를 가진다.
//        int idx = 0;
//        for (int i = 0; i < P.length(); i++) {
//            if (S.indexOf(P.substring(idx, i+1)) != -1) continue;
//            result++;
//            idx = i;
//        }
//        result+=1;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
