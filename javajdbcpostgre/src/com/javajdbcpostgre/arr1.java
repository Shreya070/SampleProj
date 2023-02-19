package com.javajdbcpostgre;

public class arr1 {
	 public static void main(String[] args){
		   
		       int[] arr = { 4,5,8,7,4,7,6,7};
		      int n = arr.length;
		      int max_count = 0;
		      int maxfreq = 0;
		      for (int i = 0; i < n; i++){
		         int count = 0;
		         for (int j = 0; j < n; j++){
		            if (arr[i] == arr[j]){
		               count++;
		            }
		         }
		        
		         if (count > max_count){
		            max_count = count;
		            maxfreq = arr[i];
		         }
		      }
		    
		      System.out.print("Most frequent element is: " + maxfreq);
		   }

	}
