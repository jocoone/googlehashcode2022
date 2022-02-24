package com.axxes.googlehashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private int days;
    private int completionScore;
    private int bestBefore;
    private int roles;
    private List<Project.Skill> skills;

    public Project(final String name, final int days, final int completionScore, final int bestBefore, final int roles) {
        this.name = name;
        this.days = days;
        this.completionScore = completionScore;
        this.bestBefore = bestBefore;
        this.roles = roles;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project.Skill> getSkills() {
        return skills;
    }

    public static class Skill {
        private String name;
        private int level;

        public Skill(final String name, final int level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }
    }
}
