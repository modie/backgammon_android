package com.gna.bstrds.backgammon;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;

public abstract class Checker extends Point{
	public Checker(int x,int y){
		super(x,y);
	}
	abstract public void draw(Canvas g,Resources res , int x ,int y ,int w,int h);
	public int getX() {
		return x;
	}
	public int getY(){
		return y ;
	}
	
	

}
