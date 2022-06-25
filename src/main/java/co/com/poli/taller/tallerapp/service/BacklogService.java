package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.mapper.BackLogMapper;
import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.persistence.repository.BacklogRepository;
import co.com.poli.taller.tallerapp.service.Interface.BacklogServiceInf;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BacklogService implements BacklogServiceInf {

    private final BacklogRepository repository;
    private final BackLogMapper backLogMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BacklogDto backlogDto) {
        Backlog backlog = backLogMapper.map(backlogDto);
        repository.save(backlog);
    }

    @Override
    public Optional<Backlog> findById(long id) {
        return repository.findById(id);
    }
}
