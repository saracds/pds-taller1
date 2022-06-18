package co.com.poli.taller.tallerapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "backlog")
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "project_identifier")
    private String projectIdentifier;

    @OneToOne(mappedBy="backlog")
    private Project project;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "backlog",
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Id == backlog.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
