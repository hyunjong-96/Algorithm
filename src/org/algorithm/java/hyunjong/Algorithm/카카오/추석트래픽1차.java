package org.algorithm.java.hyunjong.Algorithm.카카오;

public class 추석트래픽1차 {
	public static void main(String[] args) {
		String[] lines = {
			"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"
		};
		System.out.println(solution(lines));
	}

	static public int solution(String[] lines){
		int[] startTimes = new int[lines.length];
		int[] endTimes = new int[lines.length];
		setTime(lines, startTimes, endTimes);

		int processCount=0;
		for(int i=0;i<startTimes.length;i++){
			int count = 0;
			int startOfWindow = startTimes[i];
			int endOfWindow = startTimes[i]+999;

			for(int j=0;j<lines.length;j++){
				if(startTimes[j] > endOfWindow) break;

				if(startTimes[j]>=startOfWindow && startTimes[j]<=endOfWindow){
					count++;
				}else if(endTimes[j]>=startOfWindow && endTimes[j]<=endOfWindow){
					count++;
				}else if(startTimes[j]<=startOfWindow && endTimes[j]>=endOfWindow){
					count++;
				}
			}
			processCount = Math.max(processCount, count);
		}

		for(int i=0;i<endTimes.length;i++){
			int count=0;
			int startOfWindow = endTimes[i];
			int endOfWindow = endTimes[i]+999;

			for(int j=0;j<lines.length;j++){
				// if(startTimes[j]>endOfWindow) break;

				if(startTimes[j]>=startOfWindow && startTimes[j]<=endOfWindow){
					count++;
				}else if(endTimes[j]>=startOfWindow && endTimes[j]<=endOfWindow){
					count++;
				}else if(startTimes[j]<startOfWindow && endTimes[j]>endOfWindow){
					count++;
				}
			}
			processCount = Math.max(processCount, count);
		}

		return processCount;
	}

	static void setTime(String[] lines, int[] startLines, int[] endLines){
		for(int i = 0;i<lines.length;i++){
			String[] log = lines[i].split(" ");

			String[] endTimeArr = log[1].split(":");
			int endTime = 0;
			endTime += Integer.parseInt(endTimeArr[0])*60*60*1000;
			endTime += Integer.parseInt(endTimeArr[1])*60*1000;
			endTime += (int)(Double.parseDouble(endTimeArr[2])*1000);

			int processingTime = (int)(Double.parseDouble(log[2].substring(0,log[2].length()-1))*1000);
			int startTime = endTime - processingTime + 1;

			startLines[i] = startTime;
			endLines[i] = endTime;
		}
	}
}
