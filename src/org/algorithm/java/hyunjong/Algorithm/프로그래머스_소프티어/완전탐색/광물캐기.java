package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.완전탐색;

import java.util.Arrays;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.완전탐색
 * fileName       : 광물캐기
 * author         : leehyunjong
 * date           : 2025/01/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/01/21        leehyunjong       최초 생성
 */
public class 광물캐기 {
    public static void cost(int[] costs, int a, int b, int c){ // 피로도 계산
        costs[0] += a;
        costs[1] += b;
        costs[2] += c;
    }

    public static void main(String[] args) {
        int[] picks = new int[]{1, 0, 1};
        String[] minerals = new String[]{"stone", "stone", "stone", "stone", "stone", "iron", "iron", "iron", "iron", "iron", "diamond", "diamond"};
        int result = solution(picks, minerals);
        System.out.println(result);
    }

    public static int solution(int[] picks, String[] minerals) {
        int maxGroup = minerals.length/5 + 1;
        int sum = picks[0]+picks[1]+picks[2];
        int[][] energy = new int[maxGroup][3];

        //광물 그룹(5개당 1그룹)
        int group = 0;

        for(int i=0;i< minerals.length;i=i+5) {
            //첫번째 돌부터 순서대로 캐야하기때문에 광석을 캘 그룹이 곡갱이 갯수를 넘으면 해당 광물 그룹부터는 캘 수 없다.
            if(sum <= group) {
                break;
            }

            //광물 1그룹에 있는 피로도 계산
            for(int j=0;j<5;j++){
                //5개를 넘어가면 다음 그룹 계산
                if(i+j >= minerals.length) {
                    break;
                }

                String m = minerals[j+i];

                energy[group][0] += getEnergy(m, 0);
                energy[group][1] += getEnergy(m, 1);
                energy[group][2] += getEnergy(m, 2);
            }

            group++;
        }

        //stone을 캤을때 가장 많은 피로도인 그룹부터 다이어몬드로 깨는것이 최소의 피로도 구하는 킥.
        Arrays.sort(energy, (g1, g2) -> g2[2]-g1[2]);

        int result = 0;
        for(int i=0;i<group;i++){
            //stone피로도가 가장 높은 순으로 다이아 곡괭이로 피로도를 최소해나감
            if(picks[0] != 0) {
                picks[0]--;
                result += energy[i][0];
            }
            else if(picks[1] != 0) {
                picks[1]--;
                result += energy[i][1];
            }
            else if(picks[2] != 0) {
                picks[2]--;
                result += energy[i][2];
            }
        }

        return result;
    }

    static int getEnergy(String m ,int p) {
        if(m.equals("diamond")) {
            if(p==0) {
                return 1;
            }
            else if(p==1) {
                return 5;
            }
            else {
                return 25;
            }
        }
        else if(m.equals("iron")) {
            if(p==0 || p==1) {
                return 1;
            }
            else {
                return 5;
            }
        }
        else {
            return 1;
        }
    }
//    public static int solution(int[] picks, String[] minerals) {
//        int answer = 0;
//        int sum = picks[0] + picks[1] + picks[2]; // 곡괭이 갯수
//        int[][] p = new int[sum][3];
//
//        for (int i = 0 ; i < minerals.length; i += 5){
//            int n = i/5;
//            if(n == sum){
//                break;
//            }
//            int[] costs = new int[3];
//            for (int j = i ; j < i+5; j++){
//                if (j == minerals.length){ // 마지막에 5개가 안되는 경우
//                    break;
//                }
//                String x = minerals[j];
//                if (x.equals("diamond")){
//                    cost(costs,1,5,25);
//                }
//                else if (x.equals("iron")){
//                    cost(costs,1,1,5);
//                }
//                else {
//                    cost(costs,1,1,1);
//                }
//            }
//            for (int l = 0 ; l < 3; l++){
//                p[n][l] = costs[l];
//            }
//            costs = new int[3];
//        }
//
//        Arrays.sort(p, (a1, a2) -> (a2[2]-a1[2]));
//
//        for(int i = 0; i < sum; i++){
//            if(picks[0] > 0){
//                answer += p[i][0];
//                picks[0]--;
//            }
//            else if(picks[1] > 0){
//                answer += p[i][1];
//                picks[1]--;
//            }
//            else if(picks[2] > 0){
//                answer += p[i][2];
//                picks[2]--;
//            }
//        }
//
//        return answer;
//    }
}
