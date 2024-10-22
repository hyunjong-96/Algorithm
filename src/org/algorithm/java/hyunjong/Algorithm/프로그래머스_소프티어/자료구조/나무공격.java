package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.자료구조;

import java.io.*;
import java.util.*;

public class 나무공격 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken())-1;
        int m = Integer.parseInt(st.nextToken())-1;
        // System.out.println(n+" / "+m);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<=n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            map.put(i,0);

            for(int j=0;j<=m;j++){
                int p = Integer.parseInt(st.nextToken());
                if(p == 1) {
                    map.put(i,map.getOrDefault(i,0)+1);
                }
            }
        }
        // System.out.println("0 index : "+map.get(0));

        for(int i=0;i<2;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            // System.out.println(start+" / "+end);

            for(int j=start;j<=end;j++){
                // System.out.println(j);
                int p=map.get(j);

                if(p>0){
                    map.put(j,p-1);
                }
            }
        }

        int answer = 0;
        for(int cnt : map.keySet()){
            answer += map.get(cnt);
            // System.out.println(cnt+" - map : "+map.get(cnt));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
