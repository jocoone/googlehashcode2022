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
    private List<Contributor> contributors;

    public Project(final String name, final int days, final int completionScore, final int bestBefore, final int roles) {
        this.name = name;
        this.days = days;
        this.completionScore = completionScore;
        this.bestBefore = bestBefore;
        this.roles = roles;
        this.skills = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project.Skill> getSkills() {
        return skills;
    }

    public void addContributor(Contributor contributor) {
        contributor.select(days);
        contributors.add(contributor);
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public boolean isFinished() {
        return !skills.stream().anyMatch(project -> !project.isFilled());
    }

    public static class Skill {
        private String name;
        private int level;
        private boolean filled;

        public Skill(final String name, final int level) {
            this.name = name;
            this.level = level;
            this.filled = false;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public boolean isFilled() {
            return filled;
        }

        public void fill() {
            this.filled = true;
        }
    }

    public int getDays() {
        return days;
    }

    public int getCompletionScore() {
        return completionScore;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public int getRoles() {
        return roles;
    }
}
