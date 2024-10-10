package ProgramaBarbearia.Modelos;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String numero) {
        this.nome = nome;
        this.telefone = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return telefone;
    }

    public void setNumero(String numero) {
        this.telefone = numero;
    }

}
