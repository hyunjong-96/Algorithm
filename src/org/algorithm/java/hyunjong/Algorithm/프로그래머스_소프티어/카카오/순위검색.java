package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
첫번째 풀이
언어, 직근, 경력, 소울푸드의 정보를 map의 key로 value를 각 사용자의 id를 저장.
코테 점수는 scoreList에 따로 저장(index를 id로 생각하여 저장)
모든 정보를 저장한 후 query에서 요청하는 각 정보들의 id리스트와 query에서 요청하는 점수 이상인 id리스트를 map과 scoreList에서 추출하여
List의 retainAll 함수를 사용하여 교집합인 list의 크기를 반환하여 결과 배열에 저장하여 반환하였다.
정확성은 통과했지만 효율성에서 시간초과가 발생했다.
1<=info<=50000 && 1<=query<=100000 인 제한 사항이 있기 떄문에 위의 풀이로하면
retainAll하는 과정에서 초과가 날수밖에 없다.
물론 통과 못할거라고 생각했지만 더 좋은 방법이 떠오르지 않았었다.

두번째 풀이
참말로 기가막힌 방법일수 밖에 없었다. 생각지도 못했던 풀이였다ㅋㅋ
map의 key값으로 사용자의 정보를 재귀함수를 사용하여 "-"를 포함한 사용자의 정보를 저장하였다.
그리고 value에는 해당 key를 가지고 있는 사용자의 코테 점수를 저장하였다.

저장된 코테 점수를 이분탐색하기 위해 오름차순으로 정렬한다(핵심)

query를 [조건string, 코테점수]로 분리를 시킨다.
그런다음 map의 key에서 조건string을 가지고 있는 value를 가져와 이분탐색을 통해 갯수를 반환한다.
이때 query의 조건 string이 map에 존재하지 않을수 있기 때문에 존재하지 않으면 0을 반환한다.(놓치고 있던 부분)

각 query에 해당하는 argument로 갯수를 반환받으면 answer배열에 저장해서 반환하면 된다.
 */
public class 순위검색 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150"};
		String[] query = {"- and - and - and - 100"};
		for (int r : solution(info, query)) {
			System.out.println(r);
		}
	}

	static HashMap<String, List<Integer>> InfoMap;
	static int[] scoreList;

	public static int[] solution(String[] info, String[] query) {
		// InfoMap = new HashMap<>();
		// InfoMap.put("java", new ArrayList<>());
		// InfoMap.put("cpp", new ArrayList<>());
		// InfoMap.put("python", new ArrayList<>());
		// InfoMap.put("backend", new ArrayList<>());
		// InfoMap.put("frontend", new ArrayList<>());
		// InfoMap.put("junior", new ArrayList<>());
		// InfoMap.put("senior", new ArrayList<>());
		// InfoMap.put("chicken", new ArrayList<>());
		// InfoMap.put("pizza", new ArrayList<>());
		// InfoMap.put("-",new ArrayList<>());
		//
		// scoreList = new int[info.length];
		// for(int i=0;i<info.length;i++){
		// 	String[] infoArr = info[i].split(" ");
		// 	for(int inf = 0;inf < infoArr.length;inf++){
		// 		if(inf == 4){
		// 			scoreList[i] = Integer.parseInt(infoArr[inf]);
		// 		}else{
		// 			InfoMap.get(infoArr[inf]).add(i);
		// 		}
		// 		InfoMap.get("-").add(i);
		// 	}
		// }
		//
		// int idx = 0;
		// int[] answer = new int[query.length];
		// for(String q : query){
		// 	q = q.replace(" and", "");
		// 	String[] queryArr = q.split(" ");
		//
		// 	List<Integer> langList = InfoMap.get(queryArr[0]);
		// 	List<Integer> workList = InfoMap.get(queryArr[1]);
		// 	List<Integer> time = InfoMap.get(queryArr[2]);
		// 	List<Integer> food = InfoMap.get(queryArr[3]);
		// 	List<Integer> score = new ArrayList<>();
		// 	for(int s = 0;s<scoreList.length;s++){
		// 		if(scoreList[s] >= Integer.parseInt(queryArr[4])){
		// 			score.add(s);
		// 		}
		// 	}
		//
		// 	score.retainAll(langList);
		// 	score.retainAll(workList);
		// 	score.retainAll(time);
		// 	score.retainAll(food);
		//
		// 	answer[idx] = score.size();
		// 	idx++;
		// }
		// return answer;

		InfoMap = new HashMap<>();
		for (String i : info) {
			//info의 정보를 key로 코테 점수를 value로 저장하는 함수
			setInfo("", 0, i.split(" "));
		}

		//map의 value를 오름차순으로 정렬
		for (String k : InfoMap.keySet()) {
			Collections.sort(InfoMap.get(k));
		}

		int[] answer = new int[query.length];
		//query를 [조건string, 점수]로 변환하여 조건을 만족하는 지원자 갯수를 반환하는 함수
		for (int q = 0; q < query.length; q++) {
			answer[q] = setQuery(query[q]);
		}
		return answer;
	}

	static void setInfo(String infoString, int idx, String[] info) {
		if (idx >= 4) {
			//지원자 정보를 key로 저장하고 value에 해당 지원자의 코테 점수를 저장
			if (!InfoMap.containsKey(infoString)) {
				InfoMap.put(infoString, new ArrayList<>());
			}
			InfoMap.get(infoString).add(Integer.parseInt(info[4]));
			return;
		}

		//지원자 정보를 key로 저장할때 "-"를 포함한 key도 생성하기 위한 함수 호출
		setInfo(infoString + "-", idx + 1, info);
		//지원자 일부 정보를 포함한 key를 생성하기 위한 함수
		setInfo(infoString + info[idx], idx + 1, info);
	}

	static int setQuery(String query) {
		//[조건string, 점수]로 치환하기 위해 코테 점수를 제외한 모든 조건을 붙여준다.
		query = query.replace(" and ", "");
		//q[0] = 조건string, q[1] = 점수
		String[] q = query.split(" ");

		//조건string에 부합하는 지원자가 없는 경우 0반환
		if(!InfoMap.containsKey(q[0])) return 0;
		//이분 탐색을 통해 start를 코테 점수 이상인 index로 갱신한다.
		List<Integer> scoreList = InfoMap.get(q[0]);
		int score = Integer.parseInt(q[1]);
		int start = 0;
		int end = scoreList.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (scoreList.get(mid) >= score) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		//scoreList.size()-start를 함으로써 query의 점수 이상인 지원자 수를 구할수 있다.
		return scoreList.size() - start;
	}
}
