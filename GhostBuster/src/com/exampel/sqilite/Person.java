package com.exampel.sqilite;

public class Person {

	private    int  id;
	private   String name;
	private    int level;
	private    String power;
	private   String  intelligence;
	private   String life;


	public Person(){

	}

	public Person(int id, String name, int level, String power,
			String intelligence, String life) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.power = power;
		this.intelligence = intelligence;
		this.life = life;
	}

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}



}
