package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 데이터분석
 * author         : leehyunjong
 * date           : 2025/05/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/05        leehyunjong       최초 생성
 */
import java.util.*;
public class 데이터분석 {
    public static void main(String[] args) {
        int[][]data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int valExt= 20300501;
        String sortBy = "remain";
        int[][] result = solution(data, ext, valExt, sortBy);

        System.out.print(Arrays.deepToString(result));
    }

    static public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 열 이름 → 인덱스 매핑
        Map<String, Integer> colIndex = new HashMap<>();
        colIndex.put("code", 0);
        colIndex.put("date", 1);
        colIndex.put("maximum", 2);
        colIndex.put("remain", 3);

        int extIdx = colIndex.get(ext);
        int sortIdx = colIndex.get(sort_by);

        // 조건: ext 열의 값이 val_ext보다 작은 경우만 남김
        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }

        // 정렬
        filtered.sort(Comparator.comparingInt(a -> a[sortIdx]));

        // List → int[][]
        int[][] result = new int[filtered.size()][];
        for (int i = 0; i < filtered.size(); i++) {
            result[i] = filtered.get(i);
        }

        return result;
    }
}
