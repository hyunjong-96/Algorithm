package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
첫번째 풀이에서는 크레인과 박스를 배열에 저장하고 정렬하여 n*m으로 비교하면서 모든 박스를 이동시켰을때 중지시켰다.
	이렇게 풀이하면 3중 반복문을 쓰게되는데 n*m의 계산에서 while문이 최대 m개이므로 O(n*m^2)가 되어 시간초과가 발생한다.

두번째 풀이는 크레인과 박스를 리스트에 저장하고 정렬하여 n*m이 아닌 box의 index를 수동으로 이동시켜주면서
	크레인이 들수있는 박스의 무게라면 박스 리스트에서 해당 박스를 제거해주고 moveBox++를 해주었다.
	만약 크레인이 들수 없는 박스의 무게라면 boxIndex를 이동시켜 다음 박스를 확인하게 한다.
	여기서 boxIndex는 크레인이 박스를 들 수 있을때까지 무한이 증가하므로 boxIndex가 boxList의 범위를 넘어가게 되면
	해당 time의 박스 움직임을 끝낸다(더이상 박스를 이동할수 있는 크레인이 없다는 뜻이기 때문)

	한 타임동안 크레인이 박스를 움직였을 때 움직이지 않은 박스가 박스리스트에 남아있으므로 해당 박스를 모두 움직여
	moveBox의 크기가 주어진 박스의 크기와 동일해졌다면 time을 반환해준다.
 */
public class 배 {
	static List<Integer> cranes;
	static List<Integer> boxs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxCrane = 0;
		int maxBox = 0;
		int N = Integer.parseInt(br.readLine());
		cranes = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
			maxCrane = Math.max(maxCrane, cranes.get(i));
		}

		int M = Integer.parseInt(br.readLine());
		boxs = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxs.add(Integer.parseInt(st.nextToken()));
			maxBox = Math.max(maxBox, boxs.get(i));
		}

		cranes.sort(Comparator.reverseOrder());
		boxs.sort(Comparator.reverseOrder());

		int answer = -1;
		if (maxCrane >= maxBox) {
			answer = moveBox(M);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int moveBox(int allBox) {
		int time = 0;
		int moveBox = 0;

		while (moveBox < allBox) {
			int boxIndex = 0;
			for (int i = 0; i < cranes.size();) {
				//boxIndex는 박스를 들수 있는 크레인을 만날때까지 무한히 증가하기 때문에 break를 걸어주어야한다.
				if(boxIndex >= boxs.size()) break;
				if(cranes.get(i) >= boxs.get(boxIndex)){
					boxs.remove(boxIndex);
					moveBox++;
					i++;
				}else{
					boxIndex++;
				}
			}
			time++;
		}

		return time;
	}
}
