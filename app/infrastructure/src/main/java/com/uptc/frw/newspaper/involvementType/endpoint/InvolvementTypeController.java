package com.uptc.frw.newspaper.involvementType.endpoint;

import com.uptc.frw.newspaper.application.involvementType.InvolvementTypeUseCases;
import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("involvementTypes")
public class InvolvementTypeController {
    public final InvolvementTypeUseCases involvementTypeUseCases;

    public InvolvementTypeController(InvolvementTypeUseCases involvementTypeUseCases) {
        this.involvementTypeUseCases = involvementTypeUseCases;
    }
    @GetMapping()
    public List<InvolvementType> getAlliInvolvementTypes(){
        return involvementTypeUseCases.listAll();
    }
    @GetMapping("/{involvementTypeId}")
    public InvolvementType getInvolvementTypeById(@PathVariable Long involvementTypeId){
        return involvementTypeUseCases.get(involvementTypeId).orElseThrow();
    }
    @PostMapping()
    public InvolvementType addInvolvementType(@RequestBody InvolvementType involvementType){
        return involvementTypeUseCases.add(involvementType);
    }
    @DeleteMapping("/{involvementTypeId}")
    public InvolvementType removeInvolvementType(@PathVariable Long involvementTypeId){
        return involvementTypeUseCases.remove(involvementTypeId).orElseThrow();
    }
    @PutMapping("/{involvementTypeId}")
    public InvolvementType updateInvolvementType(@RequestBody InvolvementType involvementType, @PathVariable Long involvementTypeId){
        return  involvementTypeUseCases.update(involvementType,involvementTypeId).orElseThrow();
    }
}
