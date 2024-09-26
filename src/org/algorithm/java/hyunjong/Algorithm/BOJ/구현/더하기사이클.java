package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;

public class 더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] comNum = new int[2];


        String stringNum = String.valueOf(N);
        if(N < 10) {
            comNum[0] = 0;
            comNum[1] = Integer.parseInt(String.valueOf(stringNum.charAt(0)));
        }
        else {
            comNum[0] = Integer.parseInt(String.valueOf(stringNum.charAt(0)));
            comNum[1] = Integer.parseInt(String.valueOf(stringNum.charAt(1)));
        }

        int count = 0;

        int[] num = new int[2];
        num[0] = comNum[0];
        num[1] = comNum[1];
        int result = recursive(num, count, comNum);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int recursive(int[] num, int count, int[] comNum) {
        count++;

        int a = num[0];
        int b = num[1];

        int s = a+b;

        String stringNum = String.valueOf(s);

        num[0] = b;
        if(s<10) {
            num[1] = Integer.parseInt(String.valueOf(stringNum.charAt(0)));
        }
        else {
            num[1] = Integer.parseInt(String.valueOf(stringNum.charAt(1)));
        }

        if(comNum[0] == b && comNum[1] == num[1]) {
            return count;
        }

        return recursive(num, count, comNum);
    }
}
