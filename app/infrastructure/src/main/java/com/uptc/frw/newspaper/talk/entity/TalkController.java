package com.uptc.frw.newspaper.talk.entity;

import com.uptc.frw.newspaper.application.talk.TalkUseCases;
import com.uptc.frw.newspaper.domain.talk.entity.Talk;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talk")
public class TalkController {
    private TalkUseCases talkUseCases;

    public TalkController(TalkUseCases talkUseCases) {
        this.talkUseCases = talkUseCases;
    }

    @GetMapping
    public List<Talk> getAllTalks(){
        return talkUseCases.listAll();
    }
    @GetMapping("/{talkId}")
    public Talk getTalkById(@PathVariable Long talkId){
        return talkUseCases.get(talkId).orElseThrow();
    }
    @PostMapping()
    public Talk addTalk(@RequestBody Talk talk){
        return talkUseCases.add(talk);
    }
    @DeleteMapping("/{talkId}")
    public Talk removeTalk(@PathVariable Long talkId){
        return talkUseCases.remove(talkId).orElseThrow();
    }

    @PutMapping("/{talkId}")
    public Talk updateTalk(@RequestBody Talk talk,@PathVariable Long talkId){
        return  talkUseCases.update(talk, talkId).orElseThrow();
    }

}
