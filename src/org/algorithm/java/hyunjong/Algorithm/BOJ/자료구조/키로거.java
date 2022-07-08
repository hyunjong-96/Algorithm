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
					//특수 문자 일 때 cursor가 null이면 무시
					if(cursor == null) continue;

					//왼쪽 이동시 왼쪽이 null이면 이동불가능
					//null이 아니면 왼쪽으로 커서 이동
					if(input == '<' && cursor.left != null){
						cursor = cursor.left;
					}
					//오른쪽 이동시 오른쪽이 null이면 이동불가능
					//null이 아니면 오른쪽으로 커서 이동
					if(input == '>' && cursor.right != null){
						cursor = cursor.right;
					}
					if(input == '-'){
						//삭제 연산시 커서가 가리키는 값이 null이 아니라면 현재 값을 삭제하고 현재 커서의 왼쪽과 오른쪽을 연결해준다.
						if(cursor.current != null){
							if(cursor.left != null)
								cursor.left.right = cursor.right;
							if(cursor.right != null)
								cursor.right.left = cursor.left;

							//커서는 값의 오른쪽에 존재한다고 가정하므로 삭제시 왼쪽에 있는 값으로 커서를 이동
							cursor = cursor.left;
							//만약 커서 이동후 커서가 왼쪽 끝에 있으면서 오른쪽에 값이 존재하지 않다면 모든 값을 삭제한것임.
							if(cursor != null && cursor.current==null && cursor.right == null)
								cursor = null;
						}

					}
				}else{
					//cursor가 null을 가리키면 cursor는 현재 값을 가리키고 있으며 왼쪽 끝을 표시하기 위해 Cursor.current가 null인 객체를 생성 후 왼쪽에 연결한다.
					if(cursor == null){
						cursor = new Cursor(input, null, null);
						Cursor leftEnd = new Cursor(null,null,null);
						cursor.left = leftEnd;
						leftEnd.right = cursor;
					}else{
						//커서가 어떤 값을 가리키고 있다면 커서가 가리키는 값의 오른쪽에 새로운 값을 생성하고 커서를 새로운 값을 가리키게 한다.
						Cursor newCursor = new Cursor(input, cursor, cursor.right);
						if(cursor.right != null)
							cursor.right.left = newCursor;
						cursor.right = newCursor;

						cursor = newCursor;
					}
				}
			}

			//커서의 가장 왼쪽으로 이동 시킨 후 오른쪽으로 이동시키면서 cursor.current를 반환한다.
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
