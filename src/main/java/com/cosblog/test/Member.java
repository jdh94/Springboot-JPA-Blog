package com.cosblog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Member {
	private final int id;
	private final String username;
	private final String password;
	private final String email;
}


