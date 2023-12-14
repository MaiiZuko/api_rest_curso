package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.medico.DadosCadastroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //métodos que vão declarar as funcionalidades

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ //Para chamar o corpo da requisição - para receber cada um dos campos json separadamente - usar classe, dentro da classe declaramos o atributo com os mesmos nomes que vem do json
        System.out.println(dados);

    }
    
}
