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
}
