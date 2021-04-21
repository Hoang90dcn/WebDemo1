package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.Entity.AdministrativeUnits;
import com.fsot.demoWeb1.Service.IAdministrativeUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdministrativeUnitsAPI {

    @Autowired
    IAdministrativeUnitsService service;
    @GetMapping(value = "/get-dia-chi")
    List<AdministrativeUnits> findAllByParentId(@RequestParam("parent_id") long parent_id)
    {
        System.out.println(parent_id);
        return service.findAllByParentId(parent_id);
    }

    @PostMapping (value = "/them-dia-chi")
    List<AdministrativeUnits> addAddress(@RequestBody List<AdministrativeUnits> list, @RequestParam Long parent_id)
    {

        return  service.saveAll(list, parent_id);
    }
}
