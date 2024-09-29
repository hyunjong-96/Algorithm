package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 디지털티비 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] channelList = new String[N];
        for(int i=0;i<N;i++) {
            String c = br.readLine();
            channelList[i] = c;
        }

        int kbs1Index = 0;
        int kbs2Index = 1;
        List<String> buttonList = new ArrayList<>();

        //index 0부터 KBS1이 있는 곳까지 1로 이동
        //찾으면 channel값을 변경해주면서 "4"로 채널 이동
        while(!channelList[0].equals("KBS1")) {
            if(channelList[kbs1Index].equals("KBS1")) {
                String temp = channelList[kbs1Index];
                channelList[kbs1Index] = channelList[kbs1Index-1];
                channelList[kbs1Index-1] = temp;

                buttonList.add("4");
                kbs1Index--;
            }
            else {
                buttonList.add("1");
                kbs1Index++;
            }
        }
        //모두 이동하고난 뒤에는 index는 0으로 되어있음

        //KBS2가 두번째 채널에 없는 경우 현재 index가 0에 가있기 때문에 index 1로 이동시켜줘야한다.
        if(!channelList[1].equals("KBS2")) {
            buttonList.add("1");
        }

        //KBS2가 두번째 채널에 없는 경우
        while(!channelList[1].equals("KBS2")) {
            if(channelList[kbs2Index].equals("KBS2")) {
                String temp = channelList[kbs2Index];
                channelList[kbs2Index] = channelList[kbs2Index-1];
                channelList[kbs2Index-1] = temp;

                buttonList.add("4");
                kbs2Index--;
            }
            else {
                buttonList.add("1");
                kbs2Index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String m : buttonList) {
            sb.append(m);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
