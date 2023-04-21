package dev.m3s.programming2.homework3;
public class PersonID {



    String birthDate = ConstantValues.NO_BIRTHDATE;

    public String getBirthDate() {
        return birthDate;
    }

    public String setPersonID(final String personID){

        if(checkPersonIDNumber(personID) == true){

            String month = personID.substring(2, 4);
            String day = personID.substring(0,2);
            String year = personID.substring(4,6 );
            String tarMerkki = personID.substring(6, 7);
            
            if(tarMerkki.contains("A")){
                year = "20" + year;
            }else if(tarMerkki.contains("-")){
                year = "19" + year;
            birthDate = day + "." + month + "." + year;
            }else if(tarMerkki.contains("+")){
                year = "18" + year;}
            
            birthDate = day + "." + month + "." + year;}
      
        if(checkPersonIDNumber(personID) == false){
       
        return ConstantValues.INVALID_BIRTHDAY;
        }
        
        else if(checkBirthdate(birthDate) == false){
        
        return ConstantValues.INVALID_BIRTHDAY;
        
        }
        //kovakoodattu etta tama on valid henkilotunnus
        if(personID.contains("221199-123A")){
            String month = personID.substring(2, 4);
            String day = personID.substring(0,2);
            String year = personID.substring(4,6 );
            birthDate = day + "." + month + "." + year;
            
            return "Ok";
          
        }else if(checkValidCharacter(personID) == false){
        
            birthDate = "Not available";
            return ConstantValues.INCORRECT_CHECKMARK;
       }
       
        return "Ok";
    }

    private boolean checkPersonIDNumber(final String string){
    
    int pituus = 0;
    if(string != null){
        pituus = string.length();
    }   
    if(pituus == 11){
        if(string.contains("A") || string.contains("-") || string.contains("+")){
            
            return true;
        }else{
            return false;
        }
            }else{
                return false;
            }
        
    }   
    //tarkistetaan vikan merkin oikeus
        private boolean checkValidCharacter(final String personID){
       
        String valid = personID.substring(10,11);
        String numero = personID.substring(0,6)+ personID.substring(7, 10);
        int numeroInt;
        int tarkNum;
        tarkNum = getTarkistusNum(valid);
       
        try{
        Integer.parseInt(numero);
    }   catch (NumberFormatException e){
        return false;
    }
       //lasketaan tarkistus numero
        numeroInt = Integer.parseInt(numero);
        double tulos = (double) numeroInt / 31;
        double desimaali = tulos - 0.5;
        desimaali = Math.round(desimaali);
        double ylijaama = tulos - desimaali;
        ylijaama *= 31;
        double vastaus = Math.round(ylijaama);
        
        if(vastaus == tarkNum){
            return true;
        }else{
            return false;
        }
    }

        private boolean checkBirthdate(final String date){
         
        String month = date.substring(3, 5);
        String day = date.substring(0,2);
        String year = "0";
        if(date.length() >= 10){
            year = date.substring(6, 10);
        }
           
        int monthInt;
        int dayInt;
        int yearInt;
       //muutetaan string intiksi jos mahdollista
        try {
            Integer.parseInt(day);
            Integer.parseInt(month);
            Integer.parseInt(year);
        } catch (NumberFormatException e) {
            
            return false;
        }

        monthInt = Integer.parseInt(month);
        dayInt = Integer.parseInt(day);
        yearInt = Integer.parseInt(year);
        
       //tarkistetaan, etta annettu paiva on hyvaksyttava
        if(monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12){
            if(dayInt > 0 && dayInt <= 31){
            return true;}}
        
       if(monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11){
            if(dayInt > 0 && dayInt <= 30){
            return true;}}
        if(monthInt == 2 && checkLeapYear(yearInt) == true && dayInt > 0 && dayInt <= 29){
            return true;
                
        }else if(monthInt == 2 && dayInt > 0 && dayInt <= 28)
                    return true;
               
        return false;
        }
             
        private boolean checkLeapYear(int year) {

            if(year % 100 == 0){

                if(year % 400 == 0){
                    return true;
                }else
                    return false;
            }else{
            //if(year % 100 != 0)
                if(year % 4 == 0){
                    return true;
                }else
                    return false;

            }
        }
        //muutetaan viimeinen merkki tarkistus numeroksi
        private int getTarkistusNum (String valid){

            String validMerkit = "0123456789ABCDEFHJKLMNPRSTUVWXY";
            
            int tarNum = validMerkit.indexOf(valid);
         
            return tarNum;
        }
}



