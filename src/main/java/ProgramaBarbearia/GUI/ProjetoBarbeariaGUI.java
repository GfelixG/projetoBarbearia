package ProgramaBarbearia.GUI;

import ProgramaBarbearia.Controladores.SistemaBarbearia;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.EnumSet;

public class ProjetoBarbeariaGUI {
    private JFrame janela = new JFrame("Barbearia");
    private SistemaBarbearia sistema;

    public ProjetoBarbeariaGUI() {
        this.sistema = new SistemaBarbearia();

        createDialog();
        createMenuBar();
        //createLayout();
    }

    public void createDialog() {
        JLabel espaco1, espaco2;
        JTextField espaco3;

        ImageIcon LogoImg = new ImageIcon("./imgs/LOGO.png");

        espaco1 = new JLabel(LogoImg, JLabel.CENTER);

        espaco2 = new JLabel("Digite seu numero de telefone:  (99) 9.9999-9999", JLabel.LEADING);
        espaco2.setForeground(Color.WHITE);
        espaco2.setFont(new Font("Serif", Font.BOLD, 20));

        espaco3 = new JTextField("");

        janela.setSize(800, 600);
        janela.setResizable(false);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.getContentPane().setLayout(new GridLayout(3, 3));
        janela.getContentPane().add(espaco1);
        janela.getContentPane().add(espaco2);
        janela.getContentPane().add(espaco3, BorderLayout.LINE_END);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        janela.setVisible(b);
    }

    private void customizeMenuBar(JMenuBar menuBar) {

        menuBar.setUI(new BasicMenuBarUI() {

            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(Color.black);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }

        });

        MenuElement[] menus = menuBar.getSubElements();

        for (MenuElement menuElement : menus) {

            JMenu menu = (JMenu) menuElement.getComponent();
            changeComponentColors(menu);
            menu.setOpaque(true);

            MenuElement[] menuElements = menu.getSubElements();

            for (MenuElement popupMenuElement : menuElements) {

                JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
                popupMenu.setBorder(null);

                MenuElement[] menuItens = popupMenuElement.getSubElements();

                for (MenuElement menuItemElement : menuItens) {

                    JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                    changeComponentColors(menuItem);
                    menuItem.setOpaque(true);

                }
            }
        }
    }

    private void changeComponentColors(Component comp) {
        comp.setBackground(Color.black);
        comp.setForeground(Color.white);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();

        menuArquivo = new JMenu("Arquivo");
        menuArquivoSair = new JMenuItem("Sair");
        //menuArquivoSair.addActionListener(a -> btnSair_Click());
        menuArquivo.add(menuArquivoSair);

        menuCliente = new JMenu("Cliente");
        menuCadastrarCliente = new JMenuItem("Cadastrar");
        //menuCadastrarCliente.addActionListener(a -> cadastrarCliente());
        menuBuscarCliente = new JMenuItem("Buscar");
        //menuBuscarCliente.addActionListener(a -> PesquisaCliente());
        //menuApagarCliente.addActionListener(a -> apagarCliente());

        //menuCliente.add(menuCadastrarCliente);
        //menuCliente.add(menuBuscarCliente);
        //menuCliente.add(menuApagarCliente);

        menuAgendar = new JMenu("Agendar");
        menuAgendarMarcarHorario = new JMenuItem("Marcar Horário");
        //menuAgendarMarcarHorario.addActionListener(a -> btnAgendar_Click());
        menuAgendarDesmarcar = new JMenuItem("Desmarcar Horário");
        menuAgendar.add(menuAgendarMarcarHorario);
        menuAgendar.add(menuAgendarDesmarcar);

        menuBar.add(menuArquivo);
        menuBar.add(menuAgendar);

        janela.setJMenuBar(menuBar);
        customizeMenuBar(menuBar);
    }

    //==================================================================================================================
    //=============COMPONENTES======================================================================================================
    //==================================================================================================================
    private JMenuBar menuBar;

    private JMenu menuArquivo;
    private JMenuItem menuArquivoSair;
    private JMenu menuCliente;
    private JMenuItem menuCadastrarCliente;
    private JMenuItem menuBuscarCliente;
    private JMenuItem menuApagarCliente;

    private JMenu menuAgendar;
    private JMenuItem menuAgendarMarcarHorario;
    private JMenuItem menuAgendarDesmarcar;
}