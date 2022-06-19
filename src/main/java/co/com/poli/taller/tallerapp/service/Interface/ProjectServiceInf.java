package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;

import java.util.List;

public interface ProjectServiceInf {

    List<Project> findAll();

    Project save (ProjectDto projectDto);

}
