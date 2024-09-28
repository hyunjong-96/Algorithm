package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;
import java.util.*;

public class 카드게임 {
    public static List<List<String>> numList = new ArrayList<>(10);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 1; i <= 10; i++) {
            numList.add(new ArrayList<>());
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String color = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            numList.get(number).add(color);
        }

        TreeSet<Integer> resultSet = new TreeSet<>();
        resultSet.add(check1());
        resultSet.add(check2());
        resultSet.add(check3());
        resultSet.add(check4());
        resultSet.add(check5());
        resultSet.add(check6());
        resultSet.add(check7());
        resultSet.add(check8());
        resultSet.add(check9());

        bw.write(String.valueOf(resultSet.last()));
        bw.flush();
        bw.close();

    }

    private static int check1() {
        boolean[] redNum = new boolean[10];
        boolean[] blueNum = new boolean[10];
        boolean[] yellowNum = new boolean[10];
        boolean[] greenNum = new boolean[10];

        for (int num = 9; num > 0; num--) {
            List<String> colorList = numList.get(num);

            if (colorList.isEmpty()) {
                continue;
            }

            for (String color : colorList) {
                if (color.equals("R")) redNum[num] = true;
                else if (color.equals("B")) blueNum[num] = true;
                else if (color.equals("Y")) yellowNum[num] = true;
                else if (color.equals("G")) greenNum[num] = true;
            }
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(allNumCheck(redNum, 5));
        treeSet.add(allNumCheck(blueNum, 5));
        treeSet.add(allNumCheck(yellowNum, 5));
        treeSet.add(allNumCheck(greenNum, 5));

        if (treeSet.last() != 0) {
            return treeSet.last() + 900;
        }
        return 0;
    }

    private static int allNumCheck(boolean[] colorNum, int limit) {
        int largeNum = 0;
        for (int i = 1; i + limit <= 10; i++) {

            for (int j = i; j <= i + limit - 1; j++) {
                if (!colorNum[j]) {
                    break;
                }

                if (j == i + limit - 1) {
                    largeNum = j;
                }
            }
        }

        return largeNum;
    }

    private static int check2() {
        for (int num = 9; num > 0; num--) {
            if (numList.get(num).size() >= 4) {
                return num + 800;
            }
        }

        return 0;
    }

    private static int check3() {
        boolean flag = true;
        int firstNum = 0;
        int secondNum = 0;

        for (int num = 9; num > 0; num--) {
            if (flag) {
                if (numList.get(num).size() >= 3) {
                    firstNum = num;
                    flag = false;
                    continue;
                } else if (numList.get(num).size() >= 2) {
                    secondNum = num;
                    flag = false;
                    continue;
                }
            } else {
                if (numList.get(num).size() >= 3) {
                    firstNum = num;
                    continue;
                } else if (numList.get(num).size() >= 2) {
                    secondNum = num;
                    continue;
                }
            }
        }

        if(firstNum != 0 && secondNum != 0) {
            return firstNum * 10 + secondNum + 700;
        }

        return 0;
    }

    private static int check4() {
        int redCnt = 0;
        int blueCnt = 0;
        int yellowCnt = 0;
        int greenCnt = 0;

        int largeNum = 0;

        for (int num = 1; num <10 ; num++) {
            List<String> colorList = numList.get(num);

            for (String color : colorList) {
                if (color.equals("R")) redCnt++;
                else if (color.equals("B")) blueCnt++;
                else if (color.equals("Y")) yellowCnt++;
                else if (color.equals("G")) greenCnt++;
            }

            if(!colorList.isEmpty()) {
                largeNum = num;
            }

        }
        if (redCnt == 5 || blueCnt == 5 || yellowCnt == 5 || greenCnt == 5) {
            return largeNum + 600;
        }

        return 0;
    }

    private static int check5() {
        boolean[] numCnt = new boolean[10];
        for (int num = 9; num > 0; num--) {
            if (!numList.get(num).isEmpty()) {
                numCnt[num] = true;
            }
        }

        int result = allNumCheck(numCnt, 5);
        if (result != 0) {
            return result + 500;
        }
        return 0;
    }

    private static int check6() {
        for (int num = 9; num > 0; num--) {
            if (numList.get(num).size() >= 3) {
                return num + 400;
            }
        }

        return 0;
    }

    private static int check7() {
        boolean flag = true;
        int firstNum = 0;
        int secondNum = 0;

        for (int num = 9; num > 0; num--) {
            if (flag) {
                if (numList.get(num).size() >= 2) {
                    firstNum = num;
                    flag = false;
                    continue;
                }
            } else {
                if (numList.get(num).size() >= 2) {
                    secondNum = num;
                    return firstNum * 10 + secondNum + 300;
                }
            }
        }

        return 0;
    }

    private static int check8() {
        for (int num = 9; num > 0; num--) {
            if (numList.get(num).size() >= 2) {
                return num + 200;
            }
        }

        return 0;
    }

    private static int check9() {
        for (int num = 9; num > 0; num--) {
            if (!numList.get(num).isEmpty()) {
                return num + 100;
            }
        }
        return 0;
    }
}