package dev.m3s.programming2.homework3;

public abstract class Employee extends Person implements Payment{

    private String empId;
    private int startYear = 2023;
    private Payment payment;

    Employee(String lname, String fname){

        super(lname, fname);
        int Id = getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
        String id = Integer.toString(Id);
        empId = getEmployeeIdString() + id;

    }

    public String getIdString(){

        return empId;
    }

    public int getStartYear(){

        return startYear;
    }

    public void setStartYear(final int startYear){

        if(startYear <= 2023 && startYear > 2000){
            this.startYear = startYear;
        }
    }

    public Payment getPayment(){

        return payment;
    }

    public void setPayment(Payment payment){

        if(payment != null){
        this.payment = payment;}
    }

    public double calculatePayment(){

        double salary = 0.0;
        if(payment != null){
        salary = payment.calculatePayment();
        }

        return salary;
    }

    protected abstract String getEmployeeIdString();

    
}
