// Interface for activities
interface PerformActivities {
    void performActivity();
}

// Person class representing common properties of students and teachers
class Person {
    String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }
}

// Student class inheriting from Person and implementing PerformActivities
class Student extends Person implements PerformActivities {
    int studentID;
    char grade;

    // Constructor
    public Student(String name, int studentID, char grade) {
        super(name);
        this.studentID = studentID;
        this.grade = grade;
    }

    // Implementing interface method
    @Override
    public void performActivity() {
        System.out.println(name + " is participating in a student activity.");
    }
}

// Teacher class inheriting from Person and implementing PerformActivities
class Teacher extends Person implements PerformActivities {
    int employeeID;
    String subject;

    // Constructor
    public Teacher(String name, int employeeID, String subject) {
        super(name);
        this.employeeID = employeeID;
        this.subject = subject;
    }

    // Implementing interface method
    @Override
    public void performActivity() {
        System.out.println(name + " is participating in a teacher activity.");
    }
}

// Course class
class Course {
    String name;
    String courseCode;
    Teacher assignedTeacher;

    // Constructor
    public Course(String name, String courseCode, Teacher assignedTeacher) {
        this.name = name;
        this.courseCode = courseCode;
        this.assignedTeacher = assignedTeacher;
    }

    // Display course information
    public void displayCourseInfo() {
        System.out.println("Course: " + name);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Assigned Teacher: " + assignedTeacher.name);
    }
}

// Main class to test the school management system
public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Create students and teachers
        Student student1 = new Student("John Doe", 101, 'A');
        Teacher teacher1 = new Teacher("Ms. Smith", 201, "Mathematics");

        // Perform activities
        student1.performActivity();
        teacher1.performActivity();

        // Create a course
        Course mathCourse = new Course("Mathematics 101", "MATH101", teacher1);

        // Display course information
        mathCourse.displayCourseInfo();
    }
}
