package ProgramaBarbearia.Controladores;

import ProgramaBarbearia.Modelos.Barbeiro;
import ProgramaBarbearia.Modelos.TipoDeCorte;
import ProgramaBarbearia.Modelos.horariodata;

public interface Barbearia {

    boolean CadastrarCliente(String nome, String telefone);
    void CadastrarBarbeario(String Nome, horariodata HorarioLivre, TipoDeCorte Especialidade);
    Barbeiro PesquisarBarbeiro(TipoDeCorte especialidade);
}
