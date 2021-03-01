package org.algorithm.java.hyunjong;

import org.algorithm.java.hyunjong.Algorithm.두개더뽑아서더하기;
import org.algorithm.java.hyunjong.Algorithm.모의고사.모의고사;
import org.algorithm.java.hyunjong.Algorithm.신규아이디추천.신규아이디추천;
import org.algorithm.java.hyunjong.Algorithm.완주하지못한선수.완주하지못한선수;
import org.algorithm.java.hyunjong.Algorithm.크레인인형뽑기게임.크레인인형뽑기게임;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        모의고사();
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
    private static void 아이디추천(){
        String new_id="=.=";
        신규아이디추천 third = new 신규아이디추천();
        third.solution(new_id);
    }
    private static void 완주하지못한선수(){
        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[] completion={"stanko", "ana", "mislav"};
        완주하지못한선수 fourth = new 완주하지못한선수();
        fourth.solution(participant,completion);
    }
    private static void 모의고사(){
        int[] answers = {1,3,2,4,2};
        모의고사 fifth = new 모의고사();
        fifth.solution(answers);
    }
}
