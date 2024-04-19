import java.sql.Array;
import java.util.ArrayList;

public class Student {
    private double weightedGPA = 0.0;
    private double unweightedGPA = 0.0;
    private double totalCreditsAttempted = 0.0;
    private double totalCreditsEarned = 0.0;
    private ArrayList<String> courseList = new ArrayList<String>();
    private ArrayList<Integer> courseIDList = new ArrayList<Integer>();
    private ArrayList<String> courseType = new ArrayList<String>();
    private ArrayList<Double> courseCreditsAttempted = new ArrayList<Double>();
    private ArrayList<Double> courseCreditsEarned = new ArrayList<Double>();
    private ArrayList<Integer> termNumber = new ArrayList<Integer>();
    private ArrayList<String> gradeList = new ArrayList<String>();

    Student(){
    }

    Student(double unweightedGPA){
        this.unweightedGPA = unweightedGPA;
    }

    Student(double unweightedGPA, double weightedGPA){
        this.unweightedGPA = unweightedGPA;
        this.weightedGPA = weightedGPA;
    }

    public double getWeightedGPA(){
        return weightedGPA;
    }

    public double getUnweightedGPA(){
        return unweightedGPA;
    }

    public double getTotalCreditsAttempted(){
        return totalCreditsAttempted;
    }

    public double getTotalCreditsEarned(){
        return totalCreditsEarned;
    }

    public void addCredit(String courseName, int courseID, int termNumber, String courseType, String gradeEarned, double creditAttempted, double creditEarned){
        courseList.add(courseName);
        courseIDList.add(courseID);
        this.termNumber.add(termNumber);
        this.courseType.add(courseType);
        gradeList.add(gradeEarned);
        courseCreditsAttempted.add(creditAttempted);
        courseCreditsEarned.add(creditEarned);
        calcCredits();
        calcUnweightedGPA();
        calcWeightedGPA();
    }

    public void removeCredit(int courseID, int termNum){
        for(int i = 0; i < courseIDList.size(); i++){
            if (courseIDList.get(i) == courseID && termNumber.get(i) == termNum){
                courseList.remove(i);
                courseType.remove(i);
                gradeList.remove(i);
                courseCreditsEarned.remove(i);
                courseCreditsAttempted.remove(i);
                courseCreditsEarned.remove(i);
                courseIDList.remove(i);
                termNumber.remove(i);
                break;
            }
        }
        calcUnweightedGPA();
        calcWeightedGPA();
    }

    private void calcUnweightedGPA(){
        double qualPoints = 0;
        for(int i = 0; i < courseCreditsAttempted.size(); i++){
            if(courseCreditsAttempted.get(i) == 0.5){
                String queryGrade = gradeList.get(i);
                if(queryGrade.equals("A")){
                    qualPoints += 2.0;
                } else if (queryGrade.equals("B+") || queryGrade.equals("B")) {
                    qualPoints += 1.5;
                } else if (queryGrade.equals("C+") || queryGrade.equals("C")) {
                    qualPoints += 1.0;
                } else if (queryGrade.equals("D+") || queryGrade.equals("D")) {
                    qualPoints += 0.5;
                } else {
                    qualPoints += 0;
                }
            } else if (courseCreditsAttempted.get(i) == 1.0) {
                String queryGrade = gradeList.get(i);
                if(queryGrade.equals("A")){
                    qualPoints += 4.0;
                } else if (queryGrade.equals("B+") || queryGrade.equals("B")) {
                    qualPoints += 3.0;
                } else if (queryGrade.equals("C+") || queryGrade.equals("C")) {
                    qualPoints += 2.0;
                } else if (queryGrade.equals("D+") || queryGrade.equals("D")) {
                    qualPoints += 1.0;
                } else {
                    qualPoints += 0;
                    }
                }
            }

        unweightedGPA = qualPoints / totalCreditsAttempted;
    }

