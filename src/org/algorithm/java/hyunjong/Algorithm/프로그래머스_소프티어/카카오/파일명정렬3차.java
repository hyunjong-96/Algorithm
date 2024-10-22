package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.Arrays;

public class 파일명정렬3차 {
	public static void main(String[] args) {
		String[] files = {"img12", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		for(String s : solution(files)){
			System.out.println(s);
		}
	}

	static public String[] solution(String[] files) {
		File[] fileArr = new File[files.length];

		for(int i=0;i<files.length;i++){
			fileArr[i] = new File(files[i]);
		}
		Arrays.sort(fileArr);
		for(int i=0;i<files.length;i++){
			files[i] = fileArr[i].file;
		}
		return files;
	}

	static class File implements Comparable<File> {
		String file;
		String head;
		int number;
		String tail;

		public File(String file) {
			this.file = file;
			StringBuilder headBuilder = new StringBuilder();
			int idx = 0;
			char[] chars = file.toCharArray();
			while (idx < chars.length && chars[idx] < '0' || chars[idx] > '9') {
				headBuilder.append(chars[idx]);
				idx++;
			}
			this.head = headBuilder.toString();

			StringBuilder numberBuilder = new StringBuilder();
			while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
				numberBuilder.append(chars[idx]);
				idx++;
			}
			this.number = Integer.parseInt(numberBuilder.toString());
			this.tail = file.substring(idx);
		}

		@Override
		public int compareTo(File o) {
			if (this.head.equalsIgnoreCase(o.head)) {
				return this.number - o.number;
			} else {
				return this.head.compareToIgnoreCase(o.head);
			}
		}
	}
}
