package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//2839
public class 설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while(N%5!=0){
			if(N<3){
				count = -1;
				break;
			}
			N-=3;
			count++;
		}
		if(count != -1){
			count+=N/5;
		}

		System.out.println(count);
	}
}
