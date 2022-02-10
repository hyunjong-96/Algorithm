package org.algorithm.java.hyunjong.Algorithm.animalShelter;

import java.util.LinkedList;

public class AnimalShelter {
	private LinkedList<Dog> dogs = new LinkedList<>();
	private LinkedList<Cat> cats = new LinkedList<>();

	private int order = 0;

	public void saveAnimal(Animal animal){
		animal.setOrder(order);

		if(animal.type.equals(AnimalType.CAT)){
			cats.add((Cat)animal);
		}else{
			dogs.add((Dog)animal);
		}

		order++;
	}

	public Animal parcelOut(){
		if(dogs.isEmpty() && cats.isEmpty()){
			return null;
		}else if(dogs.isEmpty()){
			return cats.poll();
		}else if(cats.isEmpty()){
			return dogs.poll();
		}

		Dog dog = dogs.peekFirst();
		Cat cat = cats.peekFirst();

		return dog.getOrder() < cat.getOrder() ? dogs.poll() : cats.poll();
	}

	public Animal parcelOutDog(){
		return dogs.poll();
	}

	public Animal parcelOutCat(){
		return cats.poll();
	}
}