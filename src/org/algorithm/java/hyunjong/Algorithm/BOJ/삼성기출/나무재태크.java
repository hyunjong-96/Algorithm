package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무재태크 {
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] soil;
	static int[][] add;
	static Queue<Tree> trees;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		soil = new int[N][N];
		add = new int[N][N];
		trees = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				soil[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			trees.offer(new Tree(x, y, z));
		}

		Collections.sort((List<Tree>)trees);
		while (K-- > 0) {
			springToSummer();
			fall();
			winter();
		}

		bw.write(String.valueOf(trees.size()));
		bw.flush();
		bw.close();
	}

	static void springToSummer() {
		Queue<Tree> dieTrees = new LinkedList<>();

		int treeSize = trees.size();
		for (int i = 0; i < treeSize; i++) {
			Tree currentTree = trees.poll();
			if (soil[currentTree.x][currentTree.y] - currentTree.age < 0) {
				dieTrees.offer(currentTree);
			} else {
				soil[currentTree.x][currentTree.y] -= currentTree.age;
				currentTree.age += 1;
				trees.offer(currentTree);
			}
		}

		for (Tree dieTree : dieTrees) {
			soil[dieTree.x][dieTree.y] += dieTree.age / 2;
		}
	}

	static void fall() {
		int treesSize = trees.size();
		for (int i = 0; i < treesSize; i++) {
			Tree tree = trees.poll();
			if (tree.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nx = tree.x + dx[j];
					int ny = tree.y + dy[j];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						trees.offer(new Tree(nx, ny, 1));
					}
				}
			}
			trees.offer(tree);
		}

		Collections.sort((List<Tree>)trees);
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				soil[i][j] += add[i][j];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int y;
		int x;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
}
