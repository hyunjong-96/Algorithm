package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.정렬;

import java.util.Arrays;

/*
h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용된 h의 최댓값.
문제를 이해하는 데 참 오래걸렸다.
citations[i]의 값이 h이상인 h의 최댓값을 찾는 문제이다.
나머지 논문은 위의 citations를 오름차순으로 정렬하고 조건을 맞춰준다면 i번째 앞의 citations값들은 h값보다 작게된다.
먼저 citations의 값들을 앞에서 부터 탐색하는데 citations[i]의 값보다 큰 값들이 정렬되어있기 때문에
citations[i]번 이상 인용된 논문의 갯수는 citations.length-i이 되게 된다.
이를 h로 놓게 되면 citations = {0,0,1,3,5,5,6}이라고 할때 citations[0]은 0, h = 7이 되게되고
0번의 인용된 논문 citations[0]은 h(7)개 이하 이므로 조건을 만족하지 못한다.
3번의 인용된 논문 citations[3]은 h(4)개 이하 이므로 조건을 만족하지 못한다.
첫번째 5번의 인용된 논문 citations[4]는 h(3)개 이상이므로 조건을 만족하게되므로 answer = h(3)을 넣어준다.
두번째 5번의 인용된 논문 citations[5]는 h(2)개 이상이므로 조건을 만족하지만 이전의 h(3)과 비교했을때 더 작은값이므로
바꿔줄 필요없다. 이렇게 첫번째 조건을 만족하는 h를 찾았을때 뒤로갈수록 h의 값이 작아지므로
첫번째 h를 찾았을때 탐색을 중단하면된다.
 */
public class H_Index {
	public static void main(String[] args) {
		int[] citations = {0,0,1,3,5,5,6};
		System.out.println(solution(citations));
	}

	static int solution(int[] citations){
		int answer =0;
		Arrays.sort(citations);

		for(int i=0;i<citations.length;i++){
			int h = citations.length-i;
			if(citations[i]>=h){
				answer = h;
				break;
			}
		}
		return answer;
	}
}
