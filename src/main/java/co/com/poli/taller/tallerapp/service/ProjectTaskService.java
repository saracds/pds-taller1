package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.ProjectTaskMapper;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectTaskRepository;
import co.com.poli.taller.tallerapp.service.Interface.ProjectTaskSerivceInf;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectTaskService implements ProjectTaskSerivceInf {

    private final ProjectTaskRepository repository;
    private final ProjectTaskMapper projectTaskMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ProjectTaskDto projectTaskDto) {
        ProjectTask projectTask = projectTaskMapper.map(projectTaskDto);
        repository.save(projectTask);
    }

    @Override
    public List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier) {
        return repository.findAllByProjectIdentifier(projectIdentifier);
    }

    @Override
    public double totalHoursByProjectIdentifier(String ProjectIdentifier) {
        return repository.totalHoursByProjectIdentifier(ProjectIdentifier);
    }

    @Override
    public Double totalHoursByProjectIdentifierAndStatus(String ProjectIdentifier, ProjectStatus status) {
        switch (status){
            case NOT_STARED -> {
                return repository.totalHoursByProjectIdentifierAndStatus(ProjectIdentifier, 0);
            }
            case IN_PROGRESS ->{
                return repository.totalHoursByProjectIdentifierAndStatus(ProjectIdentifier, 1);
            }
            case COMPLETED -> {
                return repository.totalHoursByProjectIdentifierAndStatus(ProjectIdentifier, 2);
            }
            case DELETED -> {
                return repository.totalHoursByProjectIdentifierAndStatus(ProjectIdentifier, 3);
            }
        }
        return 0.0;
    }

    @Override
    @Transactional
    public void deleteByIdTaskAndProjectIdentifier(Long idtask, String ProjectIdentifier) {
        repository.deleteByIdTaskAndProjectIdentifier(idtask, ProjectIdentifier);
    }

    @Override
    public Optional<ProjectTask> findById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void updateTaskStatusByIdTask(ProjectStatus status, Long Id) {
        switch (status) {
            case NOT_STARED -> repository.updateTaskStatusByIdTask(0, Id);
            case IN_PROGRESS -> repository.updateTaskStatusByIdTask(1, Id);
            case COMPLETED -> repository.updateTaskStatusByIdTask(2, Id);
            case DELETED -> repository.updateTaskStatusByIdTask(3, Id);
        }
    }

    @Override
    public List<ProjectTask> findAllByProjectStatus(ProjectStatus projectStatus) {
        return repository.findAllByProjectStatus(projectStatus);
    }
}


