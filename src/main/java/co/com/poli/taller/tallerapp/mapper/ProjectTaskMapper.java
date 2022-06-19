package co.com.poli.taller.tallerapp.mapper;

import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectTaskMapper implements  IMapper <ProjectTaskDto, ProjectTask> {

    @Override
    public ProjectTask map(ProjectTaskDto projectTaskDto) {
        ProjectTask projectTask = new ProjectTask();
        projectTask.setName(projectTaskDto.getName());
        projectTask.setSummary(projectTaskDto.getSummary());
        projectTask.setAcceptanceCriteria(projectTaskDto.getAcceptanceCriteria());
        projectTask.setStatus(ProjectStatus.NOT_STARED);
        projectTask.setPriority(projectTaskDto.getPriority());
        projectTask.setHours(projectTaskDto.getHours());
        projectTask.setStartDate(projectTask.getStartDate());
        projectTask.setEndDate(projectTaskDto.getEndDate());
        projectTask.setProjectIdentifier(projectTaskDto.getProjectIdentifier());
        projectTask.setBacklog(projectTaskDto.getBacklog());
        return projectTask;
    }
}
