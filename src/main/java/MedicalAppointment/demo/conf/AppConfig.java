package MedicalAppointment.demo.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {

    @Bean(name = "sc")
    public Scanner scanner (){ return new Scanner(System.in); }

    @Bean(name = "sc2")
    public Scanner scanner2 (){ return new Scanner(System.in); }
}
