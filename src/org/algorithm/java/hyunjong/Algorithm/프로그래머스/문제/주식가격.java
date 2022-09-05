package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Stack;

/*
초마다 떨어지는 가격 여부를 확인하고 떨어질때까지 걸리는 시간을 구해야한다.

answer에 각 가격의 시점을 정의해준다.
stack에 해당 가격을 넣어주고 stack에서 가져온 가격이 현재 시점의 가격보다 크다면 가격이 떨어진것이기 때문에
가격이 떨어졌을때 answer[해당 시점]에 현재 시점에서 해당 가격의 시점을 빼주면 가격이 떨어지지 않았던 시간 범위를 알 수 있다.
그리고 가격이 하락하지 않았던 시점은 마지막 시점인 prices.length-1에서 각 가격의 시점을 빼주도록 한다.

가격 하락 여부를 판단하는 boolean[]과 Price라는 객체를 사용하기 때문에 좀더 많은 공간이 필요로 한다.
다른 풀이를 보니 Stack에 price가 아닌 시점을 저장하고 prices[stack.peek()]와 prices[i]의 시점을 비교해서 pop여부를 판단한다.
상대적으로 시간복잡도는 동일하지만 메모리적으로는 다른 풀이가 더 효율적이다.
 */
public class 주식가격 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 3, 2, 2, 4, 3};
		int[] result = solution(prices);
		for(int r : result){
			System.out.println(r);
		}
	}

	static int[] solution(int[] prices){
		int[] answer = new int[prices.length];
		for(int i=0;i<prices.length;i++){
			answer[i] = i;
		}

		Stack<Price> stack = new Stack<>();
		boolean[] check = new boolean[prices.length];
		for(int i=0;i<prices.length;i++){
			if(stack.isEmpty()){
				stack.push(new Price(i, prices[i]));
			}else{
				while(!stack.isEmpty() && stack.peek().price > prices[i]){
					Price p = stack.pop();
					answer[p.idx] = i - answer[p.idx];
					check[p.idx] = true;
				}
				stack.push(new Price(i,prices[i]));
			}
		}
		int end = prices.length-1;

		for(int i=0;i<prices.length;i++){
			if(!check[i]){
				answer[i] = end - answer[i];
			}
		}

		return answer;
	}

	static class Price{
		int idx;
		int price;
		public Price(int idx, int price){
			this.idx = idx;
			this.price = price;
		}
	}
}
