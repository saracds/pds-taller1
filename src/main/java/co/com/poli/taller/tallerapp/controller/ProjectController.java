package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.ProjectService;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @PostMapping
    public Project save  (@RequestBody ProjectDto projectDto){
        return projectService.save(projectDto);
    }

}
