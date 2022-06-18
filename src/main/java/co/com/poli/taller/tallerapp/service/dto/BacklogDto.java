package co.com.poli.taller.tallerapp.service.dto;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class BacklogDto {

    @NotBlank
    private String projectIdentifier;

    private Project project;

    private List<ProjectTask> projectTasks;
}
