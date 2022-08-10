package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
질문에서 경우의 숫자를 뽑아내는것이 아닌, 모든 숫자 0~9까지의 숫자로 3자리의 숫자를 만들어 질문과 비교해
strike와 ball의 개수를 비교하여 모든 질문의 조건을 만족하는 숫자를 뽑아내는 완전탐색.
 */
public class 숫자야구 {
	static String[] ask;
	static int[] strike;
	static int[] ball;
	static int answer;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		ask = new String[N];
		strike = new int[N];
		ball = new int[N];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			ask[i] = st.nextToken();
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		setNumber(new int[3], new boolean[10], 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setNumber(int[] number, boolean[] check, int depth){
		if(depth == 3){
			StringBuilder num = new StringBuilder();
			for(int i=0;i<3;i++){
				num.append(number[i]);
			}
			if(isTrueBaseball(num.toString())){
				answer++;
			}
			return;
		}

		for(int i=1;i<=9;i++){
			if(!check[i]){
				check[i] = true;
				number[depth] = i;
				setNumber(number, check, depth+1);
				number[depth] = 0;
				check[i] = false;
			}
		}
	}

	static boolean isTrueBaseball(String number){
		for(int i=0;i<N;i++){
			int s = 0;
			int b = 0;

			for(int j=0;j<3;j++){
				if(number.charAt(j) == ask[i].charAt(j)){
					s++;
				}
				for(int k=0;k<3;k++){
					if(j!=k && number.charAt(k) == ask[i].charAt(j)){
						b++;
					}
				}
			}

			if(strike[i] != s || ball[i] != b) return false;
		}

		return true;
	}
}
