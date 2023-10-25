package com.crud.crudproject.experiment;

import java.awt.Container;

public class Box<T>{

	T container;
	
	public Box(T container){
		this.container=container;
	}
	
// public Object getValue() {
//	 
//	 return this.container;
// }
 
 public void performSomeTask() {
	 
	 if(container instanceof String) {
		 System.out.println("this is my first generic example");
	 }else if (container instanceof Integer) {
		System.out.println("this conatiner have integer value" +container);
	}
 }
}
