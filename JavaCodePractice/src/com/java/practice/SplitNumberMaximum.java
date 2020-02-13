package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
/*
 * This class is useful to find the possible pairs and their sum of individual digits of numbers 
 */
public class SplitNumberMaximum {
	
	public static int count =0;
	public static void main(String[] args) {
		int no=132;
		int n=1;
		// map to store two numbers as an entry
		Map<Integer, Integer> pair;
		// map to store key as sum of digits and value as map which contains number pairs 
		//This tree map stores the keys in ascending order by default
		TreeMap<Integer, Map<Integer, Integer>> pairs = new TreeMap<Integer, Map<Integer,Integer>>();
		int[] maxpair = {0,0};
		int maxNum =0;
		int totalPairs =0;
		int  size = (no%2==0) ? (no/2)+1 : (no+1)/2;
	//Iterating the loop to get the possible pairs 
		while(n< size) {
			int sum =sumIndividuals(n,no-n);
			if(sum>=maxNum) {
				maxNum = sum;
			}
		//checking for entry is exists in the map
				if(pairs.containsKey(sum)) {
					pair = pairs.get(sum);
					pair.put(n, no-n);
					pairs.put(sum, pair);
				}else {
				pair = new HashMap<Integer, Integer>();
				pair.put(n, no-n);
				pairs.put(sum, pair);
				}
			n++;
		}	
		//printing the pairs
		pairs.forEach((sum,entry) -> {
			System.out.println("Sum of digits is "+ sum +" and it has "+entry.size()+" pairs");
			System.out.println("possible pairs are below");
			count += entry.size();
			entry.forEach((key,value) ->{
				System.out.print(key +" "+value +", ");
			});
			System.out.println();
		});
		
		System.out.println("The total pairs are "+ count);
	}
	/*
	 * Method to  find the sum of individual digits of given two numbers
	 */
	public static int sumIndividuals(int n1, int n2) {
		//converting an integer of array of digits
		int[] n1ar =Integer.toString(n1).chars().map(c -> c-'0').toArray();
		int[] n2ar =Integer.toString(n2).chars().map(c -> c-'0').toArray();
		// inbuilt functions to add all the elements in an array.
		 int n1sum = Arrays.stream(n1ar).sum();
		 int n2sum = Arrays.stream(n2ar).sum();
		 return n1sum+n2sum;
	}
}
