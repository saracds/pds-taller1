package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProjectServiceInf {

    List<Project> findAll();

    void save (ProjectDto projectDto);

    Optional<Project> findById(long id);

    @Transactional(readOnly = true)
    Optional<Project> findByProjectIdentifier (String projectIdentifier);

}
