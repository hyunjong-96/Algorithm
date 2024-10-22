package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.DP;

import java.util.*;

public class 매출하락최소화 {
    public static void main(String[] args) {
        int[] sales = new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};

        System.out.println(solution(sales, links));
    }

    static int[] Sales;
    static List<List<Integer>> ChildList = new ArrayList<>();
    static int[][] dp;

    static public int solution(int[] sales, int[][] links) {
        int N = sales.length;
        Sales = sales;
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            ChildList.add(new ArrayList<>());
        }

        for (int[] link : links) {
            ChildList.get(link[0] - 1).add(link[1] - 1);
        }


        recursive(0);

        return Math.min(dp[0][0], dp[0][1]);
    }

    static void recursive(int node) {
        //참석했을때 비용
        dp[node][0] = Sales[node];
        //참석하지 않았을때 비용
        dp[node][1] = 0;

        if(ChildList.get(node).isEmpty()) {
            return;
        }

        int extraCost = Integer.MAX_VALUE;
        for (int child : ChildList.get(node)) {
            recursive(child);

            //자식 노드의 참석하지 않은 비용이 더 작은 경우
            if (dp[child][1] < dp[child][0]) {
                dp[node][0] += dp[child][1];
                dp[node][1] += dp[child][1];


                //자식 노드가 참석했을떄의 값을 가지고있는다(자식 노드가 참여하지 않은 값을 이미 가지고있기 때문에 겂의 차를 가진다)
                extraCost = Math.min(extraCost, dp[child][0] - dp[child][1]);
            }
            //자식 노드의 참석한 비용이 더 작은 경우
            else {
                dp[node][0] += dp[child][0];
                dp[node][1] += dp[child][0];

                //자식이 참석한 경우 현재 노드는 참여할 필요가 없기 때문에 extraCost값을 더 추가해줄 필요없다.
                extraCost = 0;
            }
        }
        //현재노드가 참여하지 않은 경우에는 자식 노드가 참석했을때의 경우 중 가장 작은 값을 넣어주기 위해 해당 값에 대한 값의 차를 더해준다.
        //현재노드가 참여하지 않아도 자식 노드가 참여했을 경우에는 상관없기 때문에 위에서 extraCost = 0으로 바꿔줌.
        dp[node][1] += extraCost;

    }
}
