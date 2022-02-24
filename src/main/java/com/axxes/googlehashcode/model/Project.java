package com.axxes.googlehashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private int days;
    private int completionScore;
    private int bestBefore;
    private int roles;
    private List<Contributor.Skill> skills;

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

    public List<Contributor.Skill> getSkills() {

        return skills;
    }
}
