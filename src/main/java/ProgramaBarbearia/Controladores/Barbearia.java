package ProgramaBarbearia.Controladores;

import ProgramaBarbearia.Excecoes.HorarioNaoDisponivelException;
import ProgramaBarbearia.Modelos.Barbeiro;
import ProgramaBarbearia.Modelos.Cliente;
import ProgramaBarbearia.Modelos.TipoDeCorte;
import ProgramaBarbearia.Modelos.horariodata;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

public interface Barbearia {
    boolean CadastrarCliente(String nome, String telefone);

    void CadastrarBarbeario(String Nome, LocalDateTime HorarioLivre, TipoDeCorte Especialidade);

    boolean MarcaHorario(Cliente cliente, Barbeiro barbeiro, horariodata horario, TipoDeCorte corte) throws HorarioNaoDisponivelException;

    Collection<Barbeiro> PesquisarBarbeiro(TipoDeCorte especialidade);

    Cliente PesquisarCliente(String telefone);

    Collection<horariodata> PesquisarHorariodisponiveisnodia(horariodata dia);

    boolean VerificaSetaAberta(int hora, int minuto);

    Collection<Barbeiro> VerificaEspecialidadeBarbeiro(TipoDeCorte especialidade);

    void salvadaos() throws IOException;

    void gravardaos() throws IOException;
}
