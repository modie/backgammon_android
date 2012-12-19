package com.gna.bstrds.backgammon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CheckerEmpty extends Checker{
	public CheckerEmpty(int x,int y)
	{
		super(x,y);
	}
	public void draw(Canvas g,Resources res,int x,int y,int w,int h)
	{
		//Bitmap im = BitmapFactory.decodeResource(res, R.drawable.pouliportok);
		//g.drawBitmap(im, null,new Rect(x*w,y*h,(x*w)+w,(y*h)+h),new Paint());
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof CheckerEmpty)
		{
			return true;
		}
		else
		{
			return false ;
		}
		
	}
	public String toString()
	{
		return "E";
	}
	public int getX(){
		return x ;
	}
	public int getY(){
		return y ;
	}

}