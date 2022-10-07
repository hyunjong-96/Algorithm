package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/*
오리 울음소리를 q:0, u:1, a:2, c:3, k:4로 선언한다.
울음소리 순서 여부를 판별하기 위한 quack배열은 특정 문자가 나왔을때 해당 문자 이전의 숫자 하나를 줄이고 해당 문자 숫자를 늘려준다.
	예를 들어 a일때 숫자로는 2이다. 그렇다면 quack[2]++, quack[1]--을 해준다.
	이는 오리 울음소리는 연속적이지 않아도 되지만 순차적으로 나와야하기 때문에 이전 문자를 삭제해줌으로써
	하나의 오리가 a까지 울음을 내었다는 의미이다.
	만약 이전 숫자가 0이라면 순차적인 울음소리가 아니기 때문에 -1을 반환해주어야 한다.

	[1,2,0,0,1]인경우
	현재 총 3마리의 오리가 있는 경우이다. 5의 울음소리는 이미 다 울었기 때문에 적용시켜주지 않는다.
	두마리는 qu까지 울었고, 다른 한마리는 q까지 울은것이다.

주어진 울음소리를 한 문자씩 읽어가면서 해당 문자를 숫자로 변경하여 quack배열을 갱신해준다.
모든 문자를 파악한 뒤 quack배열이 0~3, 즉, q,u,a,c의 위치에 1이상의 값이 남아있다면 정상적인 울음소리가 아니기 때문에
이또한 -1을 반환해준다.
 */
public class 오리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String record = br.readLine();

		Map<Character, Integer> map = new HashMap<>();
		map.put('q',0);
		map.put('u',1);
		map.put('a',2);
		map.put('c',3);
		map.put('k',4);

		int[] quack = new int[5];
		int answer = 0;
		for (int i = 0; i < record.length(); i++) {
			char c = record.charAt(i);

			int num = map.get(c);

			quack[num]++;
			//q문자인 경우 울음소리의 첫 문자이기 때문에 넘어간다.
			if(num>0){
				//이전 숫자가 0이라면 정상적이지 못한 울음소리
				if(quack[num-1]==0){
					answer = -1;
					break;
				}
				//이전 문자를 빼줌으로써 현재 문자에 해당 오리가 해당 문자까지 울었다는 것을 표시
				quack[num-1]--;
			}
			answer = Math.max(answer, quack[0]+quack[1]+quack[2]+quack[3]);
		}

		for(int i=0;i<4;i++){
			if(quack[i] != 0){
				answer = -1;
				break;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
