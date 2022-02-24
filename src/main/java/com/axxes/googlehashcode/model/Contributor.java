package com.axxes.googlehashcode.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contributor {

    private String name;
    private Map<String, Integer> skills;

    public Contributor(final String name) {
        this.name = name;
        this.skills = new HashMap<>();
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
}
