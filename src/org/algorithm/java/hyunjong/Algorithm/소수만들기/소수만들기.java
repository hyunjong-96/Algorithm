package org.algorithm.java.hyunjong.Algorithm.소수만들기;

public class 소수만들기 {
    public int solution(int[] nums){
        int answer = 0;

        for(int i=0;i< nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    for(int p=2;p<sum;p++){
                        if(sum%p==0) break;
                        if(p == sum-1) answer+=1;
                    }
                }
            }
        }

        return answer;
    }
}
