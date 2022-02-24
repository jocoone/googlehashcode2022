package com.axxes.googlehashcode;

import com.axxes.googlehashcode.model.Contributor;
import com.axxes.googlehashcode.model.Project;

import java.util.ArrayList;
import java.util.List;

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
		convert(a_filename);
		//convert(b_filename);
		/*convert(c_filename);
		convert(d_filename);
		convert(e_filename);
		convert(f_filename);*/
	}

	private static void convert(String file) {
		final List<String> lines = readLines("src/main/resources/" + file + ".txt");
		final String[] splitline1 = lines.get(0)
										 .split(" ");
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

			for (int sk = 0; sk < skills; sk++) {
				final String[] skillLine = lines.get(i)
												.split(" ");
				contributor.addSkill(skillLine[0], Integer.parseInt(skillLine[1]));
				i++;
			}

			contributors.add(contributor);
			i++;
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

			for (int sk = 0; sk < contri; sk++) {
				final String[] skillLine = lines.get(i)
												.split(" ");
				Project.Skill skill = new Project.Skill(skillLine[0], Integer.parseInt(skillLine[1]));
				project.getSkills()
					   .add(skill);
				i++;
			}
			projects.add(project);
			i++;
		} while (projects.size() < numProjects);




		createOutput(file + "_out", "");
	}

	public static void createOutput(String fileName, String content) {
		final StringBuilder builder = new StringBuilder(content);

		writeString(fileName, builder.toString());
	}
}
