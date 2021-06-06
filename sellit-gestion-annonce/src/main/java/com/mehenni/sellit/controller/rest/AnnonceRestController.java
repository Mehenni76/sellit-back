package com.mehenni.sellit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehenni.sellit.config.SellItGestionAnnonceConfiguration;

@RestController
public class AnnonceRestController {
	@Autowired
	private SellItGestionAnnonceConfiguration sellitGestionAnnonceConfiguration;

    @GetMapping("/endpoint")
    public String retrieveLimits(){
        return sellitGestionAnnonceConfiguration.getValue();
    }
}