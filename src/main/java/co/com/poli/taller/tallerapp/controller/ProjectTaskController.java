package co.com.poli.taller.tallerapp.controller;


import co.com.poli.taller.tallerapp.persistence.entity.ProjectStatus;
import co.com.poli.taller.tallerapp.service.BacklogService;
import co.com.poli.taller.tallerapp.service.ProjectService;
import co.com.poli.taller.tallerapp.service.ProjectTaskService;
import co.com.poli.taller.tallerapp.service.dto.ProjectTaskDto;

import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ProjectService projectService;
    private final BacklogService backlogService;
    private final ResponseBuild build;
    private final FormatMessage formatMessage;
    @GetMapping
    public Response findAll() {
        return build.success(projectTaskService.findAll());
    }

    @GetMapping("/status/{status}")
    public Response findAllByProjectStatus(@PathVariable("status") ProjectStatus projectStatus) {
        return build.success(projectTaskService.findAllByProjectStatus(projectStatus));
    }

    @PostMapping
    public Response save(@Valid @RequestBody ProjectTaskDto projectTaskDto, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
        } else {
            var backlog = backlogService.findById(projectTaskDto.getBacklog().getId());
            if (backlog.isPresent()) {
                var project = projectService.findById(backlog.get().getProject().getId());
                if (project.isPresent()) {
                    if (project.get().getProjectIdentifier().equals(projectTaskDto.getProjectIdentifier())) {
                        projectTaskService.save(projectTaskDto);
                        return build.created(projectTaskDto);
                    } else {
                        return build.failed("El identificador del proyecto no coincide");
                    }
                } else {
                    return build.failed("El proyecto no existe");
                }
            } else {
                return build.failed("El backlog no existe");
            }
        }
    }

    @GetMapping("/task/project/{projectIdentifier}")
    public Response findAllByProjectIdentifier(@PathVariable("projectIdentifier") String projectIdentifier) {
        var project = projectService.findByProjectIdentifier(projectIdentifier);
        if (!project.isPresent()) {
            return build.notFound("El proyecto no existe");
        } else {
            return build.success(projectTaskService.findAllByProjectIdentifier(projectIdentifier));
        }
    }

    @GetMapping("/task/project/hours/{projectIdentifier}")
    public Response totalHoursByProjectIdentifier(@PathVariable("projectIdentifier") String projectIdentifier) {
        var project = projectService.findByProjectIdentifier(projectIdentifier);
        if (!project.isPresent()) {
            return build.notFound("El proyecto no existe");
        } else {
            return build.success(projectTaskService.totalHoursByProjectIdentifier(projectIdentifier));
        }
    }

    @GetMapping("/task/project/hours/{projectIdentifier}/{status}")
    public Response totalHoursByProjectIdentifierAndStatus(@PathVariable("projectIdentifier") String projectIdentifier, @PathVariable("status") ProjectStatus status) {
        var project = projectService.findByProjectIdentifier(projectIdentifier);
        if (!project.isPresent()) {
            return build.notFound("El proyecto no existe");
        } else {
            var hours = projectTaskService.totalHoursByProjectIdentifierAndStatus(projectIdentifier, status);
            return build.success( hours == null ? 0 : hours);
        }
    }

    @PatchMapping("/task/{idtask}/{projectIdentifier}")
    public Response deleteByIdTaskAndProjectIdentifier(@PathVariable("idtask") Long idtask, @PathVariable("projectIdentifier") String projectIdentifier) {

        var projectTask = projectTaskService.findById(idtask).orElse(null);

        if (projectTask == null) {
            return build.notFound("No existe la tarea del proyecto");
        } else {
            projectTaskService.deleteByIdTaskAndProjectIdentifier(idtask, projectIdentifier);
            return build.success();
        }
    }

    @PatchMapping("/updatetask/{idtask}/{status}")
    public Response updateTaskStatusByIdTask(@PathVariable("idtask") Long idtask, @PathVariable("status") ProjectStatus status) {

        var projectTask = projectTaskService.findById(idtask).orElse(null);
        System.out.println("------------------ " + status + " --------------------");
        if (projectTask == null) {
            return build.notFound("No existe la tarea del proyecto");
        } else {
            projectTaskService.updateTaskStatusByIdTask(status, idtask);
            return build.success();
        }
    }
}
