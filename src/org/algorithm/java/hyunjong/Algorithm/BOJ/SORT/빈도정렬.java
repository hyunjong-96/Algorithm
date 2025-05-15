package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.SORT
 * fileName       : 빈도정렬
 * author         : leehyunjong
 * date           : 2025/05/14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/14        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 빈도정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> seqMap = new HashMap<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        List<Integer> seqList = new ArrayList<>();


        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());

            //숫자 처음 나온 위치
            if(!seqMap.containsKey(n)) {
                seqMap.put(n, i);
            }
            //숫자 빈도
            cntMap.put(n, cntMap.getOrDefault(n, 1)+1);

            seqList.add(n);
        }

        seqList.sort((n1,n2)-> {
           int result = 0;

           result = Integer.compare(cntMap.get(n2),cntMap.get(n1));

           if(result == 0) {
               result = Integer.compare(seqMap.get(n1), seqMap.get(n2));
           }

            return result;
        });

        StringBuilder sb = new StringBuilder();
        for(int n : seqList) {
            sb.append(String.valueOf(n)).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}
