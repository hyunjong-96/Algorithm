package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 플레이페어암호 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String message = br.readLine();
		String key = br.readLine();

		char[][] keyBoard = new char[5][5];
		int[][] alphaPos = new int[27][2];

		Set<Character> useAlpha = new HashSet<>();

		init(key, keyBoard, alphaPos, useAlpha);

		Deque<Character> messageQueue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			messageQueue.offerLast(message.charAt(i));
		}

		while (!messageQueue.isEmpty()) {
			char first = messageQueue.pollFirst();

			char second = 'X';
			if (!messageQueue.isEmpty()) {
				second = messageQueue.pollFirst();

				if (first == second) {
					messageQueue.offerFirst(second);
					second = first == 'X' ? 'Q' : 'X';
				}

			}
			int firstY = alphaPos[first - 'A'][0];
			int firstX = alphaPos[first - 'A'][1];
			int secondY = alphaPos[second - 'A'][0];
			int secondX = alphaPos[second - 'A'][1];

			if (firstY == secondY) {
				sb.append(keyBoard[firstY][(firstX + 1) % 5]);
				sb.append(keyBoard[secondY][(secondX + 1) % 5]);
			} else if (firstX == secondX) {
				sb.append(keyBoard[(firstY + 1) % 5][firstX]);
				sb.append(keyBoard[(secondY + 1) % 5][secondX]);
			} else {
				sb.append(keyBoard[firstY][secondX]);
				sb.append(keyBoard[secondY][firstX]);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void init(String key, char[][] keyBoard, int[][] alphaPos, Set<Character> useAlpha) {
		int y = 0;
		int x = 0;

		for (int i = 0; i < key.length(); i++) {
			char k = key.charAt(i);
			int pos = k - 'A';

			if(useAlpha.contains(k)) continue;

			keyBoard[y][x] = k;
			alphaPos[pos][0] = y;
			alphaPos[pos][1] = x;

			useAlpha.add(k);

			x = (x + 1) % 5;
			y = (x == 0) ? y + 1 : y;
		}

		int keyCount = 25 - useAlpha.size();
		char alphabet = 'A';
		while (keyCount != 0) {
			if (useAlpha.contains(alphabet) || alphabet == 'J') {
				alphabet = (char)(alphabet + 1);
				continue;
			}
			int pos = alphabet - 'A';
			alphaPos[pos][0] = y;
			alphaPos[pos][1] = x;
			keyBoard[y][x] = alphabet;

			x = (x + 1) % 5;
			y = (x == 0) ? y + 1 : y;
			alphabet = (char)(alphabet+1);
			keyCount--;
		}
	}
}