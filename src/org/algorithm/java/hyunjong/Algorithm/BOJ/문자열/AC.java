package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

/*
1. 시간 초과
P를 순환하면서 R일 경우에는 역정렬하고 D일 경우에는 앞의 요소를 삭제하는 식으로 구현을했다.
하지만 P의 최대 크기는 100000, LinkedList로 역정렬을 했으니 시간복잡도는 N, N이 최대 100000이 되므로 N^2으로
시간 초과가 나게된다.
2. Dequeue
Deque를 통해 역정렬하는 시간을 줄여 앞뒤의 방향만 맞춰주고 D할때 해당 방향에 맞는 요소를 삭제해주면 된다.
 */
public class AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		Deque<Integer> dq;

		while (TC-- > 0) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());

			dq = new LinkedList<>();	//테스트케이스 마다 Dequeue를 초기화
			String getArr = br.readLine();
			//주어지는 배열을 맨앞과 뒤('[',']')를 제거하고 ','에 따라 배열로 분리
			String[] sArr = getArr.substring(1, getArr.length() - 1).split(",");
			for (int i = 0; i < N; i++) {
				//각 숫자를 Integer로 변환
				//마지막 까지 놓치고 있었던 부분 charAt(0)으로 하고있어서 한자리 수만 변환를 시켜주고 있었는데 모르고있었음
				dq.add(Integer.parseInt(sArr[i]));
			}

			boolean r = false;	//reverse 여부
			boolean flag = false;	//빈 배열에 D 여부
			if (dq.isEmpty()) {
				if (P.contains("D")) {	//빈 배열이 초기값으로 들어왔을때 D 실행시 error 반환후 다음 테스트케이스
					sb.append("error");
					sb.append("\n");
				}else{
					sb.append("[]");	//빈 배열이 초기값일때는 그냥 빈배열 반환 후 다음 테스트케이스
					sb.append("\n");
				}
				continue;
			} else {
				for(char p : P.toCharArray()){
					if(p == 'R'){	//함수를 돌며 R인 경우 reverse여부를 바꿔준다.
						r = !r;
					}else{
						if(dq.isEmpty()){
							flag = true;
							break;
						}else{	//D함수
							if(r){	//reverse가 true인 경우 역정렬이 되어 앞뒤가 바뀌어야 하지만 역정렬 대신 뒤에 있는 요소를 빼주기만해서 시간 단축
								dq.pollLast();
							}else{	//reverse가 false이므로 앞에있는 요소 삭제
								dq.pollFirst();
							}
						}
					}
				}
			}

			if(flag){	//빈 배열에서 D함수를 실행시켰을 경우 error 출력
				sb.append("error");
			}else{
				sb.append("[");
				while(dq.size()>1){
					if(r){
						sb.append(dq.pollLast()).append(",");
					}else{
						sb.append(dq.pollFirst()).append(",");
					}
				}
				//D함수를 실행시켜 마지막 요소를 삭제했을때 dq.size == 0 인 경우를 잡기위한 조건
				//또는 위의 while을 돌고 하나 남은 요소를 넣어주기 위한 조건
				if(dq.size() != 0){
					sb.append(dq.pollFirst());
				}
				sb.append("]");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
