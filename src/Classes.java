import java.util.*;
import java.io.*;

public class Classes {
    static class Course {
        Integer courseCode;
        String courseName;
        Integer creditHours;
        String subject;
        float professorRating;
        String time; // HH:MM
        List<Integer> prerequisites;

        public Course(Integer courseCode, String courseName, Integer creditHours, String subject, float professorRating, String time, List<Integer> prerequisites) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.creditHours = creditHours;
            this.subject = subject;
            this.professorRating = professorRating;
            this.time = time;
            this.prerequisites = prerequisites;
        }
    }

    public List<Course> courses = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("classes.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        Set<Integer> completedCourses = new HashSet<>();
        for (String code : sc.nextLine().split(" ")) {
            completedCourses.add(Integer.parseInt(code));
        }

        Classes classes = new Classes();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("\\|");
            Integer courseCode = Integer.parseInt(line[0]);
            String courseName = line[1];
            int creditHours = Integer.parseInt(line[2]);
            String subject = line[3];
            float professorRating = Float.parseFloat(line[4]);
            String time = line[5];
            String[] prerequisitesStr = line[6].split(", ");
            List<Integer> prerequisites = new ArrayList<>();
            for (String p : prerequisitesStr) {
                prerequisites.add(Integer.parseInt(p));
            }
            Course c = new Course(courseCode, courseName, creditHours, subject, professorRating, time, prerequisites);
            classes.courses.add(c);
        }

        // Filter out courses for which prerequisites are not met
        List<Course> eligibleCourses = new ArrayList<>();
        for (Course course : classes.courses) {
            if (completedCourses.containsAll(course.prerequisites)) {
                eligibleCourses.add(course);
            }
        }

        // Define comparators
        Comparator<Course> comp1 = Comparator.comparing((Course c) -> {
            String[] classOptions = {"Writing", "Lighting", "Sound-Design", "Casting", "Set-Design"};
            return Arrays.asList(classOptions).indexOf(c.subject);
        });

        Comparator<Course> comp2 = Comparator.comparing((Course c) -> -c.professorRating);

        Comparator<Course> comp3 = Comparator.comparingInt((Course c) -> getTimeIndex(c.time));

        Comparator<Course> comp4 = Comparator.comparingInt(c -> c.creditHours);

        Comparator<Course> comp5 = Comparator.comparingInt(c -> c.courseCode);

        eligibleCourses.sort(comp1.thenComparing(comp2).thenComparing(comp3).thenComparing(comp4).thenComparing(comp5));

        int totalCreditHours = 0;
        List<Course> selectedCourses = new ArrayList<>();
        for (Course course : eligibleCourses) {
            if (totalCreditHours + course.creditHours <= 20) {
                selectedCourses.add(course);
                totalCreditHours += course.creditHours;
            }
        }

        for (Course course : selectedCourses) {
            System.out.println(course.courseCode + ": " + course.courseName);
        }
    }

    private static int getTimeIndex(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int totalMinutes = hours * 60 + minutes;

        if (totalMinutes >= 11 * 60 && totalMinutes < 15 * 60) {
            return 0; // 11:00-15:00
        } else if (totalMinutes >= 15 * 60 && totalMinutes < 18 * 60) {
            return 1; // 15:00-18:00
        } else if (totalMinutes >= 9 * 60 && totalMinutes < 11 * 60) {
            return 2; // 9:00-11:00
        } else if (totalMinutes >= 18 * 60 && totalMinutes < 20 * 60) {
            return 3; // 18:00-20:00
        } else if (totalMinutes >= 7 * 60 && totalMinutes < 9 * 60) {
            return 4; // 7:00-9:00
        } else {
            return Integer.MAX_VALUE;
        }
    }
}