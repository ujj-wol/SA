package greet.greetingservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting/{message}")
    public ResponseEntity<?> getGreeting(@PathVariable String message) {
        Greeting greeting = new Greeting("");
        greeting.setContent("Hello World " + message);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}
