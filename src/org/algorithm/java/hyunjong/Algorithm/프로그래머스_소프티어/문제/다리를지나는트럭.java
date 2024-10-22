package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	/*
	정해진 순서대로 트럭이 다리를 건널 때
	Queue를 이용해서 트럭이 다리를 건널때 Queue의 경우의 수를 통해 트럭을 이동시킨다.

	queue가 비어있는 경우 다리에 트럭이 없는 경우이기 때문에 해당 트럭을 다리에서 이동시키고 무게와 시간을 더한다.
	queue가 비어있지 않는 경우
	queue.size()가 bridge_length와 동일한 경우,
	다리위의 트럭 무게 + 해당 트럭 무게가 wieght를 초과하는 경우,
	다리위의 트럭 무게 + 해당 트럭 무게가 weight를 초과하지 않는 경우 총 3가지로 나누어 볼 수 있다.

	첫번째는 queue.size() == bridge_length인 경우 다리에 트럭이 꽉 차 있는 경우이기 때문에 queue에서 트럭을 하나 빼준다.
	두번째 해당 트럭 무게를 포함하여 weight를 초과하는 경우 다리에 트럭을 올릴 수 없기 때문에 queue에 트럭이 아닌 0을 넣어
		해당 트럭을 올리지 않고 기존에 올라가있던 트럭을 움직이도록 한다.
	세번째 다리에 해당 트럭을 이동시킬 수 있는 경우 queue에 해당 트럭을 올리고 answer, sum에 트럭 무게를 더해준다.

	이때 팁은 시간(answer)는 다리에 트럭의 개수가 꽉 차있을때 트럭을 빼주는 경우에는 트럭이 이동한 것으로 판단하지 않기 때문에 answer 갱신을 해주지 않는다.

	마지막으로 모든 반복문을 돌았을때 마지막 트럭을 다리위에 위치시키고 끝나게 된다. 그렇기 때문에
	마지막 트럭이 다리위에 위치한 후로부터 bridge_length까지의 시간을 더해주게 되면 마지막 트럭이 다리위를 무사히 지나간 시간이 포함되게 된다.
	 */
	static int solution(int bridge_length, int weight, int[] truck_weights){
		Queue<Integer> queue = new LinkedList<>();

		int sum = 0;
		int answer = 0;
		for(int t : truck_weights){
			while(true){
				if(queue.isEmpty()){
					queue.offer(t);
					sum += t;
					answer++;
					break;
				}
				else{
					if(queue.size() == bridge_length){
						sum -= queue.poll();
					}
					else if(sum + t > weight){
						queue.offer(0);
						answer++;
					}
					else{
						queue.offer(t);
						sum += t;
						answer++;
						break;
					}
				}
			}
		}
		return answer + bridge_length;
	}
}
