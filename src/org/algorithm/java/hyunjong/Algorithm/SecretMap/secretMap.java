package org.algorithm.java.hyunjong.Algorithm.SecretMap;

public class secretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[][] binaryArr1 = new int[n][n];
		int[][] binaryArr2 = new int[n][n];

		for (int i = 0;i<n;i++) {
			binaryArr1[i] = convertToBinary(n, arr1[i]);
		}
		for (int i = 0;i<n;i++) {
			binaryArr2[i] = convertToBinary(n, arr2[i]);
		}

		for (int j = 0; j < n; j++) {
			String answerValue = "";
			for(int k = 0; k < n; k++){
				if(binaryArr1[j][k] == 0 && binaryArr2[j][k] == 0){
					answerValue+=" ";
				}else{
					answerValue+="#";
				}
			}
			answer[j] = answerValue;
		}

		return answer;
	}

	private int[] convertToBinary(int n, int arrValue) {
		int[] binaryValue = new int[n];

		while (true) {
			n--;
			if (arrValue < 2) {
				binaryValue[n] = arrValue;
				break;
			}
			binaryValue[n] = arrValue % 2;
			arrValue = arrValue / 2;
		}
		return binaryValue;
	}
}
