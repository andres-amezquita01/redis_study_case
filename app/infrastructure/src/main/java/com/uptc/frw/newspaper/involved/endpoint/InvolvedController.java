package com.uptc.frw.newspaper.involved.endpoint;

import com.uptc.frw.newspaper.application.involved.InvolvedUseCases;
import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("involved")
public class InvolvedController {

    public final InvolvedUseCases involvedUseCases;

    public InvolvedController(InvolvedUseCases involvedUseCases) {
        this.involvedUseCases = involvedUseCases;
    }

    @GetMapping()
    public List<Involved> getAllInvolved() {
        return involvedUseCases.listAll();
    }

    @GetMapping("/{involvedId}")
    public Involved getInvolvedById(@PathVariable("involvedId") Long involvedId) {
        return involvedUseCases.get(involvedId).orElseThrow();
    }

    @PostMapping()
    public Involved addInvolved(@RequestBody Involved newInvolved) {
        return involvedUseCases.add(newInvolved);
    }

    @DeleteMapping("/{involvedId}")
    public Involved removeInvolved(@PathVariable("involvedId")  Long involvedId) {
        return involvedUseCases.remove(involvedId).orElseThrow();
    }

    @PutMapping()
    public Involved modifyInvolved(@RequestParam("involvedId") Long involvedId,
                                   @RequestBody Involved newInvolved) {
        return involvedUseCases.update(newInvolved, involvedId).orElseThrow();
    }

}
