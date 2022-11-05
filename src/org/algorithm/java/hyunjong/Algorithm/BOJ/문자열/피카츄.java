package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
public class 피카츄{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String sound = br.readLine();

		//replaceAll에 적용하고 싶은 것
		// sound = sound.replace("pi","");
		// sound = sound.replace("ka","");
		// sound = sound.replace("chu","");

		//오답
		/*
		[]안의 요소들은 하나의 문자별로 인식하기 때문에 ()가 무의미
		 */
		// sound = sound.replaceAll("[(pi)(ka)(chu)]","");

		//정답
		sound = sound.replaceAll("pi|ka|chu","");

		String answer = sound.length()==0 ? "YES" : "NO";

		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
