package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기 {
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(n,data));
	}
	static int N;
	static String[] data;
	static Map<Character,Integer> map;
	static boolean[] visit = new boolean[8];
	static int[] position = new int[8];
	static int answer;
	public static int solution(int n, String[] d){
		N = n;
		data = d;
		map = new HashMap<>();
		map.put('A',0);
		map.put('C',1);
		map.put('F',2);
		map.put('J',3);
		map.put('M',4);
		map.put('N',5);
		map.put('R',6);
		map.put('T',7);

		answer=0;
		dfs(0);

		return answer;
	}

	static void dfs(int idx){
		if(idx>=8){
			if(checkCondition()){
				answer++;
			}
			return;
		}

		for(int i=0;i<8;i++){
			if(!visit[i]){
				visit[i] = true;
				position[idx] = i;
				dfs(idx+1);
				visit[i] = false;
			}
		}
	}

	static boolean checkCondition(){
		for(int i=0;i<data.length;i++){
			int first = map.get(data[i].charAt(0));
			int second = map.get(data[i].charAt(2));
			char op = data[i].charAt(3);
			int range = data[i].charAt(4)-'0'+1;

			switch(op){
				case '=':
					if(Math.abs(position[first]-position[second]) != range) return false;
					break;
				case '>':
					if(Math.abs(position[first]-position[second]) <= range) return false;
					break;
				case '<':
					if(Math.abs(position[first]-position[second]) >= range) return false;
					break;
			}
		}
		return true;
	}
}
