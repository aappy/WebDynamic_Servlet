package com.apex.server;

public class BasicCalc implements Calc {

	public int add(int i, int j) {
		return i + j;
	}

	public int sub(int i, int j) {
		return i - j;
	}

	public int prod(int i, int j) {
		return i * j;
	}
	public int div(int i, int j) {
		return i / j;
	}	
}
