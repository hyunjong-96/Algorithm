package org.algorithm.java.hyunjong.MyDataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class QStack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		MyQueue queue = new MyQueue();
		SingleStackQueue queue2 = new SingleStackQueue();
		StringBuilder sb = new StringBuilder();
		while(N-- > 0){
			String[] method = br.readLine().split(" ");

			String m = method[0];

			if(m.equals("push")){
				int e = Integer.parseInt(method[1]);
				// queue.push(e);
				queue2.add(e);
			}else if(m.equals("pop")){
				sb.append(queue2.poll());
				// sb.append(queue.pop());
				sb.append("\n");
			}else if(m.equals("size")){
				sb.append(queue.size());
				sb.append("\n");
			}else if(m.equals("empty")){
				sb.append(queue.empty());
				sb.append("\n");
			}else if(m.equals("front")){
				sb.append(queue.front());
				sb.append("\n");
			}else if(m.equals("back")){
				sb.append(queue.back());
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class SingleStackQueue{
		Stack<Integer> stack;

		public SingleStackQueue(){
			this.stack = new Stack<>();
		}

		public void add(int e){
			stack.push(e);
		}

		public int poll(){
			if(stack.isEmpty()) return -1;
			if(stack.size() == 1) return stack.pop();

			int out = stack.pop();
			int result = poll();
			stack.push(out);

			return result;
		}

		public int peek(){
			if(stack.isEmpty()) return -1;
			if(stack.size()==1) return stack.peek();

			int out = stack.pop();
			int result = peek();
			stack.push(out);
			return result;
		}
	}

	static class MyQueue{
		Stack<Integer> oldStack;
		Stack<Integer> newStack;

		public MyQueue(){
			oldStack = new Stack<>();
			newStack = new Stack<>();
		}

		/*
		O(1)
		 */
		public void push(int e){
			oldStack.add(e);
		}

		/*
		O(N)
		 */
		public int pop(){
			int result = -1;

			while(!oldStack.isEmpty()){
				newStack.push(oldStack.pop());
			}

			if(!newStack.empty()){
				result = newStack.pop();
			}

			return result;
		}

		/*
		O(1)
		 */
		public int size(){
			return oldStack.size()+ newStack.size();
		}

		/*
		O(1)
		 */
		public int empty(){
			return oldStack.empty() && newStack.empty() ? 1 : 0;
		}

		/*
		O(N)
		 */
		public int front(){
			int result = -1;

			if(!newStack.empty()) result = newStack.peek();
			else{
				while(!oldStack.empty()){
					newStack.push(oldStack.pop());
				}

				if(!newStack.empty()) result = newStack.peek();
			}

			return result;
		}

		/*
		O(N)
		 */
		public int back(){
			int result = -1;

			if(!oldStack.empty()) result = oldStack.peek();
			else{
				while(!newStack.empty()){
					oldStack.push(newStack.pop());
				}
				if(!oldStack.empty()) result = oldStack.peek();
			}

			return result;
		}
	}
}
