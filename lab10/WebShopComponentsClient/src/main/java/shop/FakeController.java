package shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {

    @GetMapping("/health")
    public String health() {
        return "Alive and Awesome !!";
    }
}
