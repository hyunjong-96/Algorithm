package org.algorithm.java.hyunjong.Algorithm.크레인인형뽑기게임;

import java.util.ArrayList;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public int solution(int[][]board, int[] moves){
        int answer=0;
        Stack<Integer> bucket = new Stack<>();
        bucket.push(0);

        for(int move : moves){
            for(int i=0;i<board.length;i++){
                int doll = board[i][move-1];
                if(doll != 0){
                    if(bucket.peek()==doll){
                        bucket.pop();
                        answer+=2;
                    }else{
                        bucket.push(doll);
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}
