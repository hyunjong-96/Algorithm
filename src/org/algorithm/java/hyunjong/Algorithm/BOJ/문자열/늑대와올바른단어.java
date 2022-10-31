package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
/*
올바른 단어는 wolf가 연속적으로 나오거나, 같은 문자가 연속으로 나와 wolf를 구성하는 문자가 연속으로 나와야한다.
idx변수를 하나 선언하고 올바른 단어라면 idx=0은 항상 w가 나오고 w가 연속 1개 이상으로 나오게 된다.
그리고 연속된 w개수 만큼 다른 o,l,f도 연속적으로 나와야한다.
이를 idx가 모든 문자열을 확인할때까지 반복하거나 중간에 w개수를 만족하지 않는 문자가 있거나 모든 문자를 확인하지 못한 경우가 있다면 실패
 */
public class 늑대와올바른단어{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();

		int answer = 0;
		if(isCorrect(word)) answer = 1;

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean isCorrect(String word){
		Character[] wolf = new Character[4];
		wolf[0]='w';
		wolf[1]='o';
		wolf[2]='l';
		wolf[3]='f';

		int idx = 0;
		int N = word.length();
		while(idx<N){
			int wCount = 0;

			if(word.charAt(idx)!='w') return false;
			boolean[] wolfCheck = new boolean[4];
			wolfCheck[0] = true;

			//올바른 단어의 첫번째에는 항상 w가 나오고 연속으로 나올수 있기 때문에 w의 개수를 파악
			while(idx<N && word.charAt(idx)=='w'){
				wCount++;
				idx++;
			}

			/*
			다음 w가 나올때까지 또는 모든 문자열을 확인할때까지 w의 개수만큼 각 문자가 나오는지 확인하고
			각 문자 중 하나라도 개수가 동일하지 않는다면 false
			 */
			while(idx < N && word.charAt(idx)!='w'){
				for(int i=1;i<4;i++){
					char c = wolf[i];

					for(int j=0;j<wCount;j++){
						if(idx >= N || word.charAt(idx++) != c) return false;
						wolfCheck[i] = true;
					}
				}
			}

			//w를 제외한 o,l,f 를 모두 확인했는지 확인
			for(int i=0;i<4;i++){
				if(!wolfCheck[i]) return false;
			}
		}
		return true;
	}
}
