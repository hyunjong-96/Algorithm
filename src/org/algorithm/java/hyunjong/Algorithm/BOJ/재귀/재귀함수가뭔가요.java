package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;

public class 재귀함수가뭔가요 {
	static String RightAnswer;
	static String DepthMark;
	static int limit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		limit = Integer.parseInt(br.readLine());
		answerInit();

		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		recursive(0, sb);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void recursive(int depth, StringBuilder sb) {
		String currentDepthMark = setDepthMark(depth);

		sb.append(currentDepthMark).append("\"재귀함수가 뭔가요?\"").append("\n");
		if (depth == limit) {
			sb.append(currentDepthMark).append(RightAnswer).append("\n");
		} else {
			sb.append(currentDepthMark).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
			sb.append(currentDepthMark).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
			sb.append(currentDepthMark).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
			recursive(depth + 1, sb);
		}
		sb.append(currentDepthMark).append("라고 답변하였지.").append("\n");
	}

	static String setDepthMark(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(DepthMark);
		}
		return sb.toString();
	}

	static void answerInit() {

		RightAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";

		DepthMark = "____";
	}
}
