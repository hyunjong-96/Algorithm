package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ㅋㅋ루ㅋㅋ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String sequence = br.readLine();

		List<Integer> lk = new ArrayList<>();
		List<Integer> rk = new ArrayList<>();

		int kCount = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if(sequence.charAt(i)=='K') kCount++;
			else lk.add(kCount);
		}

		kCount=0;
		for(int i=sequence.length()-1;i>=0;i--){
			if(sequence.charAt(i)=='K') kCount++;
			else rk.add(kCount);
		}

		rk.sort(Comparator.reverseOrder());

		int left=0;
		int right=rk.size()-1;
		int answer = 0;
		while(left<=right){
			answer = Math.max(answer, (right-left+1)+2*(Math.min(lk.get(left),rk.get(right))));

			if(lk.get(left)<=rk.get(right)){
				left++;
			}else{
				right--;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();

	}
}
