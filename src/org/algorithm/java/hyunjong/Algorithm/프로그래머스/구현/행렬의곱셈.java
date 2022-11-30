package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

public class 행렬의곱셈 {
	public static void main(String[] args) {

	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int arr1R = arr1.length;
		int arr1C = arr1[0].length;
		int arr2R = arr1C;
		int arr2C = arr2[0].length;

		int[][] answer = new int[arr1R][arr2C];
		for(int r=0;r<arr1R;r++){
			for(int c=0;c<arr2C;c++){
				int sum = 0;
				for(int k=0;k<arr1C;k++){
					sum += arr1[r][k]*arr2[k][c];
				}
				answer[r][c] = sum;
			}
		}

		return answer;
	}
}
