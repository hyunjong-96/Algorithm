package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트택시 {
	static int N;
	static int M;
	static int[][] map;
	static Client[] clients;
	static Taxi taxi;

	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int initOil = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		clients = new Client[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int e = Integer.parseInt(st.nextToken());
				if (e == 1)
					e = -1;
				map[i][j] = e;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int taxiY = Integer.parseInt(st.nextToken())-1;
		int taxiX = Integer.parseInt(st.nextToken())-1;
		taxi = new Taxi(taxiY, taxiX, initOil);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startY = Integer.parseInt(st.nextToken())-1;
			int startX = Integer.parseInt(st.nextToken())-1;
			int endY = Integer.parseInt(st.nextToken())-1;
			int endX = Integer.parseInt(st.nextToken())-1;
			clients[i] = new Client(i, startY, startX, endY, endX);
			map[startY][startX] = i;
		}

		int answer = work();
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int work() {
		while (taxi.oil != 0) {
			//손님찾기
			int client = findClient();
			if (client == -1)
				return -1;
			map[clients[client].startY][clients[client].startX] = 0;

			//손님 이동시키기
			if(moveClient(client)){
				if(taxi.clientCount == M) return taxi.oil;
			}else{
				return -1;
			}
		}
		return -1;
	}

	static boolean moveClient(int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {taxi.y, taxi.x});

		boolean[][] visit = new boolean[N][N];
		visit[taxi.y][taxi.x] = true;
		Client client = clients[num];

		int move = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int[] pos = queue.poll();

				if(pos[0] == client.endY && pos[1] == client.endX){
					taxi.y = pos[0];
					taxi.x = pos[1];
					taxi.oil += move*2 - move;
					taxi.clientCount++;
					return true;
				}

				for(int i=0;i<4;i++){
					int ny = pos[0]+dy[i];
					int nx = pos[1]+dx[i];

					if(ny>=0 && nx>=0 && ny<N && nx<N && map[ny][nx] != -1 && !visit[ny][nx]){
						visit[ny][nx] = true;
						queue.offer(new int[]{ny, nx});
					}
				}
			}

			if(++move > taxi.oil) return false;
		}
		return false;
	}

	static int findClient() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {taxi.y, taxi.x});

		boolean[][] visit = new boolean[N][N];
		visit[taxi.y][taxi.x] = true;

		int move = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			PriorityQueue<Client> pq = new PriorityQueue<>();

			for (int s = 0; s < size; s++) {
				int[] pos = queue.poll();

				if(map[pos[0]][pos[1]] != 0){
					pq.offer(clients[map[pos[0]][pos[1]]]);
					// taxi.y = pos[0];
					// taxi.x = pos[1];
					// taxi.soil -= move;
					// return map[pos[0]][pos[1]];
				}

				for (int i = 0; i < 4; i++) {
					int ny = pos[0] + dy[i];
					int nx = pos[1] + dx[i];

					if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] != -1 && !visit[ny][nx]) {

						visit[ny][nx] = true;
						queue.offer(new int[] {ny, nx});
					}
				}
			}

			if(pq.size()>0){
				Client client = pq.poll();
				taxi.y = client.startY;
				taxi.x = client.startX;
				taxi.oil -= move;
				return client.num;
			}

			if (++move > taxi.oil) return -1;
		}
		return -1;
	}

	static class Client implements Comparable<Client>{
		int num;
		int startY;
		int startX;
		int endY;
		int endX;

		public Client(int num, int startY, int startX, int endY, int endX) {
			this.num = num;
			this.startY = startY;
			this.startX = startX;
			this.endY = endY;
			this.endX = endX;
		}

		@Override
		public int compareTo(Client o1){
			int answer = this.startY - o1.startY;

			if(answer == 0){
				answer = this.startX - o1.startX;
			}

			return answer;
		}
	}

	static class Taxi {
		int y;
		int x;
		int oil;
		int clientCount;

		public Taxi(int y, int x, int oil) {
			this.y = y;
			this.x = x;
			this.oil = oil;
			this.clientCount = 0;
		}
	}
}
