package model;

import java.util.Iterator;
import java.util.List;

public class Box implements Iterable<Pomegranate>  {
	String name;
	List<Pomegranate> granates;
	
	
	
	public Box(String name, List<Pomegranate> granates) {
		this.name = name;
		this.granates = granates;
	}

	public int getTotalSeeds() {
		return granates.stream()
								.mapToInt(value -> value.seeds.size())
								.sum();
								}

	
	@Override
	public String toString() {
		return "Box [name=" + name + ", seeds = " + getTotalSeeds() + "]";
	}

	@Override
	public Iterator<Pomegranate> iterator() {
		// TODO Auto-generated method stub
		return granates.iterator();
	}

}
