package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.Endereco;

public record DadosCadastroMedico(

    @NotBlank(message = "Nome é obrigatório") //Verifica se não está vazio, nem nulo
    String nome, 

    @NotBlank @Email //Valida email
    String email, 

    @NotBlank
    String telefone,

    @NotBlank @Pattern(regexp = "\\d{4,6}") //crm de 4 a 6 digitos
    String crm, 

    @NotNull
    Especialidade especialidade, 

    @NotNull @Valid Endereco endereco) { //valida também oq está dentro

}
