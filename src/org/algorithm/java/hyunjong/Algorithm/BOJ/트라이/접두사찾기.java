package org.algorithm.java.hyunjong.Algorithm.BOJ.트라이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 접두사찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		TrieNode root = new TrieNode();

		for(int i=0;i<N;i++){
			String n = br.readLine();

			setWord(root, n, 0);
		}

		int result = 0;
		for(int i=0;i<M;i++){
			String m = br.readLine();

			result = findWord(root, m, 0) ? result+1 : result;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static boolean findWord(TrieNode node, String m, int depth){
		if(node == null) return false;

		if(depth == m.length()-1) return true;

		char c = m.charAt(depth);
		return findWord(node.child[c-'a'], m, depth+1);
	}

	static void setWord(TrieNode node, String n, int index){
		if(index == n.length()) {
			return;
		}

		char c = n.charAt(index);
		node.child[c-'a'] = node.child[c-'a'] == null ? new TrieNode() : node.child[c-'a'];
		setWord(node.child[c-'a'], n, index+1);
	}

	static class TrieNode{
		TrieNode[] child;
		boolean isEnd;

		public TrieNode(){
			this.child = new TrieNode['z'-'a'+1];
			isEnd = false;
		}
	}
}