package co.com.poli.taller.tallerapp.mapper;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectMapper implements IMapper <ProjectDto, Project> {

    @Override
    public Project map(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setProjectIdentifier(projectDto.getProjectIdentifier());
        project.setDescription(projectDto.getDescription());
        project.setStartDate(LocalDateTime.now());
        project.setEndDate(null);
        project.setBacklog(projectDto.getBacklog());
        return project;
    }
}
