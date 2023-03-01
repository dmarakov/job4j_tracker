package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double rsl = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                count++;
                rsl += subj.score();
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        double averageScore;
        for (Pupil pupil : pupils) {
            double pupilScore = 0;
            for (Subject subj : pupil.subjects()) {
                pupilScore += subj.score();
            }
            averageScore = pupilScore / pupil.subjects().size();
            rsl.add(new Label(pupil.name(), averageScore));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Integer> tempMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                if (!tempMap.containsKey(subj.name())) {
                    tempMap.put(subj.name(), subj.score());
                } else {
                    tempMap.put(subj.name(), tempMap.get(subj.name()) + subj.score());
                }

            }
        }
        for (String name : tempMap.keySet()) {
            rsl.add(new Label(name, (double) tempMap.get(name) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double pupilScore = 0;
            for (Subject subj : pupil.subjects()) {
                pupilScore += subj.score();
            }
            rsl.add(new Label(pupil.name(), pupilScore));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> tempMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                if (!tempMap.containsKey(subj.name())) {
                    tempMap.put(subj.name(), subj.score());
                } else {
                    tempMap.put(subj.name(), tempMap.get(subj.name()) + subj.score());
                }

            }
        }
        for (String name : tempMap.keySet()) {
            rsl.add(new Label(name, tempMap.get(name)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}