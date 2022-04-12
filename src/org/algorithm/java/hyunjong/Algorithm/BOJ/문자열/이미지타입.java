package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class 이미지타입 {
	public static void main(String[] args) {
		RoutineImage routineImage1 = new RoutineImage("2022-03-20T05:50:26.948image", "IMAGE");
		RoutineImage routineImage2 = new RoutineImage("2022-03-20T05:50:26.1000image", "IMAGE");
		RoutineImage routineImage3 = new RoutineImage("2022-03-20T05:50:26.9999image", "VIDEO");
		List<RoutineImage> routineImageList = new ArrayList<>();
		routineImageList.add(routineImage1);
		routineImageList.add(routineImage2);
		routineImageList.add(routineImage3);

		List<String> fileTypeArr = new ArrayList<>();
		fileTypeArr.add("jpg");
		fileTypeArr.add("jpeg");
		fileTypeArr.add("mp4");
		// String[] videoTypeArr = {"mp4"};

		for (RoutineImage image : routineImageList) {
			//imageUrl에 타입이 들어있는지 없는지 확인
			//없다면 사진은 jpeg, 동영상은 mp4
			StringBuilder sb = new StringBuilder();
			sb.append(image.imageUrl);
			String[] urlArr = image.imageUrl.toLowerCase(Locale.ROOT).split("\\.");
			String type = urlArr[urlArr.length - 1];
			if (!fileTypeArr.contains(type)) {
				if (image.fileType.equals("IMAGE")) {
					sb.append(".jpeg");
				} else {
					sb.append(".mp4");
				}
				image.imageUrl = sb.toString();
			}
		}

		for(RoutineImage image : routineImageList){
			System.out.println(image.imageUrl+" / "+image.fileType);
		}
	}

	static class RoutineImage {
		String imageUrl;
		String fileType;

		public RoutineImage(String imageUrl, String fileType) {
			this.imageUrl = imageUrl;
			this.fileType = fileType;
		}
	}
}
