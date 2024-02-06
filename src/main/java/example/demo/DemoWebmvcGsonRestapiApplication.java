package example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "example")
public class DemoWebmvcGsonRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebmvcGsonRestapiApplication.class, args);
    }

}
