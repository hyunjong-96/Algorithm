package org.algorithm.java.hyunjong.Algorithm.프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.List;

/*
각 자리마다 위치를 바꿔가며 numbers.size()까지의 자릿수를 바꿔줘야한다.
이때 dfs를 사용하면된다.
첫번쨰 반복문에서는 만들 자릿수를 1부터 numbers.size()까지로 dfs를 호출한다.
dfs내부에서는 문자열 숫자 tmp와 만들 자릿수 l을 매개변수로 받는데
tmp의 길이와 l이 같고 numbers숫자로 만들수 있는 수를 저장한 list에 중복여부를 확인한 후 list에 저장하고 함수 종료.
tmp의 길이와 l이 같지 않은 경우에는 numbers의 각 숫자 방문여부를 확인하고 방문하지 않은 숫자이면
백트래킹을 해주고 tmp에 해당 숫자를 추가해서 dfs를 재호출한다.
dfs가 반환되었을때는 tmp에 추가되었던 숫자를 제거해준다(백트래킹)

dfs를 모두 수행했으면 list에는 numbers로 만들수 있는 모든 수가 저장되어있다.
그런다음 list에 저장되어있는 수 중에서 소수인지 판별하는 함수를 돌린다.
소수는 0과1을 제외하고 2부터 n-1까지의 수 중에서 하나라도 나누어 떨어지는게 있다면 함수 종료.
그렇지 않다면 answer++를 해준다.

answer값 반환.
 */
public class 소수찾기2 {
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}

	static List<Integer> list;
	static boolean[] check;
	static String Numbers;
	static int answer;

	static int solution(String numbers){
		list = new ArrayList<>();
		check = new boolean[numbers.length()];
		Numbers = numbers;
		for(int i=1;i<=numbers.length();i++){
			String tmp = "";
			dfs(tmp, i);
		}
		answer = 0;
		for(int i=0;i<list.size();i++){
			is_prime(list.get(i));
		}
		return answer;
	}

	static void is_prime(int number){
		if(number < 2) return;
		for(int i=2;i<number;i++){
			if(number%i==0){
				return;
			}
		}
		answer++;
	}

	static void dfs(String tmp, int l){
		if(tmp.length() == l){
			int num = Integer.parseInt(tmp);
			if(!list.contains(num)){
				list.add(num);
				return;
			}
		}

		for(int i=0;i<Numbers.length();i++){
			if(!check[i]){
				check[i] = true;
				tmp += Numbers.charAt(i);
				dfs(tmp,l);
				check[i] = false;
				tmp = tmp.substring(0,tmp.length()-1);
			}
		}
	}
}
