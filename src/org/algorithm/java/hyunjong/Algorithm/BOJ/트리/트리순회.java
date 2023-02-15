package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.*;
import java.util.StringTokenizer;

public class 트리순회 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Node[] tree = new Node[N];

		for (int i = 0; i < N; i++) {
			char alp = (char)('A' + i);
			tree[i] = new Node(alp);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char alp = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (left != '.') {
				tree[alp - 'A'].setLeft(tree[left - 'A']);
			}
			if (right != '.') {
				tree[alp - 'A'].setRight(tree[right - 'A']);
			}
		}

		Node root = tree[0];

		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		sb.append("\n");
		inorder(root, sb);
		sb.append("\n");
		postorder(root, sb);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void postorder(Node node, StringBuilder sb) {
		if (node == null)
			return;

		postorder(node.left, sb);
		postorder(node.right, sb);
		sb.append(node.alp);
	}

	static void inorder(Node node, StringBuilder sb) {
		if (node == null)
			return;

		inorder(node.left, sb);
		sb.append(node.alp);
		inorder(node.right, sb);
	}

	static void preorder(Node node, StringBuilder sb) {
		if (node == null)
			return;

		sb.append(node.alp);
		preorder(node.left, sb);
		preorder(node.right, sb);
	}

	static class Node {
		char alp;
		Node left;
		Node right;

		public Node(char alp) {
			this.alp = alp;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}
