package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
처음으로 골드 브루트포스, 구현 문제를 스스로 푼 문제라 감회가 깊다.(비록 시간은 걸렸지만)
사다리 게임의 세로선 간의 관계를 game[i][j]로 세로선 간의 가로선 여부를 game[i][j][r]로 구분하였다.
예를 들어 1번세로선과 2번세로선 간에 2번 가로선이 존재한다면 game[1][2][2]이 true이다.(i <= N, j <= N, r <= H)
함수는 가로선을 추가하는 함수와 i번 세로선이 i로 끝나는지 확인하는 함수로 구성하였다.
가로선을 추가하는 함수는 count와 세로선의 번호를 argument로 두어 count가 3이 될때까지 반복하여 백트래킹을 사용하였다.
각 가로선을 추가하고 3개 이하의 가로선일때 가로선을 추가하는 함수 실행시 해당 가로선을 가지고 i번 세로선이 i로 끝나는지 확인하는 함수를 호출하였다.
시간초과가 발생하지 않을까 생각했지만 최대(H*H*H)*(N*H)으로 생각되어 구현했다.((addRowLine함수 가로선을 추가하기 위한 경우의 수*3)*(checkResult함수 n^2)
res를 Integer.Max값으로 초기화 후 res값이 변함없다면 가로선 추가가 3이상을 초과하거나 불가능하므로 -1을 반환, 그렇지않다면 res반환.
 */
public class 사다리조작 {
	static boolean[][][] game;
	static int N;
	static int M;
	static int H;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		game = new boolean[N + 1][N + 1][H + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			game[c][c + 1][r] = true;
			game[c+1][c][r] = true;
		}

		res = Integer.MAX_VALUE;
		addRowLine(0, 1);
		//res값이 변함없다면 가로선 추가가 3보다 크거나 불가능하므로 -1반환.
		if(res == Integer.MAX_VALUE){
			res = -1;
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	//가로선 추가 함수
	static void addRowLine(int count, int colLine) {
		//가로선을 추가하지 않고도 완료 조건을 만족할수 있으므로 함수 시작때 체크
		if (checkResult()) {
			res = Math.min(res, count);
			return;
		}
		//가로선 추가가 3보다큰 경우는 없다.
		if (count >= 3) {
			return;
		}
		/*
		가로선을 추가할때 세로선보다는 같거나크고, 가로선보다는 커야하지만 세로선의 index가 커질경우 1부터 다시 세어야 하기 떄문에 세로선은 1부터.
		 */
		for (int c = colLine; c < N; c++) {
			for (int r = 1; r <= H; r++) {
				//기준 세로선에서 이전 세로선과 다음 세로선과의 가로선이 존재한다면 가로선을 추가할수 없다.
				if (game[c][c + 1][r] || game[c][c - 1][r])
					continue;
				/*
				기준 세로선이 N-1보다 작다면 기준세로선 다음 세로선의 가로선 여부를 확인하고
				기준 세로선의 다음 세로선이 가로선을 가지고 있다면 기준 세로선은 가로선을 가질수 없다.(핵심)
				 */
				if(c<N-1){
					if(game[c+1][c+2][r]) continue;
				}
				game[c][c + 1][r] = true;
				game[c+1][c][r] = true;
				addRowLine(count + 1, c);
				game[c][c + 1][r] = false;
				game[c+1][c][r] = false;
			}
		}
	}

	//i세로선이 출발해서 i세로선에서 끝나는지 확인하는 함수
	static boolean checkResult() {
		for (int i = 1; i <= N; i++) {
			//i번 세로선으로 출발해서 현재 이동해있는 세로선의 위치 c
			int c = i;
			for (int k = 1; k <= H; k++) {
				//출발 세로선이 오른쪽 맨끝 세로선이라면 이전 세로선과의 가로선 여부를 확인하고 c를 이전 세로선으로 이동하는 경우밖에 없음.
				if (c == N) {
					if (!game[c - 1][c][k])
						continue;
					c -= 1;
				}
				//출발 세로선이 왼쪽 맨끝 세로선이라면 다음 세로선과의 가로선 여부를 확인하고 c를 다음 세로선으로 이동하는 경우밖에 없음.
				else if(c == 1){
					if (!game[c][c + 1][k])
						continue;
					c += 1;
				}
				//둘다 아니라면 기준 세로선으로부터 왼쪽 세로선과 오른쪽 세로선과의 가로선 여부를 확인하고 c를 이동시켜줘야한다.
				else {
					if(game[c][c-1][k]){
						c-=1;
					}else if(game[c][c+1][k]){
						c+=1;
					}else{
						continue;
					}
				}
			}
			//이동할수 있는 가로 범위를 마쳤을때 c의 위치와 출발 위치(i)가 다르다면 조건을 만족하지 못하므로 false반환.
			if(c!=i) return false;
		}
		//모든 세로선에서의 도착세로선이 같다면 true반환.
		return true;
	}
}
