package ProgramaBarbearia.GravadorDeDados;

import ProgramaBarbearia.Modelos.Barbeiro;
import ProgramaBarbearia.Modelos.Cliente;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {
    private static final String ARQUIVO_BARBEIRO = "BARBEIRO.dat";
    private static final String ARQUIVO_CLIENTE = "CLIENTE.dat";

    public HashMap<String, Barbeiro> recuperarbarbeiro() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_BARBEIRO))){
            return (HashMap<String, Barbeiro>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
    public HashMap<String, Cliente> recuperarCliente() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CLIENTE))){
            return (HashMap<String, Cliente>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public void salvarBarbeiros(HashMap<String,Barbeiro> Barbeiro) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BARBEIRO))){
            out.writeObject(Barbeiro);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
    public void salvaCliente(HashMap<String,Cliente> Cliente) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CLIENTE))){
            out.writeObject(Cliente);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
}
