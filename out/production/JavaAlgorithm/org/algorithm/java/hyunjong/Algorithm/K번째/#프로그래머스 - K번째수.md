# #프로그래머스 - K번째수

## 문제설명

> 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
>
> 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
>
> 1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
> 2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
> 3. 2에서 나온 배열의 3번째 숫자는 5입니다.
>
> 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한사랑

> - array의 길이는 1 이상 100 이하입니다.
> - array의 각 원소는 1 이상 100 이하입니다.
> - commands의 길이는 1 이상 50 이하입니다.
> - commands의 각 원소는 길이가 3입니다.

## 예시

| array                 | commands                          | return    |
| --------------------- | --------------------------------- | --------- |
| [1, 5, 2, 6, 3, 7, 4] | [[2, 5, 3], [4, 4, 1], [1, 7, 3]] | [5, 6, 3] |



## 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];
        for(int q=0;q< commands.length;q++){
            ArrayList<Integer> sortList = new ArrayList();
            int i = commands[q][0];
            int j = commands[q][1];
            int k = commands[q][2];

            for(int p=i-1;p<j;p++){
                sortList.add(array[p]);
            }
            Collections.sort(sortList);

            answer[q] = sortList.get(k-1);
        }

        return answer;
    }
}
```

- 정렬을 위해 `sort()메소드`를 위해 `Collections`와 `ArrayList`를 불러온다
- for문으로 command각 행마다 배열을 자를 첫번째위치(i), 마지막 위치(j), 정렬된 배열에서 가져올 위치(k)를 가져온다
- i와 j의 위치를 index에 맞춰주고 arrayList에 하나씩 넣는다
- Collections의 sort를 통해 정렬한후 k번째 수를 answer에 대입해준다.