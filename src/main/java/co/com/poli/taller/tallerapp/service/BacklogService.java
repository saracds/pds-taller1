package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.persistence.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BacklogService {

    private final BacklogRepository repository;
}
