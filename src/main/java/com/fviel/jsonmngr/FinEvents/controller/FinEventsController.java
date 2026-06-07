package com.fviel.jsonmngr.FinEvents.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.jsonmngr.FinEvents.service.FinEventsService;
import com.fviel.jsonmngr.FinEvents.model.Account;

@RestController
@RequestMapping("/finevents")
public class FinEventsController {
    
    private final FinEventsService finEventsService;

    public FinEventsController(FinEventsService finEventsService){
        this.finEventsService = finEventsService;
    }

    @GetMapping
    public List<Account> list(){
        return finEventsService.list();
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return finEventsService.save(account);
    }

}
