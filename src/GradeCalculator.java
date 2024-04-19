import java.util.Scanner;

public class GradeCalculator {
    public static void main(String args[ ]){
        Scanner input = new Scanner(System.in);
        Student student = new Student();

        String courseName = "";
        int courseID = 0;
        int termNum = 0;
        String courseType = "";
        String grade = "";
        double creditAttempted = 0;
        double creditEarned = 0;
        boolean repeat = true;

        while(repeat) {
            System.out.println("Please enter the course name.");
            courseName = input.nextLine();
            System.out.println("Please enter the course ID.");
            courseID = input.nextInt();
            System.out.println("Please enter the term number.");
            termNum = input.nextInt();
            System.out.println("Please enter the course type.");
            courseType = input.next();
            System.out.println("Please enter the credit amount the course is worth.");
            creditAttempted = input.nextDouble();
            System.out.println("Please enter the credit amount you earned for this course.");
            creditEarned = input.nextDouble();
            System.out.println("Please enter the grade you earned for this course.");
            grade = input.next();

            student.addCredit(courseName,courseID,termNum,courseType,grade,creditAttempted,creditEarned);

            System.out.println("Enter another course?");
            if(! input.next().equalsIgnoreCase("y")){
                repeat = false;
            }
            input.nextLine();
        }

        System.out.println("Thank you. Your unweighted GPA is " + student.getUnweightedGPA() + ", and your weighted GPA is " + student.getWeightedGPA() + ". Goodbye!");

    }
}
