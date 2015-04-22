package com.openteach.qsync.api;

import java.util.Random;

public class RanomUtil {

	static Random r = new Random();
	public static int[] randomInteger(int total, int size) {
		
		int[] result = new int[size];
		int max = total;
		int min = 0;
		while(size > 0) {
			int everage = max / size;
			
			min = everage * (size - 1);
			int i = size == 1 ? max - min : r.nextInt(max - min);
			System.out.println("max:" + max + "   min:" + min + "  everage:" + everage + "   i:" + i);
			max = max - i;
			result[size - 1] = i;
			size --;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] r = randomInteger(1024, 10);
		int total = 0;
		for(int i : r) {
			System.out.println(i);
			total += i;
		}
		
		System.out.println("total: " + total);
	}
}
