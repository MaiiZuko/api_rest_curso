package med.voll.api.dto.medico;

import med.voll.api.dto.endereco.Endereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

}
