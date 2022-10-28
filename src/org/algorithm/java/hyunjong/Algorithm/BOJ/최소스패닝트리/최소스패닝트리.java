package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
최소 스패닝 트리란, 시작지점에서 부터 모든 정점을 선택했을 때 최소의 가중치를 구하는 알고리즘.
유사한 알고리즘으로 크루스칼 알고리즘이 있다.
이 둘의 차이는 크루스칼 알고리즘은 그래프의 개념이기 때문에 사이클이 존재한다.
	그렇기 때문에 그래프에 사이클이 존재하게 되면 모든 정점을 선택할 수 없다.
최소 스패닝 트리는 말 그대로 트리이기 때문에 사이클이 존재하지 않는다.
	그렇기 때문에 사이클 존재 여부를 확인하기 위해 union을 사용하지 않아도 된다.
 */
public class 최소스패닝트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<List<int[]>> map = new ArrayList<>();
		for(int i=0;i<=V;i++){
			map.add(new ArrayList<>());
		}

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine()," ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map.get(v1).add(new int[]{v2,cost});
			map.get(v2).add(new int[]{v1,cost});
		}

		long result = MST(map);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	//결과가 int 범위이지 중간 가중치가 int 범위라고는 안했기 때문에 long
	public static long MST(List<List<int[]>> map){
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});
		boolean[] check = new boolean[map.size()];

		pq.offer(new int[]{1,0});

		long result = 0;

		while(!pq.isEmpty()){
			int[] currentInfo = pq.poll();
			int currentV = currentInfo[0];
			int currentC = currentInfo[1];

			/*
			pq에 중복되는 정점으로 가는 가중치가 있을 수 있기 때문에 방문여부를 확인해야한다.
			 */
			if(check[currentV]) continue;

			check[currentV] = true;

			/*
			최소 가중치로 연결된 정점까지의 가중치를 더해준다.
			 */
			result += currentC;

			/*
			해당 정점과 연결된 간선을 pq에 저장한다.
			물론 연결된 정점이 방문되었다면 이를 막아서 최소한의 성능을 보장한다.
			 */
			for(int[] link : map.get(currentInfo[0])){
				int linkV = link[0];
				int linkC = link[1];

				if(check[linkV]) continue;

				pq.offer(new int[]{linkV, linkC});
			}
		}

		return result;
	}

}
