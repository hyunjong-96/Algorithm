package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 지게차와크레인
 * author         : leehyunjong
 * date           : 2025/05/11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/11        leehyunjong       최초 생성
 */
public class 지게차와크레인 {
    public static void main(String[] args) {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};

        System.out.println(solution(storage, requests));
    }

    static int[][] distance = {{-1,0},{0,-1},{1,0},{0,1}};
    static Character[][] containerMap;
    static boolean[][] validCheck;
    static int n=0;
    static int m=0;

    public static int solution(String[] storage, String[] requests) {
        m = storage[0].length();
        n = storage.length;

        containerMap = new Character[n][m];
        validCheck = new boolean[n][m];

        for(int i=0;i<storage.length;i++) {
            String row = storage[i];

            for(int j=0;j<row.length();j++){
                containerMap[i][j] = row.charAt(j);
            }
        }

        for(String req : requests) {
            moveContainer(req);
        }

        int answer = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!validCheck[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void moveContainer(String req) {
        boolean[][] copyValidCheck = copyArray();
        char con = req.charAt(0);
        if(req.length() == 1) {
            useNormal(con, copyValidCheck);
        }
        else if(req.length() == 2) {
            useCrain(con, copyValidCheck);
        }
    }

    public static void useNormal(char con, boolean[][] copyValidCheck){

        for(int i=0;i<n;i++) {

            for(int j=0;j<m;j++) {

                if(containerMap[i][j] == con && !copyValidCheck[i][j]) {

                    for(int d=0;d<4;d++) {
                        int nextY = i+distance[d][0];
                        int nextX = j+distance[d][1];

                        if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || checkNormal(copyValidCheck, nextY, nextX)) {
//                        if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || copyValidCheck[nextY][nextX]) {
                            validCheck[i][j] = true;
                            break;
                        }
                    }

                }
            }
        }
    }

    public static void useCrain(char con, boolean[][] copyValidCheck) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {

                if(containerMap[i][j] == con && !copyValidCheck[i][j]) {
                    validCheck[i][j] = true;
                }
            }
        }
    }

    public static boolean[][] copyArray() {
        boolean[][] copy = new boolean[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                copy[i][j] = validCheck[i][j];
            }
        }

        return copy;
    }

    public static boolean checkNormal(boolean[][] copyValidCheck, int y,int x) {
        if(!copyValidCheck[y][x]) {
            return false;
        }
        boolean[][] check = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            int currentY = point[0];
            int currentX = point[1];

            if(check[currentY][currentX]) {
                continue;
            }

            for(int d=0;d<4;d++) {
                int nextY = currentY + distance[d][0];
                int nextX = currentX + distance[d][1];


                if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
                    return true;
                }

                if(!copyValidCheck[nextY][nextX]) {
                    continue;
                }

                check[currentY][currentX] = true;
                queue.offer(new int[]{nextY,nextX});
            }
        }

        return false;
    }
}
