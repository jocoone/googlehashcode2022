package com.axxes.googlehashcode;

import com.axxes.googlehashcode.model.Contributor;
import com.axxes.googlehashcode.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.axxes.googlehashcode.util.Util.readLines;
import static com.axxes.googlehashcode.util.Util.writeString;

public class LibraryApplication {
    public static final String a_filename = "a_example";
    public static final String b_filename = "b_better_start_small.in";
    public static final String c_filename = "c_collaboration.in";
    public static final String d_filename = "d_dense_schedule.in";
    public static final String e_filename = "e_exceptional_skills.in";
    public static final String f_filename = "f_find_great_mentors.in";
    private static final String newLine = "\n";

    public static void main(String[] args) {
        //convert(a_filename);
        convert(b_filename);
        //convert(c_filename);
        //convert(d_filename);
        //convert(e_filename);
        //convert(f_filename);
    }

    private static void convert(String file) {
        final List<String> lines = readLines("src/main/resources/" + file + ".txt");
        final String[] splitline1 = lines.get(0).split(" ");
        final int numContribu = Integer.parseInt(splitline1[0]);
        final int numProjects = Integer.parseInt(splitline1[1]);
        final List<Contributor> contributors = new ArrayList<>();
        int i = 1;
        do {
            final String line = lines.get(i);
            System.out.println(line);
            final String[] s = line.split(" ");
            final String name = s[0];
            final int skills = Integer.parseInt(s[1]);

            final Contributor contributor = new Contributor(name);
            i++;
            for (int sk = 0; sk < skills; sk++) {
                final String[] skillLine = lines.get(i)
                        .split(" ");
                contributor.addSkill(skillLine[0], Integer.parseInt(skillLine[1]));
                i++;
            }

            contributors.add(contributor);
        } while (contributors.size() < numContribu);
        List<Project> projects = new ArrayList<>();
        do {
            final String line = lines.get(i);
            System.out.println(line);
            final String[] s = line.split(" ");
            final String name = s[0];
            final int numDays = Integer.parseInt(s[1]);
            final int score = Integer.parseInt(s[2]);
            final int best = Integer.parseInt(s[3]);
            final int contri = Integer.parseInt(s[4]);
            final Project project = new Project(name, numDays, score, best, contri);
            i++;
            for (int sk = 0; sk < contri; sk++) {
                final String[] skillLine = lines.get(i)
                        .split(" ");
                Project.Skill skill = new Project.Skill(skillLine[0], Integer.parseInt(skillLine[1]));
                project.getSkills()
                        .add(skill);
                i++;
            }
            projects.add(project);
        } while (projects.size() < numProjects);

        int day = 0;
        while (day < projects.stream().map(Project::getDays).max(Integer::compareTo).orElse(0)) {
            List<Project> nfProj = projects.stream().filter(Project::isNotFinished).toList();
            for (Project project : nfProj) {
                for (Project.Skill pskill : project.getSkills()) {
                    for (Contributor contributor : contributors) {
                        if (contributor.isBusy()) {
                            contributor.work();
                        } else {
                            if (pskill.getLevel() <= contributor.getLevel(pskill.getName())) {
                                project.addContributor(pskill, contributor);
                            }
                        }
                    }
                }
            }
            int finalDay = day;
            projects.forEach(project -> {
                        if (project.isNotFinished() && project.getDays() == finalDay) {
                            project.finish();
                        }
                    }
            );
            day++;
        }
        createOutput(file + "_out", projects.stream().filter(project -> !project.getContributors().isEmpty()).toList());
    }

    public static void createOutput(String fileName, List<Project> projects) {
        final StringBuilder builder = new StringBuilder();
        builder.append(projects.size()).append(newLine);

        for (Project project : projects) {
            builder.append(project.getName()).append(newLine);

            String test = project.getContributors()
                    .stream().map(Contributor::getName)
                    .collect(Collectors.joining(" "));
            builder.append(test).append(newLine);
        }

        writeString(fileName + ".txt", builder.toString());
    }
}
