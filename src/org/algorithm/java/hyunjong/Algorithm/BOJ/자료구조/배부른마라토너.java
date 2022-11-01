package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
/*
Map에 참가자 이름과 참가자 명수를 저장한다.
N-1명의 완주자를 map에서 value를 1씩 뺀다. 그리고 map의 key에서 1을 가지는 사람이 완주하지 않은 사람
이는 동명이인이 있는 경우 동명이인 중 한명이 완주하지 않았을 경우를 확인하기 위한 방법
 */
public class 배부른마라토너{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Map<String, Integer> participants = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			String name = br.readLine();
			participants.put(name, participants.getOrDefault(name, 0)+1);
		}

		for(int i=0;i<N-1;i++){
			String name = br.readLine();
			participants.put(name, participants.get(name)-1);
		}

		String answer = "";
		for(String name : participants.keySet()){
			if(participants.get(name) > 0) {
				answer = name;
				break;
			}
		}

		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
