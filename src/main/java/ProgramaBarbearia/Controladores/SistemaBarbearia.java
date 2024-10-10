package ProgramaBarbearia.Controladores;

import ProgramaBarbearia.Modelos.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SistemaBarbearia implements Barbearia{
    private HashMap<String, Barbeiro> barbeiros;
    private HashMap<String, Cliente> cliente;
    private HashMap<String, Horario> horario;

    public SistemaBarbearia(){
        this.barbeiros = new HashMap<>();
        this.cliente = new HashMap<>();
        this.horario = new HashMap<>();

    }
    @Override
    public boolean CadastrarCliente(String nome, String telefone){
        if(this.cliente.containsKey(telefone)){
            return false;
        }else {
            Cliente c = new Cliente(nome, telefone);
            this.cliente.put(telefone, c);
            return true;
        }

    }
    @Override
    public void CadastrarBarbeario(String Nome, Horario HorarioLivre, TipoDeCorte Especialidade){
            Barbeiro b = new Barbeiro(Nome, HorarioLivre, Especialidade);
            this.barbeiros.put(Nome, b);
    }




    public boolean MarcaHorario(Cliente cliente, Barbeiro barbeiro, Horario horario, TipoDeCorte corte){
        return false;

    }

    @Override
    public Barbeiro PesquisarBarbeiro(TipoDeCorte especialidade){
        for(Barbeiro b : this.barbeiros.values()){
            if(b.getEspecialidade().equals(especialidade)){
                return b;
            }
        }return null;

    }

    public Cliente PesquisarCliente(String telefone) {
        for (Cliente c : this.cliente.values()) {
            if(c.getNumero().equals(telefone)){
                return c;
            }
        }return null;
    }
    public Collection PesquisarHorariodisponiveisnodia(DiaDaSemana dia){
        for(Horario h : this.horario.values()){

        }
        return null;
    }
    public boolean VerificaSetaAberta(){
        return false;
    }

    public Collection<Barbeiro> VerificaEspecialidadeBarbeiro(Barbeiro barbeiro,String nome){
        Collection<Barbeiro> barbeirosespecialidade = new ArrayList<>();
        for(Barbeiro b : this.barbeiros.values()){
            if(b.getNome().equals(nome)){
                barbeirosespecialidade.add(b);
                }
            } return barbeirosespecialidade;
        }



    public void salvadaos(){

    }

    public void gravardaos(){

    }

}
