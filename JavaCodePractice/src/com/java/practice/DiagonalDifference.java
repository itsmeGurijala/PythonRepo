package com.java.practice;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		
		//Scanner class is used to read inputs from console
		Scanner in = new Scanner(System.in);
		
		//take the size of the matrix from the user
		System.out.println("enter the size of matrix ");
		int size = in.nextInt();
		
		//create a matrix(array of arrays) with given size.
		int[][] matrix = new int[size][size];
		
		//read the values from console one by one  
		System.out.println("Enter the values of matrix on by one");
		int temp;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.println("Enter the element at position "+i+""+j+"");
				temp = in.nextInt();
				matrix[i][j] = temp;
			}
		}
		displayMatrix(matrix);
		int diagonalDiffference = calculateDiagonalDiff(matrix, size);
		System.out.println("Diagonal difference for given matrix is "+diagonalDiffference);
		
	}
	public static int calculateDiagonalDiff(int[][] matrix, int size) {
		int diagonal1Sum = 0,diagonal2Sum =0;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i == j)
					diagonal1Sum += matrix[i][j];
				if(i == size-j-1) 
					diagonal2Sum += matrix[i][size-j-1];
			}
		}
		
		return diagonal1Sum - diagonal2Sum;
	}
	public static void displayMatrix(int[][] matrix) {
		System.out.println("Matrix you have entered is ");
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2 +" ");
			}
			System.out.println();
		}
	}
}
