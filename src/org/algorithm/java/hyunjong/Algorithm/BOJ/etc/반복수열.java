package org.algorithm.java.hyunjong.Algorithm.BOJ.etc;

import java.util.ArrayList;
import java.util.Scanner;

public class 반복수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(A);
		int currentElement = A;
		int findIndex;
		while(true) {

			/*각 자리수의 P제곱
			int tmp = arrayList.get(arrayList.size()-1);
			int result=0;
			while(tmp != 0){
				result += Math.pow(tmp%10,P);
				tmp /= 7;
			}
			일의 자리 숫자부터 P제곱을 하며 더해서 result에 들어감
			*/
			String[] nextElementArr = String.valueOf(currentElement).split("");
			int sum=0;
			for (String s : nextElementArr) {
				sum += Math.pow(Integer.parseInt(s),P);
			}

			findIndex = arrayList.indexOf(sum);
			if(findIndex != -1){
				System.out.println(findIndex);
				break;
			}
			arrayList.add(sum);
			currentElement = sum;
		}
	}
}
