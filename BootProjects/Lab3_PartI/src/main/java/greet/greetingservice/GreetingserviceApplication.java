package greet.greetingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GreetingserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Started ... !");
    }
}