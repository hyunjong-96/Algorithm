package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY
 * fileName       : 카약과강풍
 * author         : leehyunjong
 * date           : 2025/02/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/01        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 카약과강풍 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int result = S;


        int[] sArr = new int[S];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<S;i++){
            sArr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> more = new HashSet<>();
        int[] rArr = new int[R];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<R;i++){
            rArr[i] = Integer.parseInt(st.nextToken());
            more.add(rArr[i]);
        }

        //자신이 여분 카약이 있고 카약이 손상되어있는 경우 체크
        for(int i=0;i<sArr.length;i++) {
            if(more.contains(sArr[i])) {
                more.remove(sArr[i]);
                sArr[i] = -1;
                result--;
            }
        }

        List<Integer> moreList = new ArrayList<>(more);

        //손상된 카약이 빌릴 카약을 찾음
        for(int i=0;i<sArr.length;i++) {
            //스스로 해결한 경우 패스
            if(sArr[i] == -1) continue;

            for(int j=0;j<moreList.size();j++) {
                if(moreList.get(j) == sArr[i]-1 || moreList.get(j) == sArr[i]+1) {
                    //빌릴 카약을 찾았으면 다음이 빌릴수 없도록 제거
                    moreList.remove(j);
                    result--;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
