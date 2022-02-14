package org.algorithm.java.hyunjong.Algorithm.sort;

public class QuickSort {
	public QuickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int start, int end) {
		if (start >= end) {    //start값과 end값이 같거나 start가 더 크다면 더이상 정렬할 필요가 없는것.(하나의 요소만 남은것)
			return;
		}

		int part2 = partition(arr, start, end);    //오른쪽 파티션의 첫번째 인덱스 반환(pivot)
		quickSort(arr, start, part2 - 1);
		quickSort(arr, part2, end);
	}

	private int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];

		while (start <= end) { //swap했을때 start와 end를 각각 이동시켜줬을때 같은 곳을 가리킬때 start,end의 이동이 필요하다.
			while (arr[start] < pivot)
				start++;
			while (arr[end] > pivot)
				end--;

			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}

	public void printArr(int[] arr) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
