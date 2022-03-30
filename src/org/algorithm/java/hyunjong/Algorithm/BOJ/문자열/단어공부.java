package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

/*
문자열로 들어오는 알파벳을 소문자로 변경한다.
참고로 아스키코드로 A : 65, a : 97
길이 26인 배열의 index 0에는 a를 25에는 z의 갯수를 넣어준다.
반복문을 사용해서 해당 알파벳의 갯수보다 많은 알파벳이 있다면 index, value를 저장하고, flag를 false
현재 최대갯수와 같은 알파벳이 있다면 flag를 true로 변경해준다.
flag가 true로 유지되어있을 시 최대 갯수의 알파벳이 중복되는 것이므로 '?'를
flag가 false로 유지되어있다면 index+'A'을 통해 대문자를 출력
 */
public class 단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine().toLowerCase(Locale.ROOT);
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int numC = c - 'a';
			arr[numC]++;
		}

		int index = -1;
		int value = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if(value < arr[i]){
				value = arr[i];
				index = i;
				flag = false;
			}else if(value == arr[i]){
				flag = true;
			}
		}

		char indexString;
		if(flag){
			indexString = '?';
		}else{
			indexString = (char)(index+'A');
		}
		// for (int i=0;i<arr.length; i++) {
		// 	if (index != i && value == arr[i]) {
		// 		indexString = '?';
		// 		break;
		// 	}
		// }
		bw.write(indexString);
		bw.flush();
		bw.close();
	}
}
