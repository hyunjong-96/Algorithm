package org.algorithm.java.hyunjong.Algorithm.키패드누르기;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand){
        String answer="";
        int leftPosition = 10;
        int rightPostion = 12;

        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] ==4 || numbers[i] ==7){
                leftPosition = numbers[i];
                answer+="L";
            }
            else if(numbers[i] == 3|| numbers[i] == 6|| numbers[i] == 9){
                rightPostion = numbers[i];
                answer+="R";
            }
            else{
                if(numbers[i]==0) numbers[i]+=11;
                int leftDistance = (Math.abs(numbers[i]-leftPosition))/3+(Math.abs(numbers[i]-leftPosition))%3;
                int rightDistance = (Math.abs(numbers[i]-rightPostion))/3+(Math.abs(numbers[i]-rightPostion))%3;
                if(leftDistance > rightDistance) {
                    rightPostion=numbers[i];
                    answer+="R";
                }
                else if(leftDistance < rightDistance) {
                    leftPosition=numbers[i];
                    answer+="L";
                }
                else{
                    if(hand.equals("left")) {
                        leftPosition=numbers[i];
                        answer+="L";
                    }
                    else {
                        rightPostion=numbers[i];
                        answer+="R";
                    }
                }
            }
        }
        return answer;
    }
}
