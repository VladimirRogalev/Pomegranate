package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import model.Box;
import model.Pomegranate;
import model.Seed;


public class PomegranateImpl implements PomegranateInterface{

	private static final int MIN_BOXES = 100;
	private static final int MAX_BOXES = 200;
	private static final int MIN_POMEGRANATES = 10;
	private static final int MAX_POMEGRANATES = 20;
	private static final int MIN_SEEDS = 400;
	private static final int MAX_SEEDS = 700;
	private static Random random = new Random();
	
		@Override
	public   List<Box> generateRandomBoxes() {
		int numOfBoxes = random.nextInt(MAX_BOXES - MIN_BOXES + 1) + MIN_BOXES;
		List<Box> boxes = new ArrayList<>();
		for (int i = 0; i < numOfBoxes; i++) {
			boxes.add(new Box("Box " + i, generateRandomPomegranates()));

		}
		return boxes;
	}

	private static List<Pomegranate> generateRandomPomegranates() {
		int numOfPomegranates = random.nextInt(MAX_POMEGRANATES - MIN_POMEGRANATES + 1) + MIN_POMEGRANATES;
		List<Pomegranate> pomegranates = new ArrayList<>();
		for (int i = 0; i < numOfPomegranates; i++) {
			pomegranates.add(new Pomegranate(generateRandomSeeds()));
		}
		return pomegranates;
	}

	private static List<Seed> generateRandomSeeds() {
		int numOfSeeds = random.nextInt(MAX_SEEDS - MIN_SEEDS + 1) + MIN_SEEDS;
		List<Seed> seeds = new ArrayList<>();
		for (int i = 0; i < numOfSeeds; i++) {
			seeds.add(new Seed(2.0));
		}
		return seeds;
	}
	public int calculateTotalSeeds(List<Box> boxes) {
	return boxes.stream()
						.mapToInt(Box :: getTotalSeeds)
						.sum();
	}
	public int calculateMaxSeeds(List<Box> boxes) {
	return boxes.stream()
						.mapToInt(Box::getTotalSeeds)
						.max()
						.orElse(0);
	}
	
	public List<Box> fiveMaxBoxes (List<Box> boxes){
		List<Box> res = boxes.stream()
										.sorted((o2, o1) -> Long.compare(o1.getTotalSeeds(), o2.getTotalSeeds()))
										.limit(5)
										.collect(Collectors.toList());
		res.forEach(System.out::println);
		return null;
}


}
