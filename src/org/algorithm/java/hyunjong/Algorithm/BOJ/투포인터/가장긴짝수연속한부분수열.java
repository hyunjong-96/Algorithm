package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int aCnt = 0;
        int bCnt = 0;
        while(right < N && bCnt<K) {
            if(arr[right]%2 == 0) {
                aCnt++;
            }
            else {
                bCnt++;
            }
            right++;
        }

        int result = twoPointer(K, N, left, right, aCnt, bCnt, arr);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int twoPointer(int K, int N, int left, int right, int aCnt, int bCnt, int[] arr) {
        int max = aCnt;

        while(right < N) {
//            right++;

            if(arr[right] % 2 == 0) {
                aCnt++;
                max = Math.max(max, aCnt);
            }
            else {
                bCnt++;

                while (bCnt > K) {
                    if (arr[left] % 2 == 0) {
                        aCnt--;
                    } else {
                        bCnt--;
                    }
                    left++;
                }
            }

            right++;
        }

        return max;
    }
}
