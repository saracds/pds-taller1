package co.com.poli.taller.tallerapp;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void executing_findByProjectIdentifier(){
        Project project = Project.builder()
                .Id(1)
                .projectName("Practica")
                .ProjectIdentifier("Practica1")
                .startDate(LocalDateTime.now())
                .endDate(null)
                .description("Practica de profundizacion :)")
                .build();
        projectRepository.save(project);

        Optional<Project> projectPruba = projectRepository.findByProjectIdentifier("Practica1");

        //System.out.println("--------------" + projectPruba.get().getProjectIdentifier() + "-----------------");

        Assertions.assertThat(projectPruba.get().getProjectIdentifier()).isEqualTo("Practica1 ");

    }


}
