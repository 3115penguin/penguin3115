package ru.vsu.cs.course1;


import java.util.ArrayList;
import java.util.List;

public class Task {
    public static List<Integer> Process(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }

        List<Integer> maxProgression = new ArrayList<>();

        for (int start = 0; start < list.size(); start++) {
            for (int i = start + 1; i < list.size(); i++) {
                int step = list.get(i) - list.get(start);
                List<Integer> progression = new ArrayList<>();
                progression.add(list.get(start));
                progression.add(list.get(i));

                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) - step == progression.get(progression.size() - 1)) {
                        progression.add(list.get(j));
                    }
                }

                if (progression.size() > maxProgression.size()) {
                    maxProgression = new ArrayList<>(progression);
                }
            }
        }

        return maxProgression;
    }
}
