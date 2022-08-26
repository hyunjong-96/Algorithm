package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.LinkedList;
import java.util.Queue;

/*
대진표가 2의 지수승으로 주어지기 때문에 부전승이 주어지지 않는다.
Queue에 모든 선수를 넣고 2명씩 꺼내어 a와b를 비교하여 queue에 다시 넣어주는 것을 한 라운드 (n/2) 씩 반복한다.
이 과정을 a와 b가 만날때까지 반복한다.

대진은 2의 지수승만큼 반복하기 때문에 최대 20회가 걸릴듯.

다른 사람의 풀이를 보면
1과 2가 대결했을 때 누가 이기든 다음 라운드에서 1번을 부여받고
3과 4가 대결했을 때 누가 이기든 2번을 부여받는다.
이를 공식으로 풀자면 i번 숫자가 있을 때 i/2 + i%2가 다음 라운드에 부여받는 수가 된다.
i==2 일 때, 2/2 + 2%2 = 1+0 = 1이 되고 i==3 일 때, 3/2 + 3%2 = 1+1 = 2가 되므로 조건에 부합한다.
그러므로 a = a/2 + a%2, b = b/2 + b%2를 반복하여 a와 b가 같아질때의 count를 반환한다.
 */
public class 예상대진표 {
	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(solution(n,a,b));
	}

	static int solution(int n, int a, int b){
		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<=n;i++){
			queue.offer(i);
		}

		if(a>b){
			int tmp = a;
			a = b;
			b = tmp;
		}

		boolean isMatching = false;
		int count=0;
		while(n>0 && !isMatching){
			count++;
			for(int i=0;i<n/2;i++){
				int f = queue.poll();
				int l = queue.poll();

				if(f==a && l==b){
					isMatching = true;
					break;
				}else if(f==a || l==a){
					queue.offer(f==a ? f : l);
				}else if(f==b || l==b){
					queue.offer(f==b ? f : l);
				}else{
					queue.offer(f);
				}
			}

			n /= 2;
		}

		return count;
	}
}
