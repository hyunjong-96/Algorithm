package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.PriorityQueue;
import java.util.Stack;

/*

 */
public class 방금그곡3차 {
	public static void main(String[] args) {
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
	}

	static String solution(String m, String[] musicinfos) {
		String answer = "(None)";

		String[] M = setMelody(m);
		PriorityQueue<Music> musicPQ = new PriorityQueue<>();

		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");
			int runTime = runTime(info[0], info[1]);
			String title = info[2];
			String[] melody = setMelody(info[3]);
			boolean isFind = false;
			for (int i = 0; i < runTime; i++) {
				int j = i;
				for (int l = 0; l < M.length; l++) {

					if (M[l].equals(melody[j % melody.length])) {
						isFind = true;
						j++;
					} else {
						isFind = false;
						break;
					}
				}
				if (isFind) {
					break;
				}
			}

			if (isFind) {
				musicPQ.offer(new Music(title, runTime));
			}
		}

		if (musicPQ.size() > 0) {
			answer = musicPQ.poll().title;
		}

		return answer;
	}

	static public String[] setMelody(String melody) {
		Stack<String> stack = new Stack<>();
		for (char m : melody.toCharArray()) {
			if (m >= 'A' && m <= 'Z') {
				stack.push(String.valueOf(m));
			} else {
				String s = stack.pop();
				stack.push(s + m);
			}
		}

		String[] arr = new String[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			arr[i] = stack.pop();
		}
		return arr;
	}

	static public int runTime(String startTime, String endTime) {
		int h = (Integer.parseInt(endTime.substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2))) * 60;
		int m = Integer.parseInt(endTime.substring(3)) - Integer.parseInt(startTime.substring(3));
		return h + m;
	}

	static public class Music implements Comparable<Music> {
		String title;
		int runTime;

		public Music(String title, int runTime) {
			this.title = title;
			this.runTime = runTime;
		}

		@Override
		public int compareTo(Music o) {
			return o.runTime - this.runTime;
		}
	}
}
