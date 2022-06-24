package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.ProjectMapper;
import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectRepository;
import co.com.poli.taller.tallerapp.service.Interface.ProjectServiceInf;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectServiceInf {

    private final ProjectRepository repository;
    private final ProjectMapper projectMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ProjectDto projectDto) {
        Project project = projectMapper.map(projectDto);
        repository.save(project);
    }

    @Override
    public Optional<Project> findById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findByProjectIdentifier(String projectIdentifier) {
        return repository.findByProjectIdentifier(projectIdentifier);
    }



}
