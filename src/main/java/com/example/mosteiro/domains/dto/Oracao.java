package com.example.mosteiro.domains.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Oracao {
	private String name;
	private String email;
	private String phone;
	private String message;
}
