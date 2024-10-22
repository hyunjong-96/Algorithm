package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.Stack;

public class 표편집 {
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = 	{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n,k,cmd));
	}

	static Stack<Tuple> deletes;
	static String solution(int n, int k, String[] cmd){
		int[] prev = new int[n];
		int[] next = new int[n];
		deletes = new Stack<>();

		StringBuilder status = new StringBuilder();
		for(int i=0;i<n;i++){
			status.append('O');
			prev[i]=i-1;
			next[i]=i+1;
		}
		next[next.length-1]=-1;

		int cursor = k;
		for(String command : cmd){
			String[] c = command.split(" ");
			String method = c[0];
			int move = 0;
			switch(method){
				case "D":
					move = Integer.parseInt(c[1]);
					while(move-- > 0) cursor = next[cursor];
					break;
				case "U":
					move = Integer.parseInt(c[1]);
					while(move-- > 0) cursor = prev[cursor];
					break;
				case "C":
					deletes.add(new Tuple(prev[cursor], cursor, next[cursor]));
					if(prev[cursor]!=-1) next[prev[cursor]] = next[cursor];
					if(next[cursor]!=-1) prev[next[cursor]] = prev[cursor];
					status.setCharAt(cursor, 'X');
					if(next[cursor]!=-1) cursor = next[cursor];
					else cursor = prev[cursor];
					break;
				case "Z":
					Tuple t = deletes.pop();
					if(t.prev != -1) next[t.prev] = t.num;
					if(t.next != -1) prev[t.next] = t.num;
					status.setCharAt(t.num,'O');
					break;
			}
		}

		return status.toString();
	}

	static class Tuple{
		int prev;
		int num;
		int next;
		public Tuple(int prev, int num, int next){
			this.prev = prev;
			this.num = num;
			this.next = next;
		}
	}
}
