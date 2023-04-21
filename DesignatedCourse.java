package dev.m3s.programming2.homework3;

public class DesignatedCourse {

    Course course;
    boolean responsible;
    int year = 2023;

    DesignatedCourse() {
    }

    DesignatedCourse(Course course, boolean responsible, int year) {
        setCourse(course);
        setResponsible(responsible);
        setYear(year);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
    
    if(course != null){
        this.course = course;}
    }

    public boolean isResponsible() {
        if(responsible == true){
        return true;}
        else{
        return false;}
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean getResponsible(){
        return responsible;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
    
    if(year >= 2000 && year <= 2024){
        this.year = year;}
    }

    public String toString() {
        
        return "[Course=" + course.toString()+ ", year=" + year + "]\n";
    }
}
