package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
서로 다른 N개의 자연수의 합이 S가 되도록 할때, N의 최대값을 구하는 문제이다.
N의 갯수가 최대값을 가지려면 최대한 많은 수를 가져야하는데, 총 합을 구해야하기 때문에 최대한 작은 값들로 이루어진 합을 구하면 될것같았다.
작은 값들은 1에서 부터 +1씩 점진적으로 늘려나가는 작은수를 말한다.
작은 값들로 합을 구해나가다가 남은 수에서 작은 값을 빼었을때 뺴려고하는 작은 수의 값보다 작다면은 그 이전에 합했던 값이므로
결국 뺴려고하는 수보다 작은 결과로는 중복되는 N의 갯수가 되는것이다.
그렇기 때문에 해당 뺴려고하는 작은 수를 취소하고 그 바로 이전의 수에서 나오는 결괏값을 그대로 count해준다.
 */
public class 수들의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long S = Long.parseLong(br.readLine());

		long number = S;
		long count=0;
		for(long n=1;n<=S;n++){
			number -= n;
			count++;
			if(number<=n){
				break;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
