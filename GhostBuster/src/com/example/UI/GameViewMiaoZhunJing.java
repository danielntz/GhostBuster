package com.example.UI;

import java.io.IOException;

import com.example.UI.GameViewGhost.ghost;
import com.example.data.Point;
import com.example.function.PlayVoice;
import com.example.function.TransitData;
import com.example.ghostbuster.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameViewMiaoZhunJing  extends View{
      
	
	     private static final String TAG = null;
		private   Paint   paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	      private   Bitmap       miaozhunqi; 
	      private   int     move_action  = 0 ;                                                           // 0�����޶�����1�������¶����� 2 ����̧������ 3 �����ƶ�����
	     private   float   screenX , screenY;                                                   //�����Ļ�ϵ���ĵ������
	     private   float  x , y;
	     private   PlayVoice    voice;       
	     private   MediaPlayer   player = null;
	     private   Point    miaozhun = new  Point();
	     private   Point   ghosts[] ;
	     private   int   dianjicishu = 0;
	    
	     public GameViewMiaoZhunJing(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GameViewMiaoZhunJing(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public GameViewMiaoZhunJing(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//	setOnClickListener(this);
		voice = new PlayVoice(player,getContext());
	   //��ʼ��
		

}
     //��ͼ����
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		    
		   
		  action(screenX, screenY, move_action, canvas);
		
}
	
	public  void  action(  float  x , float y , int   move_action , Canvas canvas){
	    switch (move_action) {
		case 1:      // down����
			 miaozhunqi  = BitmapFactory.decodeResource(getResources(), R.drawable.miaozhunqi);
	//		  processresult(screenX, screenY);
		     canvas.drawBitmap(miaozhunqi, x, y, paint);
		     try {
				  voice.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case  2:    //up����
			 
			 break;
			 
		case 3:    //�ƶ�����
			break;
		
		}
}
	
	public   boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {


		case  MotionEvent.ACTION_DOWN:
                    move_action =1 ;
			        screenX  = x ;
			        screenY = y ;
			        miaozhun.ghostX =screenX;
			        miaozhun.ghostY = screenY;
			        TransitData.setIsdown(true);  
			        TransitData.setMiaozhunpoints(miaozhun);
			       //�õ�ǰ����׼������͵�ǰ������������бȽϣ��������������˵�����У����ϴ���˵��û������
			       TransitData.setZidanshu(true);
			        break;

		case MotionEvent.ACTION_MOVE:
		         move_action =2 ;
			      break;

		case MotionEvent.ACTION_UP:
			move_action =3;
		         	break;
        
		}
	  postInvalidate();
		  return true;
	}
	//�����ж��Ƿ����еķ���
	public  void  processresult(float  miaozhunX , float  miaozhunY){
		
		   ghosts = TransitData.getGhostpoints();
		
		   for(int  ghostcount = 0 ;  ghostcount < ghosts.length ; ghostcount ++){
		           if(   Math.abs (miaozhunX  -  ghosts[ghostcount].ghostX)  < 60&& Math.abs(miaozhunY - ghosts[ghostcount].ghostY) <60){
		    	    	//Ŀ������
		    	  	  Log.i(TAG, "Ŀ������");
		    	  	  break;
		       }
		    	     
	  } 
	}
	

		  
}