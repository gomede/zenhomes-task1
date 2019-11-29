package com.zenhomes.app;

public abstract class Person {

    private int id;

    private String name;

    private Type type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Person(int id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}