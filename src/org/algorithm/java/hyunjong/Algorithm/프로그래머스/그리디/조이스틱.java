package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그리디;

/*
연속된 A를 고려하여 왼쪽,오른쪽으로 이동하는 방법을 찾지 못해 다른 분들의 풀이를 봄.
name의 한 문자씩을 탐색하면서 다음 문자에 A가 있다면 다음 문자에 A가 아닌 다른 문자를 가리키는 index를 갱신한다.
A문자 다음으로 오는 문자까지 가기 위해 name.charAt(i)의 문자를 뒤로 돌아 뒷 자리부터 index까지 가는 거리와
뒤에서부터 index까지 갔다가 앞으로 가서 i까지 방문하는 거리 중 최솟값을 구하면서 반복하는 문제이다.
 */
public class 조이스틱 {
	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(name);
	}

	static int solution(String name){
		int answer = 0;
		//초기화 하는 최소 거리는 처음부터 끝까지 모든 문자를 이동하는 최대값으로 초기화.
		int min_distance=name.length()-1;
		//각각의 문자 탐색
		for(int i=0;i<name.length();i++){
			//현재 i위치의 문자를 만들기 위해 위,아래로 움직이는 값중 최소값
			answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);

			//다음 문자가 A가 아닌 문자가 나올때까지 index를 구함
			int index = i+1;
			while(index<name.length() && name.charAt(index)=='A'){
				index++;
			}

			/*
			A가 아닌 문자를 가리키는 index에 도달하기 위해 현재 위치의 i에서 index까지 뒤로 돌아 뒤에서 부터
			탐색하여 index까지의 거리 중 최솟값을 구함
			i*2 : i까지 왔던 거리를 다시 돌아감
			name.length()-index : index까지 뒤에서 가는 거리
			 */
			min_distance = Math.min(min_distance, (i*2)+name.length()-index);
			/*
			A가 아닌 i다음 문자인 index를 뒤에서부터 탐색하고 i까지 가기위해 뒤로 돌아서 앞에서부터 i까지 가는 거리 중 최솟값
			(name.length()-index)*2 : 뒤에서부터 index까지 가는 거리
			i : 앞에서 i까지 가는 거리
			 */
			min_distance = Math.min(min_distance, (name.length()-index)*2+i);
		}
		return answer + min_distance;
	}
}
