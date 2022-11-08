package org.algorithm.java.hyunjong.Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] seq = new int[N];
		//원소, idx
		Map<Integer, Integer> seqMap = new HashMap<>();

		for(int i=0;i<N;i++){
			seq[i] = Integer.parseInt(st.nextToken());
			seqMap.put(seq[i], i);
		}
		int target = Integer.parseInt(br.readLine());

		int[] answer = new int[2];
		int count=0;
		for(int i=0;i<N;i++){
			int diff = target - seq[i];
			if(seqMap.containsKey(diff) && diff != seq[i]) {
				answer[0] = i;
				answer[1] = seqMap.get(diff);
				break;
			}
		}


		bw.write(String.valueOf(Arrays.toString(answer)));
		bw.flush();
		bw.close();
	}
}
// public class A{
//
// 	public static void main(String[] args) {
//
// 	}
// 	nums -> [2, 3, 1, 3, 6]
// 	target -> 7
// 	ret [2, 4]
//
// 	public int[] twoSum(int[] nums, int target) {
//
// 		Num[] num = new Num[nums.length];
// 		for(int i=0;i<nums.lenght;i++){
// 			num[i] = new Num(i, nums[i]);
// 		}
//
// 		Arrays.sort(num);
//
// 		int start=0;
// 		int end=nums.length-1;
//
// 		int sum = num[start].num+num[end].num;
// 		while(start<end && sum!=target){
// 			if(sum < target){
// 				start++;
// 			}else if(sum > target){
// 				return end--;
// 			}else{
// 				break;
// 			}
// 			sum = num[start].num+num[end].num;
// 		}
//
// 		if(sum == target){
// 			return new int[]{start,end};
// 		}
//
//
// 		//   for(int i=0;i<nums.length-1;i++){
// 		//   	int firstNum = nums[i];
//
// 		//   	for(int j=i+1;j<nums.length-1;j++){
// 		//     	int secondNum = nums[j];
// 		//       if(firstNum+secondNum == target) return new int[]{i,j};
// 		//     }
// 		//   }
// 		//   return null;
// 		return null;
// 	}
//
// 	class Num implements Comparable<Num>{
// 		int idx;
// 		int num;
// 		public class Num(int idx, int num){
//   	this.idx= idx;
//     this.num=num;
// 		}
//
// 		@Override
// 		public int compareTo(Num o){
// 			return this.num-o.num;
// 		}
// 	}
//
// }