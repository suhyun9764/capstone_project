package Group2.capstone_project.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class testApp {


    public static void main(String[] args) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String test = "asdf9764";
        String eTest = passwordEncoder.encode(test);

        System.out.println("encoding pwd:"+eTest);
    }
}
