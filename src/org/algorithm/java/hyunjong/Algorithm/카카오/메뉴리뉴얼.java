package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
완전 탐색 문제이다.
손님들의 단품메뉴를 담은 배열 orders와 후보 메뉴를 뽑을 단품 메뉴 갯수를 담은 course가 주어진다.

course에서 각 단품메뉴의 갯수를 기준으로 각 손님들이 주문한 메뉴들중에서 해당 메뉴 갯수를 뽑아내서
map에 각각 저장한다. 이때 후보 메뉴에 오를 수 있는 메뉴 구성은 2명이상의 손님이 먹은 메뉴만 가능하고
후보 메뉴중 각 메뉴 갯수중 가장 많은 선택을 받은 메뉴 구성이 올라갈수 있기 때문에 해당 메뉴 갯수에서 가장 많은 선택을 받은
그 수를 저장해야한다.
해당 메뉴 갯수에서 저장된 메뉴 구성 중 2명 이상의 손님이 주문했고 가장 많은 선택을 받은 후보 메뉴를 PQ에 저장해서
사전순으로 오름차순되도록 한다.
 */
public class 메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		for(String s : solution(orders, course)){
			System.out.println(s);
		}
	}

	static PriorityQueue<String> pq;
	static String[] orders;
	static int[] course;
	static HashMap<String,Integer> map;
	static int orderCount;
	static String[] solution(String[] os, int[] cs){
		orders = os;
		course = cs;
		pq = new PriorityQueue<>();

		//각 코스요리의 메뉴 구성 갯수
		for(int c : course){
			//해당 메뉴 구성 갯수마다 map을 초기화
			map = new HashMap<>();
			//가장 많은 orderCount를 가진 메뉴 구성만 코스 메뉴에 오를수 있다.
			orderCount=0;
			//각 주문 리스트를 뽑아서 메뉴 구성을 만든다.
			for(String m : orders){
				//메뉴 구성은 setMenu에서 수행
				setMenu(0, 0, "", m,c);
			}
			//모든 orders에서 후보 메뉴를 구했다면 orderCount가 최고로 높고 2명 이상의 손님이 주문한 것으로 선택
			for(String s : map.keySet()){
				if(map.get(s)==orderCount && orderCount>1){
					pq.offer(s);
				}
			}
		}

		String[] result = new String[pq.size()];
		for(int r =0;r<result.length;r++){
			result[r] = pq.poll();
		}
		return result;
	}

	/*
	count : 현재 선택된 단품 메뉴 갯수
	idx : 해당 주문 리스트에서 시작으로 선택할수 있는 메뉴 위치(orderMenu의 위치)
	courseMenu : 후보 메뉴(AB, AC 등..)
	orderMenu : 해당 주문 리스트(한 명 손님의 주문 리스트-문자열)
	targetCount : 목표로 하는 단품 메뉴 갯수
	 */
	static void setMenu(int count, int idx, String courseMenu, String orderMenu, int targetCount){
		if(count >= targetCount){
			char[] courseMenuArr = courseMenu.toCharArray();
			//중복되는 메뉴 구성을 막기 위한 정렬
			Arrays.sort(courseMenuArr);
			StringBuilder sb = new StringBuilder();
			//정렬된 후보 메뉴 문자열화
			for(int j=0;j<courseMenuArr.length;j++){
				sb.append(courseMenuArr[j]);
			}
			map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);

			//최고로 많이 선택된 메뉴의 선택 빈도
			orderCount = Math.max(map.get(sb.toString()),orderCount);
			return;
		}

		//해당 주문 리스트를 기준으로 후보 메뉴를 하나하나 만들어본다.
		for(int i=idx;i<orderMenu.length();i++){
			char[] orderMenuArr = orderMenu.toCharArray();
			setMenu(count+1,i+1,courseMenu+orderMenuArr[i],orderMenu, targetCount);
		}
	}
}
