package com.anderslazis.avaj.tower;
import com.anderslazis.avaj.aircrafts.Flyable;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class Tower{
private List<Flyable> observers = new ArrayList<>();

 public void register(Flyable p_flyable){
	 observers.add(p_flyable);
	 System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() +
			 "(" + p_flyable.getId() + ")" +  " registered to weather tower.");
 }
 public void unregister(Flyable p_flyable){
	 observers.remove(p_flyable);
  }
 protected void conditionChanged(){
	 for (Flyable item : observers){
		item.updateConditions();
	 }
 }
}