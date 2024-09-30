package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;

public class 전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = 300;
        int B = 60;
        int C = 10;

        int T = Integer.parseInt(br.readLine());

        int[] result = new int[3];

        result[0] = T/A;
        T %= A;

        result[1] = T/B;
        T %= B;

        result[2] = T/C;
        T %= C;

        StringBuilder sb = new StringBuilder();

        if(T == 0) {
            sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]);
        }
        else {
            sb.append("-1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
