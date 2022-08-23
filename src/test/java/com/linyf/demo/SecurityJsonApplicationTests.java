package com.linyf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityJsonApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123"));
        //$2a$10$sWYuRJBdNoMCFyvqpWIi2.H/EIN1z7NaqyQ1cXDcTfd7DFpgOHvju
        boolean matches = encoder.matches("123", "$2a$10$sWYuRJBdNoMCFyvqpWIi2.H/EIN1z7NaqyQ1cXDcTfd7DFpgOHvju");
        System.out.println(matches);
    }

}
