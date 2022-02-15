package org.algorithm.java.hyunjong.Algorithm.sort;

public class BubbleSort {
	public BubbleSort(int[] arr){
		bubbleSort(arr, arr.length-1);
	}

	private void bubbleSort(int[] arr, int last){
		if(last > 0){
			for(int i =1 ; i<=last; i++){
				if(arr[i-1]>arr[i]){
					swap(arr, i-1, i);
				}
			}
			bubbleSort(arr, last-1);
		}
	}

	private void swap(int[] arr, int preIndex, int currentIndex){
		int tmp = arr[preIndex];
		arr[preIndex] = arr[currentIndex];
		arr[currentIndex] = tmp;
	}

	public void printArray(int[] arr){
		for(int data : arr){
			System.out.print(data + " ");
		}
		System.out.println();
	}
}
