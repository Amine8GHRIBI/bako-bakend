package com.bakomotors.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakomotors.backend.Model.Category;
import com.bakomotors.backend.Model.Configurations;
import com.bakomotors.backend.Model.Product;
import com.bakomotors.backend.Repositories.ConfigurationsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ConfigurationService {
	
	 @Autowired
     private ConfigurationsRepository configRepos;
	 
	    public void save(Configurations configuration){
	    	configRepos.save(configuration);
	    }
	    
	    public List<Configurations> findAll(){
	        return configRepos.findAll();
	    }
	    

}
