package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.*;
import java.util.stream.Collectors;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 데이터분석2
 * author         : leehyunjong
 * date           : 2025/05/06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/06        leehyunjong       최초 생성
 */
public class 데이터분석2 {
    public static void main(String[] args) {
        int[][]data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int valExt= 20300501;
        String sortBy = "remain";
        int[][] result = solution(data, ext, valExt, sortBy);

        System.out.print(Arrays.deepToString(result));
    }

    public static int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        List<int[]> list = Arrays.asList(data);

        Map<String, Integer> idxMap = new HashMap<>();
        idxMap.put("code",0);
        idxMap.put("date", 1);
        idxMap.put("maximum", 2);
        idxMap.put("remain", 3);

        int extIdx = idxMap.get(ext);
        int sortIdx = idxMap.get(sortBy);

        //필터링
        list = list.stream().filter(d -> d[extIdx] < valExt).collect(Collectors.toList());

        //정렬
        Collections.sort(list, (d1, d2) -> d1[sortIdx] - d2[sortIdx]);

        int[][] result = new int[list.size()][4];
        for(int i=0;i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
