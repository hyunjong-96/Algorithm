package org.algorithm.java.hyunjong.Algorithm.LinkedList;

public class LinkedListDigitSum {

	public void start(int a, int b){
		char[] convertStringA = this.charArr(a);
		char[] convertStringB = this.charArr(b);

		LinkedListNode lla = this.addCharNumber(convertStringA);
		LinkedListNode llb = this.addCharNumber(convertStringB);


	}

	private char[] charArr(int number){
		String convertToString = String.valueOf(number);
		return convertToString.toCharArray();
	}

	private LinkedListNode addCharNumber(char[] numberArray){
		LinkedListNode ll = new LinkedListNode();

		for(char number : numberArray){
			ll.append(number);
		}

		return ll;
	}
}
