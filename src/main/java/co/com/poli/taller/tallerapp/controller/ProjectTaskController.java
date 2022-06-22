package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.helpers.Response;
import co.com.poli.taller.tallerapp.helpers.ResponseBuild;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.ProjectTaskService;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ResponseBuild build;

    @GetMapping
    public Response findAll(){
        return build.success(projectTaskService.findAll());
    }

    @PostMapping
    public Response save (@Valid  @RequestBody ProjectTaskDto projectTaskDto, BindingResult result){
        if (result.hasErrors()) {
            return build.failed(result);
        }
        projectTaskService.save(projectTaskDto);
        return build.success(projectTaskDto);
    }

}
