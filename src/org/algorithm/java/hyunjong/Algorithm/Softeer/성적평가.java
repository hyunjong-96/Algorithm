package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;


public class 성적평가
{
	static int N;
	public static void main(String args[])
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[] totalPoint = new int[N];

		StringBuilder sb = new StringBuilder();

		for(int c=0;c<3;c++){
			PriorityQueue<Participant> pq = new PriorityQueue<>();

			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				int point = Integer.parseInt(st.nextToken());

				pq.offer(new Participant(i,point));
				totalPoint[i] += point;
			}

			int[] grades = getGrade(pq);

			for(int i=0;i<N;i++){
				sb.append(grades[i]).append(" ");
			}
			sb.append("\n");
		}


		PriorityQueue<Participant> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			pq.offer(new Participant(i, totalPoint[i]));
		}

		int[] grades = getGrade(pq);

		for(int i=0;i<N;i++){
			sb.append(grades[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] getGrade(PriorityQueue<Participant> pq){
		int[] grades = new int[N];

		Participant first = pq.poll();
		int grade = 1;
		int prevPoint = first.point;
		int sameCount = 1;

		grades[first.idx] = grade;

		while(!pq.isEmpty()){
			Participant participant = pq.poll();

			if(prevPoint != participant.point){
				grade += sameCount;
				sameCount = 1;
			}
			else{
				sameCount++;
			}

			grades[participant.idx] = grade;
			prevPoint = participant.point;
		}

		return grades;
	}

	static class Participant implements Comparable<Participant>{
		int idx;
		int point;

		public Participant(int idx, int point){
			this.idx = idx;
			this.point = point;
		}

		@Override
		public int compareTo(Participant o){
			return o.point - this.point;
		}
	}
}
