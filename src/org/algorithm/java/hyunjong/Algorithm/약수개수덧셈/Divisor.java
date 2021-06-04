package org.algorithm.java.hyunjong.Algorithm.약수개수덧셈;

public class Divisor {
    public int soilution(int left,int right){
        int answer=0;
        for(int i=left;i<=right;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j == 0) count++;
            }
            if(count%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
}
