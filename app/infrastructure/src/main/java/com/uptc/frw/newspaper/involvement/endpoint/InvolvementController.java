package com.uptc.frw.newspaper.involvement.endpoint;

import com.uptc.frw.newspaper.application.involvement.InvolvementUseCases;
import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involvement")
public class InvolvementController {
    InvolvementUseCases involvementUseCases;

    public InvolvementController(InvolvementUseCases involvementUseCases) {
        this.involvementUseCases = involvementUseCases;
    }
    @GetMapping
    public List<Involvement> getAllInvolvements(){
        return involvementUseCases.listAll();
    }

    @GetMapping("/{involvementId}")
    public Involvement getInvolvementById(@PathVariable Long involvementId) {
        return involvementUseCases.get(involvementId).orElseThrow();
    }
    @PostMapping
    public Involvement addInvolvement(@RequestBody Involvement involvement){
        return  involvementUseCases.add(involvement);
    }
    @DeleteMapping("/{involvementId}")
    public Involvement deleteInvolvement(@PathVariable Long involvementId){
        return  involvementUseCases.remove(involvementId).orElseThrow();
    }
    @PutMapping("/{involvementId}")
    public Involvement updateInvolvement(@RequestBody Involvement involvement, @PathVariable Long involvementId){
        return involvementUseCases.update(involvement, involvementId).orElseThrow();
    }

}
