import ProgramaBarbearia.Controladores.SistemaBarbearia;
import ProgramaBarbearia.Modelos.Barbeiro;
import ProgramaBarbearia.Modelos.Cliente;
import ProgramaBarbearia.Modelos.TipoDeCorte;
import ProgramaBarbearia.Modelos.horariodata;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
public class SIstemaBarbeariaTest {

    private SistemaBarbearia sistemaBarbearia;
    private Cliente cliente1;
    private Cliente cliente2;
    @Test
    public void testPesquisarClientePorTelefone() {
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
    }
    @Test
    public void testCadastrarBarbeiro() {
        sistemaBarbearia = new SistemaBarbearia();
        LocalTime horario = LocalTime.of(14, 10 );
        TipoDeCorte especialidade = TipoDeCorte.DEGRADE;

        sistemaBarbearia.CadastrarBarbeario("Carlos", horariodata, especialidade);
        Barbeiro barbeiroCadastrado = sistemaBarbearia.PesquisarBarbeiro(TipoDeCorte.DEGRADE);

        assertNotNull(barbeiroCadastrado, "Barbeiro não deveria ser nulo após cadastro!");
        assertEquals("Carlos", barbeiroCadastrado.getNome(), "Nome do barbeiro não confere!");
        assertEquals(especialidade, barbeiroCadastrado.getEspecialidade() , "Especialidade do barbeiro não confere!");
    }




}
