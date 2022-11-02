package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;

/*
지뢰 위치를 저장하는 mineMap
열린 위치를 저장하는 openMap
지뢰 주변 개수를 저장하는 mineCountMap
결과를 저장하는 resultMap

열린 위치를 초기화하는 과정에서 지뢰가 있는 곳이 열려있다면 isOpenMine = true 지정

resultMap 생성
1. isOpenMine이 true이고 mineMap[i][j]이 *인 곳이라면 reusltMap[i][j]는 *
2. 그렇지 않고 openMap[i][j]가 열려있는 곳이라면 resultMap[i][j]는 mineCountMap[i][j]
3. 그것도 아니라면 resultMap[i][j]는 .
 */
public class 지뢰찾기{
	static boolean isOpenMine;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		isOpenMine = false;
		char[][] mineMap = new char[N][N];

		for(int i=0;i<N;i++){
			String[] sArr = br.readLine().split("");
			for(int j=0;j<N;j++){
				mineMap[i][j] = sArr[j].charAt(0);
			}
		}
		char[][] openMap = new char[N][N];

		for(int i=0;i<N;i++){
			String[] sArr = br.readLine().split("");
			for(int j=0;j<N;j++){
				openMap[i][j] = sArr[j].charAt(0);
				if(openMap[i][j] == 'x' && mineMap[i][j] == '*') isOpenMine = true;
			}
		}

		int[][] mineCountMap = makeMineCountMap(mineMap, N);
		char[][] resultMap = makeResultMap(mineMap, openMap, mineCountMap, N);

		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(resultMap[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static char[][] makeResultMap(char[][] mineMap, char[][] openMap, int[][] mineCountMap, int N){
		char[][] resultMap = new char[N][N];

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(isOpenMine && mineMap[i][j] == '*') resultMap[i][j]='*';
                else if(openMap[i][j] == 'x'){
					resultMap[i][j] = (char)(mineCountMap[i][j]+'0');
				}else{
					resultMap[i][j] = '.';
				}
			}
		}

		return resultMap;
	}

	public static int[][] makeMineCountMap(char[][] mineMap, int N){
		int[][] dir = new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};

		int[][] mineCountMap = new int[N][N];

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(mineMap[i][j] == '*'){
					for(int d=0;d<8;d++){
						int ny = i+dir[d][0];
						int nx = j+dir[d][1];
						if(ny>=0 && nx>=0 && ny<N && nx<N) mineCountMap[ny][nx]++;
					}
				}
			}
		}

		return mineCountMap;
	}
}
