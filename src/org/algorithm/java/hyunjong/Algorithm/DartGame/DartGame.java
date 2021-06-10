package org.algorithm.java.hyunjong.Algorithm.DartGame;

public class DartGame {
	public int solution(String dartResult) {
		int answer = 0;
		int[] scoreArr = new int[3];
		int arrCount = 0;
		String tmp="";
		for (int i = 0; i < dartResult.length(); i++) {
			switch (dartResult.charAt(i)){
				case '*':
					if(arrCount<2) scoreArr[arrCount-1]*=2;
					else{
						scoreArr[arrCount-2]*=2;
						scoreArr[arrCount-1]*=2;
					}
					break;
				case '#':
					scoreArr[arrCount-1]*=-1;
					break;
				case 'S':
					scoreArr[arrCount] = (int)Math.pow(Integer.parseInt(tmp),1);
					arrCount++;
					tmp="";
					break;
				case 'D':
					scoreArr[arrCount] = (int)Math.pow(Integer.parseInt(tmp),2);
					arrCount++;
					tmp="";
					break;
				case 'T':
					scoreArr[arrCount] = (int)Math.pow(Integer.parseInt(tmp),3);
					arrCount++;
					tmp="";
					break;
				default:
					tmp += String.valueOf(dartResult.charAt(i));
					break;
			}
		}
		for (int i : scoreArr) {
			answer += i;
		}
		return answer;
	}
}
