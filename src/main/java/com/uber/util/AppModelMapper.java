package com.uber.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.uber.dto.UberDTO;
import com.uber.entity.UberEntity;

@Component
public class AppModelMapper {

	private ModelMapper modelMapper = new ModelMapper();
	
	// ModelMapper used for convert DTO class to Entity Class
	public UberEntity dtoToEntity(UberDTO uberDTO) {
	return	modelMapper.map(uberDTO, UberEntity.class);
	}
	
	// ModelMapper used for convert from Entity class to DTO class
	public UberDTO entityToDto(UberEntity uberEntity) {
		return modelMapper.map(uberEntity, UberDTO.class);
	}
	
	
}
