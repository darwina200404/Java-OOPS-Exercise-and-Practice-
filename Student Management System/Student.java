
import java.util.ArrayList;

public class Student{
    private String name;
    private int totalClass;
    private int AttendedClass;
    private ArrayList<Course> courses;
    private int totalCreditNeeded;
    private int semestersLeft;
    private int currentCredits;
    
    Student(String name,int totalCreditNeeded,int semestersLeft){
        this.name=name;
        this.totalCreditNeeded=totalCreditNeeded;
        this.semestersLeft=semestersLeft;
        this.totalClass=0;
        this.currentCredits=0;
        this.AttendedClass=0;
        this.courses=new ArrayList<>();
    }
    public void addCourse(String CourseName,double grade,int credits){
        courses.add(new Course(CourseName, grade));
        currentCredits += credits;
    }
    
    public void markAttendance(int totalClasses, int attendedClasses) {
        this.totalClass = totalClasses;
        this.AttendedClass = attendedClasses;
    }

    public double getAttendancePercentage() {
        if (totalClass == 0) return 0;
        return (AttendedClass * 100.0) / totalClass;
    }

    public void checkAttendanceWarning() {
        double attendance = getAttendancePercentage();
        if (attendance < 75.0) {
            System.out.println("Warning: Low attendance (" + attendance + "%)");
        } else {
            System.out.println("Attendance is sufficient (" + attendance + "%)");
        }
    }

    public double calculateAverageGrade() {
        if (courses.isEmpty()) return 0;
        double total = 0;
        for (Course c : courses) {
            total += c.grade;
        }
        return total / courses.size();
    }

    public boolean isEligibleForScholarship() {
        double avgGrade = calculateAverageGrade();
        double attendance = getAttendancePercentage();
        return avgGrade >= 85.0 && attendance >= 90.0;
    }

    public void predictGraduationDate() {
        int remainingCredits = totalCreditNeeded - currentCredits;
        int avgCreditsPerSemester = remainingCredits / semestersLeft;
        System.out.println("Credits remaining: " + remainingCredits);
        System.out.println("Estimated graduation in " + semestersLeft + " semester(s) if " 
                            + avgCreditsPerSemester + " credits earned per semester.");
    }

    public void showStudentSummary() {
        System.out.println("\n--- Student Summary ---");
        System.out.println("Name: " + name);
        System.out.println("Average Grade: " + calculateAverageGrade());
        checkAttendanceWarning();
        if (isEligibleForScholarship()) {
            System.out.println("Eligible for Scholarship ");
        } else {
            System.out.println("Not eligible for Scholarship ");
        }
        predictGraduationDate();
    }
}


