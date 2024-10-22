package ProgramaBarbearia.Controladores;

import ProgramaBarbearia.Excecoes.HorarioNaoDisponivelException;
import ProgramaBarbearia.GravadorDeDados.GravadorDeDados;
import ProgramaBarbearia.Modelos.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SistemaBarbearia implements Barbearia{
    private HashMap<String, Barbeiro> barbeiros;
    private HashMap<String, Cliente> cliente;
    private final HashMap<String, HorarioMarcado> horario;
    private GravadorDeDados gravador;

    public SistemaBarbearia(){
        this.barbeiros = new HashMap<>();
        this.cliente = new HashMap<>();
        this.horario = new HashMap<>();
        this.gravador = new GravadorDeDados();

    }

    /**
     * cadastra o cliente com base nas informacoes passada no paramentro e adcionar em no hashmap de cliente
     * @param nome
     * @param telefone
     * @return bollean
     */
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

    /**
     * @param Nome
     * @param HorarioLivre
     * @param Especialidade
     * @return
     */
    @Override
    public boolean CadastrarBarbeario(String Nome, LocalDateTime HorarioLivre, TipoDeCorte Especialidade){
        if(this.cliente.containsKey(Nome)){
            return false;
        } else {
            Barbeiro b = new Barbeiro(Nome, HorarioLivre, Especialidade);
            this.barbeiros.put(Nome, b);
            return true;
        }
    }

    /**
     *
     * @param cliente
     * @param barbeiro
     * @param horario
     * @param corte
     * @return
     * @throws HorarioNaoDisponivelException
     */
    @Override
    public boolean MarcaHorario(Cliente cliente, Barbeiro barbeiro, horariodata horario, TipoDeCorte corte) throws HorarioNaoDisponivelException {
            if(this.horario.containsKey(horario)){
                throw new HorarioNaoDisponivelException("horario ja marcado");
            }else{
                HorarioMarcado NovoHorario = new HorarioMarcado(cliente, barbeiro, horario, corte);
                this.horario.put(cliente.getTelefone(), NovoHorario);
                return true;
            }
    }

    /**
     * @param especialidade
     * @return
     */
    @Override
    public Collection<Barbeiro> PesquisarBarbeiro(TipoDeCorte especialidade){
        Collection<Barbeiro> barbeiros = new ArrayList<>();
        for(Barbeiro b : this.barbeiros.values()){
            if(b.getEspecialidade().equals(especialidade)){
                barbeiros.add(b);
            }
        }return barbeiros;

    }

    /**
     *
     * @param telefone
     * @return
     */
    @Override
    public Cliente PesquisarCliente(String telefone) {
        for (Cliente c : this.cliente.values()) {
            if(c.getTelefone().equals(telefone)){
                return c;
            }
        }return null;
    }

    /**
     *
     * @param dia
     * @return
     */
    @Override
    public Collection<horariodata> PesquisarHorariodisponiveisnodia(horariodata dia){
        Collection<horariodata> horariosDisponiveis = new ArrayList<>();
        LocalTime horaAbertura = LocalTime.of(7, 0);
        LocalTime horaFechamento = LocalTime.of(19, 0);
        for (int hora = horaAbertura.getHour(); hora <= horaFechamento.getHour(); hora++) {
            LocalDateTime horarioPossivel = LocalDateTime.of(dia.toLocalDate(), LocalTime.of(hora, 0));
            boolean estaDisponivel = true;
            for (HorarioMarcado m : this.horario.values()) {
                if (m.getHorario().getDateTime().equals(horarioPossivel)) {
                    estaDisponivel = false;
                    break;
                }
            }if (estaDisponivel) {
                horariosDisponiveis.add(new horariodata(horarioPossivel));
            }
        }

        return null;
    }

    /**
     *
     * @param hora
     * @param minuto
     * @return
     */
    @Override
    public boolean VerificaSetaAberta(int hora, int minuto) {
        BarbeariaBrasil brasil = new BarbeariaBrasil(LocalTime.of(8,00), LocalTime.of(19,00));
        return brasil.estaAberta(LocalDateTime.now());
    }

    /**
     * verifica a especilide passada como parametro e percorrer o hashmap analisando  a especialidade
     * e adcionando em um collection
     * @param especialidade
     * @return Collection de barbeiros
     */
    @Override
    public Collection<Barbeiro> VerificaEspecialidadeBarbeiro(TipoDeCorte especialidade){
        Collection<Barbeiro> barbeirosespecialidade = new ArrayList<>();
        for(Barbeiro b : this.barbeiros.values()){
            if(b.getEspecialidade().equals(especialidade)){
                barbeirosespecialidade.add(b);
            }
        } return barbeirosespecialidade;
    }

    /**
     *gravar o dados do sistema
     * @throws IOException
     */
    @Override
    public void salvadaos() throws IOException {
        this.gravador.salvarBarbeiros(this.barbeiros);
        this.gravador.salvaCliente(this.cliente);
    }

    /**
     *recuperar o dados que foi salvo na ARQUIVOS_BARBEIROS e ARQUIVOS_CLIENTE
     * @throws IOException
     */
    @Override
    public void gravardaos() throws IOException {
        this.barbeiros= this.gravador.recuperarbarbeiro();
        this.cliente= this.gravador.recuperarCliente();

    }

}
