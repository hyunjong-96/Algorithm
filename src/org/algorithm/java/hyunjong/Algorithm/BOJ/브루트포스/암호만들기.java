package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 암호만들기 {
	static int L;
	static int C;
	static char[] words;
	static PriorityQueue<String> passwords;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		words = new char[C];
		passwords = new PriorityQueue<>();
		visit = new boolean[C];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<C;i++){
			words[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(words);
		findPassword(0, "", 0);

		StringBuilder sb = new StringBuilder();

		for (String pw : passwords) {
			if (checkPassword(pw)) {
				sb.append(pw);
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean checkPassword(String pw){
		int vowelCount=0;
		int total = pw.length();

		char[] p = pw.toCharArray();
		for(char c : p){
			if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
				vowelCount++;
			}
		}

		return vowelCount >= 1 && total - vowelCount >= 2;
	}

	static void findPassword(int count, String pw, int idx){
		if(count == L){
			passwords.offer(pw);
			return;
		}

		for(int i=idx;i<C;i++){
			if(!visit[i]){
				visit[i] = true;
				findPassword(count+1, pw+words[i],i+1);
				visit[i] = false;
			}
		}
	}
}
