package com.axxes.googlehashcode.model;

import java.util.HashMap;
import java.util.Map;

public class Contributor {

    private String name;
    private Map<String, Integer> skills;
    private boolean busy;

    public Contributor(final String name) {
        this.name = name;
        this.skills = new HashMap<>();
        this.busy = false;
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

    public boolean isBusy() { return busy; }

    public void select() { this.busy = true; }
}
