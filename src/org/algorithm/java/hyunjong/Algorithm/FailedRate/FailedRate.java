package org.algorithm.java.hyunjong.Algorithm.FailedRate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FailedRate {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        int successUser = stages.length;
        List<Stage> stageList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int stageCount = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i + 1) stageCount++;
            }
            stageList.add(new Stage(i + 1, stageCount / (double) successUser));
            successUser -= stageCount;
        }

        stageList.sort(Comparator.reverseOrder());
        answer = stageList.stream().mapToInt(Stage::getStage).toArray();

        return answer;
    }
}

class Stage implements Comparable<Stage> {
    private int stage;
    private double failRate;

    public Stage(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public int compareTo(Stage o) {
        if (this.failRate == o.failRate) {
            return this.stage < o.stage ? 1 : -1;
        } else {
            return this.failRate > o.failRate ? 1 : -1;
        }
    }
}
