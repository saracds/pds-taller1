package co.com.poli.taller.tallerapp.controller;

import co.com.poli.taller.tallerapp.persistence.entity.Backlog;
import co.com.poli.taller.tallerapp.service.BacklogService;
import co.com.poli.taller.tallerapp.service.dto.BacklogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;

    @GetMapping
    public List<Backlog> findAll(){
        return backlogService.findAll();
    }

    @PostMapping
    public Backlog save(@RequestBody BacklogDto backlogDto){
        return  backlogService.save(backlogDto);
    }

}
