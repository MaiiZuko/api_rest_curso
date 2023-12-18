package med.voll.api.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.endereco.Endereco;

public record DadosAtualizacaoMedico(
    
    @NotNull
    Long id, 

    String telefone, 
    
    Endereco endereco, 
    
    String nome) {

}
