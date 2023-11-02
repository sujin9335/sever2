package com.test.toy.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok 처리

@Setter
@Getter
@ToString
@EqualsAndHashCode

public class UserDTO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String lv;
	private String pic;
	private String intro;

	

	
	
}
