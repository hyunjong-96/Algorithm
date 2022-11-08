package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

/*
물이 더이상 이동할 수 없는 곳에서의 물 기대값의 평균을 구하는 문제
더이상 이동할 수 없는 곳이란 것은 트리에서 leafNode이고
물 기대값의 평균을 구하는것은 물의 총 합에서 leafNode 개수를 나눈것이다.

즉, leaf노드의 개수를 구해서 주어지는 물의 양 W를 나누고 10^-3차이의 오차를 허용한다고해서 소숫점 3자리까지 반올림
 */
public class 나무위의빗물{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		List<List<Integer>> tree = new ArrayList<>();
		for(int i=0;i<=500000;i++){
			tree.add(new ArrayList<>());
		}

		for(int i=0;i<N-1;i++){
			st = new StringTokenizer(br.readLine()," ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			tree.get(U).add(V);
			tree.get(V).add(U);
		}

		// int count = findLeafNode(tree, new boolean[500001], 1);
		int count = 0;
		for(int i=2;i<tree.size();i++){
			List<Integer> link = tree.get(i);
			if(link.size() == 1) count++;
		}

		bw.write(String.format("%.03f",(double)W/count));
		bw.flush();
		bw.close();
	}

	// static int findLeafNode(List<List<Integer>> tree, boolean[] check, int node){
	// 	int leafCount = 0;
	// 	boolean isLeafNode = true;
	// 	check[node] = true;
	// 	for(int i=0;i<tree.get(node).size();i++){
	// 		int linkNode = tree.get(node).get(i);
	// 		if(check[linkNode]) continue;
	// 		//check[linkNode] = true;
	// 		isLeafNode = false;
	// 		leafCount += findLeafNode(tree, check,linkNode);
	// 	}
	//
	// 	if(isLeafNode) return 1;
	// 	else return leafCount;
	// }
}