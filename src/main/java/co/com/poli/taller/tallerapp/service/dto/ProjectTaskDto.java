package co.com.poli.taller.tallerapp.service.dto;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
public class ProjectTaskDto {

    @NotBlank
    private String name;

    @NotBlank
    private String summary;

    @NotBlank
    private String acceptanceCriteria;

    @Range(min=1, max=5, message = "Debe tener un rango de 1 a 5")
    private int priority;

    @Positive(message = "Las horas deben ser mayor a cero")
    @Range(min = 1, max = 8, message = "Las horas deben estar en un rango de 1 a 8")
    private double hours;

    private LocalDateTime startDate;

    private String ProjectIdentifier;

    private Backlog backlog;

}
