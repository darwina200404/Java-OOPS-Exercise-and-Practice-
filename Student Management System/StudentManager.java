public class StudentManager {
    public static void main(String[] args) {
        Student student = new Student("Darwin A", 120, 4); // total credits needed, semesters left

        // Add some courses
        student.addCourse("Math", 90, 3);
        student.addCourse("Physics", 80, 4);
        student.addCourse("Java", 95, 3);

    
        student.markAttendance(100, 88); // total classes, attended classes

        
        student.showStudentSummary();
    }
    
}
