/*
 * Assignment #5.
 * 
 * This is a test class to run and test each method from Class Vector.
 * 
 * Author: Chris Griffis <chdgriff@ucsc.edu>
 * 12/4/16
 */
public class VectorTest {
	public static void main(String[] args) {
		//Creates two vector objects
		Vector v1 = new Vector(3, 5);
		Vector v2 = new Vector(6, -20);
		//Prints both vectors
		System.out.println("Vector 1: " + v1 + "\nVector 2: " + v2 + "\n");
		
		//Prints examples of all methods from Class vector
		System.out.println("Sum of both vectors: " + v1.sum(v2));
		System.out.println("Difference of Vector 2 from Vector 1: " + v1.difference(v2));
		System.out.println("Magnitude of both vectors: \n\tVector 1: " + v1.magnitue()
							+ "\n\tVector 2: " + v2.magnitue());
		System.out.println("Both the product of each Vector by 11: \n\tVector 1: "
							+ v1.scalorProd(11) + "\n\tVector 2: " + v2.scalorProd(11));
		System.out.println("Dot product of both vectors: " + v1.dotProd(v2));
		System.out.println("Angle between both vectors: " + v1.findAngle(v2));
	}
}
