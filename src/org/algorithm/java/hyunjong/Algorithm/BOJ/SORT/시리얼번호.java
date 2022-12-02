package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class 시리얼번호{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Guitar> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			list.add(new Guitar(br.readLine()));
		}
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			sb.append(list.get(i).guitar).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class Guitar implements Comparable<Guitar>{
		String guitar;
		int sum;
		int size;
		public Guitar(String guitar){
			this.guitar = guitar;
			this.sum = getSum(guitar);
			this.size = guitar.length();
		}

		private int getSum(String guitar){
			int sum=0;
			for(int i=0;i<guitar.length();i++){
				if(guitar.charAt(i)>='0' && guitar.charAt(i)<='9'){
					sum += guitar.charAt(i)-'0';
				}
			}
			return sum;
		}

		@Override
		public int compareTo(Guitar o){
			int result = this.size - o.size;

			if(result == 0){
				result = this.sum - o.sum;

				if(result == 0){
					result = this.guitar.compareTo(o.guitar);
				}
			}

			return result;
		}
	}
}
