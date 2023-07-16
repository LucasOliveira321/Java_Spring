package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var paciente = repository.findAllByAtivoTrueById(dados.idPaciente());
        if (!paciente){
            throw new ValidacaoException("Paciente não está ativo ou não foi cadastrado!");
        }
    }
}
