package com.example.data;

public class Point {

	public    float      ghostX;
	public    float     ghostY;
	
	
	public  Point(){
		
	}
	
	public Point( float x , float y){
		   this.ghostX = x;
		   this.ghostY = y;
	}
	public float getGhostX() {
		return ghostX;
	}
	public void setGhostX(float ghostX) {
		this.ghostX = ghostX;
	}
	public float getGhostY() {
		return ghostY;
	}
	public void setGhostY(float ghostY) {
		this.ghostY = ghostY;
	}




}
