package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

public class 점찍기 {
	public static void main(String[] args) {
		int k = 1;
		int d = 5;
		System.out.println(solution(k,d));
	}


	static public long solution(int k, int d) {

		long answer = 0;
		for(int y=0;y<=d;y+=k){
			int x = (int)Math.sqrt((Math.pow(d,2)-Math.pow(y,2)));
			// System.out.println("y : "+y+" x : "+x);
			answer += (x/k)+1;
		}
		return answer;
	}

}
// static public long solution(int k, int d) {
// 	int a = 0;
// 	while(k*a <= d){
// 		a++;
// 	}
//
// 	long answer = 0;
// 	a--;
// 	int y = a*k;
// 	for(int i=0;i<=y;i+=k){
// 		while(Math.pow(i,2)+Math.pow(a*k,2) > Math.pow(d,2)){
// 			a--;
// 		}
// 		answer += (a+1);
// 	}
// 	return answer;
// }
