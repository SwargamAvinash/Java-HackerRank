import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
/*
 * Create the Student and Priorities classes here.
 */

// Start using a lot more of lambda type of functions.. 
// And Learn more what can Comparator what else it can do and all.

class Student {
    int id;
    String name;
    double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCGPA() {
        return cgpa;
    }
    
    // @Override
    // public int compareTo(Student s2) {
    //     if (this.cgpa > s2.getCGPA()) return 1;
    //     else if (this.cgpa < s2.getCGPA()) return -1;
    //     else {
    //         if (this.name > s2.getName()) return 1;
    //         else if (this.name < s2.getName()) return -1;
    //         else {
    //             return this.id - s2.getID();
    //         }
    //     }
    // }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCGPA).reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getID)
        ); // Defining a priority Queue without comparable.. and Comparing multiple 
        // Multiple Stuff At once..
        
        List<Student> students = new ArrayList<>();
        
        for (String e: events) {
            Scanner in = new Scanner(e);
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                float cgpa = in.nextFloat();
                int token = in.nextInt();

                Student student = new Student(token, name, cgpa);
                queue.add(student);
            } else if (event.equals("SERVED")) {
                Student first = queue.poll();
            } in.close();
        }
        Student first = queue.poll();
        if (first == null) {
            return students;
        } else {
            while (first != null) {

                students.add(first);
                first = queue.poll();

            }
            return students;
        }
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}