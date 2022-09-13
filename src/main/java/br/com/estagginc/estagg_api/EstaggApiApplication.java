package br.com.estagginc.estagg_api;

import br.com.estagginc.estagg_api.core.TestAPIConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@SpringBootApplication
@RestController
public class EstaggApiApplication {
    @GetMapping
    public ResponseEntity<?> testConnection(HttpServletRequest request) {
        return new ResponseEntity(
                new TestAPIConnection(new Date(), "Conexão estabelecida!", request.getRemoteAddr()),
                HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(EstaggApiApplication.class, args);
        System.out.println("API ONLINE!!!");
    }

}
