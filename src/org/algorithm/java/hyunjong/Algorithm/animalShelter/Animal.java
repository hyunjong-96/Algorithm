package org.algorithm.java.hyunjong.Algorithm.animalShelter;

public abstract class Animal {
	AnimalType type;
	String name;
	private int order;

	public Animal(AnimalType type, String name) {
		this.type = type;
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	public String getName(){
		return this.name;
	}
}

enum AnimalType{
	DOG, CAT
}

