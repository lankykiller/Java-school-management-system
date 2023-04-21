package dev.m3s.programming2.homework3;
public class Course {
        
    
    String name = ConstantValues.NO_TITLE;
    String courseCode = ConstantValues.NOT_AVAILABLE;
    Character courseBase = ' '; //joko A, P tai S
    int courseType; //0 = Optional, 1 = Mandatory
    int period;
    double credits;
    boolean numericGrade;
   
    Course(){}
    
    Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade){
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

     Course(Course course){
    
        this.name = course.name;
        this.courseCode = course.courseCode;
        this.courseBase = course.courseBase;
        this.courseType = course.courseType;
        this.period = course.period;
        this.credits = course.credits;
        this.numericGrade = course.numericGrade;
    
    }



    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        if(name != null && name != ""){
            this.name = name;}
        
    }
    
    public String getCourseTypeString(){

        if(courseType == ConstantValues.OPTIONAL){
            return "Optional";
        }
        else if(courseType == ConstantValues.MANDATORY){
            return "Mandatory";
        }else{
            return "Error";
        }
    }

    public int getCourseType(){
        return courseType;
    }

    public void setCourseType(final int type){

        if(type == ConstantValues.OPTIONAL || type == ConstantValues.MANDATORY){
            courseType = type;
        }

    }

    public String getCourseCode(){
        return courseCode;
    }
    
    public void setCourseCode(final int courseCode, Character courseBase){
   
        if(courseCode > 0 && courseCode < 1000000 && (courseBase == 'A' || courseBase == 'P' ||courseBase == 'S' || courseBase == 'a')){
                
                this.courseBase = courseBase;
                this.courseCode = Integer.toString(courseCode) + courseBase;
        }

    }

    public Character getCourseBase(){
        return courseBase;
    }

    public int getPeriod(){
        return period;
    }

    public void setPeriod(final int period){

        if(period <= ConstantValues.MAX_PERIOD && period >= ConstantValues.MIN_PERIOD){

                this.period = period;
        }
    }

    public double getCredits(){
            return credits;
    }

    private void setCredits(final double credits){
    
        if(credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS){
            this.credits = credits;
        }
    }

    public boolean isNumericGrade(){
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade){

        this.numericGrade = numericGrade;
    }

    public String toString(){

           return " [" + courseCode + " ( " + String.format("%.2f", credits) + " cr), \"" + name + "\". " 
            + getCourseTypeString() + ", period: " + period + ".] ";
        
        
    }

}
