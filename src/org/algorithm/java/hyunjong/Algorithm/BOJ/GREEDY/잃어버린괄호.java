package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
어떻게 괄호를 치게 되면 가장 작은 값이 될까 고민하다가 음수의 뒤에 나오는 양수들을 모두 괄호에 묶어주게 된다면
그 값들은 모두 음수가 되기 때문에 최대한 작은 값이 나오게 될것이다.
계산식을 받아오면서 처음에는 무조건 +가 나오게 되므로 그 숫자들을 저장해두었다가
다른 부등호가 나오게 되면 저장된 값을 결과값에 더해주고
다음 부등호가 음수가 나오게 된다면 뒤에 나오는 수들이 음수가 나올때까지 전부 합해준다.(핵심)
 */
public class 잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		List<Integer> list = new ArrayList<>();
		String num = "";
		char p = '+';
		for (char c : s.toCharArray()) {
			if (c == '+' || c == '-') {	//식에서 부등호가 나왔을경우
				if (p == '+') {	//그리고 이전 식의 부등호가 +인 경우 저장된 값을 +해준다.
					list.add(Integer.parseInt(num));
				} else {	//만약 이전 식의 부등호가 -인 경우 현재 값의 부등호는 중요하지 않고 무조건 -해준다(앞의 음수값과 합쳐져야하니까)
					list.add(-Integer.parseInt(num));
				}
				num = "";
				p = c;
			} else {
				num += c;
			}
		}
		if (p == '+') {
			list.add(Integer.parseInt(num));
		} else {
			list.add(-Integer.parseInt(num));
		}

		int sum = 0;
		boolean check = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 0) {
				sum += list.get(i);
				check = true;
			} else if(check){
				sum -= list.get(i);
			}
			else {
				sum += list.get(i);
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
