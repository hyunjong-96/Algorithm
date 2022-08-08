package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문자열에 _가 있다면 c++, 대문자가 있다면 java이다.
만약 맨앞,맨뒤, 2개 이상의 _가 있거나, 맨앞에 대문자가 있거나, _와 대문자가 한 문자열에 같이있다면 Error
 */
public class JavaVsCplusplus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		char[] cArr = new char[s.length()];
		for(int i=0;i<s.length();i++){
			cArr[i] = s.charAt(i);
		}

		StringBuilder sb = new StringBuilder();
		boolean isSuccess = true;
		boolean isCPlus = false;
		boolean isJava = false;
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];

			if(c=='_'){
				isCPlus = true;
				//맨뒤, 맨앞 _ : Error
				if(i == 0 || i == cArr.length-1){
					isSuccess = false;
					break;
				}

				char nextC = cArr[++i];
				//_ 다음 대문자 or _ : Error
				if(Character.isUpperCase(nextC) || nextC == '_'){
					isSuccess = false;
					break;
				}
				sb.append(Character.toUpperCase(nextC));
			}else if(Character.isUpperCase(c)){
				isJava = true;
				//맨앞 대문자 : Error
				if(i == 0){
					isSuccess = false;
					break;
				}
				sb.append("_").append(Character.toLowerCase(c));
			}else{
				sb.append(c);
			}
		}

		String answer = "";
		if(!isSuccess || (isJava && isCPlus)) answer = "Error!";
		else answer = sb.toString();


		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
