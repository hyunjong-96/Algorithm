package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int max;
	static int monsters;

	static int[] dy = {0,-1,0};
	static int[] dx = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i][j] = e;
				if (e == 1)
					monsters++;
			}
		}

		max = 0;
		setBow(new boolean[M], 0, 0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	/*
	3명의 궁수가 배치되었을 때 각 궁수의 x좌표를 가지고 몬스터가 map에서 사라질 때까지 몬스터를 잡는다.
	순서는
	1. 3명의 궁수가 bfs를 통해 D이내에 있으면서 가장 가까운 몬스터를 찾아서 잡았다면 true를 반환하여 count+1을 해준다.
		이때 궁수가 중복되는 몬스터를 잡았다면 false를 반환하게되고 어떤 몬스터도 잡지못했을때도 false를 반환하여 count에 영향을 주지않는다.
	2. 모든 몬스터를 y축으로 한칸 움직인다.
	3. 살아남은 몬스터의 개수를 구하다.

	좌표의 크기가 최대 15*15이기 때문에 몬스터를 이동시키는 경우(최대 15)에서 copyMap이 가능한것같다.
	 */
	static int start(boolean[] pos) {
		int monstersCount = monsters;

		int[][] playMap = copyMap(map);
		int[] bow = new int[3];
		int idx = 0;
		for (int i = 0; i < M; i++) {
			if (pos[i]) {
				bow[idx++] = i;
			}
		}
		int count = 0;
		while (monstersCount > 0) {
			int[][] copyMap = copyMap(playMap);
			for (int b = 0; b < 3; b++) {
				int bowPosition = bow[b];
				if(killMonster(copyMap, playMap, bowPosition)) count++;
			}

			playMap = moveMonster(copyMap);
			monstersCount = countMonster(playMap);
		}

		return count;
	}

	/*
	백트래킹을 통해 3명의 궁수를 배치한 경우의 수에서 가장 많은 몬스터를 잡은 경우를 찾는다.
	 */
	static void setBow(boolean[] pos, int idx, int count) {
		if (count == 3) {
			int catches = start(pos);
			max = Math.max(catches, max);
			return;
		}

		for (int i = idx; i < M; i++) {
			pos[i] = true;
			setBow(pos, i + 1, count + 1);
			pos[i] = false;
		}
	}

	/*
	몬스터와의 거리가 D이하이고 가장 가까우면서, 거리가 같을 때 왼쪽을 잡아야하기 때문에
	bfs로 왼,위,오른쪽 방향으로 이동하면서 D이하의 좌표를 모두 탐색한다.
	이때 특정 좌표에 몬스터가 있을때 copyMap이 1이라면(다른 궁수에 의해 잡히지 않았다면) true를 반환해 몬스터를 잡았다고 표시
	만약 copyMap이 0이라면 이미 잡힌 몬스터이기 때문에 false를 반환하여 count에 영향을 받지 않도록 한다.
	범위안의 몬스터를 찾지 못했어도 false를 반환한다.
	 */
	static boolean killMonster(int[][] copyMap, int[][] map, int pos){
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{N-1, pos});

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			if(visit[current[0]][current[1]]) continue;

			if(map[current[0]][current[1]] == 1){
				if(copyMap[current[0]][current[1]] == 1) {
					copyMap[current[0]][current[1]] = 0;
					return true;
				}
				else return false;
			}

			visit[current[0]][current[1]] = true;

			for(int d=0;d<3;d++){
				int ny = current[0]+dy[d];
				int nx = current[1]+dx[d];
				boolean isRange = (Math.abs(N-ny)+Math.abs(pos-nx))<=D;
				if(ny>=0 && nx>=0 && ny<N && nx<M && isRange){
					queue.offer(new int[]{ny,nx});
				}
			}
		}

		return false;
	}

	static int[][] moveMonster(int[][] map){
		for(int i=N-2;i>=0;i--){
			for(int j=0;j<M;j++){
				map[i+1][j] = map[i][j];
				map[i][j] = 0;
			}
		}
		return map;
	}

	static int[][] copyMap(int[][] map) {
		int[][] copyMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	static int countMonster(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}
		return count;
	}
}
