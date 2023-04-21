package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
public class AssistantTeacher extends Employee implements Teacher{


        private List<DesignatedCourse> courses = new ArrayList<>();
     
        AssistantTeacher(String lname, String fname) {
            super(lname, fname);
            
            
        }

        public String getEmployeeIdString() {
            return "OY_ASSISTANT_";
        }

        public String getCourses() {

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i<courses.size(); i++){
                sb.append(courses.get(i).toString());
            }
            return sb.toString();
        }

        public void setCourses(List<DesignatedCourse> courses) {
        
            if(courses != null){
                this.courses.clear();
               
                for(int i = 0; i<courses.size(); i++){
                    
                        this.courses.add(courses.get(i));
                    }
        }
        }

        public String toString(){

            DecimalFormat df = new DecimalFormat("0.00");

            return "Teacher id: " + getIdString() + "\nFirst Name: " + getFirstName() + ", Last Name: " + getLastName() + "\nBirthdate: " + getBirthDate()
            + "\nSalary: " + df.format(calculatePayment())+ " \n Assistant for courses :   " + getCourses();
        }


    
}
