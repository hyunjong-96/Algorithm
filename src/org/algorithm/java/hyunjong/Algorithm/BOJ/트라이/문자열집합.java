package org.algorithm.java.hyunjong.Algorithm.BOJ.트라이;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

import java.io.*;
	import java.util.StringTokenizer;
	import java.util.Map;
	import java.util.HashMap;
public class 문자열집합{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		TrieNode root = new TrieNode();

		for(int i=0;i<N;i++){
			String word = br.readLine();
			insert(root, word);
		}

		int answer = 0;
		for(int i=0;i<M;i++){
			String word = br.readLine();
			if(isContains(root, word)) answer++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean isContains(TrieNode node, String word){

		for(int i=0;i<word.length();i++){
			char cur = word.charAt(i);
			if(node.childNode[cur-'a']==null) return false;
			node = node.childNode[cur-'a'];
		}

		return node.isEnd;
	}

	static void insert(TrieNode node, String word){
		for(int i=0;i<word.length();i++){
			char cur = word.charAt(i);
			if(node.childNode[cur-'a']==null){
				node.childNode[cur-'a'] = new TrieNode();
			}
			node = node.childNode[cur-'a'];
		}
		node.setEnd(true);
	}

	static class TrieNode{
		TrieNode[] childNode = new TrieNode[26];
		boolean isEnd;

		public TrieNode(){
		}

		public void setEnd(boolean end){
			this.isEnd = end;
		}
	}
}
