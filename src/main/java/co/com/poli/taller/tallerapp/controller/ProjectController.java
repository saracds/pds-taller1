package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.helpers.Response;
import co.com.poli.taller.tallerapp.helpers.ResponseBuild;
import co.com.poli.taller.tallerapp.persistence.entity.Project;
import co.com.poli.taller.tallerapp.persistence.entity.ProjectTask;
import co.com.poli.taller.tallerapp.service.ProjectService;
import co.com.poli.taller.tallerapp.service.dto.ProjectDto;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild build;


    @GetMapping
    public Response findAll(){
        return build.success(projectService.findAll());
    }

    @PostMapping
    public Response save (@Valid  @RequestBody ProjectDto projectDto, BindingResult result){
        if (result.hasErrors()) {
            return build.failed(result);
        }
        projectService.save(projectDto);
        return build.success(projectDto);
    }

}
