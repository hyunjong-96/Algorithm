package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 이진검색트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node root = null;
		while (true) {
			String n = br.readLine();
			if(n == null || n.equals("")){
				break;
			}
			if(root == null) root = new Node(Integer.parseInt(n));
			else init(Integer.parseInt(n), root);
		}

		List<Integer> postOrder = new ArrayList<>();
		postOrder(root, postOrder);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<postOrder.size();i++){
			sb.append(postOrder.get(i));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void init(int input, Node current){
		if(current.left != null & input < current.num){
			init(input, current.left);
		}else if(current.right != null & input > current.num){
			init(input, current.right);
		}else if(current.left == null & input < current.num){
			current.left = new Node(input);
		}else if(current.right == null & input > current.num){
			current.right = new Node(input);
		}
	}

	static void postOrder(Node current, List<Integer> postOrder){
		if(current == null) return;

		postOrder(current.left, postOrder);
		postOrder(current.right, postOrder);
		postOrder.add(current.num);
	}

	static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
			this.left = null;
			this.right = null;
		}
	}
}
