package Api.build.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// @getter
// @setter
// @NoArgConstructor
// @AllArgsConstructor
@Embeddable
public class Punches {
   
    public Punches() {
    }
    public Punches(LocalDateTime inpunch, LocalDateTime outpunch) {
        Inpunch = inpunch;
        Outpunch = outpunch;
    }
    public LocalDateTime getInpunch() {
        return Inpunch;
    }
    public void setInpunch(LocalDateTime inpunch) {
        Inpunch = inpunch;
    }
    public LocalDateTime getOutpunch() {
        return Outpunch;
    }
    public void setOutpunch(LocalDateTime outpunch) {
        Outpunch = outpunch;
    }
    private LocalDateTime Inpunch;
    private LocalDateTime Outpunch;
}
