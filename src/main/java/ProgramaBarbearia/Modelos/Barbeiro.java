package ProgramaBarbearia.Modelos;

public class Barbeiro {
    private String Nome;
    private Horario HorarioLivre;
    private TipoDeCorte Especialidade;

    public Barbeiro(String nome, Horario horarioLivre, TipoDeCorte especialidade) {
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

    public Horario getHorarioLivre() {
        return HorarioLivre;
    }

    public void setHorarioLivre(Horario horarioLivre) {
        HorarioLivre = horarioLivre;
    }

    public TipoDeCorte getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(TipoDeCorte especialidade) {
        Especialidade = especialidade;
    }
}
