package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.ArrayList;
import java.util.List;

/*
attribute 1개부터 relation.size()-1개(attribute 총 갯수) 까지 각 attribute 조합의 유일성을 확인하며 반복하면 최소성을 만족할수있다.
예를 들어 후보키에 {1}이 들어있다. 그리고 그 뒤에 attribute의 조합 {1,2}가 유일성을 만족한다고 할때,
이미 후보키에 저장되어 있는 {1}이 조합{1,2}에 포함되어 있으므로 최소성을 만족하지 못하게 된다.
attribute의 조합으로 후보키를 만드는 makeCandidate함수와 해당 attribute조합의 유일성을 확인하는 isUnique함수를 이용해 구현할수 있다.
makeCandidate는 attribute의 조합의 크기를 1부터 attribute의 총갯수까지 조합을 만들고 최소성을 만족하기 위해
작은 크기 1부터 시작한다. makeCandidate에서 attribute(idx)를 list에 넣어서 attribute 조합을 만들어준다.
target(조합의 크기)에 맞는 attribute list를 받았다면 유일성검사(isUnique)와 최소성(기존 후보키와 비교)을 통해
후보키 리스트를 갱신하고 후보키의 갯수를 count해준다.
 */
public class 후보키 {
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}
	static List<List<Integer>> candidates;
	static String[][] relation;
	static int tupleSize;
	static int answer;
	static int solution(String[][] r){
		relation = r;
		tupleSize = r[0].length;
		candidates = new ArrayList<>();

		//attribute조합 1부터 attribute 총 갯수까지
		for(int i=1;i<=tupleSize;i++){
			makeCandidate(-1, 0, i, new ArrayList<>());
		}

		return answer;
	}

	//후보키 생성
	static void makeCandidate(int idx, int count, int target, List<Integer> attributes){
		//만들고자하는 조합의 크기가 되었을때
		if(count >= target){
			//유일성 체크
			if(!isUnique(attributes)) return;
			//최소성 체크
			for(List<Integer> candidate : candidates){
				if(attributes.containsAll(candidate)) return;
			}
			candidates.add(attributes);
			answer++;
			return;
		}

		for(int i = idx+1;i<tupleSize;i++){
			List<Integer> newAttributes = new ArrayList<>(attributes);
			newAttributes.add(i);
			makeCandidate(i, count+1, target, newAttributes);
		}
	}

	//유일성 체크
	static boolean isUnique(List<Integer> attributes){
		//attribute의 값을 string으로 합쳐 유일성 여부 확인
		List<String> newList = new ArrayList<>();
		for(String[] t : relation){
			String tmp = "";
			for(int a : attributes){
				tmp += t[a];
			}
			if(!newList.contains(tmp)){
				newList.add(tmp);
			}else{
				return false;
			}
		}
		return true;
	}
}
