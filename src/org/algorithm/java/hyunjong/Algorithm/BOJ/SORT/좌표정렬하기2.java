package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬하기2 {
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y != o.y) {
				if (this.y < o.y)
					return -1;
				else
					return 1;
			} else {
				if (this.x < o.x)
					return -1;
				else
					return 1;
			}
		}

		public String toString(){
			return this.x+" "+this.y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Point[] position = new Point[N];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			position[i] = new Point(x,y);
		}

		Arrays.sort(position);
		for(Point p : position){
			System.out.println(p.toString());
		}
	}
}
