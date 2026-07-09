package main.java.Api.build.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@getter
@setter
@NoArgConstructor
@AllArgsConstructor
@Embeddable
public class Punches {
   
    private LocalDateTime Inpunch;
    private LocalDateTime Outpunch;
}
