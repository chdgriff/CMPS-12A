/*
 * Assignment #5.
 * This program creates an object of a vector and has various methods to run
 * calculations with vectors.
 * 
 * 
 * Author: Chris Griffis <chdgriff@ucsc.edu>
 * 12/4/16
 */
public class Vector {
	//zero-arg Constructor.
	public Vector() {};
	
	//Constructor asigning values to create vectors.
	public Vector(double x, double y) {
		this.x  = x;
		this.y = y;
	}
	
	//Adds the vector coordinates from input to object vector and return a new vector.
	public Vector sum(Vector v) {
		Vector sum = new Vector();
		
		sum.x = x + v.x;
		sum.y = y + v.y;
		
		return sum;
	}
	
	//Subtracts inputed vector coordinates from object vector and returns a new vector.
	public Vector difference(Vector v) {
		Vector diff = new Vector();
		
		diff.x = x - v.x;
		diff.y = y - v.y;
		
		return diff;
	}
	
	//Finds the magnitude of the vector and rounds final value to 3 decimals
	public double magnitue() {
		double result = Math.hypot(x, y);
		result = (double)Math.round(result * 1000d) / 1000d;
		
		return result;
	}
	
	//Multiplies coordinates of vector by a number and returns a new vector
	public Vector scalorProd(double val) {
		Vector prod = new Vector();
		
		prod.x = x * val;
		prod.y = y * val;
		
		return prod;
	}
	
	//Calculates the dot product using the coordinates of vector and parameter v
	public double dotProd(Vector v) {
		return x * v.x + y * v.y;
	}
	
	//Finds angle of two vectors by finding the arccos of the dot product divided by
	//the product of both magnitudes and then rounds the result
	public double findAngle(Vector v) {
		double result = Math.acos(dotProd(v) / (magnitue() * v.magnitue()));
		result = (double)Math.round(result * 1000d) / 1000d;
		
		return result;
	}
	
	//Prints a coordinate format
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	//instance variables
	private double x, y;
}
