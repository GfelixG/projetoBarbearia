package ProgramaBarbearia.Modelos;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BarbeariaBrasil {
    private final LocalTime horaAbertura;
    private final LocalTime horaFechamento;

    public BarbeariaBrasil(LocalTime horaAbertura, LocalTime horaFechamento) {
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    public boolean estaAberta(LocalDateTime dataHoraAtual) {
        DayOfWeek diaDaSemana = dataHoraAtual.getDayOfWeek();
        LocalTime horaAtual = dataHoraAtual.toLocalTime();

        // Verifica se está aberta de segunda a sábado, das 07:00 às 18:00
        if((diaDaSemana != DayOfWeek.SUNDAY) && horaAtual.isAfter(horaAbertura) && horaAtual.isBefore(horaFechamento)) {
            return true;
        }
        return false;
    }

}

