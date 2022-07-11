package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//map 이용해 주어진 각 친구를 map에 넣어 idx를 만들어준다.
//만들어진 idx를 통해 union find로 친구그룹을 만든다.
//친구의 친구도 친구개수로 포함되기 때문에 1차원 배열을 통해 루트 그룹(network[i]의 결과값)에 친구그룹에 포함되는 개수를 저장한다.
//루트 그룹 idx 외의 친구 idx는 level에 영향을 받지 않으므로 신경쓰지 않아도된다.
public class 친구네트워크 {
	static int[] network;
	static int[] level;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int idx = 0;
			int F = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			network = new int[F * 2];
			level = new int[F * 2];

			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String A = st.nextToken();
				String B = st.nextToken();
				int friendCount = 0;

				if (!map.containsKey(A)) {
					map.put(A, idx);
					network[idx] = idx;
					level[idx] = 1;
					idx++;
				}

				if (!map.containsKey(B)) {
					map.put(B, idx);
					network[idx] = idx;
					level[idx] = 1;
					idx++;
				}

				int a = find(map.get(A));
				int b = find(map.get(B));

				if (a != b) {
					friendCount = union(a, b);
				}else{
					friendCount = level[Math.min(a,b)];
				}

				sb.append(friendCount);
				sb.append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			network[b] = a;
			level[a] += level[b];
			return level[a];
		} else {
			network[a] = b;
			level[b] += level[a];
			return level[b];
		}
	}

	static int find(int idx) {
		if (idx == network[idx])
			return idx;
		return network[idx] = find(network[idx]);
	}
}
