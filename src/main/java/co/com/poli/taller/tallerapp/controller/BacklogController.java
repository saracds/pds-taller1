package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.helpers.Response;
import co.com.poli.taller.tallerapp.helpers.ResponseBuild;
import co.com.poli.taller.tallerapp.service.BacklogService;
import co.com.poli.taller.tallerapp.service.ProjectService;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ProjectService projectService;
    private final ResponseBuild build;


    @GetMapping
    public Response findAll() {
        return build.success(backlogService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody BacklogDto backlogDto, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(result);
        } else {
            var project = projectService.findById(backlogDto.getProject().getId());
            if (project.isPresent()) {
                if (project.get().getProjectIdentifier().equals(backlogDto.getProjectIdentifier())) {
                    backlogService.save(backlogDto);
                    return build.created(backlogDto);
                } else {
                    return build.failed("El identificador del proyecto no coincide");
                }
            } else {
                return build.failed("El proyecto no existe");
            }
        }
    }
}
