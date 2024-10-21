package ProgramaBarbearia.Modelos;



import java.time.LocalDate;
import java.time.LocalDateTime;

public class horariodata {
    private LocalDateTime dateTime;

    public horariodata(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

}
