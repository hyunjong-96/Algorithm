package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

public class 자물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};

		System.out.println(solution(key,lock));
	}

	static int M;
	static int N;
	static int paddingSize;
	static boolean solution(int[][] key, int[][] lock){
		M = key.length;
		N = lock.length;
		paddingSize = N-1;

		for(int i=0;i<4;i++){
			key = turnKey(key);
			int[][] paddingKey = padding(key);
			for(int ky=0;ky<paddingKey.length-paddingSize;ky++){
				for(int kx=0;kx<paddingKey[ky].length-paddingSize;kx++){
					if(matching(paddingKey,lock,ky,kx)){
						return true;
					}
				}
			}
		}

		return false;
	}

	static boolean matching(int[][] key, int[][] lock, int startY, int startX){
		for(int i=0;i<N*N;i++){
			int ly = i/N;
			int lx = i%N;
			if(lock[ly][lx]+key[startY+ly][startX+lx] != 1) return false;
		}
		return true;
	}

	static int[][] turnKey(int[][] key){
		int[][] turn = new int[M][M];
		for(int i=0;i<M*M;i++){
			if(key[i/M][i%M]==1){
				int y = i/M;
				int x = i%M;
				turn[x][(M-1)-y]=1;
			}
		}
		return turn;
	}

	static int[][] padding(int[][] key){
		int[][] paddingKey = new int[M+2*paddingSize][M+2*paddingSize];
		for(int i=0;i<M*M;i++){
			if(key[i/M][i%M]==1){
				paddingKey[(i/M)+paddingSize][(i%M)+paddingSize] = 1;
			}
		}
		return paddingKey;
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	//시간초과 풀이
	// public static void main(String[] args) {
	// 	int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
	// 	int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
	//
	// 	System.out.println(solution(key,lock));
	// }
	//
	// static int M;
	// static int N;
	// //up, left, down, right
	// static int[] dy = {-1, 0, 1, 0};
	// static int[] dx = {0, -1, 0, 1};
	// static boolean solution(int[][] key, int[][] lock){
	// 	M = key.length;
	// 	N = lock.length;
	//
	// 	List<Point> keyPointList = new ArrayList<>();
	// 	List<Point> lockHollList = new ArrayList<>();
	// 	for(int i=0;i<M*M;i++){
	// 		if(key[i/M][i%M] == 1){
	// 			keyPointList.add(new Point(i%M, i/M));
	// 		}
	// 	}
	// 	for(int i=0;i<N*N;i++){
	// 		if(lock[i/N][i%N] == 0){
	// 			lockHollList.add(new Point(i%N, i/N));
	// 		}
	// 	}
	//
	//
	// 	boolean answer = false;
	// 	answer = matching(keyPointList, lockHollList, 0, 0, 0, 0);
	//
	// 	return answer;
	// }
	//
	// static boolean matching(List<Point> keyPointList, List<Point> lockHollList, int upCount, int leftCount, int downCount, int rightCount){
	// 	if(upCount>=M || leftCount>=M || downCount>=M || rightCount>=M){
	// 		return false;
	// 	}
	//
	// 	if(isMatching(keyPointList, lockHollList)) return true;
	//
	// 	//90도씩 회전
	// 	for(int t = 0;t<4;t++){
	// 		List<Point> turnKeyPointList = turnKey(keyPointList);
	// 		boolean matchingResult = false;
	// 		for(int d = 0;d<4;d++){
	// 			List<Point> moveKeyPointList = moveKey(turnKeyPointList,d);
	// 			if(d==0){
	// 				matchingResult = matching(moveKeyPointList, lockHollList, upCount+1, leftCount, downCount, rightCount);
	// 			}else if(d==1){
	// 				matchingResult = matching(moveKeyPointList, lockHollList, upCount, leftCount+1, downCount, rightCount);
	// 			}else if(d==2){
	// 				matchingResult = matching(moveKeyPointList, lockHollList, upCount, leftCount, downCount+1, rightCount);
	// 			}else{
	// 				matchingResult = matching(moveKeyPointList, lockHollList, upCount, leftCount, downCount, rightCount+1);
	// 			}
	// 			if(matchingResult) return true;
	// 		}
	// 	}
	// 	return false;
	// }
	//
	// static boolean isMatching(List<Point> keyPointList, List<Point> lockHollList){
	// 	int matchingCount = 0;
	//
	// 	for(Point lp : lockHollList){
	// 		for(Point kp : keyPointList){
	// 			if(lp.y == kp.y && lp.x==kp.x){
	// 				matchingCount++;
	// 			}
	// 		}
	// 	}
	// 	return matchingCount == lockHollList.size();
	// }
	//
	// static List<Point> moveKey(List<Point> keyPointList, int d){
	// 	List<Point> moveKey = new ArrayList<>(keyPointList);
	// 	for(Point p : keyPointList){
	// 		p.y = p.y+dy[d];
	// 		p.x = p.x+dx[d];
	// 	}
	// 	return moveKey;
	// }
	//
	// static List<Point> turnKey(List<Point> keyPointList){
	// 	List<Point> turnKeyList = new ArrayList<>(keyPointList);
	// 	for(Point p : turnKeyList){
	// 		int px = p.x;
	// 		int py = p.y;
	// 		p.y = p.x;
	// 		p.x = M-1-(p.y);
	// 	}
	// 	return turnKeyList;
	// }
	//
	// static class Point{
	// 	int x;
	// 	int y;
	// 	public Point(int x, int y){
	// 		this.x = x;
	// 		this.y = y;
	// 	}
	// }
}
