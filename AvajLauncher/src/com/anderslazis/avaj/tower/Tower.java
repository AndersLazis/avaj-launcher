package com.anderslazis.avaj.tower;
import com.anderslazis.avaj.aircrafts.Flyable;
import com.anderslazis.avaj.simulator.AnsiColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tower{
private List<Flyable> observedAircrafts = new ArrayList<>();

 public void register(Flyable p_flyable){
	 System.out.println(AnsiColor.colorize(("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() +
			 "(" + p_flyable.getId() + ")" +  " registered to the weather tower."), AnsiColor.BLUE));
	 observedAircrafts.add(p_flyable);
 }

 public void unregister (Flyable p_flyable){
	 	observedAircrafts.remove(p_flyable);
	}

 protected void conditionChanged(){

	 //System.out.println("OBSERVED: " + observedAircrafts);
	 Stack<Flyable> toDelete = new Stack<>();

	 for (int i = 0; i < observedAircrafts.size(); i++) {
		 observedAircrafts.get(i).updateConditions();

		 if (observedAircrafts.get(i).getHeight() <= 0) {
			 // unregister(observedAircrafts.get(i));
			 System.out.println(AnsiColor.colorize(("Tower says: " + observedAircrafts.get(i).getType() + "#" + observedAircrafts.get(i).getName() +
					 "(" + observedAircrafts.get(i).getId() + ")" + " unregistered from the weather tower."), AnsiColor.GREEN));
			 toDelete.add(observedAircrafts.get(i));
		 }
	 }
	 while (!toDelete.isEmpty()) {
		 unregister(toDelete.pop());
	 }
	 //System.out.println("OBSERVED AFTER DELETE: " + observedAircrafts);
	 }
 }
