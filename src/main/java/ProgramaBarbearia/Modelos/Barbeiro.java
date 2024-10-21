package ProgramaBarbearia.Modelos;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Barbeiro implements Serializable {
    private String Nome;
    private LocalDateTime HorarioLivre;
    private TipoDeCorte Especialidade;

    public Barbeiro(String nome, LocalDateTime horarioLivre, TipoDeCorte especialidade) {
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

    public LocalDateTime getHorarioLivre() {
        return HorarioLivre;
    }

    public void setHorarioLivre(LocalDateTime horarioLivre) {
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
