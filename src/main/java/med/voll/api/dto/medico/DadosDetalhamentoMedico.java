package med.voll.api.dto.medico;

import med.voll.api.dto.endereco.DadosEndereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, String telefone, DadosEndereco dadosEndereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getTelefone(), medico.getDadosendereco());
    }
}
