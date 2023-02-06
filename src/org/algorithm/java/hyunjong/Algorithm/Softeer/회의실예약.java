package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 회의실예약 {
	static Map<String, ArrayList<int[]>> map;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			String room = br.readLine();
			map.put(room, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String room = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			map.get(room).add(new int[] {start, end});
		}

		StringBuilder sb = new StringBuilder();
		for (String room : map.keySet()) {
			List<int[]> timeListOfRoom = getRestTime(room);

			sb.append("Room ").append(room).append(":").append("\n");
			if (timeListOfRoom.size() > 0) {
				sb.append(timeListOfRoom.size()).append(" available:").append("\n");
				for (int[] time : timeListOfRoom) {
					String convertTime = convertTimeToString(time);
					sb.append(convertTime).append("\n");
				}
			} else {
				sb.append("Not available").append("\n");
			}
			sb.append("-----").append("\n");
		}
		int stringSize = sb.length();
		sb.delete(stringSize - 6, stringSize);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static String convertTimeToString(int[] time) {
		int start = time[0];
		int end = time[1];

		String startTime = String.format("%02d", start);
		String endTime = String.format("%02d", end);

		return startTime + "-" + endTime;
	}

	static List<int[]> getRestTime(String room) {
		List<int[]> timeListOfRoom = map.get(room);
		boolean[] useTime = new boolean[19];

		for (int[] t : timeListOfRoom) {
			for (int i = t[0] + 1; i <= t[1]; i++) {
				useTime[i] = true;
			}
		}

		if(room.equals("grandeur")){
			System.out.println();
		}

		List<int[]> timeList = new ArrayList<>();
		for (int t = 9; t <= 18; t++) {
			//t시간과 t+1시간 둘다 사용했다면 해당 t시간에는 회의가 끝나지 않음
			//if(useTime[t] && useTime[t+1]) continue;

			int start = t;
			int end = ++t;
			while (t <= 18 && !useTime[t]) {
				end = t++;
			}
			//if(t<=18) end = t;

			t--;
			if(start==t) continue;
			timeList.add(new int[] {start, end});

		}

		return timeList;
	}
}
