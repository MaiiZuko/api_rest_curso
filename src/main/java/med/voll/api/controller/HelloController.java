package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //anotação usada para api rest
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping //Requisição do tipo get
    public String olaMundo(){
        return "Hello World!";
    }
}
