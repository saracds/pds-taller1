package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.ProjectTaskService;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projecttask")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;

    @GetMapping
    public List<ProjectTask> findAll(){
        return projectTaskService.findAll();
    }

    @PostMapping
    public ProjectTask save (@RequestBody ProjectTaskDto projectTaskDto){
        return projectTaskService.save(projectTaskDto);
    }

}
