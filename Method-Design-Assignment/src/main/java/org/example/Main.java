package org.example;
import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class Main {
    public static void main(String[] args) {

        //First, I will initialize the courses
        String c1, c2, c3;
        //Here, I will initialize the student counter, which keeps track of the number of students.
        int studentCounter = 0;
        //Now, I will define the courses
        c1 = "AP Biology";
        c2 = "AP Calculus BC";
        c3 = "AP Literature";
        //Now, I will create an array list for the different students and define their test scores for the different classes.
        ArrayList<Student> students = new ArrayList<Student>();
        Student student1 = new Student("Jack", "Cipriani");
        studentCounter++;
        student1.setStudentCounter(studentCounter);
        student1.addCourse(c1, 95);
        student1.addCourse(c2, 80);
        student1.addCourse(c3, 100);
        students.add(student1);
        Student student2 = new Student("Sean", "Hoagland");
        studentCounter++;
        student2.setStudentCounter(studentCounter);
        student2.addCourse(c1, 30);
        student2.addCourse(c2, 50);
        student2.addCourse(c3, 12);
        students.add(student2);
        Student student3 = new Student("Beck", "Mahoney");
        studentCounter++;
        student3.setStudentCounter(studentCounter);
        student3.addCourse(c1, 97);
        student3.addCourse(c2, 70);
        student3.addCourse(c3, 100);
        students.add(student3);

        //Now, I will get the average test score for each student and print the students.
        student1.getAverage();
        System.out.println(student1);

        student2.getAverage();
        System.out.println(student2);

        student3.getAverage();
        System.out.println(student3);
        Scanner scan = new Scanner(System.in);
        boolean addBool = true;
        String input;

        //Now, I will allow the user to add as many students as they please. I will also allow the user to set the new student's test scores for the three courses.
        while(addBool) {
            System.out.println("Would you like to enter another student? Press 'y' for yes or 'n' for no");
            input = scan.next();
            switch (input) {

                //Here, I will define the result for the input 'y'.
                case "y":
                    studentCounter++;

                    System.out.println("\nPlease enter the first name of the new student: ");
                    String first = scan.next();
                    System.out.println("\nPlease enter the last name of the new student: ");
                    String last = scan.next();
                    Student studentNew = new Student(first, last);
                    studentNew.setStudentCounter(studentCounter);
                    System.out.println("\nPlease set their final score in " + c1 + ": ");
                    studentNew.addCourse(c1, scan.nextInt());
                    System.out.println("\nPlease set their final score in " + c2 + ": ");
                    studentNew.addCourse(c2, scan.nextInt());
                    System.out.println("\nPlease set their final score in " + c3 + ": ");
                    studentNew.addCourse(c3, scan.nextInt());
                    students.add(studentNew);
                    studentNew.getAverage();
                    System.out.println(studentNew);
                    break;

                //Here, I will define the result for the input 'n'.
                case "n":
                    System.out.println();
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i));
                    }
                    addBool = false;
                    break;

                //Here, I will define the result for an invalid input.
                default:
                    System.out.println("\nThat was not a valid response. Please try again");
            }
        }
    }
}

class Student
{
    //Here, I will establish the array list for the courses.
    ArrayList<String> courses = new ArrayList<String>();

    //Here, I will establish the array list for the test scores.
    ArrayList<Integer> testScores = new ArrayList<Integer>();
    private String firstName, lastName;
    double courseAverage;

    int studentCounter=0;

    public void addCourse(String inCourse, int score){
        courses.add(inCourse);
        testScores.add(score);
    }

    public void setTestScores(String inCourse, int score){
        courses.add(inCourse);
        testScores.add(score);
    }

    public void setStudentCounter(int inStudentCounter){
        studentCounter = inStudentCounter;
    }

    public Student(String first, String last)
    {
        firstName = first;
        lastName = last;
    }

    //Here, I will define the toString for the students.
    public String toString()
    {
        String result;
        result = "Student " + studentCounter + ": " + firstName + " " + lastName + "\nAverage test score across all three classes: " + courseAverage + "%";
        for (int i = 0; i < courses.size(); i++) {
            result += "\n" + courses.get(i) + " final score: " + testScores.get(i) + "%";
        }
        result += "\n";
        return result;
    }

    //Here, I will define how to get the average for the students.
    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < courses.size(); i++) {
            sum += testScores.get(i);
        }
        courseAverage = sum/courses.size();
        DecimalFormat fmt = new DecimalFormat(".##");
        courseAverage = Double.parseDouble(fmt.format(courseAverage));
        return courseAverage;
    }
}
