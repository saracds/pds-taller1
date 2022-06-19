package co.com.poli.taller.tallerapp.service;

import co.com.poli.taller.tallerapp.persistence.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectTaskService {
   private final ProjectTaskRepository repository;
}


