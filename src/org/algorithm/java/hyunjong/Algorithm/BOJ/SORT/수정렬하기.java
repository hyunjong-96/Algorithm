package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quickSort(arr, 0, N-1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static public void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if (start < part2 - 1)
			quickSort(arr, start, part2-1);
		if (part2 < end)
			quickSort(arr, part2, end);
	}

	static public int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];

		while (start <= end) {
			while(arr[start] < pivot){
				start++;
			}
			while(pivot < arr[end]){
				end--;
			}

			// if(start<=end){
				int swap = arr[start];
				arr[start] = arr[end];
				arr[end] = swap;
				start++;
				end--;
			// }
		}

		return start;
	}

	static public void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}

	static public void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}

		int index1 = start;
		int index2 = mid + 1;
		int index = start;

		while (index1 <= mid && index2 <= end) {
			if (tmp[index1] <= tmp[index2]) {
				arr[index] = tmp[index1++];
			} else {
				arr[index] = tmp[index2++];
			}
			index++;
		}

		for (int i = index1; i <= mid; i++) {
			arr[index++] = tmp[i];
		}
	}

	static public void bubble_sort(int[] arr, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int swap = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swap;
				}
			}
		}
	}

	static public void select_sort(int[] arr, int N) {
		for (int i = 0; i < N; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			int swap = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = swap;
		}
	}

	static public void insert_sort(int[] arr, int N) {
		for (int i = 1; i < N; i++) {
			int index = i - 1;
			int value = arr[i];

			while (index >= 0 && value < arr[index]) {
				arr[index + 1] = arr[index];
				arr[index] = value;
				index--;
			}
		}
	}
}
