package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static int R;
	static int C;
	static int T;
	static int[][] room;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int[][] machine;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		machine = new int[2][2];
		room = new int[R][C];

		boolean machineCheck = false;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == -1) {
					if (!machineCheck) {
						machine[0][0] = r;
						machine[0][1] = c;
						machineCheck = true;
					} else {
						machine[1][0] = r;
						machine[1][1] = c;
					}
				}
			}
		}

		while (T-- > 0) {
			spreadDust();
			cleanUp();
		}

		int answer = 0;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(room[i][j] != 0 && room[i][j] != -1){
					answer+=room[i][j];
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void spreadDust() {
		int[][] spreadDustSum = new int[R][C];
		List<int[]> dustList = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {

				if (room[r][c] != 0 && room[r][c] != -1) {
					int spreadCount = 0;
					for (int i = 0; i < 4; i++) {
						int ny = r + dy[i];
						int nx = c + dx[i];

						if (ny >= 0 && nx >= 0 && ny < R && nx < C && room[ny][nx] != -1) {
							spreadDustSum[ny][nx] += room[r][c] / 5;
							spreadCount++;
						}
					}
					dustList.add(new int[]{r,c,spreadCount});
					// room[r][c] = room[r][c] - (room[r][c] / 5) * spreadCount;
				}
			}
		}

		for(int[] d : dustList){
			int y = d[0];
			int x = d[1];
			int count = d[2];
			room[y][x] = room[y][x] - (room[y][x]/5)*count;
		}
		for(int r=0;r<R;r++){
			for(int c=0;c<C;c++){
				room[r][c] += spreadDustSum[r][c];
			}
		}
	}

	static void cleanUp() {
		//공기청정기 위
		int[] upPosition = machine[0].clone();
		int prevDust = 0;
		int tmp = 0;
		while(++upPosition[1] < C){
			tmp = room[upPosition[0]][upPosition[1]];
			room[upPosition[0]][upPosition[1]] = prevDust;
			prevDust = tmp;
		}
		upPosition[1]--;
		while(--upPosition[0] >= 0){
			tmp = room[upPosition[0]][upPosition[1]];
			room[upPosition[0]][upPosition[1]] = prevDust;
			prevDust = tmp;
		}
		upPosition[0]++;
		while(--upPosition[1] >= 0){
			tmp = room[upPosition[0]][upPosition[1]];
			room[upPosition[0]][upPosition[1]] = prevDust;
			prevDust = tmp;
		}
		upPosition[1]++;
		while(room[++upPosition[0]][upPosition[1]] != -1){
			tmp = room[upPosition[0]][upPosition[1]];
			room[upPosition[0]][upPosition[1]] = prevDust;
			prevDust = tmp;
		}

		int[] downPosition = machine[1].clone();
		//공기청정기 아래
		prevDust = 0;
		tmp = 0;
		while(++downPosition[1] < C){
			tmp = room[downPosition[0]][downPosition[1]];
			room[downPosition[0]][downPosition[1]] = prevDust;
			prevDust = tmp;
		}
		downPosition[1]--;
		while(++downPosition[0] < R){
			tmp = room[downPosition[0]][downPosition[1]];
			room[downPosition[0]][downPosition[1]] = prevDust;
			prevDust = tmp;
		}
		downPosition[0]--;
		while(--downPosition[1] >= 0){
			tmp = room[downPosition[0]][downPosition[1]];
			room[downPosition[0]][downPosition[1]] = prevDust;
			prevDust = tmp;
		}
		downPosition[1]++;
		while(room[--downPosition[0]][downPosition[1]] != -1){
			tmp = room[downPosition[0]][downPosition[1]];
			room[downPosition[0]][downPosition[1]] = prevDust;
			prevDust = tmp;
		}
	}
}
