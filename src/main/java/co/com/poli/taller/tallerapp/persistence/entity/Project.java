package co.com.poli.taller.tallerapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_identifier")
    private String ProjectIdentifier;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName) && ProjectIdentifier.equals(project.ProjectIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, ProjectIdentifier);
    }
}
