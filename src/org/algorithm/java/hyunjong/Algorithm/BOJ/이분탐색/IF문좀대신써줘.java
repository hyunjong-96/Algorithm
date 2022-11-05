package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class IF문좀대신써줘{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Power[] power = new Power[N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			power[i] = new Power(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(power);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			int userPower = Integer.parseInt(br.readLine());
			int index = binarySearch(power, userPower);

			if(index<N){
				sb.append(power[index].name).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int binarySearch(Power[] power, int userPower){
		int start = 0;
		int end = power.length;

		while(start<end){
			int mid = (start+end)/2;

			if(userPower>power[mid].power){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		return start;
	}

	static class Power implements Comparable<Power>{
		String name;
		int power;
		public Power(String name, int power){
			this.name = name;
			this.power = power;
		}

		@Override
		public int compareTo(Power o){
			return this.power - o.power;
		}
	}
}
