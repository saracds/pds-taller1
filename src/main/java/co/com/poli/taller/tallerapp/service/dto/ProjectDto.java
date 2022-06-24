package co.com.poli.taller.tallerapp.service.dto;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ProjectDto {

    @NotBlank
    private String projectName;

    @NotBlank
    @Size(min = 5, max = 7, message = "El identificador del proyecto debe tener entre 5 y 7 caracteres")
    private String ProjectIdentifier;

    @NotBlank
    private String description;

    private LocalDateTime startDate;

    private Backlog backlog;

}
