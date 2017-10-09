package be.pxl.week3.opdracht1;

import java.util.ArrayList;

public class Gearbox {
	private int maxGears;
	private boolean clutch;
	private int currentGear = 0;
	private ArrayList<Gear> gearList;

	public Gearbox(int gears) {
		this.maxGears = gears;
		this.gearList = new ArrayList<>();
		operateClutch(clutch);
		for(int i = 0; i <= maxGears; i++){
			addGear(i, i*5.3);
		}
	}

	public void operateClutch(boolean clutch2) {
		clutch = clutch2;

	}

	public int getMaxGears() {
		return maxGears;
	}

	public void setMaxGears(int maxGears) {
		this.maxGears = maxGears;
	}

	public boolean isClutch() {
		return clutch;
	}

	public void setClutch(boolean clutch) {
		this.clutch = clutch;
	}
	
	public void addGear(int number, double ratio){
		if (number >= 0 && number <= maxGears) {
			gearList.add(new Gear(number, ratio));
		}
	}

	private class Gear {
		private int gearNumber;
		private double ratio = 5.3;

		public Gear(int gearNumber, double ratio) {
			this.gearNumber = gearNumber;
			this.ratio = ratio;
	}

		public double drivespeed(int revs) {
			return revs * ratio;
		}
	}
	
	public void changeGear(int newGear){
		if(clutch){
			if(newGear >= 0 && newGear <= maxGears){
				currentGear = newGear;
				System.out.println("Gear " + currentGear + " selected");
			}
		} else {
			currentGear = 0;
			System.out.println("Grind!");
		}
	}
	
	public double wheelSpeed(int revs){
		if(clutch) {
			System.out.println("Grind!");
			return 0;
		} else {
			return gearList.get(currentGear).drivespeed(revs);
		}
	}

	/*private int maxGears;
	private boolean clutchIsIn = false;
	private Gear[] gears;
	private int counter = 0;
	private int currentGear = 0;
	
	public Gearbox(int maxGears) {
		this.maxGears = maxGears;
		gears = new Gear[maxGears];
		for (int i = 0; i < maxGears; i++) {
			addGear(new Gear(i));
		}
	}
	
	public double wheelSpeed(int revs) {
		if (clutchIsIn == true) {
			System.out.println("Grind!");
			return 0;
		} else {
			return gears[currentGear].driveSpeed(revs);
		}	
	}
	
	public void changeGear(int newGear) {
		if(clutchIsIn == true) {
			currentGear = newGear;
			System.out.println("Gear " + newGear + " selected");
		} else {
			System.out.println("Grind!");
			currentGear = 0;
		}
	}
	
	private class Gear {
		private int gearNumber;
		private double ratio = gearNumber * 5.3;
		
		public Gear(int number) {
			this.gearNumber = number;
		}
		
		public double getRatio() {
			return ratio;
		}
		
		public int getGearNumber() {
			return gearNumber;
		}
		
		public double driveSpeed(int revs) {
			return ratio*revs;
		}
	}
	
	private void addGear(Gear gear) {
		gears[counter] = gear;
		counter++;
	}
	
	public void setMaxGears(int maxGears) {
		this.maxGears = maxGears;
	}
	
	public void operateClutch(boolean in) {
		this.clutchIsIn = in;
	}*/
	
	
}
