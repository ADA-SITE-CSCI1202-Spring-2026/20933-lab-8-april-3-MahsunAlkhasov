import java.util.*;

public class Grades {
    public static void main(String[] args) {
        Map<String, Double> studentGrades = new HashMap<>();

        studentGrades.put("Masud Eyubov", 2.6);
        studentGrades.put("Khadija Mirzayeva", 2.69);
        studentGrades.put("Michael Jackson", 3.9);
        studentGrades.put("Arnold Shawarmanegger", 1.2);
        studentGrades.put("Emma Stone", 3.8);
        studentGrades.put("Mahsun Alkhasov", 4.0);
        studentGrades.put("Bruce Lee", 2.3);

        System.out.println("All Students and their GPAs:");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        List<String> topStudents = findTopStudents(studentGrades);
        double highestGPA = studentGrades.get(topStudents.get(0));

        System.out.printf("Student(s) with the highest GPA (%.2f):%n", highestGPA);
        for (String student : topStudents) {
            System.out.println("   " + student);
        }
        System.out.println();

        double averageGPA = calculateAverageGPA(studentGrades);
        System.out.printf("Average GPA of all students: %.2f%n%n", averageGPA);

        int belowAverageCount = countStudentsBelowAverage(studentGrades, averageGPA);
        System.out.println("Number of students with GPA less than average: " + belowAverageCount);

        System.out.println("\nStudents below average GPA:");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            if (entry.getValue() < averageGPA) {
                System.out.printf("   %s: %.2f%n", entry.getKey(), entry.getValue());
            }
        }
    }

    public static List<String> findTopStudents(Map<String, Double> grades) {
        if (grades == null || grades.isEmpty()) {
            return new ArrayList<>();
        }

        double maxGPA = Collections.max(grades.values());

        List<String> topStudents = new ArrayList<>();
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            if (entry.getValue() == maxGPA) {
                topStudents.add(entry.getKey());
            }
        }

        return topStudents;
    }

    public static double calculateAverageGPA(Map<String, Double> grades) {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (double gpa : grades.values()) {
            sum += gpa;
        }

        return sum / grades.size();
    }

    public static int countStudentsBelowAverage(Map<String, Double> grades, double averageGPA) {
        if (grades == null || grades.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (double gpa : grades.values()) {
            if (gpa < averageGPA) {
                count++;
            }
        }

        return count;
    }
}