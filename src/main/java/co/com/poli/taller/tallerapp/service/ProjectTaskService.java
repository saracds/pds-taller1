package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.ProjectTaskMapper;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectTaskRepository;
import co.com.poli.taller.tallerapp.service.Interface.ProjectTaskSerivceInf;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectTaskService implements ProjectTaskSerivceInf {

    private final ProjectTaskRepository repository;
    private final ProjectTaskMapper projectTaskMapper;

    @Override
    public List<ProjectTask> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectTask save(ProjectTaskDto projectTaskDto) {
        ProjectTask projectTask = projectTaskMapper.map(projectTaskDto);
        return this.repository.save(projectTask);
    }

    //@Override
    //public List<ProjectTask> findAllByProjectStatus(ProjectStatus projectStatus) {
        //return repository.findAllByProjectStatus(projectStatus);
    //}
}


