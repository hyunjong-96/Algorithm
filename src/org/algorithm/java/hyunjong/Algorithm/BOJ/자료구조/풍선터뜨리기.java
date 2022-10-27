package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기{
	/*
	배열로 직접 구현하는 방법에서 뎈을 이용한 더 좋은 방법이 있어 구현해보았다.

	Deque에 인덱스와 해당 값에 대해 저장해놓고
	풍선에 저장되어있는 숫자가 양수라면
		오른쪽으로 이동하기 위해 뎈의 앞에있는 요소를 뒤쪽으로 move-1만큼 이동하고 뎈의 앞에있는 값을 가져온다.
	저장되어있는 숫자가 음수라면
		왼쪽으로 이동하기 위해 뎈의 뒤에있는 요소를 앞으로 move-1만큼 이동하고 뎈의 뒤에있는 값을 가져온다.
	뎈이 빌때까지 반복하면 모든 값을 가져올수 있다.

	이때, 왜맞틀을 오래한 부분인데, 나는 보통 뎈 구현시 LinkedList를 사용했지만 자꾸 메모리 초과가 발생해서 문제를 찾아보니
	뎈의 구현클래스는 LinkedList와 ArrayDeque이 있었다.
	ArrayDeque는 뎈에서 앞,뒤의 요소를 삽입삭제하는 경우 효율적인 자료구조이다. 일단, LinkedList는 순차적으로 요소가 저장되어있긴하지만
	메모리 이곳저곳에 저장되어있어 메모리 주소가 연속적이지 못해 캐시 친화적이지 못하다. 그리고 ArrayDeque보다 메모리를 더 많이 사용한다고한다.

	그래서 메모리 초과가 발생하였고 LinkedList대신 ArrayDeque를 사용해서 문제를 해결했다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Deque<int[]> dq = new ArrayDeque<>();
		for(int i=1;i<=N;i++){
			dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});
		}

		StringBuilder sb = new StringBuilder();
		int[] info = dq.poll();
		sb.append(info[0]).append(" ");
		int move = info[1];

		while (!dq.isEmpty()){
			if(move>0){
				for(int i=1;i<move;i++){
					dq.offerLast((dq.pollFirst()));
				}
				info = dq.poll();
				sb.append(info[0]).append(" ");
				move = info[1];
			}else{
				for(int i=1;i<Math.abs(move);i++){
					dq.offerFirst(dq.pollLast());
				}
				info = dq.pollLast();
				sb.append(info[0]).append(" ");
				move = info[1];
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	/*
	배열을 이용해서 0번째 index에서부터 ballons[i]에 있는 값으로 이동하는 과정을 거쳐 마지막 index까지 이동하여 이동했던 index를 저장해서 반환하는 문제
	0번쨰 index부터 ballons[i]만큼 이동하는데 그 값이 양수이면 오른쪽으로 이동하기 위해 (index+ballons[i])%N으로 index를 갱신하며 이동한다.
	음수이면 왼쪽으로 이동하면서 index--으로 이동하는데 index가 음수가 나오게 되면 마지막 index로 이동하기 위해 index = N-1로 이동시킨다.

	이때, 하나씩 이동시키지 않고 index = N-index이런식으로 한번이 이동시킨다면 이미 풍선을 터트린 곳에서 이동이 되는것이기 때문에 예외를 찾는데 까다로울 수 있다.
	그렇기 때문에 해당 index에서부터 ballons[i]만큼 이동하는데, 터트린 풍선이 있다면은 움직임 카운트를 세지않고 이동해야한다.
	O(N^2)의 시간복잡도가 발생.
	 */
	// public static void main(String[] args) throws IOException{
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	int N = Integer.parseInt(br.readLine());
	// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 	int[] ballons = new int[N];
	// 	for(int i=0;i<N;i++){
	// 		ballons[i] = Integer.parseInt(st.nextToken());
	// 	}
	//
	// 	StringBuilder sb = new StringBuilder();
	// 	boolean[] check = new boolean[N];
	// 	int index = 0;
	// 	int count = 0;
	//
	// 	while(count<N){
	// 		check[index] = true;
	// 		count++;
	// 		sb.append(index+1).append(" ");
	//
	// 		if(count==N) break;
	//
	// 		int move = ballons[index];
	// 		int nextIndex = index;
	// 		int nextCount = 0;
	// 		while(nextCount < Math.abs(move)){
	// 			if(move > 0){
	// 				nextIndex = (nextIndex+1)%N;
	// 			}else{
	// 				nextIndex--;
	// 				if(nextIndex < 0) nextIndex = N+nextIndex;
	// 			}
	// 			if(!check[nextIndex]) nextCount++;
	// 		}
	// 		index = nextIndex;
	// 	}
	//
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }
}
