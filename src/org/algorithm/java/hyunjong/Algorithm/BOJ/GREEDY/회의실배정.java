package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정 {
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		//회의 끝시간을 정렬로 하되, 끝시간이 같다면 시작시간도 오름차순으롷 정렬해줘야한다
		//시작시간 정렬안할시 반례) (6,7) (6,6) (5,6) (5,5) (7,7)
		@Override
		public int compareTo(Meeting o) {
			if(this.end != o.end){
				if(this.end > o.end) return 1;
				else return -1;
			}else{
				if(this.start > o.start) return 1;
				else return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(i, new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int count = 0;
		int min = 0;
		for (int i = 0; i < N; i++) {
			if(list.get(i).start >= min){
				min = list.get(i).end;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
