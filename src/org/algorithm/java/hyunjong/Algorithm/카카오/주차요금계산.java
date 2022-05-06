package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 주차요금계산 {
	public static void main(String[] args) {
		String[] records = {"00:00 1234 IN"};
		int[] fees = {1, 461, 1, 10};
		for (int r : solution(fees, records)) {
			System.out.println(r);
		}
	}

	static int basicTime;
	static int basicCost;
	static int perTime;
	static int perCost;

	static int[] solution(int[] fees, String[] records) {
		basicTime = fees[0];
		basicCost = fees[1];
		perTime = fees[2];
		perCost = fees[3];

		HashMap<String, Integer> completeMap = new HashMap<>();
		HashMap<String, Integer> inMap = new HashMap<>();
		List<String> inCarList = new ArrayList<>();
		for (String record : records) {
			String[] rArr = record.split(" ");
			int time = s2i(rArr[0]);
			String number = rArr[1];
			String event = rArr[2];

			if (event.equals("IN")) {
				inMap.put(number, time);
				inCarList.add(number);
			} else {
				completeMap.put(number, completeMap.getOrDefault(number, 0) + time - inMap.get(number));
				inMap.put(number, 0);
				inCarList.remove(number);
			}
		}

		int lastTime = 23 * 60 + 59;
		for (String n : inCarList) {
			int time = lastTime - inMap.get(n);
			completeMap.put(n, completeMap.getOrDefault(n,0) + time);
		}

		int[][] carInfos = new int[completeMap.size()][2];
		int idx = 0;
		for (String n : completeMap.keySet()) {
			carInfos[idx][0] = Integer.parseInt(n);
			carInfos[idx][1] = completeMap.get(n);
			idx++;
		}

		// for(int[] c : carInfos){
		//     System.out.println("number : "+c[0]+" time : "+c[1]);
		// }

		Arrays.sort(carInfos, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] answer = new int[carInfos.length];
		for (int i = 0; i < carInfos.length; i++) {
			answer[i] = getCost(carInfos[i][1]);
		}

		return answer;
	}

	static int getCost(int time) {
		if (time <= basicTime)
			return basicCost;
		int timeCost = (time - basicTime) / perTime;
		if ((time - basicTime) % perTime > 0) {
			timeCost += 1;
		}
		return (timeCost * perCost) + basicCost;
	}

	static int s2i(String time) {
		String[] t = time.split(":");
		int h = Integer.parseInt(t[0]) * 60;
		int m = Integer.parseInt(t[1]);
		return h + m;
	}
}
