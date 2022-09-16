package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
완전 이진트리는 부모노드의 자식노드가 2개있고 깊이가 K인 완전이진트리는 총 2^K-1 개의 노드를 가지고 있다.
그렇기 때문에 left와 right로 범위를 지정하고 해당 범위의 가운데값이 부모노드로 정의하고 각 해당 높이에 부모노드를 저장한다.
재귀를 사용하여 부모노드의 왼쪽 범위를 (left, mid-1), 오른쪽 범위를 (right, mid+1)로 부모노드를 저장하면서
left==right일때 해당 노드를 저장하고 재귀를 종료한다.
 */
public class 완전이진트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = (int)Math.pow(2, K) - 1;
		int[] tree = new int[size];
		for (int i = 0; i < size; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer>[] nodeOfDepth = new List[K];
		for(int i=0;i<K;i++){
			nodeOfDepth[i] = new ArrayList<>();
		}

		find(tree, nodeOfDepth, 0, size-1, 0);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;i++){
			for(int node : nodeOfDepth[i]){
				sb.append(node);
				sb.append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void find(int[] tree, List<Integer>[] node, int left, int right, int depth) {

		int mid = (left+right)/2;

		node[depth].add(tree[mid]);

		if(left == right) return;

		find(tree, node, left, mid-1, depth+1);
		find(tree, node, mid+1, right, depth+1);
	}
}
