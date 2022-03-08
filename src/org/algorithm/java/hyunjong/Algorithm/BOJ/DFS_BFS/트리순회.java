package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 트리순회 {
	static int N;
	static int tree[][];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		tree = new int[N][3];
		sb = new StringBuilder();

		//각 문자들을 int타입으로 바꿔서 각 자리마다 저장해준다.(A=0, B=1, G=7)
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			int root = (st[0].charAt(0)) - 'A';
			int left = (st[1].charAt(0)) - 'A';
			int right = (st[2].charAt(0)) - 'A';
			tree[root][0] = root;
			tree[root][1] = left;
			tree[root][2] = right;
		}

		preorder(0);
		sb.append("\n");

		inorder(0);
		sb.append("\n");

		postorder(0);
		sb.append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void preorder(int y) {
		if (y == -19)	//.은 바이트코드를 -'A'해줬을때 -19가 나오므로 해당값이 나왔을때는 순회를 하지 않는다.
			return;

		sb.append((char)(tree[y][0] + 'A'));
		preorder(tree[y][1]);
		preorder(tree[y][2]);
	}

	private static void inorder(int y){
		if(y==-19) return;

		inorder(tree[y][1]);
		sb.append((char)(tree[y][0]+'A'));
		inorder(tree[y][2]);
	}

	private static void postorder(int y){
		if(y==-19) return;

		postorder(tree[y][1]);
		postorder(tree[y][2]);
		sb.append((char)(tree[y][0]+'A'));
	}
}
