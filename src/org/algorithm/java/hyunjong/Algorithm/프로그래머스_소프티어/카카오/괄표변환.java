package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.Stack;

/*
주어진 변환 알고리즘을 잘사용하면 해결할수 있는 문제.
문자열 w를 "균형잡힌 괄호 문자열" u,v로 나눌때 w를 첫번쨰 단어부터 비교하면서
"("와 ")"갯수를 비교하며 갯수가 최초로 같을때 (u는 더이상 균형잡힌 괄호 문자열로 나눠질수 없기때문)
u가 "올바른 괄호 문자열"인지 여부를 판단하고 같다면 v를 재귀함수에 사용
u가 "올바른 괄호 문자열"이 아니라면 4-1~4-5의 프로세스를 수행하면된다.
그리고 해당 문자열 반환.
 */
public class 괄표변환 {
	public static void main(String[] args) {
		String p = ")()(()";
		System.out.println(solution(p));
	}

	static String solution(String p){
		String answer = stringSeparate(p);
		return answer;
	}

	static public String stringSeparate(String s){
		//빈 문자열은 둘로 나눌수 없으니 그냥 반환
		if(s == "") return s;

		Stack<Character> stack = new Stack<>();
		int leftCount=0;
		int rightCount=0;
		String u = "";
		String v = "";
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			//해당 문자열의 (와 )의 갯수를 카운트하며 stack에 저장
			if(c == '('){
				leftCount++;
			}else{
				rightCount++;
			}
			stack.push(c);

			//괄호의 갯수가 동일해졌다면 u와 v를 나누어준다.
			if(leftCount == rightCount){
				for(int j=0;j<stack.size();j++){
					u+=stack.get(j);
				}
				if(i+1<s.length()){
					v = s.substring(i+1);
				}
				break;
			}
		}

		//u가 "올바른 괄호 문자열"이라면 u와 재귀함수를 통한 반환된 v를 합해서 반환.
		if(isCorrect(stack)){
			return u+stringSeparate(v);
		}
		//u가 조건에 부합하다면
		else{
			StringBuilder sb = new StringBuilder();
			//4-1
			sb.append("(");
			//4-2
			sb.append(stringSeparate(v));
			//4-3
			sb.append(")");
			//4-4
			String temp = u.substring(1, u.length()-1);
			for(char t : temp.toCharArray()){
				if(t == ')') sb.append("(");
				else if(t == '(') sb.append(")");
			}
			//4-5
			return sb.toString();
		}
	}

	/*
	올바른 괄호 문자열은 "("과 ")"의 짝이 올바르게 있는 문자열을 말한다.
	stack에 들어있는 문자열은 더 이상 균형잡힌 괄호 문자열로 나눌수 없는 문자들로 이루어져있기 떄문에
	올바른 괄호 문자열인 증거 중 맨 앞의 괄호가 "("이고 맨 뒤 괄호가 ")"이라면 true 반환.
	그 이외는 false반환
환 */
	static  boolean isCorrect(Stack<Character> stack){
		if(stack.get(0) == '(' && stack.get(stack.size()-1) == ')') return true;
		return false;
	}
}
