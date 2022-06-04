package com.example.mosteiro.domains.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mosteiro.domains.dto.Oracao;
import com.example.mosteiro.domains.service.OracaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/oracao")
public class OracaoResource {

	private final OracaoService oracaoService;

	@PostMapping
	public ResponseEntity<Void> sendMail(@RequestBody Oracao oracao) {
		oracaoService.enviaEmail(oracao);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
