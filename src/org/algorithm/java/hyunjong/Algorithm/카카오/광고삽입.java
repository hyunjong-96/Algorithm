package org.algorithm.java.hyunjong.Algorithm.카카오;

public class 광고삽입 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(solution(play_time, adv_time, logs));
	}

	static public String solution(String play_time, String adv_time, String[] logs){
		int[] accumulateTime = new int[360001];
		int advTime = timeToint(adv_time);
		int playTime = timeToint(play_time);
		for(String log : logs){
			String[] logTimes = log.split("-");
			int startTime = timeToint(logTimes[0]);
			int endTime = timeToint(logTimes[1]);

			accumulateTime[startTime] += 1;
			accumulateTime[endTime] -= 1;
		}

		int s=0;
		for(int i = 0;i<accumulateTime.length;i++){
			s += accumulateTime[i];
			accumulateTime[i] = s;
		}

		int maxIdx=0;
		long maxSum=0;
		long sum=0;
		for(int i=0;i<advTime;i++){
			sum+=accumulateTime[i];
		}
		maxSum = sum;

		for(int i=advTime;i<=playTime;i++){
			sum += accumulateTime[i]-accumulateTime[i-advTime];
			if(maxSum<sum){
				maxSum = sum;
				maxIdx = i-advTime+1;
			}
		}

		return timeTostring(maxIdx);
	}

	static String timeTostring(int time){
		int h = time/3600;
		time %= 3600;
		int m = time/60;
		time %= 60;
		int s = time;

		StringBuilder sb = new StringBuilder();
		if(h<10) sb.append("0");
		sb.append(h);
		sb.append(":");
		if(m<10) sb.append("0");
		sb.append(m);
		sb.append(":");
		if(s<10) sb.append("0");
		sb.append(s);

		return sb.toString();
	}

	static int timeToint(String time){
		String[] arr = time.split(":");
		int h = Integer.parseInt(arr[0])*60*60;
		int m = Integer.parseInt(arr[1])*60;
		int s = Integer.parseInt(arr[2]);

		return h+m+s;
	}
}
