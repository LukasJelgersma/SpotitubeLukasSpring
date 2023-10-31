package dea.spotitube.spring.spotitubelukasspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan(basePackages = "dea.spotitube.spring.spotitubelukasspring")
public class SpotitubeLukasSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpotitubeLukasSpringApplication.class, args);
    }
}

