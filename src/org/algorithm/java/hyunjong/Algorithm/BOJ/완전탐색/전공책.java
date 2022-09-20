package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/*
첫번째 접근에서는 백트래킹으로 타겟 문자열을 index로 놓고 각 문제집에 해당 단어가 포함되어있다면 조합으로 만들어 최소값을 만들었다.
하지만 이 접근은 각 문제집의 단어 개수를 고려하지 않아서 반례가 있었다.

두번쨰 접근
전공책을 선택하는 모든 경우의 수(전공책 선택, 선택하지 않음)를 백트래킹으로 구현한다.
만들고자 하는 문자열의 각 문자 개수를 targetCount배열에 저장.
백트래킹을 통해 전공책을 선택하면서 해당 전공책의 각 문자 개수를 selectCount배열에 추가.
N개의 전공책을 모두 돌았을때 targetCount[i] > selectCount[i]를 만족하지 못한다면 선택된 문제집 조합으로는 목표 문자열을 만들수 없다.
모든 문자의 개수가 타겟 문자열의 문자 개수보다 많다면 만들 수 있기 때문에 최소 가격을 갱신해준다.

하나의 재귀에서 2개의 재귀를 만들기 때문에 시간복잡도 걱정을 했는데 다행이 돌아갔다.
N이 최대 16개라 무사했나보다.
 */
public class 전공책 {
	static int answer;
	static int[] targetCount;
	static int[] selectCount;
	static int N;
	static int[] prices;
	static String[] books;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String T = br.readLine();
		N = Integer.parseInt(br.readLine());
		books = new String[N];
		prices = new int[N];
		targetCount = new int[26];
		selectCount = new int[26];

		for(int i=0;i<T.length();i++){
			targetCount[T.charAt(i)-'A']++;
		}
		for(int i=0;i<N;i++){
			String[] info = br.readLine().split(" ");
			prices[i] = Integer.parseInt(info[0]);
			books[i] = info[1];
		}

		answer = Integer.MAX_VALUE;
		dfs(0,0);
		if(answer == Integer.MAX_VALUE) answer = -1;
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void dfs(int index, int total){
		//문제집 조합을 만들었을 경우 타겟 문자열의 문자 개수를 모두 충족한다면 최소 가격 갱신.
		if(index == N){
			if(check()){
				answer = Math.min(answer, total);
			}
			return;
		}

		//해당 문제집의 문자 개수를 추가해준다.
		for(int i=0;i<books[index].length();i++){
			selectCount[books[index].charAt(i)-'A']++;
		}
		dfs(index+1, total+prices[index]);
		for(int i=0;i<books[index].length();i++){
			selectCount[books[index].charAt(i)-'A']--;
		}
		//해당 문제집은 포함하지 않는 재귀
		//이전 문제집을 포함한 조합으로 해당 문제집을 뛰어넘고 다음 문제집을 재귀한다.
		dfs(index+1, total);
	}

	static boolean check(){
		for(int i=0;i<26;i++){
			if(targetCount[i] > selectCount[i]) return false;
		}
		return true;
	}

	// static void findLeastPrice(Set<Character>[] books, int[] prices, int index, int[] bookCount, String T, int N) {
	// 	if (index == T.length()) {
	// 		int sum = 0;
	// 		for(int i=0;i<N;i++){
	// 			if(bookCount[i] > 0){
	// 				sum += prices[i];
	// 			}
	// 		}
	// 		answer = Math.min(answer, sum);
	// 		return;
	// 	}
	//
	// 	for (int i = 0; i < N; i++) {
	// 		if (books[i].contains(T.charAt(index))) {
	// 			bookCount[i]++;
	// 			findLeastPrice(books, prices, index + 1, bookCount, T, N);
	// 			bookCount[i]--;
	// 		}
	// 	}
	// }
}
