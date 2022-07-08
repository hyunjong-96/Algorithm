package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 키로거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String inputString = br.readLine();

			Cursor cursor = null;
			for (int i = 0; i < inputString.length(); i++) {
				char input = inputString.charAt(i);

				if(input == '<' || input == '>' || input == '-'){
					if(cursor == null) continue;

					if(input == '<' && cursor.left != null){
						cursor = cursor.left;
					}
					if(input == '>' && cursor.right != null){
						cursor = cursor.right;
					}
					if(input == '-'){
						if(cursor.current != null){
							if(cursor.left != null)
								cursor.left.right = cursor.right;
							if(cursor.right != null)
								cursor.right.left = cursor.left;

							cursor = cursor.left;
							if(cursor != null && cursor.current==null && cursor.right == null)
								cursor = null;
						}

					}
				}else{
					if(cursor == null){
						cursor = new Cursor(input, null, null);
						Cursor leftEnd = new Cursor(null,null,null);
						cursor.left = leftEnd;
						leftEnd.right = cursor;
					}else{
						Cursor newCursor = new Cursor(input, cursor, cursor.right);
						if(cursor.right != null)
							cursor.right.left = newCursor;
						cursor.right = newCursor;

						cursor = newCursor;
					}
				}
			}

			while(cursor != null && cursor.left != null){
				cursor = cursor.left;
			}

			while(cursor != null && cursor.right != null){
				cursor = cursor.right;
				if(cursor.current == null) continue;

				sb.append(cursor.current);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class Cursor{
		Character current;
		Cursor left;
		Cursor right;
		public Cursor(Character current, Cursor left, Cursor right){
			this.current = current;
			this.left = left;
			this.right = right;
		}
	}
}
