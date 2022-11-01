package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
/*
시간의 크기를 비교해야하기 때문에 int타입으로 변경해주고 개강시작이전에 채팅은 in에,
개강총회가끝나고 스트리밍이 끝나는 사이에 채팅이 있다면 out에 저장한다.
그리고 in을 선형탐색하면서 out에도 in의 닉네임이 포함되어있다면 정상적으로 출석이 확인된 인원이다.
 */
public class 싸이버개강총회{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int START = convertToIntegerTime(st.nextToken());
		int END = convertToIntegerTime(st.nextToken());
		int END_STREAMING = convertToIntegerTime(st.nextToken());

		Set<String> in = new HashSet<>();
		Set<String> out = new HashSet<>();
		while(true){
			String chat = br.readLine();
			if(chat==null) break;

			String[] chatInfo = chat.split(" ");
			int time = convertToIntegerTime(chatInfo[0]);
			String nickName = chatInfo[1];

			if(time<=START){
				in.add(nickName);
			}else if(END<= time && time <=END_STREAMING){
				out.add(nickName);
			}
		}

		int answer = 0;
		for(String inNickName : in){
			if(out.contains(inNickName)) answer++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	public static int convertToIntegerTime(String time){
		String[] tArr = time.split(":");
		return Integer.parseInt(tArr[0])*60 + Integer.parseInt(tArr[1]);
	}
}
