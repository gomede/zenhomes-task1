package com.zenhomes.app.model.domain;

import com.zenhomes.app.model.types.Type;

public class Tenant extends Person {

	public Tenant(int id, String name, Type type) {
		super(id, name, type);
	}

}