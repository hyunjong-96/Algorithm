package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 셔틀버스1차 {
	public static void main(String[] args) {
		int n = 10;
		int t = 60;
		int m = 45;
		String[] timetable = 	{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println(solution(n,t,m,timetable));
	}

	static String solution(int n, int t, int m, String[] timetable){
		int[] convertTimeTable = convertTimeTable(timetable);
		Arrays.sort(convertTimeTable);
		List<List<Integer>> takeBus = new ArrayList<>();
		for(int i=0;i<n;i++){
			takeBus.add(new ArrayList<>());
		}

		int timeTableIndex = 0;
		int arriveTime = 0;
		for(int arrive =0;arrive<n;arrive++){
			arriveTime = 9*60+(t*arrive);

			while(takeBus.get(arrive).size()<m){
				if(timeTableIndex>= convertTimeTable.length) break;
				if(convertTimeTable[timeTableIndex]>arriveTime) break;
				takeBus.get(arrive).add(convertTimeTable[timeTableIndex]);
				timeTableIndex++;
			}
		}

		String answer = "";
		List<Integer> lastBus = takeBus.get(takeBus.size()-1);

		if(lastBus.size() != 0){
			int lastCrewTime = lastBus.get(lastBus.size()-1);
			if(lastBus.size() == m){
				answer = convertTimeToString(lastCrewTime-1);
			}else{
				answer = convertTimeToString(arriveTime);
			}
		}else{
			answer = convertTimeToString(arriveTime);
		}


		return answer;
	}

	static String convertTimeToString(int time){
		StringBuilder sb = new StringBuilder();
		int h = time/60;
		int m = time%60;

		if(h<10) sb.append("0");
		sb.append(h);
		sb.append(":");
		if(m<10) sb.append("0");
		sb.append(m);
		return sb.toString();
	}

	static int[] convertTimeTable(String[] timetable){
		int[] convertTimeTable = new int[timetable.length];
		for(int t=0;t<timetable.length;t++){
			String[] arr = timetable[t].split(":");
			int h = Integer.parseInt(arr[0])*60;
			int m = Integer.parseInt(arr[1]);
			convertTimeTable[t] = h+m;
		}
		return convertTimeTable;
	}
}
