package co.com.poli.taller.tallerapp.persistence.repository;

import co.com.poli.taller.tallerapp.persistence.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query(value = "SELECT * FROM PROJECT WHERE PROJECT_IDENTIFIER =:ProjectIdentifier", nativeQuery = true)
    Optional<Project> findByProjectIdentifier(@Param("ProjectIdentifier") String ProjectIdentifier);
}
