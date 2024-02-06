package example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "example")
@ConfigurationPropertiesScan(basePackages = "example")
public class DemoWebmvcGsonRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebmvcGsonRestapiApplication.class, args);
    }

}
