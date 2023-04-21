package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;

public class Degree {

        static final int MAX_COURSES = 50;
        String degreeTitle = ConstantValues.NO_TITLE;
        String titleOfThesis = ConstantValues.NO_TITLE;
        List<StudentCourse> myCourses = new ArrayList<StudentCourse>(MAX_COURSES);
        
        public List<StudentCourse> getCourses() {
            return myCourses;
        }

        public void addStudentCourses(List<StudentCourse> courses){
        
        int i;
        int pituus = 0;
        if(courses == null){
            pituus = 0;
        }else{
            pituus = courses.size();
        }

            for(i = 0; i < pituus; i++){
                addStudentCourse(courses.get(i));
            }
        }
        
        public boolean addStudentCourse(StudentCourse course){
        
        int count = myCourses.size();

            if (count >= MAX_COURSES || course == null) {
                return false;
            }
            myCourses.add(course);
            count ++;
            return true;
        }

        public String getDegreeTitle() {
            return degreeTitle;
        }

        public void setDegreeTitle(String degreeTitle) {
            if(degreeTitle != null)
                this.degreeTitle = degreeTitle;
        }

        public String getTitleOfThesis() {
            return titleOfThesis;
        }

        public void setTitleOfThesis(String titleOfThesis) {
            if(titleOfThesis != null)
                this.titleOfThesis = titleOfThesis;
        }
       
        public double getCreditsByBase(Character base){
            
        double credits = 0;
        int i;
           
            for(i = 0; i < myCourses.size(); i++){
                if(myCourses.get(i).getCourse().getCourseBase() == base && isCourseCompleted(myCourses.get(i)) == true ){
                    credits += myCourses.get(i).getCourse().getCredits();
                }
            }
                          
            return credits;
        }

        public double getCreditsByType(final int courseType){

        double credits = 0;
        int i;
            
            for(i = 0; i < myCourses.size(); i++){
                if(myCourses.get(i).getCourse().getCourseType() == courseType && isCourseCompleted(myCourses.get(i)) == true){
                    credits += myCourses.get(i).getCourse().getCredits();
                }
            }
            
            return credits;
        }

        public double getCredits(){
        
        double credits = 0;
        int i;

            for(i = 0; i < myCourses.size(); i++){
                
                if(isCourseCompleted(myCourses.get(i)) == true){
                    credits += myCourses.get(i).getCourse().getCredits();
                }
            }

            return credits;
        }

        private boolean isCourseCompleted(StudentCourse c){

            if(c.isPassed() == true){
                return true;
            }else{
                return false;
            }
        }
        
        public void printCourses(){
        
        int i;
           
            for(i = 0; i < myCourses.size(); i++){
            if(myCourses.get(i) != null){
            System.out.println(myCourses.get(i) + ".] ");
            }
            }
        }

        public List<Double> getGPA(int type){

        List<Double> list = new ArrayList<Double>();
        
        double sum = 0;
        double count = 0;
        double average = 0;
        int i;

        for(i = 0; i < myCourses.size(); i++){
                if(type == 2 ){
                if(myCourses.get(i).getCourse().isNumericGrade() == true){
                    sum+= myCourses.get(i).getGradeNum();
                    count ++;}
                }else{
                    
                    if(myCourses.get(i).getCourse().getCourseType() == type && myCourses.get(i).getCourse().isNumericGrade() == true){
                    sum += myCourses.get(i).getGradeNum();
                    count ++;
                }
            }
            }
            
            average = sum / count;
            //average = Math.round(average * 100.0) / 100.0;
           //vähän hassua että testissä ei pyöristetty kahden tarkkuudella
            list.add(sum);
            list.add(count);
            list.add(average);

            return list;
        }

        public String toString(){
       
        StringBuilder sb = new StringBuilder();
        
        sb.append("Degree [Title: \"" + getDegreeTitle() + "\" (courses: " + myCourses.size() + ") \n" + "Thesis title: \"" + getTitleOfThesis() + "\"\n");

        int i;
                for (i = 0; i < myCourses.size(); i++) {
                    if (myCourses.get(i) != null) {
                    sb.append(myCourses.get(i)).append(".]\n");
                }
            }

        return sb.toString();
        }

        //student toString gpa varten    
        public double getSum(){

        double sum = 0;
        int i;

        for(i = 0; i < myCourses.size(); i++){
            if(myCourses.get(i).getCourse().isNumericGrade() == true){
                    sum += myCourses.get(i).getGradeNum();                    
                    }
                }
        return sum;
        }

        public double getCount(){

        double count = 0;
        int i;        
            
        for(i = 0; i < myCourses.size(); i++){
            if(myCourses.get(i).getCourse().isNumericGrade() == true){
                    count ++;
                }
            }
        
        return count;
    }
}
