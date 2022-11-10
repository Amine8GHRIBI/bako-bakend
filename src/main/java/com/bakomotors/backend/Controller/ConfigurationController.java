package com.bakomotors.backend.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakomotors.backend.Model.Configurations;
import com.bakomotors.backend.Model.Product;
import com.bakomotors.backend.Services.CategoryService;

import lombok.RequiredArgsConstructor;
import com.bakomotors.backend.Services.ConfigurationService;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/configuration")

public class ConfigurationController {

    private final ConfigurationService configurationservice;

	
	@GetMapping(path = "")
    public List<Configurations> getAllConfigurations(){
        return configurationservice.findAll();
    }

}
