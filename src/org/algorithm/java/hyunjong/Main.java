package org.algorithm.java.hyunjong;

import org.algorithm.java.hyunjong.Algorithm.두개더뽑아서더하기;
import org.algorithm.java.hyunjong.Algorithm.크레인인형뽑기게임.크레인인형뽑기게임;

public class Main {

    public static void main(String[] args) {
        크인게();
    }
    private static void 두뽑더(){
        int[] number = {2,1,3,4,1};
        두개더뽑아서더하기 first = new 두개더뽑아서더하기();
        first.solution(number);
    }
    private static void 크인게(){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        크레인인형뽑기게임 second = new 크레인인형뽑기게임();
        second.solution(board,moves);
    }
}
