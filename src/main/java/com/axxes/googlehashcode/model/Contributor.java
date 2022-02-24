package com.axxes.googlehashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Contributor {

    private String name;
    private List<Skill> skills;

    public Contributor(final String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public List<Skill> getSkills() {
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
