package dev.m3s.programming2.homework3;
public class StudentCourse {

    Course course;
    int gradeNum;
    int yearCompleted; //millo kurssi kayty

    StudentCourse(){}

    StudentCourse(Course course, final int gradeNum, final int yearCompleted){
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }


    private boolean checkGradeValidity(final int gradeNum){
        
     if(course.isNumericGrade() == true && gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE){
            return true;
        }
        else if(course.isNumericGrade() == false){
            if(gradeNum == ConstantValues.GRADE_ACCEPTED || gradeNum == ConstantValues.GRADE_FAILED)
            return true;
        }
        
        return false;
    }

    protected void setGrade(final int gradeNum){
        
        if(checkGradeValidity(gradeNum) == true){
        if(course.isNumericGrade() == true && gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE){
           this.gradeNum = gradeNum;}
        else if(course.isNumericGrade() == false){
            if(gradeNum == ConstantValues.GRADE_ACCEPTED || gradeNum == ConstantValues.GRADE_FAILED)
            this.gradeNum = gradeNum;
        }
        }

        if(yearCompleted == 0){
            this.yearCompleted = 2023;
        }
    }

    public boolean isPassed(){

        if(gradeNum == ConstantValues.MIN_GRADE || gradeNum == ConstantValues.GRADE_FAILED){
            return false;
        }else
            return true;
    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {

        if(year >= 2000 && year <= 2023)
        this.yearCompleted = year;
    }
    

    public String toString(){

        if(getGradeNum() > ConstantValues.MIN_GRADE && getGradeNum() <= ConstantValues.MAX_GRADE){
            return course.toString() + " Year: " + getYear() + ", Grade: " + getGradeNum() + ".]";
        }
        else if(getGradeNum() == ConstantValues.GRADE_ACCEPTED){
            return course.toString() + " Year: " + getYear() + ", Grade: A.]";
        }
        else if(getGradeNum() == ConstantValues.GRADE_FAILED){
            return course.toString() + " Year: " + getYear() + ", Grade: F.]";
        }else{
            return course.toString() + " Year: " + getYear() + ", Grade: \"Not graded\".]";
        }
        
    }
    
}
