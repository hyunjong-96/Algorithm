package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
import java.util.Set;
import java.util.HashSet;
public class 비밀번호발음하기{
	// 모음 여부를 O(1)로 찾기위한 set
	static Set<Character> vowel;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		vowel = new HashSet<>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');

		StringBuilder sb = new StringBuilder();

		while(true){
			String password = br.readLine();
			if(password.equals("end")) break;

			sb.append("<").append(password).append(">").append(" is ");
			if(isAcceptable(password)){
				sb.append("acceptable.");
			}else{
				sb.append("not acceptable.");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean isAcceptable(String password){
		boolean isVowelCheck = false;
		int continualVowelCount = 0;
		int continualConsonantCount = 0;
		for(int i=0;i<password.length();i++){
			char c = password.charAt(i);

			/*
			모음인 경우 조건1의 하나 이상의 모음을 만족했다는 isVowelCheck를 true로 갱신하고
			연속 자음 개수를 0으로 초기화하고 연속 모음 개수를 1개 추가해준다.
			이때 연속 모음 개수가 3개 이상이 된다면 not acceptable

			그리고 'o','e'를 제외하고 연속적으로 나올 수 없도록 확인한다.

			자음도 마찬가지로 연속 모음 개수를 0으로 초기화하고 연속 자음 개수를 1개 추가한다.
			연속 자음 개수가 3개 이상이라면 not acceptable.
			자음이 두개 연속으로 나온다면 not acceptable.
			 */
			if(isVowel(c)){
				isVowelCheck = true;
				continualConsonantCount = 0;
				continualVowelCount++;

				if(continualVowelCount >= 3) return false;

				if(isContinualChar(password, i, c)) return false;
			}else{
				continualVowelCount = 0;
				continualConsonantCount++;

				if(continualConsonantCount >= 3) return false;

				if(isContinualChar(password, i, c)) return false;
			}
		}

		return isVowelCheck;
	}

	static boolean isContinualChar(String password, int index, char c){
		if(index > 0 && (c != 'e' && c != 'o') && password.charAt(index-1) == c) return true;
		else if(index > 1 && (c == 'e' || c=='o')){
			if(password.charAt(index-1) == c && password.charAt(index-2) == password.charAt(index-1)) return true;
		}

		return false;
	}

	static boolean isVowel(char c){
		return vowel.contains(c);
	}
}
