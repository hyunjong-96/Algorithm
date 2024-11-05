package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;
import java.io.*;
import java.util.*;
public class FlymetotheAplhaCentauri {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y-x;
            int n = (int) Math.sqrt(distance);

            if(n*n == distance) {
                sb.append(2*n-1);
            }
            else if(n*n+n < distance) {
                sb.append(2*n+1);
            }
            else if(n*n+n >= distance) {
                sb.append(2*n);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
