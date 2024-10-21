package ProgramaBarbearia.Modelos;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String numero) {
        this.telefone = numero;
    }

    @Override
    public String toString() {
        return "Cliente:" + nome + "telefone:" + telefone;
    }
}
