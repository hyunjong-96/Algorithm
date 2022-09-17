package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
녹음된 울음소리를 list에 저장하고 알고있는 동물의 울음소리는 set에 저장한다.
list를 선형탐색하면서 set에 저장된 울음소리가 없다면 여우 울음소리이기 때문에 sb에 저장한다.
반복.
 */
public class 여우는어떻게울까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			String[] sArr = br.readLine().split(" ");
			List<String> sounds = new ArrayList<>(Arrays.asList(sArr));
			Set<String> otherSounds = new HashSet<>();
			while(true){
				String info = br.readLine();
				if(info.equals("what does the fox say?")) break;

				String[] infoArr = info.split(" ");
				otherSounds.add(infoArr[2]);
			}


			for(String sound : sounds){
				if(!otherSounds.contains(sound)) sb.append(sound).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
