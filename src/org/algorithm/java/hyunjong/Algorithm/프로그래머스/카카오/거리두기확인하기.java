package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

public class 거리두기확인하기 {
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] result = solution(places);
		for(int r : result){
			System.out.println(r);
		}
	}

	static char[][][] room = new char[5][5][5];
	static boolean[][][] visit = new boolean[5][5][5];
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	/*
	dfs를 이용해서 맨해튼 거리(|r1-r2| + |c1-c2|)가 2이하인 거리에 면접자가 한명이라도 있다면 0을 그렇지 않다면 1을 반환
	dfs조건에 파라미터로 받은 distance가 2일경우 조건을 넘어가는 경우이므로 1을 리턴해준다.
	상하좌우를 이용해 맨해튼거리 2이하인 곳을 방문하지 않고 파티션('X')인 곳 이외를 탐색하게 되는데
	이때 다음 좌표값이 'P'인 곳을 탐색하게 된다면 result값을 0으로 재선언 후 해당 반복문을 나가게된다.
	그리고 최초 dfs를 발생시키는 곳에서도 dfs의 값이 0이 나오게 된다면 더이상 탐색할 이유가 없기 떄문에 탐색을 중단하고
	answer 배열에 저장해준다.
	 */
	static int[] solution(String[][] places) {
		for (int i = 0; i < 5; i++) {
			String[] r = places[i];
			for (int j = 0; j < 5; j++) {
				char[] rArr = r[j].toCharArray();
				room[i][j] = rArr;
			}
		}

		int[] answer = new int[5];
		for (int r = 0; r < 5; r++) {
			int result = 1;
			for (int i = 0; i < 25; i++) {
				if (room[r][i / 5][i % 5] == 'P') {
					visit[r][i / 5][i % 5] = true;
					result = dfs(r, i / 5, i % 5, 0);
					visit[r][i / 5][i % 5] = false;
					if (result == 0)
						break;
				}
			}
			answer[r] = result;
		}
		return answer;
	}

	static int dfs(int roomNumber, int y, int x, int distance) {
		if (distance >= 2) {
			return 1;
		}

		int result = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visit[roomNumber][ny][nx]
				&& room[roomNumber][ny][nx] != 'X') {
				if(room[roomNumber][ny][nx] == 'P'){
					result = 0;
					break;
				}
				visit[roomNumber][ny][nx] = true;
				result = dfs(roomNumber, ny, nx, distance + 1);
				visit[roomNumber][ny][nx] = false;
			}
		}
		return result;
	}
}
