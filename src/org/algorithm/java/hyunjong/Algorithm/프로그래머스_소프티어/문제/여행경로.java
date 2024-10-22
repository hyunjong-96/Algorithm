package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
공항을 index로 변환해주는 airPortNum
연결된 공항을 저장하는 linked
	인접 리스트로 연결된 공항으로 dfs하고 알파벳 순서가 앞서는 경로부터 이동하기 위해 PriorityQueue 사용

위상정렬을 사용했는데 위상정렬에는 indegree를 이용한 BFS 풀이와 DFS를 이용한 풀이가 있다.
	인접배열사용시 O(V^2), 인접 리스트 사용시 O(V+E)의 시간복잡도가 발생한다.
	해당 문제에서는 DFS를 이용해 PQ를 이용해 인접 리스트를 사용했다.

linked를 PQ배열로 tickets에 들어오는 공항을 airPortNum에 저장하고 생성된 index를 linked[index]에 연결된 공항을 저장하였다.
INC공항을 시작으로 연결된 공항을 PQ.poll()로 뽑아오면서 dfs를 수행한다.
	연결된 공항을 pq.poll()로 뽑게된다면 연결된 공항으로 가는 티켓을 재사용할수 없게 된다. (핵심)
	그리고 우선순위로 공항의 알파벳순으로 경로를 정할수 있다.
더 이상 연결된 공항이 없다면 Stack에 해당 공항을 저장한다.

stack에는 경로가 알파벳순으로 접근한대로 저장이되어있으며 마지막 stack에 출발한 INC을 넣어서 stack.pop()을 index을 0부터
순차적으로 배열에 넣어서 반환한다.
 */
public class 여행경로 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] result = solution(tickets);
		for(String r : result){
			System.out.println(r);
		}
	}

	static public String[] solution(String[][] tickets) {
		Map<String, Integer> airPortNum = new HashMap<>();
		PriorityQueue<String>[] linked = new PriorityQueue[10000];
		for(int i=0;i<linked.length;i++){
			linked[i] = new PriorityQueue<>();
		}
		int num = 0;
		for(String[] ticket : tickets){
			String departure = ticket[0];
			String arrival = ticket[1];
			if(!airPortNum.containsKey(departure)){
				airPortNum.put(departure, num++);
			}
			linked[airPortNum.get(departure)].add(arrival);

			if(!airPortNum.containsKey(arrival)){
				airPortNum.put(arrival, num++);
			}
		}

		Stack<String> stack = new Stack<>();
		int start = airPortNum.get("ICN");
		dfs(linked, stack,airPortNum, start);

		String[] answer = new String[stack.size()+1];
		int index = 0;
		stack.push("ICN");
		while(!stack.isEmpty()){
			answer[index++] = stack.pop();
		}

		return answer;
	}

	static void dfs(PriorityQueue<String>[] linked, Stack<String> stack, Map<String,Integer> airPortNum, int currentAirPort){
		while(!linked[currentAirPort].isEmpty()){
			String linkAirPort = linked[currentAirPort].poll();

			dfs(linked, stack, airPortNum, airPortNum.get(linkAirPort));
			stack.push(linkAirPort);
		}
	}
}
