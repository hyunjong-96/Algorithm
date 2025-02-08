package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.*;

public class 택배 {
    //	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		//마을 수
//		int N = Integer.parseInt(st.nextToken());
//		//트럭 용량
//		int C = Integer.parseInt(st.nextToken());
//
//		int M = Integer.parseInt(br.readLine());
//
//		PriorityQueue<Box> boxes = new PriorityQueue<>();
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int send = Integer.parseInt(st.nextToken()) - 1;
//			int receive = Integer.parseInt(st.nextToken()) - 1;
//			int size = Integer.parseInt(st.nextToken());
//
//			boxes.offer(new Box(send, receive, size));
//		}
//
//		int[] maxBoxSize = new int[N];
//		Arrays.fill(maxBoxSize, C);
//
//		int answer = 0;
//
//		for (Box box : boxes) {
//			int maxSize = 10000;
//			for (int i = box.send; i < box.receive; i++) {
//				maxSize = Math.min(maxBoxSize[i], maxSize);
//			}
//			maxSize = Math.min(maxSize, box.size);
//
//			for (int i = box.send; i < box.receive; i++) {
//				maxBoxSize[i] -= maxSize;
//			}
//
//			answer += maxSize;
//		}
//
//		bw.write(String.valueOf(answer));
//		bw.flush();
//		bw.close();
//	}
//
//	static class Box implements Comparable<Box> {
//		int send;
//		int receive;
//		int size;
//
//		public Box(int send, int receive, int size) {
//			this.send = send;
//			this.receive = receive;
//			this.size = size;
//		}
//
//		@Override
//		public int compareTo(Box o1) {
//			int answer = this.receive - o1.receive;
//			if (answer == 0) {
//				answer = this.send - o1.send;
//			}
//			return answer;
//		}
//	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Box[] boxs = new Box[M];
        int[] villages = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            boxs[i] = new Box(s, e, w);
        }

        Arrays.sort(boxs);

        Arrays.fill(villages, C);

        int result = 0;

        for(Box b : boxs) {
            int min = Integer.MAX_VALUE;

            for(int i=b.start; i<b.end;i++) {
                min = Math.min(min, villages[i]);
            }

            for(int i=b.start; i<b.end;i++) {
                villages[i] -= Math.min(min, b.weight);
            }

            result += Math.min(min, b.weight);
        }


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static class Box implements Comparable<Box> {
        int start;
        int end;
        int weight;

        public Box(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }

        @Override
        public int compareTo(Box b) {
            if(this.end == b.end) {
                return this.start - b.start;
            }
            return this.end - b.end;
        }
    }
}
