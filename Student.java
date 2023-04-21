package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.math.RoundingMode;

    public class Student extends Person{

        
        private int id;
        private int startYear = 2023;
        private int graduationYear;
        private List<Degree> degrees = new ArrayList<>(3); //(0 = bachelor, 1 = master, 2 = reserved for doctoral studies
    
        Student(String lname, String fname){

            super(lname, fname);
            id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
            //degrees = new ArrayList<Degree>();
             
            Degree bachelor= new Degree();
            Degree master = new Degree();
            Degree doctoral = new Degree();
            degrees.add(bachelor);
            degrees.add(master);
            degrees.add(doctoral);
        }

        public int getId(){
    
            return id;
        }
        
        public void setId(final int id){
    
            if(id >= ConstantValues.MIN_STUDENT_ID && id <= ConstantValues.MAX_STUDENT_ID){
            this.id = id;}   
        }

        public int getStartYear(){
            return startYear;
        }

        public void setStartYear(final int startYear){

            if(2000 < startYear && startYear <= 2023){

                this.startYear = startYear;
            }
        }

        public int getGraduationYear(){
            return graduationYear;
        }
        
        public String setGraduationYear(final int graduationYear){

            String feedback = "Check graduation year";
    
        if(canGraduate() == true && graduationYear >= 2000 && graduationYear <= 2023 && graduationYear >= startYear){
            feedback = "Ok";
            this.graduationYear = graduationYear;
            return feedback;
        }

        if(canGraduate() == false){
            feedback = "Check amount of required credits";
            return feedback;
        }

        return feedback;
        }

        public void setDegreeTitle(final int i, String dName){
            
            if(i >= 0 && i < degrees.size() && dName != null){
              
                degrees.get(i).setDegreeTitle(dName);
            }
        }

        public boolean addCourse(final int i, StudentCourse course){

            if(i >= 0 && i < degrees.size() && course != null){
                if(degrees.get(i).addStudentCourse(course)){
                    return true;
                }else{
                    return false;
                }

            }

            return false;
        }

        public int addCourses(final int i, List<StudentCourse> courses){

            int count = 0;

            if (i >= 0 && i < degrees.size() && courses != null) {

                Degree degree = degrees.get(i);
        
                for(int j = 0; j < courses.size(); j++){
        
                    if(degree.addStudentCourse(courses.get(j)) == true){
                        count++;
                    }
                }
                }
        
         return count;
        }

        public void printCourses(){
            
            for(int i = 0; i < degrees.size(); i++){
                
            degrees.get(i).printCourses();
            }
        }

        public void printDegrees(){
            
            for(int i = 0; i < degrees.size(); i++){
                
                System.out.println(degrees.get(i).toString());
               
            }
        }

        public void setTitleOfThesis(final int i, String title){

            if(i >= 0 && i < degrees.size() && title != null){
                degrees.get(i).setTitleOfThesis(title);
            }
        }

        
        public boolean hasGraduated(){

            if(graduationYear <= 2023 && graduationYear >= 2000){
                return true;}

        return false;
        }

        private boolean canGraduate(){
            
            if(getBachelorCredits() >= 180 && getMastersCredits() >= 120 && degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE){
                return true;
            
            }else{
             
                return false;}
        }

        public int getStudyYears(){
    
        int studyYears = 0;
        
            if(hasGraduated() == true){
                studyYears = graduationYear - startYear;
            }else{
                studyYears = 2023 - startYear;}
        
        return studyYears;
        }

        public String toString(){

            DecimalFormat df = new DecimalFormat("0.00");
             df.setRoundingMode(RoundingMode.HALF_UP);
            //GPA lasku
            Double average =( degrees.get(0).getSum() + degrees.get(1).getSum() )/(degrees.get(0).getCount() + degrees.get(1).getCount());
            average = Math.round(average * 100.0) / 100.0;
            df.format(average);

            if(canGraduate() == true && hasGraduated() == true){
            return  getIdString() + "\nFirst name: " + getFirstName() + ", Last name: " + getLastName() + "\nDate of birht: " + getBirthDate() + 
                    "\nStatus: the student has graduated in " + getGraduationYear() + "\nStart year: " + getStartYear() + "(studies have laster for " + getStudyYears() + " years)" +
                    "\nTotal credits: " + allCredits() + " (GPA = "+ average + ")\nBachelor credits: " + getBachelorCredits() + "\nTotal bachelor credits completed (" + getBachelorCredits() + 
                    "/180.0)\nAll mandatory bachelor credits completed (" + degrees.get(0).getCreditsByType(1) + "/150.0)\nGPA of Bachelor studies: " +
                    df.format((degrees.get(0).getSum()/degrees.get(0).getCount()))+
                    "\nTitle of BSc Thesis: " + degrees.get(0).getTitleOfThesis() + "\nMasters credits: " + getMastersCredits() + "\nTotal master credits completed (" + getMastersCredits() +
                    "/120.0)\nAll mandatory master credits completed (" + degrees.get(1).getCreditsByType(1) + "/90.0)\nGPA of Master studies: " + df.format((degrees.get(1).getSum()/degrees.get(1).getCount()))+
                     "\nTitle of MSc Thesis: " + degrees.get(1).getTitleOfThesis() + "\n";
            }else{
                return getIdString()+ "\nFirst name: " + getFirstName() + ", Last name: " + getLastName() + "\nDate of birht: " + getBirthDate() + 
                    "\nStatus: the student has not graduated yet" + "\nStart year: " + getStartYear() + "(studies have laster for " + getStudyYears() + " years)" +
                    "\nTotal credits: " + allCredits() + " (GPA = "+ average + ")\nBachelor credits: " + getBachelorCredits() + "\nMissing bachelors credits " + (180 - getBachelorCredits()) + "(" + getBachelorCredits() + 
                    "/180.0)\nAll mandatory bachelor credits completed (" + degrees.get(0).getCreditsByType(1) + "/150.0)\nGPA of Bachelor studies: " + df.format((degrees.get(0).getSum()/degrees.get(0).getCount())) +
                    "\nTitle of BSc Thesis: " + degrees.get(0).getTitleOfThesis() + "\nMasters credits: " + getMastersCredits() + "\nMissing master credits " + (120 - getMastersCredits()) + "(" + getMastersCredits() +
                    "/120.0)\nAll mandatory master credits completed (" + degrees.get(1).getCreditsByType(1) + "/90.0)\nGPA of Master studies: " + df.format((degrees.get(1).getSum()/degrees.get(1).getCount())) +
                     "\nTitle of MSc Thesis: " + degrees.get(1).getTitleOfThesis() + "\n";
            }

        }
        
        public String getIdString(){

            return "Student id: " + getId();
        }

        public double allCredits(){
        
            double allCredits = 0.0;
            
            for(Degree degree : degrees){
                allCredits += degree.getCredits();}
             
            return allCredits;
            }
    
        public double getBachelorCredits(){
    
            double bachelorCredits = 0.0;
                
            bachelorCredits = degrees.get(0).getCredits();

            return bachelorCredits;
            }
    
        public double getMastersCredits(){
    
            double mastersCredits = 0.0;
                
            mastersCredits = degrees.get(1).getCredits();
                          
            return mastersCredits;
            }


    
}
