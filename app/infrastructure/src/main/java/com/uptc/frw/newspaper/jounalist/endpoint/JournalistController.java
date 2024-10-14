package com.uptc.frw.newspaper.jounalist.endpoint;

import com.uptc.frw.newspaper.application.journalist.JournalistUseCases;
import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("journalists")
public class JournalistController {

    private final JournalistUseCases journalistUseCases;

    public JournalistController(JournalistUseCases journalistUseCases) {
        this.journalistUseCases = journalistUseCases;
    }

    @GetMapping
    public List<Journalist> getAllJournalists() {
        return journalistUseCases.listAll();
    }

    @GetMapping("/{journalistId}")
    public Journalist getJournalistById(@PathVariable Long journalistId) {
        return journalistUseCases.get(journalistId).orElseThrow();
    }

    @PostMapping
    public Journalist addJournalist(@RequestBody Journalist journalist) {
        return journalistUseCases.add(journalist);
    }

    @DeleteMapping("/{journalistId}")
    public Journalist removeJournalist(@PathVariable Long journalistId) {
        return journalistUseCases.remove(journalistId).orElseThrow();
    }

    @PutMapping()
    public Journalist modifyJournalist(@RequestParam Long journalistId, @RequestBody Journalist journalist) {
        return journalistUseCases.update(journalist, journalistId).orElseThrow();
    }
}
