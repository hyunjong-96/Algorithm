package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;


/*
처음에 첫번째 위치부터 w만큼 범위를 캐치하면서 개수를 구해줬는데 실패.

두번째에느 설치된 기지국을 기준으로 전달범위에 포함되지 않는 index부터 설치된 기지국+w로 기준을 잡아
전달범위에 포함되지 않는 범위와 하나의 기지국에서의 전파범위를 나누어 올림해주고 해당 개수를 answer에 갱신시켜갔다.
마지막 설치된 기지국 의 범위에 포함되지 않아 남은 범위도 똑같이 나누고 올림해주어 answer에 갱신해주었다.
정확성은 다맞았지만 효율성에서 빵점을 받았다.

O(n)으로 잘 맞게 짰다고 생각을 했지만 다른 분들의 풀이를 보니 필요없는 메모리 사용을 모두 사용하지 않았다.

불필요한 자료구조를 제거하고 순수 데이터로만 동일하게 구현하니 통과됨
 */
public class 기지국설치 {
	public static void main(String[] args) {
		int n = 10;
		int[] stations = {6};
		int w = 1;
		System.out.println(solution(n, stations,w));
	}

	static public int solution(int n, int[] stations, int w) {
		int answer = 0;

		int position = 1;
		int R = w*2+1;
		for(int station : stations){
			int end = station-w;
			int range = end-position;
			int set = (int)Math.ceil((double)range/R);
			answer += set;
			position = station+w+1;
		}

		if(position <= n){
			int range = n-position+1;
			int set = (int)Math.ceil((double)range/R);
			answer += set;
		}

		return answer;
	}

	//시간초과
	// static int solution(int n, int[] stations, int w){
	// 	int answer = 0;
	//
	// 	Queue<Integer> dq = new LinkedList<>();
	// 	for(int s : stations){
	// 		dq.offer(s-1);
	// 	}
	//
	// 	int index = 0;
	// 	int R = w*2+1;
	// 	while(!dq.isEmpty()){
	// 		int topIndex = dq.poll();
	//
	// 		int range = topIndex-w-index;
	// 		int set = (int)Math.ceil((double)range/R);
	// 		// int set = range/R;
	// 		// if(range%R!=0) set+=1;
	// 		answer+=set;
	// 		index = topIndex+w+1;
	// 	}
	//
	// 	if(index<n){
	// 		int range = n-index;
	// 		int set = (int)Math.ceil((double)range/R);
	// 		// int set = range/R;
	// 		// if(range%R!=0) set+=1;
	// 		answer+=set;
	// 	}
	//
	// 	return answer;
	// }
}
