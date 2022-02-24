package com.axxes.googlehashcode.model;

import java.util.HashMap;
import java.util.Map;

public class Contributor {

    private String name;
    private Map<String, Integer> skills;
    private int busy;

    public Contributor(final String name) {
        this.name = name;
        this.skills = new HashMap<>();
        this.busy = 0;
    }

    public String getName() {
        return name;
    }

    public void addSkill(String skill, int level) {
        this.skills.put(skill, level);
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public int getLevel(String skill) {
        return skills.containsKey(skill) ? skills.get(skill) : 0;
    }

    public boolean isBusy() {
        return busy > 0;
    }

    public void select(int days) {
        this.busy = days;
    }

    public void work() {
        this.busy -= 1;
    }
}
