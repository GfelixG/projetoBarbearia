package ProgramaBarbearia.Modelos;

import java.io.Serializable;

public class HorarioMarcado implements Serializable {

        private Cliente cliente;
        private Barbeiro barbeiro;
        private horariodata horario;
        private TipoDeCorte tipoDeCorte;

        public HorarioMarcado(Cliente cliente, Barbeiro barbeiro, horariodata horario, TipoDeCorte tipoDeCorte) {
            this.cliente = cliente;
            this.barbeiro = barbeiro;
            this.horario = horario;
            this.tipoDeCorte = tipoDeCorte;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public Barbeiro getBarbeiro() {
            return barbeiro;
        }

        public horariodata getHorario() {
            return horario;
        }

        public TipoDeCorte getTipoDeCorte() {
            return tipoDeCorte;
        }

        @Override
        public String toString() {
            return "Cliente:" + cliente.getNome() + ", Barbeiro: " + barbeiro.getNome() +
                    ", Horário: " + horario.getDateTime() + ", Tipo de Corte: " + tipoDeCorte;
        }

}
