package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.SORT
 * fileName       : 영단어암기는괴로워
 * author         : leehyunjong
 * date           : 2025/05/14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/14        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 영단어암기는괴로워 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for(int i=0;i<N;i++) {
            String w = br.readLine();

            if(w.length() >= M) {
                wordMap.put(w, wordMap.getOrDefault(w, 1)+1);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for(String key : wordMap.keySet()) {
            wordList.add(new Word(key, wordMap.get(key)));
        }

        wordList = wordList.stream().sorted().collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(Word w : wordList) {
            sb.append(w.word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static class Word implements Comparable<Word>{
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word w) {
            int result = 0;

            //단어 개수 내림차순
            result = Integer.compare(w.cnt, this.cnt);

            if(result == 0) {
                //단어 길이 내림차순
                result = Integer.compare(w.word.length(), this.word.length());

                if(result == 0) {
                    //알파멧 오름차순
                    result = this.word.compareTo(w.word);
                }
            }

            return result;
        }
    }
}
