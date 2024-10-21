package ProgramaBarbearia.Modelos;

import java.io.Serializable;


public class Barbeiro implements Serializable {
    private String Nome;
    private horariodata HorarioLivre;
    private TipoDeCorte Especialidade;

    public Barbeiro(String nome, horariodata horarioLivre, TipoDeCorte especialidade) {
        Nome = nome;
        HorarioLivre = horarioLivre;
        Especialidade = especialidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public horariodata getHorarioLivre() {
        return HorarioLivre;
    }

    public void setHorarioLivre(horariodata horarioLivre) {
        HorarioLivre = horarioLivre;
    }

    public TipoDeCorte getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(TipoDeCorte especialidade) {
        Especialidade = especialidade;
    }

    public String getTipoDeCorte() {
        return Especialidade.toString();
    }
}
