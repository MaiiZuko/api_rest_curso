package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.Endereco;

public record DadosAtualizacaoMedico(
    
    @NotNull
    Long id, 

    String telefone, 
    
    Endereco endereco, 
    
    String nome) {

}
