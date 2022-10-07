package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 빙고 {
	static int[][] widthCheck = {{0,2},{1,2},{2,2},{3,2},{4,2}};
	static int[][] lengthCheck = {{2,0},{2,1},{2,2},{2,3},{2,4}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] board = new int[5][5];
		Map<Integer, int[]> pos = new HashMap<>();
		List<Integer> callNumber = new ArrayList<>();
		boolean[][] check = new boolean[5][5];

		for(int i=0;i<5;i++){
			String[] row = br.readLine().split(" ");
			for(int j=0;j<5;j++){
				int n = Integer.parseInt(row[j]);

				board[i][j] = n;
				pos.put(n, new int[]{i,j});
			}
		}

		int answer = 1;
		for(int i=0;i<5;i++){
			String[] row = br.readLine().split(" ");
			for(int j=0;j<5;j++){
				int n = Integer.parseInt(row[j]);

				callNumber.add(n);
			}
		}

		for(int num : callNumber){
			if(pos.containsKey(num)){
				int[] p = pos.get(num);
				check[p[0]][p[1]] = true;
				if(checkBingo(check)) break;
			}
			answer++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	/*
	lengthCheck 배열 (0,2),(1,2),(2,2),(3,2),(4,2)는 가로 빙고여부를 파악한다.
	widthCheck 배열 (2,0),(2,1),(2,2),(2,3),(2,4)는 세로 빙고여부를 파악한다.
	(2,2)는 대각선 2개의 빙고여부를 파악한다.

	3개의 빙고 체크 과정을 거쳐 3개 이상의 빙고가 나오게된다면 해당 차례를 반환한다.
	 */
	static boolean checkBingo(boolean[][] check){
		int count = 0;

		count += checkLength(check);
		count += checkWidth(check);
		count += checkCross(check);

		return count >= 3;
	}

	static int checkLength(boolean[][] check){
		int count = 0;
		for(int i=0;i<5;i++){
			int[] checkPos = lengthCheck[i];
			int y = checkPos[0];
			int x = checkPos[1];

			if(check[y-2][x] && check[y-1][x] && check[y][x] && check[y+1][x] && check[y+2][x]) count++;
		}
		return count;
	}

	static int checkWidth(boolean[][] check){
		int count = 0;
		for(int i=0;i<5;i++){
			int[] checkPos = widthCheck[i];
			int y = checkPos[0];
			int x = checkPos[1];

			if(check[y][x-2] && check[y][x-1] && check[y][x] && check[y][x+1] && check[y][x+2]) count++;
		}
		return count;
	}

	static int checkCross(boolean[][] check){
		int count = 0;

		if(check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) count++;
		if(check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) count++;

		return count;
	}
}
