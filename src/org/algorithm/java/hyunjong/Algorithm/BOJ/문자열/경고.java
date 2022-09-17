package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 경고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int now = getTime(br.readLine());
		int target = getTime(br.readLine());

		int result = 0;
		if(now >= target){
			now = 24*3600 - now;
			result = target+now;
		}else{
			result = target-now;
		}

		bw.write(toTime(result));
		bw.flush();
		bw.close();
	}

	static int getTime(String time){
		String[] t = time.split(":");
		int convertTime = 0;
		convertTime += Integer.parseInt(t[0])*3600;
		convertTime += Integer.parseInt(t[1])*60;
		convertTime += Integer.parseInt(t[2]);
		return convertTime;
	}

	//%02d
	//10진수로 두자리의 정수로 나타낸다. 단 부족할 경우 0으로 채운다.
	static String toTime(int time){
		StringBuilder sb = new StringBuilder();

		int hour = time/3600;
		time %= 3600;
		int min = time/60;
		time %= 60;

		sb.append(String.format("%02d",hour));
		sb.append(":");
		sb.append(String.format("%02d",min));
		sb.append(":");
		sb.append(String.format("%02d",time));
		return sb.toString();
	}
}
