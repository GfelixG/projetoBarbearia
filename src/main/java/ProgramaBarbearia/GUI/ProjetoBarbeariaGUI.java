package ProgramaBarbearia.GUI;

import ProgramaBarbearia.Barbearia;
import ProgramaBarbearia.Controladores.SistemaBarbearia;
import ProgramaBarbearia.Excecoes.HorarioNaoDisponivelException;
import ProgramaBarbearia.Modelos.*;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProjetoBarbeariaGUI {
    private JFrame janela = new JFrame("Barbearia");
    private SistemaBarbearia sistema = new SistemaBarbearia();

    public ProjetoBarbeariaGUI(){
        this.sistema = new SistemaBarbearia();
        try {
            sistema.gravardaos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            createDialog();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createMenuBar();
        //createLayout();
    }

    public void createDialog() throws IOException {
        JLabel espaco1;
        JButton espaco2;

        ImageIcon LogoImg = new ImageIcon("./imgs/LOGO.png");
        ImageIcon botao = new ImageIcon("./imgs/botao.png");


        espaco1 = new JLabel(LogoImg);
        espaco2 = new JButton(botao);
        espaco2.addActionListener(a -> {
            try {
                AgendarHorario();
            } catch (HorarioNaoDisponivelException e) {
                throw new RuntimeException(e);
            }
        });

        janela.setSize(800, 600);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.getContentPane().setLayout(new GridLayout(2,2));
        janela.getContentPane().add(espaco1);
        janela.getContentPane().add(espaco2);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b){
        janela.setVisible(b);
    }

    public void createMenuBar(){
        JMenuBar BarraDeMenu;

        JMenu Arquivo;
        JMenuItem Sair;

        JMenu Agendar;
        JMenuItem AgendarHorario;

        JMenu Cadastrar;
        JMenuItem CadastrarBarbeiro;
        JMenuItem CadastrarCliente;

        JMenu Pesquisas;
        JMenuItem MeusHorarios;
        JMenuItem Barbeiros;
        JMenuItem Clientes;

        BarraDeMenu = new JMenuBar();

        Arquivo = new JMenu("Arquivo");
        Sair = new JMenuItem("Sair");
        Sair.addActionListener(a -> {
            try {
                btn_sair();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }) ;
        Arquivo.add(Sair);

        Agendar = new JMenu("Agendar");
        AgendarHorario = new JMenuItem("Agendar Horário");
        AgendarHorario.addActionListener(a -> {
            try {
                AgendarHorario();
            } catch (HorarioNaoDisponivelException e) {
                throw new RuntimeException(e);
            }
        });
        Agendar.add(AgendarHorario);

        Cadastrar = new JMenu("Cadastrar");
        CadastrarCliente = new JMenuItem("Cliente");
        CadastrarCliente.addActionListener(a -> cadastrarCliente());
        CadastrarBarbeiro = new JMenuItem("Barbeiro");
        CadastrarBarbeiro.addActionListener(a -> cadastrarBarbeiro());
        Cadastrar.add(CadastrarBarbeiro);
        Cadastrar.add(CadastrarCliente);

        Pesquisas = new JMenu("Pesquisas");
        MeusHorarios = new JMenuItem("Meus Horários");
        MeusHorarios.addActionListener(a -> pesquisaHorario());
        Clientes = new JMenuItem("Cliente");
        Clientes.addActionListener(a -> pesquisaCliente());
        Barbeiros = new JMenuItem("Barbeiro");
        Barbeiros.addActionListener(a -> pesquisaBarbeiro());
        Pesquisas.add(MeusHorarios);
        Pesquisas.add(Clientes);
        Pesquisas.add(Barbeiros);

        BarraDeMenu.add(Arquivo);
        BarraDeMenu.add(Cadastrar);
        BarraDeMenu.add(Agendar);
        BarraDeMenu.add(Pesquisas);

        janela.setJMenuBar(BarraDeMenu);
    }


    //===============EVENTS==============//

    private void btn_sair() throws IOException {
        sistema.salvadaos();
        System.exit(0);
    }

    private void cadastrarCliente(){
        try {
            String nomeC = showInputDialog("Digite seu nome:");
            String telefone = showInputDialog("Digite seu telefone:");
            if (sistema.CadastrarCliente(nomeC, telefone)){
                JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO!");
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE JÁ EXISTE!");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void cadastrarBarbeiro(){
        try {
            String nomeB = showInputDialog("Digite seu nome:");
            LocalDateTime horario = LocalDateTime.of(2024, 10, 21, 22, 16);
            String especialidadeString = showInputDialog("Qual a sua especialidade:").toUpperCase();
            TipoDeCorte especialidade = TipoDeCorte.valueOf(especialidadeString);
            if(sistema.CadastrarBarbeario(nomeB, horario, especialidade)){
                JOptionPane.showMessageDialog(null, "BARBEIRO CADASTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "NÃO DEU CERTO!");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "especialidade não existe!");
            ex.printStackTrace();
        }
    }

    private void pesquisaCliente(){
        try {
            String cliente1 = showInputDialog("Digite o telefone do cliente:");
            Cliente c1 = sistema.PesquisarCliente(cliente1);
            JOptionPane.showMessageDialog(null, "O CLIENTE PESQUISADO FOi\n" + c1);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void pesquisaBarbeiro(){
        try {
            String especialidadeString = showInputDialog("Qual a sua especialidade:").toUpperCase();
            TipoDeCorte especialidade2 = TipoDeCorte.valueOf(especialidadeString);
            Collection<Barbeiro> barbeiros = sistema.PesquisarBarbeiro(especialidade2);
            JOptionPane.showMessageDialog(null, "os barbeiros sao\n" + barbeiros);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void pesquisaHorario(){
        try {
            String hora  = JOptionPane.showInputDialog(null, "qual a hora que voce vai pesquisar");
            horariodata dia = new horariodata(LocalDateTime.now());
            Collection<horariodata> horario = sistema.PesquisarHorariodisponiveisnodia(dia);
            JOptionPane.showMessageDialog(null,"os horairos disponiveis sao\n" + horario);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void AgendarHorario() throws HorarioNaoDisponivelException {
                try {
                    String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
                    String EspecialidadeString = JOptionPane.showInputDialog("Digite o especialidade do barbeiro:").toUpperCase();
                    int horario = Integer.parseInt(JOptionPane.showInputDialog("Digite a hora qu você quer marcar:   12 horas -> 12"));

                    TipoDeCorte t = TipoDeCorte.valueOf(EspecialidadeString);

                    Cliente c = sistema.PesquisarCliente(telefone);
                    ArrayList<Barbeiro> b = sistema.PesquisarBarbeiro(t);
                    LocalDateTime l = LocalDateTime.of(2024, 10, 22, horario, 0);
                    horariodata h = new horariodata(l);

                    if(sistema.MarcaHorario(c, b.get(0), h, t)){
                        JOptionPane.showMessageDialog(null, String.format("""
                        Horário Marcado com Sucesso!!!
                        Hora: %d horas
                        Barbeiro: %s
                        Tipo de corte: %s
                        Valor: R$50,00""", 10, b.get(0).getNome(), t));
                    } else {
                        JOptionPane.showMessageDialog(null, "Horário não marcado. Tente novamente");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Horário não marcado. Tente novamente");
                    throw new HorarioNaoDisponivelException("Horário já preenchido");
                };
    }
}
