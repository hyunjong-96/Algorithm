package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 카드짝맞추기 {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) {
		int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
		int r = 0;
		int c = 1;
		System.out.println(solution(board, r, c));
	}

	static int solution(int[][] board, int r, int c) {
		HashSet<Integer> cardSet = getCardSet(board);
		int[] cardArr = new int[cardSet.size()];
		int idx = 0;
		for (int card : cardSet) {
			cardArr[idx] = card;
			idx++;
		}
		List<String> orders = new ArrayList<>();
		setOrders(cardArr, 0, "", orders);

		int answer = Integer.MAX_VALUE;
		for (String order : orders) {
			Cursor cursor = new Cursor(c,r,0);
			int[][] copyBoard = copyBoard(board);
			for (char num : order.toCharArray()) {
				cursor = findPair(num - '0', cursor.x, cursor.y, cursor.count, copyBoard);
				cursor.count += 1;
				cursor = findCard(num - '0', cursor.x, cursor.y, cursor.count,copyBoard);
				cursor.count += 1;
			}
			answer = Math.min(cursor.count, answer);
		}
		return answer;
	}

	static Cursor findCard(int card, int x, int y, int count,int[][] board) {
		Queue<Cursor> queue = new LinkedList<>();
		boolean[][] visit = new boolean[4][4];
		board[y][x] = 0;
		queue.add(new Cursor(x, y, count));

		while (!queue.isEmpty()) {
			Cursor current = queue.poll();
			if (board[current.y][current.x] == card) {
				board[y][x] = 0;
				board[current.y][current.x] = 0;
				return current;
			}
			if (visit[current.y][current.x])
				continue;
			visit[current.y][current.x] = true;

			for (int i = 0; i < 4; i++) {
				Cursor moveCursor = move(current.x, current.y, i);
				if (moveCursor == null)
					continue;
				moveCursor.count += current.count;
				queue.add(moveCursor);
			}

			for (int i = 0; i < 4; i++) {
				Cursor moveCursor = ctrlMove(current.x, current.y, i, board);
				moveCursor.count += current.count;
				queue.add(moveCursor);
			}
		}

		return new Cursor(x,y,count);
	}

	static Cursor findPair(int card, int x, int y, int count,int[][] board) {
		Queue<Cursor> queue = new LinkedList<>();
		boolean[][] visit = new boolean[4][4];
		queue.add(new Cursor(x, y, count));

		while (!queue.isEmpty()) {
			Cursor current = queue.poll();

			if (board[current.y][current.x] == card)
				return current;
			if (visit[current.y][current.x])
				continue;
			visit[current.y][current.x] = true;

			for (int i = 0; i < 4; i++) {
				Cursor moveCursor = move(current.x, current.y, i);
				if (moveCursor == null)
					continue;
				moveCursor.count += current.count;
				queue.add(moveCursor);
			}

			for (int i = 0; i < 4; i++) {
				Cursor moveCursor = ctrlMove(current.x, current.y, i, board);
				moveCursor.count += current.count;
				queue.add(moveCursor);
			}
		}

		return new Cursor(x, y, count);
	}

	static Cursor ctrlMove(int x, int y, int direction, int[][] board) {
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		while (ny >= 0 && nx >= 0 && ny < 4 && nx < 4) {
			if (board[ny][nx] != 0)
				return new Cursor(nx, ny, 1);

			ny += dy[direction];
			nx += dx[direction];
		}
		return new Cursor(nx-dx[direction], ny-dy[direction], 1);
	}

	static Cursor move(int x, int y, int direction) {
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4) {
			return new Cursor(nx, ny, 1);
		}
		return null;
	}

	static void setOrders(int[] cardArr, int idx, String order, List<String> orders) {
		if (idx == cardArr.length) {
			orders.add(order);
			return;
		}

		for (int i = 0; i < cardArr.length; i++) {
			if (!order.contains("" + cardArr[i])) {
				setOrders(cardArr, idx + 1, order + cardArr[i], orders);
			}
		}
	}

	static HashSet<Integer> getCardSet(int[][] board) {
		HashSet<Integer> cardSet = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					cardSet.add(board[i][j]);
				}
			}
		}
		return cardSet;
	}

	static int[][] copyBoard(int[][] board) {
		int[][] copy = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

	static class Cursor {
		int x;
		int y;
		int count;

		public Cursor(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
