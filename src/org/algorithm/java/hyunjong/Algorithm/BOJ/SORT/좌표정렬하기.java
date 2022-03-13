package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬하기 {
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		public String toString(){
			return this.x+" "+this.y;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.x != o.x){
				if(this.x < o.x) return -1;
				else return 1;
			}else{
				if(this.y < o.y) return -1;
				else return 1;
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Pair[] position = new Pair[N];
		for(int i=0;i<N;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();

			position[i] = new Pair(x,y);
		}

		Arrays.sort(position);

		for(Pair pair : position){
			System.out.println(pair.toString());
		}
	}
}
