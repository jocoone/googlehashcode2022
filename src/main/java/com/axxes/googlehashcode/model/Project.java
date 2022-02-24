package com.axxes.googlehashcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class Project {

    private String name;
    private int days;
    private int completionScore;
    private int bestBefore;
    private int roles;
    private List<Project.Skill> skills;
    private boolean finished;

    public Project(final String name, final int days, final int completionScore, final int bestBefore, final int roles) {
        this.name = name;
        this.days = days;
        this.completionScore = completionScore;
        this.bestBefore = bestBefore;
        this.roles = roles;
        this.skills = new ArrayList<>();
        this.finished =false;
    }

    public String getName() {
        return name;
    }

    public List<Project.Skill> getSkills() {
        return skills;
    }

    public void addContributor(Skill skill, Contributor contributor) {
        contributor.select(days);
        skill.fill(contributor);
    }

    public List<Contributor> getContributors() {
        return skills.stream().map(Skill::getContributor).filter(Objects::nonNull).toList();
    }

    public boolean isNotFinished() {
        return !finished;
    }

    public void finish() {
        finished = true;
        for(Skill skill: this.skills) {
            if (skill.getContributor() != null) {
                skill.getContributor().levelUp(skill);
            }
        }
    }

    public static class Skill {
        private String name;
        private int level;
        private Contributor contributor;


        public Skill(final String name, final int level) {
            this.name = name;
            this.level = level;
            this.contributor = null;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public boolean isFilled() {
            return nonNull(contributor);
        }

        public void fill(Contributor contributor) {
            this.contributor = contributor;
        }

        public Contributor getContributor() {
            return contributor;
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
