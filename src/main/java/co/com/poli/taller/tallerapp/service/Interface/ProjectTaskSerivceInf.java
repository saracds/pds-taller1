package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;


import java.util.List;
import java.util.Optional;

public interface ProjectTaskSerivceInf {

    List<ProjectTask> findAll();
    void save (ProjectTaskDto projectTask);

    List<ProjectTask> findAllByProjectStatus(ProjectStatus projectStatus);

    List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier);

    double  totalHoursByProjectIdentifier(String ProjectIdentifier);

    Double totalHoursByProjectIdentifierAndStatus(String ProjectIdentifier, ProjectStatus status);

    void deleteByIdTaskAndProjectIdentifier(Long Id,String ProjectIdentifier);

    Optional<ProjectTask> findById(long id);

    void updateTaskStatusByIdTask(ProjectStatus status,Long Id);
}
