package co.com.poli.taller.tallerapp;

import co.com.poli.taller.tallerapp.mapper.ProjectMapper;
import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectRepository;
import co.com.poli.taller.tallerapp.service.Interface.ProjectServiceInf;
import co.com.poli.taller.tallerapp.service.ProjectService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class ProjectServiceTest {


    @Mock
    private ProjectRepository projectRepository;

    private ProjectServiceInf projectService;
    private ProjectMapper projectMapper;

    @BeforeEach
    public void Begin(){
        MockitoAnnotations.openMocks(this);
        projectService = new ProjectService(projectRepository, projectMapper);

        Project project = Project.builder()
                .Id(1)
                .projectName("Practica")
                .ProjectIdentifier("Practica1")
                .startDate(LocalDateTime.now())
                .endDate(null)
                .description("Practica de profundizacion :)")
                .build();

        Mockito.when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));
    }

    @Test
    public void executing_findById(){
        Optional<Project> project = projectService.findById(1L);

        Assertions.assertThat(project.get().getId()).isEqualTo(1L);

    }

}
