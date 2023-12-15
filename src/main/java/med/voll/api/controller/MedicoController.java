package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosListagemMedico;
import med.voll.api.dto.medico.Medico;
import med.voll.api.dto.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //métodos que vão declarar as funcionalidades

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional //Transação ativa com o banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ //Para chamar o corpo da requisição - para receber cada um dos campos json separadamente - usar classe, dentro da classe declaramos o atributo com os mesmos nomes que vem do json
        repository.save(new Medico(dados));

    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();//toList para conventer para uma lista

    }
    
}
