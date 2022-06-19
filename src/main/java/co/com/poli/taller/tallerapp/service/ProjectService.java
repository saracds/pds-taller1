package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.ProjectMapper;
import co.com.poli.taller.tallerapp.mapper.ProjectTaskMapper;
import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectRepository;
import co.com.poli.taller.tallerapp.service.Interface.ProjectServiceInf;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectServiceInf {

    private final ProjectRepository repository;
    private final ProjectMapper projectMapper;

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project save(ProjectDto projectDto) {
        Project project = projectMapper.map(projectDto);
        return repository.save(project);
    }
}
