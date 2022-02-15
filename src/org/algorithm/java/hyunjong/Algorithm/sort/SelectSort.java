package org.algorithm.java.hyunjong.Algorithm.sort;

public class SelectSort {
	public SelectSort(int[] arr) {
		selectSort(arr, 0);
	}

	private void selectSort(int[] arr, int start) {
		if (start < arr.length - 1) {
			int min = start;
			for (int i = start; i <= arr.length - 1; i++) {
				if(arr[min] > arr[i]){
					min = i;
				}
			}
			swap(arr, start, min);
			selectSort(arr, start+1);
		}
	}

	private void swap(int[] arr, int start, int min){
		int tmp = arr[min];
		arr[min] = arr[start];
		arr[start] = tmp;
	}

	public void printArray(int[] arr){
		for(int e : arr){
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
