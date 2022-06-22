package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;

import java.util.List;

public interface ProjectTaskSerivceInf {

    List<ProjectTask> findAll();
    void save (ProjectTaskDto projectTask);

    //List<ProjectTask> findAllByProjectStatus(ProjectStatus projectStatus);
}
