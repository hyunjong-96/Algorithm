package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
s를 배열로 변경하는 방법(내가 만든방법, 다른사람 방법) 두개 블로그에 작성
 */
public class 튜플 {
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		for (int e : solution(s)) {
			System.out.println(e);
		}
	}

	static int[] solution(String s) {
		String subStrings = s.substring(2,s.length()-2);
		subStrings = subStrings.replace("},{","-");
		String[] sArr = subStrings.split("-");

		List<List<Integer>> tupleList = new ArrayList<>();
		for(int i=0;i<sArr.length;i++){
			tupleList.add(new ArrayList<>());
			String groupString = sArr[i];
			String[] group = groupString.split(",");
			for(int j=0;j<group.length;j++){
				tupleList.get(i).add(Integer.parseInt(group[j]));
			}
		}

		tupleList.sort(new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer>o1, List<Integer>o2){
				return o1.size()-o2.size();
			}
		});

		List<Integer> tuple = new ArrayList<>();
		for(List<Integer> l : tupleList){
			for(int e : l){
				if(!tuple.contains(e)){
					tuple.add(e);
				}
			}
		}

		int[] answer = new int[tuple.size()];
		for(int t = 0;t<tuple.size();t++){
			answer[t] = tuple.get(t);
		}
		return answer;
		// List<List<Integer>> tupleList = new ArrayList<>();
		//
		// List<Integer> tupleElement;
		// StringBuilder sb;
		// char prev = 'a';
		// char[] sArr = s.toCharArray();
		// for (int i = 0; i < s.length(); i++) {
		// 	char c = sArr[i];
		// 	if (prev == 'a') {
		// 		prev = c;
		// 	} else if (prev == '{' || prev == ',') {
		// 		if (c == '{') {
		// 			i++;
		// 			tupleElement = new ArrayList<>();
		// 			sb = new StringBuilder();
		// 			while (sArr[i] != '}') {
		// 				if (sArr[i] == ',') {
		// 					tupleElement.add(Integer.parseInt(sb.toString()));
		// 					sb = new StringBuilder();
		// 					i++;
		// 				} else {
		// 					sb.append(sArr[i]);
		// 					i++;
		// 				}
		// 			}
		// 			tupleElement.add(Integer.parseInt(sb.toString()));
		// 			tupleList.add(tupleElement);
		// 			prev = sArr[i];
		// 			continue;
		// 		}
		// 	} else if (prev == '}') {
		// 		if (c == ',') {
		// 			prev = c;
		// 			continue;
		// 		} else {
		// 			break;
		// 		}
		// 	}
		// }
		// tupleList.sort(new Comparator<List<Integer>>() {
		// 	@Override
		// 	public int compare(List<Integer> o1, List<Integer> o2) {
		// 		return o1.size() - o2.size();
		// 	}
		// });
		// for(List<Integer> list : tupleList){
		// 	Collections.sort(list);
		// }
		//
		// List<Integer> tuple = new ArrayList<>();
		// tuple.add(tupleList.get(0).get(0));
		// for (int i = 1; i < tupleList.size(); i++) {
		// 	int size = tupleList.get(i).size();
		// 	List<Integer> currentList=tupleList.get(i);
		// 	for (int j = 0; j < size; j++) {
		// 		if(!tuple.contains(currentList.get(j))){
		// 			tuple.add(currentList.get(j));
		// 		}
		// 	}
		// }
		//
		// int[] answer = new int[tuple.size()];
		// for(int i=0;i<tuple.size();i++){
		// 	answer[i] = tuple.get(i);
		// }
		//
		// return answer;
	}
}
