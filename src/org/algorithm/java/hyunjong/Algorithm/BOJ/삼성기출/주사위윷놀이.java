package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 주사위윷놀이 {
	static LinkedList<Node> board;
	static int[] numbers;
	static int answer;
	static Node root;

	static int[] orders;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		numbers = new int[10];
		orders = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		setBoard();

		permutation(0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void permutation(int depth) {
		if (depth >= 10) {
			answer = Math.max(answer, play());
			return;
		}

		for (int i = 0; i < 4; i++) {
			orders[depth] = i;
			permutation(depth + 1);
		}
	}

	static int play() {
		int sum=0;
		boolean[] status = new boolean[4];
		Node[] horses = new Node[4];

		for (int i = 0; i < 4; i++) {
			horses[i] = root;
			status[i] = true;
		}

		for (int i = 0; i < 10; i++) {
			int currentHours = orders[i];
			int move = numbers[i];

			Node current = horses[currentHours];

			Node moveResult;
			if (current.number == 10 || current.number == 20 || current.number == 30) {
				moveResult = current.moveNode(move, false);
				status[currentHours] = false;
			} else {
				moveResult = current.moveNode(move, status[currentHours]);
			}

			if (moveResult == null) {
				current.isVisit = false;
				continue;
			} else if (moveResult.isVisit) {
				sum = 0;
				break;
			} else {
				current.isVisit = false;
				moveResult.isVisit = true;
				sum += moveResult.number;
				horses[currentHours] = moveResult;
			}
		}

		for(int i=0;i<4;i++){
			horses[i].isVisit = false;
		}
		return sum;
	}

	static void setBoard() {
		board = new LinkedList<>();

		int num = 0;

		root = new Node(0);

		Node center = new Node(25);
		Node temp = center;
		Node last;
		num = 25;
		for (int i = 0; i < 3; i++) {
			num += 5;
			temp.addSubNode(new Node(num));
			temp = temp.subNext;
		}
		last = temp;

		Node start = root;
		num = 0;
		for (int i = 0; i <19; i++) {
			if (i == 5) {
				Node sub = start;
				for (int j = 1; j <= 3; j++) {
					sub.addSubNode(new Node(num + (j * 3)));
					sub = sub.subNext;
				}

				sub.addSubNode(center);
			} else if (i == 10) {
				Node sub = start;
				for (int j = 1; j <= 2; j++) {
					sub.addSubNode(new Node(num + (j * 2)));
					sub = sub.subNext;
				}
				sub.addSubNode(center);
			} else if (i == 15) {
				Node sub = start;
				int subNum = num - 1;
				for (int j = 1; j <= 3; j++) {
					sub.addSubNode(new Node(subNum - j));
					sub = sub.subNext;
				}
				sub.addSubNode(center);
			}

			num += 2;
			start.addNode(new Node(num));
			start = start.mainNext;
		}
		start.addNode(last);
	}

	static class Node {
		int number;
		Node mainNext;
		Node subNext;
		boolean isVisit;

		public Node(int number) {
			this.number = number;
			this.isVisit = false;
		}

		public void addNode(Node mainNext) {
			this.mainNext = mainNext;
		}

		public void addSubNode(Node subNext) {
			this.subNext = subNext;
		}

		public Node moveNode(int move, boolean isMain) {
			Node node = this;
			while (move-- > 0) {
				if (isMain) {
					node = node.mainNext;
				} else {
					node = node.subNext;
				}
				if (node == null)
					return null;
			}

			return node;
		}
	}
}
