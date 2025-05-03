package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 서버증설횟수
 * author         : leehyunjong
 * date           : 2025/05/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/03        leehyunjong       최초 생성
 */
public class 서버증설횟수 {

    static int result = 0;
    static int currentServer = 0;
    static LinkedList<int[]> addServer = new LinkedList<>();

    public static void main(String[] args) {

        int[] players = new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        int result = solution(players, m, k);

        System.out.println(result);
    }

    public static int solution(int[] players, int m, int k) {

        for(int t = 0; t < players.length; t++) {
            checkServer(t);

            int users = players[t];

            int wantServer = users/m;
            if(wantServer > currentServer) {
                int add = wantServer-currentServer;
                int endTime = t+k;
                int[] addServerInfo = new int[]{add, endTime};
                addServer.addLast(addServerInfo);
                currentServer += add;
                result += add;
            }
        }

        return result;

    }

    public static void checkServer(int time) {
        if(addServer.isEmpty()) {
            return;
        }
        int[] server = addServer.getFirst();
        int serverCnt = server[0];
        int serverTime = server[1];

        if(serverTime <= time) {
            currentServer -= serverCnt;
            addServer.removeFirst();
        }
    }
}
