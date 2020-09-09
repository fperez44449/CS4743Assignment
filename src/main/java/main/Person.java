package main;

import java.util.ArrayList;

public class Person {
public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

private String firstName;
private String LastName;
private int age;
private String dateOfBirth;

public Person(String firstName,String LastName,int i,String dateofBirth) {
	this.firstName = firstName;
	this.LastName = LastName;
	this.setAge(i);
	this.dateOfBirth=dateofBirth;
}

public int getAge() {
	return age;
}

public void setAge(int i) {
	this.age = i;
}
}
