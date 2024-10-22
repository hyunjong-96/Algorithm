package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
사각형을 꼭짓점에서 꼭짓점으로 선을 잇게되면 w/gcd, h/gcd 의 크기로 각 섹터가 나눠지는 경우가 있다.
섹터는 w와 h의 최대공약수가 만들어질때 생기며 섹터에서 사용할 수 있는 정사각형의 개수는 (w/gcd*h/gcd) - (w/gcd)+(h/gcd)-1 가 된다.
섹터의 개수는 gcd이므로 w*h - ((w/gcd+h/gcd)-1)*gcd 의 식이 만들어진다.
https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
 */
public class 멀쩡한사각형 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w,h));
	}

	static public long solution(int w, int h){
		int gcd = getGcd(Math.max(w,h), Math.min(w,h));
		return ((long)w *h)-(((long)w/gcd+h/gcd-1)*gcd);
	}

	static public int getGcd(int a, int b){
		if(a%b==0) return b;
		else return getGcd(b, a%b);
	}
}
