package co.com.poli.taller.tallerapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projectTask")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project")
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    @Column(name = "status")
    private ProjectStatus status;

    @Column(name = "priority")
    private int priority;

    @Column(name = "hours")
    private double hours;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "project_identifier")
    private String ProjectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_backlog")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