    private void calcWeightedGPA(){
        double qualPoints = 0;
        for(int i = 0; i < courseCreditsAttempted.size(); i++){
            if(courseCreditsAttempted.get(i) == 0.5){
                if(courseType.get(i).equalsIgnoreCase("Regular")){
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 2.0;
                    } else if (queryGrade.equals("B+") || queryGrade.equals("B")) {
                        qualPoints += 1.5;
                    } else if (queryGrade.equals("C+") || queryGrade.equals("C")) {
                        qualPoints += 1.0;
                    } else if (queryGrade.equals("D+") || queryGrade.equals("D")) {
                        qualPoints += 0.5;
                    } else {
                        qualPoints += 0;
                    }
                } else if (courseType.get(i).equalsIgnoreCase("Honors")) {
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 2.5;
                    } else if (queryGrade.equals("B+")) {
                        qualPoints += 2.25;
                    } else if (queryGrade.equals("B")) {
                        qualPoints += 2.0;
                    } else if (queryGrade.equals("C+")) {
                        qualPoints += 1.75;
                    }  else if (queryGrade.equals("C")) {
                        qualPoints += 1.5;
                    } else if (queryGrade.equals("D+")) {
                        qualPoints += 0.75;
                    } else if (queryGrade.equals("D")){
                        qualPoints += 0.5;
                    } else {
                        qualPoints += 0;
                    }
                } else if (courseType.get(i).equalsIgnoreCase("AP") || courseType.get(i).equalsIgnoreCase("AICE") || courseType.get(i).equalsIgnoreCase("IB") || courseType.get(i).equalsIgnoreCase("Dual")) {
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 3.0;
                    } else if (queryGrade.equals("B+")) {
                        qualPoints += 2.75;
                    } else if (queryGrade.equals("B")) {
                        qualPoints += 2.5;
                    } else if (queryGrade.equals("C+")) {
                        qualPoints += 2.25;
                    }  else if (queryGrade.equals("C")) {
                        qualPoints += 2.0;
                    } else if (queryGrade.equals("D+")) {
                        qualPoints += 0.75;
                    } else if (queryGrade.equals("D")){
                        qualPoints += 0.5;
                    } else {
                        qualPoints += 0;
                    }
                }
            } else if (courseCreditsAttempted.get(i) == 1.0) {
                if(courseType.get(i).equalsIgnoreCase("Regular")){
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 4.0;
                    } else if (queryGrade.equals("B+") || queryGrade.equals("B")) {
                        qualPoints += 3.0;
                    } else if (queryGrade.equals("C+") || queryGrade.equals("C")) {
                        qualPoints += 2.0;
                    } else if (queryGrade.equals("D+") || queryGrade.equals("D")) {
                        qualPoints += 1.0;
                    } else {
                        qualPoints += 0;
                    }
                } else if (courseType.get(i).equalsIgnoreCase("Honors")) {
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 5;
                    } else if (queryGrade.equals("B+")) {
                        qualPoints += 4.5;
                    } else if (queryGrade.equals("B")) {
                        qualPoints += 4.0;
                    } else if (queryGrade.equals("C+")) {
                        qualPoints += 3.5;
                    }  else if (queryGrade.equals("C")) {
                        qualPoints += 3.0;
                    } else if (queryGrade.equals("D+")) {
                        qualPoints += 1.5;
                    } else if (queryGrade.equals("D")){
                        qualPoints += 1.0;
                    } else {
                        qualPoints += 0;
                    }
                } else if (courseType.get(i).equalsIgnoreCase("AP") || courseType.get(i).equalsIgnoreCase("AICE") || courseType.get(i).equalsIgnoreCase("IB") || courseType.get(i).equalsIgnoreCase("Dual")) {
                    String queryGrade = gradeList.get(i);
                    if(queryGrade.equals("A")){
                        qualPoints += 6.0;
                    } else if (queryGrade.equals("B+")) {
                        qualPoints += 5.5;
                    } else if (queryGrade.equals("B")) {
                        qualPoints += 5.0;
                    } else if (queryGrade.equals("C+")) {
                        qualPoints += 4.5;
                    }  else if (queryGrade.equals("C")) {
                        qualPoints += 4.0;
                    } else if (queryGrade.equals("D+")) {
                        qualPoints += 1.5;
                    } else if (queryGrade.equals("D")){
                        qualPoints += 1.0;
                    } else {
                        qualPoints += 0;
                    }
                }
            }
        }

        weightedGPA = qualPoints / totalCreditsAttempted;
    }

    private void calcCredits(){
        totalCreditsAttempted = 0.0;
        totalCreditsEarned = 0.0;

        for(Double credit : courseCreditsAttempted){
            totalCreditsAttempted += credit;
        }

        for(Double credit : courseCreditsEarned){
            totalCreditsEarned += credit;
        }
    }

}
