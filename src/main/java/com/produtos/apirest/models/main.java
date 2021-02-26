//package com.produtos.apirest.models;
//
//public class main {
//
//	public static void main(String[] args) {
//		int[] v = new int[10];
//		v[0] = 1;
//		v[0] = 3;
//		v[0] = 6;
//		v[0] = 4;
//		v[0] = 1;
//		v[0] = 2;
//		System.out.println(solution(v));
//		
//	}
//
//	// you can also use imports, for example:
//	// import java.util.*;
//
//	// you can write to stdout for debugging purposes, e.g.
//	// System.out.println("this is a debug message");
//
//	public static int solution(int[] A) {
//
//		
//		int menor = 0;
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] < menor) {
//				menor = A[i];
//			}
//		}
//
//		for (int j = 0; j < A.length; j++) {
//			if (A[j] == menor) {
//				menor = A[j];
//				if (menor < 0) {
//					menor = menor + 1;
//				}else if (menor == 0 && A[j + 1] == -1) {
//					menor = 1;
//				}
//			}
//		}
//
//		return menor;
//	}
//	
//	public void existe(int val) {
//		
//	}
//	
//
//}
