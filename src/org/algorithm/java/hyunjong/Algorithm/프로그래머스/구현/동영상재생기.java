package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

public class 동영상재생기 {
    public static void main(String[] args) {
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07"	;
        String[] commands = new String[]{"next"};

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }

    static int OpStart;
    static int OpEnd;
    static int VideoLen;
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        VideoLen = convertTime(video_len);
        int currentTime = convertTime(pos);
        OpStart = convertTime(op_start);
        OpEnd = convertTime(op_end);

        currentTime = checkTime(currentTime);

        for(String command : commands) {
            if(command.equals("next")) {
                currentTime += 10;

                if(currentTime > VideoLen) {
                    currentTime = VideoLen;
                }
            }
            else if(command.equals("prev")) {
                currentTime -= 10;

                if(currentTime < 0) {
                    currentTime = 0;
                }
            }

            currentTime = checkTime(currentTime);
        }

        return toTime(currentTime);
    }

    private static int checkTime(int currentTime) {
        if(currentTime >= OpStart && currentTime <= OpEnd) {
            currentTime = OpEnd;
        }

        return currentTime;
    }

    private static int convertTime(String time) {
        String[] splitTime = time.split(":");

        int m = Integer.parseInt(splitTime[0])*60;
        int s = Integer.parseInt(splitTime[1]);

        return m+s;
    }

    private static String toTime(int time) {
        String m = String.format("%02d",time/60);
        String s = String.format("%02d",(time%60));

        return m+":"+s;
    }
}
