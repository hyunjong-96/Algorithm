package org.algorithm.java.hyunjong.Algorithm.sort;

public class MergeSort {

	public MergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}

	public void mergeSort(int[] arr, int[] tmp, int start, int end){
		if(start >= end) return;

		int mid = (start+end) / 2;
		mergeSort(arr, tmp, start, mid);
		mergeSort(arr, tmp, mid+1, end);
		mergeSort(arr, tmp, start, mid, end);
	}

	private void mergeSort(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;

		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] < tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		/*오른쪽 파티션(배열)이 모두 정렬되었고, 왼쪽 파티션의 값이 모두 정렬되지 않았을때, 왼쪽 파티션의 정렬해야할 남은 요소의 갯수(0일때 1개)
		왼쪽 파티션의 정렬이 끝났고, 오른쪽 파티션의 정렬이 끝나지 않았을 경우에는 오른쪽 파티션의 남은 요소들은 정렬할 요소들중 가장 큰 친구들이기 떄문에
		자리를 배정해주지 않아도 이미 정렬된 자리에 속해있다.
		 */
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}

	public void printArray(int[] arr){
		for(int data : arr){
			System.out.print(data + " ");
		}
		System.out.println();
	}
}
