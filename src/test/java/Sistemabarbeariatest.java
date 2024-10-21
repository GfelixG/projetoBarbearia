import ProgramaBarbearia.Controladores.SistemaBarbearia;
import ProgramaBarbearia.Excecoes.HorarioNaoDisponivelException;
import ProgramaBarbearia.Modelos.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Sistemabarbeariatest {

    private SistemaBarbearia sistemaBarbearia;
    private Cliente cliente1;
    private Cliente cliente2;
    @Test
    public void testPesquisarClientePorTelefone() {
        try {
            sistemaBarbearia = new SistemaBarbearia();
        cliente1 = new Cliente("Alex", "83986262773");
        cliente2 = new Cliente("Maria", "83986262888");
        sistemaBarbearia.CadastrarCliente("Alex", "83986262773");
        sistemaBarbearia.CadastrarCliente("Maria", "83986262888");

        Cliente resultado = sistemaBarbearia.PesquisarCliente("83986262773");
        assertEquals(cliente1, resultado, "Cliente não encontrado!");

        Cliente resultado2 = sistemaBarbearia.PesquisarCliente("83986262888");
        assertEquals(cliente2, resultado2, "Cliente não encontrado!");

        Cliente resultadoInexistente = sistemaBarbearia.PesquisarCliente("00000000000");
        assertNull(resultadoInexistente, "Cliente não deveria ser encontrado!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testCadastrarBarbeiro() {
        try {


        sistemaBarbearia = new SistemaBarbearia();
        LocalTime horario = LocalTime.of(14, 10 );
        TipoDeCorte especialidade = TipoDeCorte.DEGRADE;
        LocalDateTime data = LocalDateTime.of(2024, 10,21, 14,41);
        sistemaBarbearia.CadastrarBarbeario("Carlos", data , especialidade);
        Collection<Barbeiro> barbeiros = sistemaBarbearia.PesquisarBarbeiro(TipoDeCorte.DEGRADE);
        assertEquals(1, barbeiros.size() , "o barbeiro foi cadastrado ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testMarcaHorario() throws HorarioNaoDisponivelException {
        try {
            sistemaBarbearia = new SistemaBarbearia();
            Cliente cliente = new Cliente("Alex", "83986262773");
            LocalDateTime horario1 =LocalDateTime.of(2024, 10, 17, 14, 0);
            horariodata horario2 = new horariodata(LocalDateTime.of(2024,10, 21, 15, 24));
            TipoDeCorte especialidade = TipoDeCorte.DEGRADE;
            Barbeiro barbeiro = new Barbeiro("Carlos", horario1, especialidade);
            boolean resultado = sistemaBarbearia.MarcaHorario(cliente, barbeiro, horario2, especialidade);
            assertTrue(resultado, "Horário deveria ser marcado com sucesso!");
        }catch (HorarioNaoDisponivelException e){
            e.printStackTrace();
        }
    }
    @Test
    public void testCadastrarCliente() {
        try {
            sistemaBarbearia = new SistemaBarbearia();
            sistemaBarbearia.CadastrarCliente("Alex", "83986262773");
            Cliente clienteCadastrado = sistemaBarbearia.PesquisarCliente("83986262773");
            assertNotNull(clienteCadastrado, "Cliente não deveria ser nulo após cadastro!");
            assertEquals("Alex", clienteCadastrado.getNome(), "Nome do cliente não confere!");
            assertEquals("83986262773", clienteCadastrado.getTelefone(), "Telefone do cliente não confere!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testPesquisarBarbeiroPorEspecialidade() {
        try {
            sistemaBarbearia = new SistemaBarbearia();
            LocalDateTime horarioLivre1 = LocalDateTime.of(2024, 10, 17, 14, 0);
            LocalDateTime horarioLivre2 = LocalDateTime.of(2024, 10, 17, 15, 0);

            sistemaBarbearia.CadastrarBarbeario("Carlos", horarioLivre1, TipoDeCorte.DEGRADE);
            sistemaBarbearia.CadastrarBarbeario("João", horarioLivre2, TipoDeCorte.BARBA);

            Collection<Barbeiro> barbeirosDegrade = sistemaBarbearia.PesquisarBarbeiro(TipoDeCorte.DEGRADE);
            Collection<Barbeiro> barbeirosMoicano = sistemaBarbearia.PesquisarBarbeiro(TipoDeCorte.BARBA);

            assertEquals(1, barbeirosDegrade.size(), "Deveria haver 1 barbeiro com especialidade DEGRADÊ");
            assertEquals("Carlos", barbeirosDegrade.iterator().next().getNome(), "Nome do barbeiro não confere!");

            assertEquals(1, barbeirosMoicano.size(), "Deveria haver 1 barbeiro com especialidade MOICANO");
            assertEquals("João", barbeirosMoicano.iterator().next().getNome(), "Nome do barbeiro não confere!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
