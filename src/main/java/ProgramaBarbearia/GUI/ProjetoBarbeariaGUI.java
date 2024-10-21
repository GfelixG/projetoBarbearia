package ProgramaBarbearia.GUI;

import ProgramaBarbearia.Controladores.SistemaBarbearia;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.EnumSet;

public class ProjetoBarbeariaGUI {
    private JFrame janela = new JFrame("Barbearia");
    private SistemaBarbearia sistema;

    public ProjetoBarbeariaGUI(){
        this.sistema = new SistemaBarbearia();

        createDialog();
        //createMenuBar();
        //createLayout();
    }

    public void createDialog(){
        JLabel espaco1, espaco2;
        JTextField espaco3;

        ImageIcon LogoImg = new ImageIcon("./imgs/LOGO.png");

        espaco1 = new JLabel(LogoImg, JLabel.CENTER);

        espaco2 = new JLabel("Digite seu numero de telefone:  (99) 9.9999-9999", JLabel.LEADING);
        espaco2.setForeground(Color.WHITE);
        espaco2.setFont(new Font("Serif", Font.BOLD, 20));

        espaco3 = new JTextField("");

        janela.setSize(1200, 800);
        janela.setResizable(false);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.getContentPane().setLayout(new GridLayout(3,3));
        janela.getContentPane().add(espaco1);
        janela.getContentPane().add(espaco2);
        janela.getContentPane().add(espaco3, BorderLayout.LINE_END);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b){
        janela.setVisible(b);
    }

}
