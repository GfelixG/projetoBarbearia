package Modelos;

public class Barbeiro {
    private String Nome;
    private Horario HorarioLivre;
    private DiaDaSemana DiaLivre;
    private TipoDeCorte Especialidade;

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

    public DiaDaSemana getDiaLivre() {
        return DiaLivre;
    }

    public void setDiaLivre(DiaDaSemana diaLivre) {
        DiaLivre = diaLivre;
    }

    public TipoDeCorte getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(TipoDeCorte especialidade) {
        Especialidade = especialidade;
    }
}
