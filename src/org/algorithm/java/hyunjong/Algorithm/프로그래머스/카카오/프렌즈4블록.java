package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

import java.util.Stack;

/*
비슷한 유형을 전에 풀어봤더니 잘 풀었다.
2차원 배열 Board를 만들어준 다음 Board[i][j]==Board[i+1][j]==Board[i][j+1]==Board[i+1][j+1]인 블록들을 true처리해준다.
이떄 위의 조건을 해줄때 새로 만든 Board는 default값이 '\u0000'으로 되어있기 떄문에 빈 공간이지만 조건을 통과하기 떄문에
Board[i][j] != '\u0000'처리도 해줘야한다.(놓치고 있던 부분)
그 뒤에 열 별로 순차탐색하면서 visit[i][j]가 true가 아닌 부분만 stack에 넣고 새로운 2차원 배열 board에 저장하는 것을 반복.
이떄 visit[i][j]가 true인 것을 카운트하면서 삭제된 갯수를 구한다.
만약 삭제 갯수가 0이라면 더이상 삭제될것이 없으니 함수를 종료한다.
그렇지 않으면 삭제된 갯수를 구하는것이기 떄문에 삭제된 갯수를 합해서 함수가 종료되었을때 반환해준다.
 */
public class 프렌즈4블록 {
	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		// String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m,n,board));
	}

	static int M;
	static int N;
	static char[][] Board;
	static int answer;

	static int solution(int m, int n, String[] board){
		M = m;
		N = n;
		Board = new char[M][N];

		for(int i=0;i<M;i++){
			char[] row = board[i].toCharArray();
			for(int j=0;j<N;j++){
				Board[i][j] = row[j];
			}
		}

		answer = 0;
		setBoard(Board);

		return answer;
	}

	static void setBoard(char[][] board){
		boolean[][] visit = new boolean[M][N];
		int removeCount=0;
		for(int i=0;i<M-1;i++){
			for(int j=0;j<N-1;j++){
				if(board[i][j] != '\u0000' && board[i][j] == board[i+1][j] && board[i][j]== board[i][j+1] && board[i][j] == board[i+1][j+1]){
					visit[i][j] = true;
					visit[i+1][j] = true;
					visit[i][j+1] = true;
					visit[i+1][j+1] = true;
				}
			}
		}

		char[][] newBoard = new char[M][N];
		for(int c=0;c<N;c++){
			Stack<Character> stack = new Stack<>();
			for(int r=0;r<M;r++){
				if(visit[r][c]){
					removeCount++;
				}
				if(!visit[r][c]){
					stack.push(board[r][c]);
				}
			}
			int idx = M-1;
			while(!stack.isEmpty()){
				newBoard[idx][c] = stack.pop();
				idx--;
			}
		}
		if(removeCount==0){
			return;
		}
		answer += removeCount;
		setBoard(newBoard);
	}
}
