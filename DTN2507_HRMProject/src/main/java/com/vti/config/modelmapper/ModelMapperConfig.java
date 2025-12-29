package com.vti.config.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vti.dto.AccontDto;
import com.vti.dto.PossitonDto;
import com.vti.entity.Account;
import com.vti.entity.Position;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		Cấu hình chuyển đổi cho Account
		mapper.addMappings(new PropertyMap<Account, AccontDto>() {

			@Override
			protected void configure() {
				// Chỉ để nhận được biết cần mapping như nào
				map().setDepartment(source.getDepartment().getName());
//				map().setPosition(source.getPosition().getName().toString());
			}
		});

//		Cấu hình chuyển đổi cho Department
		mapper.addMappings(new PropertyMap<Position, PossitonDto>() {

			@Override
			protected void configure() {

			}
		});
		return mapper;
	}
}
