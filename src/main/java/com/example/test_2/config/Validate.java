package com.example.test_2.config;

public class Validate {
    public static void studentValidateDetails(String phone, String email, String gender){
        if(phone == null || !phone.matches("0\\d{9}")){//(84|0[3|5|7|8|9])+([0-9]{8})\b/g
            throw new RuntimeException("Invalid phone number. Please enter phone number must be 11 digits and start with 0.");
        }
        if(email == null || !email.endsWith("@gmail.com")){
            throw new RuntimeException("Invalid email. Please enter email must end with @gmail.com");
        }
        if(gender == null || (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))){
            throw new RuntimeException("Invalid gender. Please must be 'male' or 'female'.");
        }
    }

    public static void familyValidateDetails(String fatherphone, String motherphone){
        if(fatherphone == null || !fatherphone.matches("0\\d{9}")){//(84|0[3|5|7|8|9])+([0-9]{8})\b/g
            throw new RuntimeException("Invalid phone number. Please enter phone number must be 11 digits and start with 0.");
        }
        if(motherphone == null || !motherphone.matches("0\\d{9}")){//(84|0[3|5|7|8|9])+([0-9]{8})\b/g
            throw new RuntimeException("Invalid phone number. Please enter phone number must be 11 digits and start with 0.");
        }
    }

    public static void resultValidateDetails(Double score){
        if(score < 0 || score > 10){
            throw new RuntimeException("Invalid score. please enter 0<= score < 10");
        }
    }

    public static void tuitionValidateDetails(Double amount){
        if(amount < 0){
            throw new RuntimeException("Invalid amount. please enter amount > 0");
        }
    }

}
