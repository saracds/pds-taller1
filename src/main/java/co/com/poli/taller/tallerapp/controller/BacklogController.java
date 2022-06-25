package co.com.poli.taller.tallerapp.controller;


import co.com.poli.taller.tallerapp.service.BacklogService;
import co.com.poli.taller.tallerapp.service.ProjectService;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;


import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class BacklogController {

    private final BacklogService backlogService;
    private final ProjectService projectService;
    private final ResponseBuild build;

    private final FormatMessage formatMessage;

    @GetMapping
    public Response findAll() {
        return build.success(backlogService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody BacklogDto backlogDto, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
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
