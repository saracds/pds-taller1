package co.com.poli.taller.tallerapp.service.Interface;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;

import java.util.List;

public interface BacklogServiceInf {

    List<Backlog> findAll();

    void save(BacklogDto backlogDto);

}
