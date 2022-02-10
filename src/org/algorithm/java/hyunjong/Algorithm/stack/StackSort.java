package org.algorithm.java.hyunjong.Algorithm.stack;
import java.lang.Integer;
public class StackSort {
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<>();

	public StackSort(int[] initData){
		for(Integer data : initData){
			s1.push(data);
		}
	}

	public void sort(){
		while (!s1.isEmpty()){
			int s1Data = s1.pop();
			while(!s2.isEmpty() && s1Data<s2.peek()){
				s1.push(s2.pop());
			}
			s2.push(s1Data);
		}

		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}

	public Stack<Integer> getSort(){
		return s1;
	}
}
