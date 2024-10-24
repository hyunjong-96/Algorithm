package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;
import java.io.*;
import java.util.*;
public class pipelined {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = (N-1) + arr[N-1];
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
