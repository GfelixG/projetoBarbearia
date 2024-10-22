package ProgramaBarbearia.GUI;

import ProgramaBarbearia.Barbearia;
import ProgramaBarbearia.Controladores.SistemaBarbearia;
import ProgramaBarbearia.Modelos.*;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProjetoBarbeariaGUI {
    private JFrame janela = new JFrame("Barbearia");
    private SistemaBarbearia sistema = new SistemaBarbearia();

    public ProjetoBarbeariaGUI(){
        this.sistema = new SistemaBarbearia();

        createDialog();
        createMenuBar();
        //createLayout();
    }

    public void createDialog(){
        JLabel espaco1;
        JButton espaco2;

        ImageIcon LogoImg = new ImageIcon("./imgs/LOGO.png");

        espaco1 = new JLabel(LogoImg);
        espaco2 = new JButton("Agendar");

        janela.setSize(800, 600);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.getContentPane().setLayout(new GridLayout(2,2));
        janela.getContentPane().add(espaco1);

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
        Sair.addActionListener(a -> btn_sair()) ;
        Arquivo.add(Sair);

        Agendar = new JMenu("Agendar");
        AgendarHorario = new JMenuItem("Agendar Horário");
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

    private void btn_sair(){
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
        } catch (java.lang.IllegalArgumentException ex){
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
            JOptionPane.showMessageDialog(null,"os horairos disponiveis sao " + horario);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void AgendarHorario(){

    }
}
