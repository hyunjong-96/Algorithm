package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.*;

public class 차집합{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        List<Integer> resultList = new ArrayList<>();

        int row = 0;
        int high = bArr.length-1;
        for(int i=0;i<A;i++) {
            int key = aArr[i];

            if(binarySearch(key, row, high, bArr)){
                resultList.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(resultList.isEmpty()){
            sb.append("0");
        }
        else {
            sb.append(resultList.size()).append("\n");

            for(int r : resultList) {
                sb.append(r).append(" ");
            }

            sb.deleteCharAt(sb.length()-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int key, int row, int high, int[] bArr) {

        while(row<=high) {
            int mid = (row+high) / 2;

            if(bArr[mid] == key) {
                return false;
            }
            else if(bArr[mid] < key) {
                row = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return true;
    }
}
