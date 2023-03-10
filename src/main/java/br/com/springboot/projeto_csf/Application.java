package br.com.springboot.projeto_csf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 * Spring Boot application starter class
 */

@EntityScan(basePackages = "br.com.springboot.projeto_csf.model" )
@SpringBootApplication
public class Application { 
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); /*Linha principal que roda o projeto Java SpringBoot*/
    }
}
