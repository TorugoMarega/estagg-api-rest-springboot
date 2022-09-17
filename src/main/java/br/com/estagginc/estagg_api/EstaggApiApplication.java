package br.com.estagginc.estagg_api;

import br.com.estagginc.estagg_api.core.TestAPIConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class EstaggApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstaggApiApplication.class, args);
        System.out.println("CONEXÃO ESTABELECIDA!!!");
    }

    @GetMapping("/api")
    public ResponseEntity<?> testConnection(HttpServletRequest request) {
        return new ResponseEntity<>(
                new TestAPIConnection(request.getRemoteAddr()),
                HttpStatus.OK);
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
