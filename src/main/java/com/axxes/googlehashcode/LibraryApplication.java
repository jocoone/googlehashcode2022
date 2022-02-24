package com.axxes.googlehashcode;

import java.nio.file.Paths;
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
		final List<String> lines = readLines(Paths.get("src/main/resources/" + file + ".txt")
												  .toString(), 0);


		createOutput(file + "_out", "");
	}

	public static void createOutput(String fileName, String content) {
		final StringBuilder builder = new StringBuilder(content);

		writeString(fileName, builder.toString());
	}
}
