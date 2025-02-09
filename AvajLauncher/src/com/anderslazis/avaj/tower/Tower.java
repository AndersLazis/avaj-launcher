package com.anderslazis.avaj.tower;
import com.anderslazis.avaj.aircrafts.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower{
private List<Flyable> observers = new ArrayList<>();

 public void register(Flyable p_flyable){
	 observers.add(p_flyable);
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