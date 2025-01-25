package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그래프;
import java.io.*;
import java.util.*;
public class 나무섭지 {
    static int N;
    static int M;
    static String[][] map;
    static List<int[]> ghostPoint = new ArrayList<>();
    static int[] namPoint;
    static int[] targetPoint;
    static int[][] globalDistanceMap;
    static int globalMaxDistance = Integer.MAX_VALUE;
    static int[][] dist = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        for(int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine() ," ");
            String row = br.readLine();

            for(int j=0;j<M;j++) {
                map[i][j] = String.valueOf(row.charAt(j));

                if(map[i][j].equals("D")) {
                    targetPoint = new int[]{i,j};
                }
                else if(map[i][j].equals("N")) {
                    namPoint = new int[]{i,j};
                }
                else if(map[i][j].equals("G")){
                    ghostPoint.add(new int[]{i,j});
                }
            }
        }

//        int[][] distanceMap = bfs(namPoint[0],namPoint[1]);
        String result = "No";

        dfs(new Node(namPoint[0],namPoint[1],0,new int[N][M]));

        if(globalDistanceMap != null){
            result = "Yes";
            for(int[] g : ghostPoint) {
                if((namPoint[0]==g[0] && namPoint[1]==g[1])) {
                    result = "No";
                }
            }

            ghostPoint.sort(Comparator.comparingInt(
                    gh -> {
                        int absRow = Math.abs(targetPoint[0]-gh[0]);
                        int absCol = Math.abs(targetPoint[1]-gh[1]);

                        return absRow+absCol;
                    }
            ));

//            if(bfs()) {
//                result = "No";
//            }
            if(bfs() <= globalMaxDistance) {
                result = "No";
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(Node node) {
//        if(node.y <0 || node.y >=N || node.x < 0 || node.x >= M || node.distanceMap[node.y][node.x] != 0 || map[node.y][node.x].equals("G") || map[node.y][node.x].equals("#")) {
//            return;
//        }

//        node.distanceMap[node.y][node.x] = node.distance;

        if(map[node.y][node.x].equals("D") && globalMaxDistance>node.distance) {

            globalMaxDistance = node.distance;

            globalDistanceMap = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    globalDistanceMap[i][j] = node.distanceMap[i][j];
                }
            }

            return;
        }

        for(int i=0;i<4;i++){
            int nextY = node.y+dist[i][0];
            int nextX = node.x+dist[i][1];

            if(nextY <0 || nextY >=N || nextX < 0 || nextX >= M || node.distanceMap[nextY][nextX] != 0 || map[nextY][nextX].equals("G") || map[nextY][nextX].equals("#")) {
                continue;
            }

            node.distanceMap[nextY][nextX] = node.distance+1;
            dfs(new Node(nextY,nextX,node.distance+1, node.distanceMap));
            node.distanceMap[nextY][nextX] = 0;

        }
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
//        for(int[] g : ghostPoint) {
//            queue.offer(new Node(g[0],g[1], 0 , new int[N][M]));
//        }
        queue.offer(new Node(ghostPoint.get(0)[0], ghostPoint.get(0)[1], 0, new int[N][M]));
//        queue.offer(new Node(y,x,0,new int[N][M]));
        int[][] distanceMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int currentY = now.y;
            int currentX = now.x;
            int currentDistance = now.distance;

//            if(currentY<0&&currentY>=N&&currentX<0&&currentX>=M||(distanceMap[currentY][currentX]!=0 && distanceMap[currentY][currentX] <= currentDistance )) {
//                continue;
//            }

            if(currentY<0&&currentY>=N&&currentX<0&&currentX>=M||visited[currentY][currentX]) {
                continue;
            }

            visited[currentY][currentX] = true;
//            distanceMap[currentY][currentX] = currentDistance;
//            if(globalDistanceMap[currentY][currentX] != 0 && globalDistanceMap[currentY][currentX] >= distanceMap[currentY][currentX]){
//                return true;
//            }
            if(targetPoint[0] == currentY && targetPoint[1] == currentX) {
                return currentDistance;
            }

            for(int i=0;i<4;i++) {
                int nextY = currentY + dist[i][0];
                int nextX = currentX + dist[i][1];

                if(nextY>=0&&nextY<N&&nextX>=0&&nextX<M&&distanceMap[nextY][nextX]==0) {
                    queue.offer(new Node(nextY,nextX,currentDistance+1,distanceMap));
                }
            }

        }

        return Integer.MAX_VALUE;
    }

    static class Node {
        int y;
        int x;
        int distance;
        int[][] distanceMap;

        public Node(int y,int x,int distance, int[][] distanceMap) {
            this.y=y;
            this.x=x;
            this.distance=distance;
            this.distanceMap=distanceMap;
        }
    }
}
