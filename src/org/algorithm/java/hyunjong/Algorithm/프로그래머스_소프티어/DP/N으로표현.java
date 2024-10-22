package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
N으로 표현하기는 DP로 풀다가 도저히 점화식이 도출이 안되서 다른 분들의 풀이를 보니
DFS로 푼사람도 있고 DP로 푼사람도 있어 신기했다.
나는 DP로 해결하고있었기 때문에 DP로 풀이를 했다.
이 문제의 핵심은 i개의 N을 사용했을 때 어떤 수를 만들수 있는가를 찾는것이 핵심이다.
예를들어 2개의 5를 구했을때 나타낼수 있는 수는 10(5+5), 25(5*5), 0(5-5), 1(5/5), 55 가 있다.
3개의 5로 나타낼수 있는 수는 15(5+5+5), 125(5*5*5), -15(-5-5-5) 등이 있다.
여기서 알아야 하는것이. 3개의 5로 만들수 있는 수는 2개의 5로 만들수 있는 값과 1개의 5로 만들수 있는 사칙연산의 값을
다시 사칙연산을 하여 나올수 있는 값의 합 + 555이다.
결국 3개로 만들수 있는 수는 (2개로만들수 있는 수 + 1개로 만들수 있는수) + (1개로 만들수 있는 수+2개로 만들수 있는 수)인것이다.
2+1과 1+2는 같은게 아닌가 라고 생각할수 있는데 (5-5)+5와 5-(5+5)는 다르다.
각 i개로 만들수 있는 값을 저장하고 각 i개로 만들수 있는 수에 number값이 들어있는지 확인하면 된다.
 */
public class N으로표현 {
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}

	static int solution(int N, int number) {
		/*
		dpList의 각 index값에는 index개의 N으로 만들수 있는 값이 저장된다.
		Set으로 한 이유는 중복 방지
		 */
		List<Set<Integer>> dpList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			dpList.add(new HashSet<>());
		}
		//1개로 만들수 있는 값은 N 하나밖에 없다.
		dpList.get(1).add(N);

		//8개 이상의 N을 사용해서도 값이 나오지 않는다면 -1을 반환해야하므로 dpList의 크기는 8까지
		//i개의 N을 구하기 위한 반복문
		for (int i = 2; i < 9; i++) {
			//i개의 N으로 만들수 있는 수를 저장하기 위한 Set
			Set<Integer> dp = dpList.get(i);

			//i개의 N으로 만들수 있는 수를 저장하기 위해 1부터 i-1, 2와 i-2 등등의 값을 사칙연산해야하기 위한 반복
			for (int j = 1; j < i; j++) {
				Set<Integer> front = dpList.get(j);
				Set<Integer> back = dpList.get(i - j);
				for (int f : front) {
					for (int b : back) {
						dp.add(f + b);
						dp.add(f - b);
						dp.add(f * b);
						//자바에서는 0으로의 나눗셈이 되지 않음으로 조건을 걸어줌줌						if (f != 0 && b != 0) {
							dp.add(f / b);
						}
					}
				}
			StringBuilder sb = new StringBuilder();
			for (int r = 0; r < i; r++) {
				sb.append(N);
			}
			dp.add(Integer.parseInt(sb.toString()));
		}

		int answer = -1;
		for (int i = 1; i < 9; i++) {
			Set<Integer> dp = dpList.get(i);
			if (dp.contains(number)) {
				answer = i;
				break;
			}
		}

		return answer;
	}
}
