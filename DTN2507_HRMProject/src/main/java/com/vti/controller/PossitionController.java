package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.PossitonDto;
import com.vti.entity.Position;
import com.vti.service.IPossitionService;

@RestController
@RequestMapping(value = "api/v1/possitions")
@CrossOrigin("*")
public class PossitionController {
	@Autowired
	private IPossitionService possitionService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public ResponseEntity<?> getAllPossitons() {
		List<Position> listPositions = possitionService.getAllPossition();

//		List<PossitonDto> listPossitonDtos = new ArrayList<>();
//
//		for (Position position : listPositions) {
//			PossitonDto possitonDto = new PossitonDto();
//			possitonDto.setId(position.getId());
//			possitonDto.setName(position.getName().toString());
//
//			listPossitonDtos.add(possitonDto);
//		}
		List<PossitonDto> listPossitonDtos = listPositions.stream().map(p -> {
			PossitonDto possitonDto = modelMapper.map(p, PossitonDto.class);
			possitonDto.setName(p.getName().toString());
			return possitonDto;
		}).toList();

		return new ResponseEntity<>(listPossitonDtos, HttpStatus.OK);
	}

}
