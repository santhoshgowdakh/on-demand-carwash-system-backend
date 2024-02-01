package com.carwash.promocodeservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {

	public static List<Integer> modify(List<Integer> arr) {
		List<Integer> list=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
//			for (int j = i; j < arr.size(); j++) {
//				if(arr.get(i)==arr.get(j)) {
//					continue;
//				}
//			}
			if(arr.get(i)%2!=0) {
				list.add(arr.get(i));
			}
			if(arr.get(i)%2==0) {
				list2.add(arr.get(i));
			}
		}
		Collections.sort(list);
		Collections.sort(list2);
		list.addAll(list2);
		
		return list;
	}
	
    public static void main(String[] args) {
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(1);
    	list.add(3);
    	list.add(6);
		list=modify(list);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
