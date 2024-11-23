package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Box;
import model.Pomegranate;
import model.Seed;


public class PomegranateAppl /*implements PomegranateInterface */{

	private static final int MIN_BOXES = 100;
	private static final int MAX_BOXES = 200;
	private static final int MIN_POMEGRANATES = 10;
	private static final int MAX_POMEGRANATES = 20;
	private static final int MIN_SEEDS = 400;
	private static final int MAX_SEEDS = 700;
	
	
	public static void main(String[] args) {
		
		List<Box> boxes = generateRandomBoxes();
		int totalSeeds = calculateTotalSeeds(boxes);
		System.out.println(totalSeeds);
		int maxSeeds = calculateMaxSeeds(boxes);
		System.out.println(maxSeeds);
//		List<String> maximumSeedsBoxes = findMaximumSeedsBoxes(boxes);
//		System.out.println(maximumSeedsBoxes);
		
	}



	//	@Override
	public static List<Box> generateRandomBoxes() {
		Random random = new Random();
		int numOfBoxes = random.nextInt(MAX_BOXES - MIN_BOXES + 1) + MIN_BOXES;
		List<Box> boxes = new ArrayList<>();
		for (int i = 0; i < numOfBoxes; i++) {
			boxes.add(new Box("Box " + i, generateRandomPomegranates()));

		}
		return boxes;
	}

	private static List<Pomegranate> generateRandomPomegranates() {
		Random random = new Random();
		int numOfPomegranates = random.nextInt(MAX_POMEGRANATES - MIN_POMEGRANATES + 1) + MIN_POMEGRANATES;
		List<Pomegranate> pomegranates = new ArrayList<>();
		for (int i = 0; i < numOfPomegranates; i++) {
			pomegranates.add(new Pomegranate(generateRandomSeeds()));
		}
		return pomegranates;
	}

	private static List<Seed> generateRandomSeeds() {
		Random random = new Random();
		int numOfSeeds = random.nextInt(MAX_SEEDS - MIN_SEEDS + 1) + MIN_SEEDS;
		List<Seed> seeds = new ArrayList<>();
		for (int i = 0; i < numOfSeeds; i++) {
			seeds.add(new Seed(2.0));
		}
		return seeds;
	}
	private static int calculateTotalSeeds(List<Box> boxes) {
	return boxes.stream()
						.mapToInt(Box :: getTotalSeeds)
						.sum();
	}
	private static int calculateMaxSeeds(List<Box> boxes) {
	return boxes.stream()
						.mapToInt(Box::getTotalSeeds)
						.max()
						.orElse(0);
	}
//	private static List<String> findMaximumSeedsBoxes(List<Box> boxes) {
//	return boxes.stream()
//						.sorted()
//						.limit(5)
//						.orElse
//	}

}
