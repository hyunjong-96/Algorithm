package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProjectTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] students = new int[N*2];
        for(int i=0;i<N*2;i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int j = (2*N)-1-i;

            min = Math.min(students[i]+students[j], min);
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
