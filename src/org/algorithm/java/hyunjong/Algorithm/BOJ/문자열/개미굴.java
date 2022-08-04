package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
Trie는 여러개의 문자열에서 많은 양의 텍스트정보를 빠르고 효율적으로 검색하기 위해 사용
Map<Character, TrieNode> childNode를 사용한다.
해당 문제에서는 Map<String, TrieNode> childNode를 사용했다.
 */
public class 개미굴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		TrieNode rootNode = new TrieNode();

		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] fruits = new String[K];

			for(int i=0;i<K;i++){
				fruits[i] = st.nextToken();
			}

			rootNode.insert(fruits);
		}

		StringBuilder sb = new StringBuilder();

		print(rootNode, 1, sb);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class TrieNode{
		//현재 층의 노드들
		//현재 층의 노드들은 출력시 사전순으로 출력되야하므로 treeMap을 통해 key 오름차순으로 정렬한다.
		TreeMap<String, TrieNode> childNodes = new TreeMap<>();

		//자식 노드 추가
		public void insert(String[] fruits){
			TrieNode currentNode = this;
			for(String fruit : fruits){
				//추가하려는 자식 노드가 childNodes에 없다면 새로운 value추가
				currentNode.childNodes.putIfAbsent(fruit, new TrieNode());
				//한쪽으로 계속 자식 노드를 따라 이동하기 때문에 다음 탐색할 노드는 자식노드의 childNode
				currentNode = currentNode.childNodes.get(fruit);
			}
		}
	}

	static void print(TrieNode currentNode, int depth, StringBuilder sb){
		//현재 층의 노드들을 탐색
		for(String fruit : currentNode.childNodes.keySet()){
			//층수마다 --가 추가되서 반환된다.
			for(int i=1;i<depth;i++){
				sb.append("--");
			}
			sb.append(fruit);
			sb.append("\n");

			//다음 층의 노드를 출력한다.
			//해당 노드에 자식 노드가 있다면 자식 노드먼저 출력해줘야한다.
			print(currentNode.childNodes.get(fruit), depth+1, sb);
		}
	}
}
