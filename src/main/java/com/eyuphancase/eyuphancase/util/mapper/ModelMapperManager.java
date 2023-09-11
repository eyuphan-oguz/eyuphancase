package com.eyuphancase.eyuphancase.util.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager {
    
    private ModelMapper modelMapper;

    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}