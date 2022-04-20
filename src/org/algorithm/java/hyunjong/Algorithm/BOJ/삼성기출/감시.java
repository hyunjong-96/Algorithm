package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
역시 완탐, 구현 문제에 약하다는걸 다시 한번 느꼈다.
대충 재귀함수를 이용해 기존 배열을 새로 생성해서 구현하는 흐름은 이해했지만, 역시 구현자체에서 막혀버렸다.
일단 사각 지대는 2차원배열의 전체 크기 - 벽 갯수 - cctv갯수 - cctv가 관찰가능한 범위 를 통해 알수있다.
이를 위해서 입력값이 들어올때 cctv의 좌표정보를 저장해 list로 두고 list를 돌면서 해당 cctv의 타입에 따라
cctv가 관찰가능한 범위를 모두 확인하면서 사각지대의 최솟값을 구해야한다.
문제 해결의 핵심은 cctv의 타입에 따른 관찰 범위(cctv 움직임)이다.
1~5까지의 index에 cctv가 관찰할수 있는 방향을 먼저 초기화해놓는다 (dirOfType)
그런다음 반복문을 통해 각 type(dirOfType[i])의 한번에 볼수있는 관찰범위의 갯수를 가지고 각 다음 cctv의 관찰범위 갯수를 구해서 최소한의 관찰범위를 찾는것이다.
백트래킹을 사용했다고봐도 무방할것같다.
 */
public class 감시 {
    static int[][] office;
    static List<Point> cctvList;
    static int N;
    static int M;
    static int wallCount;
    static int cctvCount;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][][] dirOfType = {
            {{0}},
            {{0}, {1}, {2}, {3}},   //1타입 cctv는 총 4가지 방향(위, 왼, 아래, 오른쪽)으로 관찰가능.
            {{0, 2}, {1, 3}},   //2타입 cctv는 총 2가지 방향(위-아래, 왼쪽-오른쪽)으로 관찰가능.
            {{0, 3}, {0, 1}, {1, 2}, {2, 3}},   //3타입 cctv는 총 4가지 타입
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},   //4타입 cctv는 총 4가지 타입
            {{0, 1, 2, 3}}  //5타입 cctv는 총 1가지 타입
    };
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wallCount = 0;
        cctvCount = 0;
        office = new int[N][M];
        cctvList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int e = Integer.parseInt(st.nextToken());
                office[i][j] = e;
                if (e == 6) {
                    wallCount++;
                } else if (e >= 1 && e <= 5) {
                    cctvCount++;
                    cctvList.add(new Point(j, i));
                }
            }
        }

        //사각지대의 최대값은 2차원배열의 크기 - 벽갯수 - cctv갯수로 초기화.
        //cctv가 0개라면 그대로 결과값으로 반환.
        res = (N * M) - wallCount - cctvCount;
        dfs(0, res, office);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int remain, int[][] of) {
        //백트래킹
        if (idx >= cctvList.size()) {
            res = Math.min(res, remain);
            return;
        }
        Point cctv = cctvList.get(idx);
        int t = of[cctv.y][cctv.x];

        //사무실 2차원배열의 크기가 최대 8*8이라 복사하는데 메모리와 시간에 의해 초과가 발생하지 않음
        int[][] copyOffice = copyOffice(of);

        //cctv타입이 볼수있는 방향의 리스트
        for (int i = 0; i < dirOfType[t].length; i++) {
            int count = 0;
            //한번에 볼수있는 방향 리스트
            //ex) dirOfType[1][0]은 1타입 cctv가 볼수 있는 방향 중 첫번째 방향인 위쪽방향.
            for (int j = 0; j < dirOfType[t][i].length; j++) {
                int d = dirOfType[t][i][j];
                //oberservations가 반환한 관찰범위 갯수를 모두 합산.
                count += observations(d, cctv.y, cctv.x, copyOffice);
            }
            //사각지대(remain)에 관찰범위(count)를 빼고 관찰범위가 갱신된 배열을 다음 cctv와 비교하기 위해 호출
            dfs(idx + 1, remain - count, copyOffice);
            //cctv가 볼 방향을 바꾸려면 현재 방향에서 갱신했던 정보들을 초기화 해야한다.
            copyOffice = copyOffice(of);
        }
    }

    //해당 cctv의 위치에서 각 방향을 -1(관찰지대)로 of에 채워넣는다.
    //범위 넘지않고 벽이 아닌 곳과, 1~5인 cctv를 만나면 카운트하지 않는다.
    static int observations(int d, int y, int x, int[][] of) {
        int count = 0;

        while (true) {
            y += dy[d];
            x += dx[d];

            //범위를 벗어나거나 벽을 만나게 되면 관찰한 범위 갯수를 반환
            if (x < 0 || y < 0 || x >= M || y >= N || of[y][x] == 6) return count;
            //cctv를 만나거나 관찰한 곳을 만나게 되면 count하지 않고 넘어감
            if (of[y][x] >= 1 && of[y][x] <= 5 || of[y][x] == -1) continue;

            count++;
            of[y][x] = -1;
        }
    }

    //백트래킹을 하기 위한 2차원 배열 복사 함수
    //2차원배열의 크기가 작기 때문에 가능.
    static int[][] copyOffice(int[][] of) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N * M; i++) {
            tmp[i / M][i % M] = of[i / M][i % M];
        }
        return tmp;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
