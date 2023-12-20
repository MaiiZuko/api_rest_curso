package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.medico.DadosAtualizacaoMedico;
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

    @GetMapping //carrega apenas 10 registros e ordena pelo nome
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) { //agora podemos controlar por exemplo: http://localhost:8080/medicos?size=1 - mostra só um médico na lista - http://localhost:8080/medicos?size=1&page=2 vai trocando a pagina
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);// Fazendo em paginação

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        //para atualizar no banco de dados
        var medico = repository.getReferenceById(dados.id()); //id ta dentro do nosso dto
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
    
}
