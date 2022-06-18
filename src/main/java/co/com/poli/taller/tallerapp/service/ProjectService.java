package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
}
