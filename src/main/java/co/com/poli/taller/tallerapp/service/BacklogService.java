package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.BackLogMapper;
import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.persistence.repository.BacklogRepository;
import co.com.poli.taller.tallerapp.service.Interface.BacklogServiceInf;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacklogService implements BacklogServiceInf {

    private final BacklogRepository repository;
    private final BackLogMapper backLogMapper;

    @Override
    public List<Backlog> findAll() {
        return repository.findAll();
    }
    
    public Backlog save(BacklogDto backlogDto) {
        Backlog backlog = backLogMapper.map(backlogDto);
        return repository.save(backlog);
    }
}
