package ProgramaBarbearia.Controladores;

import ProgramaBarbearia.Excecoes.HorarioNaoDisponivelException;
import ProgramaBarbearia.Modelos.Barbeiro;
import ProgramaBarbearia.Modelos.Cliente;
import ProgramaBarbearia.Modelos.TipoDeCorte;
import ProgramaBarbearia.Modelos.horariodata;

import java.io.IOException;
import java.util.Collection;

public interface Barbearia {

    boolean CadastrarCliente(String nome, String telefone);

    void CadastrarBarbeario(String Nome, horariodata HorarioLivre, TipoDeCorte Especialidade);

    boolean MarcaHorario(Cliente cliente, Barbeiro barbeiro, horariodata horario, TipoDeCorte corte) throws HorarioNaoDisponivelException;

    Barbeiro PesquisarBarbeiro(TipoDeCorte especialidade);

    Cliente PesquisarCliente(String telefone);

    Collection<horariodata> PesquisarHorariodisponiveisnodia(horariodata dia);

    boolean VerificaSetaAberta(int hora, int minuto);

    Collection<Barbeiro> VerificaEspecialidadeBarbeiro(Barbeiro barbeiro, String nome);

    void salvadaos() throws IOException;

    void gravardaos() throws IOException;
}
