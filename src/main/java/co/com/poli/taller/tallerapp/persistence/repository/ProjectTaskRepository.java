package co.com.poli.taller.tallerapp.persistence.repository;

import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    List<ProjectTask> findAllByProjectStatus(ProjectStatus projectStatus);

    @Query(value = "SELECT * FROM PROJECT_TASK WHERE PROJECT_IDENTIFIER =:ProjectIdentifier", nativeQuery = true)
    List<ProjectTask> findAllByProjectIdentifier(String ProjectIdentifier);

    @Query(value = "SELECT SUM(HOURS) FROM PROJECT_TASK WHERE PROJECT_STATUS <> 3 AND PROJECT_IDENTIFIER =:ProjectIdentifier", nativeQuery = true)
    double totalHoursByProjectIdentifier(@Param("ProjectIdentifier") String ProjectIdentifier);

    @Query(value = "SELECT SUM(HOURS) FROM PROJECT_TASK WHERE PROJECT_IDENTIFIER =:ProjectIdentifier AND PROJECT_STATUS =:status", nativeQuery = true)
    Double totalHoursByProjectIdentifierAndStatus(@Param("ProjectIdentifier") String ProjectIdentifier, @Param("status") Integer status);

    @Modifying
    @Query(value = "UPDATE PROJECT_TASK SET PROJECT_STATUS = 3 WHERE ID_PROJECT_TASK =:idtask AND PROJECT_IDENTIFIER =:ProjectIdentifier", nativeQuery = true)
    void deleteByIdTaskAndProjectIdentifier(@Param("idtask") Long idtask, @Param("ProjectIdentifier") String ProjectIdentifier);

    @Modifying
    @Query(value = "UPDATE PROJECT_TASK SET PROJECT_STATUS =:status WHERE ID_PROJECT_TASK =:idtask", nativeQuery = true)
    void updateTaskStatusByIdTask(@Param("status") Integer status, @Param("idtask") Long idtask);
}


