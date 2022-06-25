package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;

import java.util.List;
import java.util.Optional;

public interface BacklogServiceInf {

    List<Backlog> findAll();

    void save(BacklogDto backlogDto);

    Optional<Backlog> findById(long id);

}
