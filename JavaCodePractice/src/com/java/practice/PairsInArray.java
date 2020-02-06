package com.java.practice;

import java.util.ArrayList;
import java.util.List;

public class PairsInArray {

	public static void main(String...args) {
		int[] input = {1,4,3,2,5,6,8,9};
		int sum =7;
		findPossiblePairs(input,sum);
	}
	
	public static void findPossiblePairs(int[] input, int n) {
		
		List<int[]> result = new ArrayList<int[]>();
		for(int i=0;i<input.length ;i++) {
			
			for(int j=i+1;j<input.length;j++) {
				
				if(input[i]+input[j] ==n) {
					int[] temp = {input[i],input[j]};
					result.add(temp);
				}
			}
		}
		
		for(int[] res:result) {
			System.out.println("["+res[0] +" "+ res[1]+"]");
		}
	
	}
	
	
}
