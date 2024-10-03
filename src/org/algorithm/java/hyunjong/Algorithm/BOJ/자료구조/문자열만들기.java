package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.*;

public class 문자열만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sequence = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<String> seqList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            seqList.add(st.nextToken());
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<sequence.length();i++) {
            map.put(sequence.charAt(i), map.getOrDefault(sequence.charAt(i), 0)+1);
        }


        StringBuilder sb = new StringBuilder();
        for(String seq : seqList) {
            sb.append(getCountSequence(map, seq)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int getCountSequence(Map<Character, Integer> countMap, String seq) {
        Map<Character, Integer> seqCountMap = new HashMap<>();

        for(int i=0;i<seq.length();i++){
            seqCountMap.put(seq.charAt(i), seqCountMap.getOrDefault(seq.charAt(i), 0)+1);
        }

        int minCount = Integer.MAX_VALUE;
        for(char s : seqCountMap.keySet()) {
            if(!countMap.containsKey(s)) {
                minCount = 0;
                break;
            }
            else {
                minCount = Math.min(minCount, countMap.get(s)/seqCountMap.get(s));
            }
        }

        return minCount;
    }
}
