package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조.Queue;

import java.io.*;
import java.util.StringTokenizer;

public class 덱_구현{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayDeque deque = new ArrayDeque(10000);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String method = st.nextToken();

			int x = 0;
			switch(method){
				case "push_front":
					x = Integer.parseInt(st.nextToken());
					deque.push_front(x);
					break;
				case "push_back":
					x = Integer.parseInt(st.nextToken());
					deque.push_back(x);
					break;
				case "pop_front":
					sb.append(deque.pop_front()).append("\n");
					break;
				case "pop_back":
					sb.append(deque.pop_back()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.empty()).append("\n");
					break;
				case "front":
					sb.append(deque.front()).append("\n");
					break;
				case "back":
					sb.append(deque.back()).append("\n");
					break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class ArrayDeque{
		int front;
		int rear;
		int size;
		int[] array;
		public ArrayDeque(int capacity){
			front = 0;
			rear = 0;
			size = 0;
			array = new int[capacity];
		}

		public void push_front(int x){
			if((rear+1)%array.length == front) resize(array.length*2);

			front = (front-1+array.length)%array.length;

			array[(front+1)%array.length] = x;
			size++;
		}

		public void push_back(int x){
			if((rear+1)%array.length == front) resize(array.length*2);

			rear = (rear+1)%array.length;

			array[rear] = x;
			size++;
		}

		public int pop_front(){
			if(front==rear) return -1;

			if(size-1 < array.length/4) resize(array.length/2);

			size--;
			front = (front+1)%array.length;

			return array[front];
		}

		public int pop_back(){
			if(front==rear) return -1;

			if(size-1 < array.length/4) resize(array.length/2);

			size--;
			int result = array[rear];
			rear = ((rear-1)+array.length)%array.length;

			return result;
		}

		public int size(){
			return size;
		}

		public int empty(){
			return rear-front == 0 ? 1 : 0;
		}

		public int front(){
			if(front==rear) return -1;
			return array[(front+1)%array.length];
		}

		public int back(){
			if(front==rear) return -1;
			return array[rear];
		}

		private void resize(int newCapacity){
			int arrayCapacity = array.length;
			int[] newArray = new int[newCapacity];

			for(int i=1, j=front+1;i<=size;i++, j++){
				newArray[i] = array[j%arrayCapacity];
			}

			this.array = newArray;
			front = 0;
			rear = size;
		}
	}
}
