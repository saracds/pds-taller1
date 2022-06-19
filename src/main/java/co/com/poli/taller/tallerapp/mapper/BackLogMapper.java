package co.com.poli.taller.tallerapp.mapper;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;

public class BackLogMapper implements  IMapper <BacklogDto, Backlog>{

    @Override
    public Backlog map(BacklogDto backlogDto) {
        Backlog backlog = new Backlog();
        backlog.setProjectIdentifier(backlogDto.getProjectIdentifier());
        backlog.setProject(backlogDto.getProject());
        backlog.setProjectTasks(backlogDto.getProjectTasks());
        return backlog;
    }
}
