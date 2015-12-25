package com.example.UI;

import java.io.IOException;

import com.example.UI.GameViewGhost.ghost;
import com.example.data.Point;
import com.example.function.PlayVoice;
import com.example.function.TransitData;
import com.example.ghostbuster.R;
import com.example.listener.OnActionListener;

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
	private   int     move_action  = 0 ;                                                           // 0代表无动作，1代表按下动作， 2 代表抬起动作， 3 代表移动动作
	private   float   screenX , screenY;                                                   //获得屏幕上点击的点的坐标
	private   float  x , y;
	private   PlayVoice    voice;       
	private   MediaPlayer   player = null;
	private   Point    miaozhun = new  Point();
	private   Point   ghosts[] ;
	private   int   dianjicishu = 0;
	private   Paint    screenpaint = new Paint();    //创建画笔写文字的画笔
	private   String score = "分数";
	private   int scorezi = 0;
	private   Bitmap  zidan;
	private   int    zidanshu = 1000;
	private   OnActionListener  lisener;
	private   Bitmap   bullethole ;
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
		//初始化


	}

	public   void initmiaozhunqi( Canvas canvas){
		screenpaint.setColor(Color.GREEN);  //字体的颜色   
		screenpaint.setTextSize(32.0f);           //字体的大小
		screenpaint.setStyle(Style.FILL);       //线条的风格
		canvas.drawText(score, 0, 442-5, screenpaint);	    
		canvas.drawText(scorezi+"", 70, 442-5, screenpaint);
		zidan = BitmapFactory.decodeResource(getResources(), R.drawable.zidan);
		canvas.drawBitmap(zidan,765, 358, paint);   //初始子弹种类,普通子弹
		canvas.drawText(zidanshu +"",690, 440, screenpaint);
	}

	//画图函数
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		initmiaozhunqi(canvas);
		action(screenX, screenY, move_action, canvas);

	}

	public  void  action(  float  x , float y , int   move_action , Canvas canvas){
		switch (move_action) {
		case 1:      // down操作
			miaozhunqi  = BitmapFactory.decodeResource(getResources(), R.drawable.miaozhunqi);
		
			//		  processresult(screenX, screenY);
			canvas.drawBitmap(miaozhunqi, x, y, paint);
			canvas.drawText(--zidanshu+"", 690, 440, paint);
		
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
		case  2:    //up操作

			break;

		case 3:    //移动操作
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
			if(this.lisener != null){
				lisener.ghoststate(true);
			}


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
	//用来判断是否命中的方法
	public  void  processresult(float  miaozhunX , float  miaozhunY){

		ghosts = TransitData.getGhostpoints();

		for(int  ghostcount = 0 ;  ghostcount < ghosts.length ; ghostcount ++){
			if(   Math.abs (miaozhunX  -  ghosts[ghostcount].ghostX)  < 60&& Math.abs(miaozhunY - ghosts[ghostcount].ghostY) <60){
				//目标命中
				Log.i(TAG, "目标命中");
				break;
			}
		} 
	}

  public   void  setOnActionListener (OnActionListener  listener){
	          if(listener != null){
	        	    this.lisener = listener;
	          }
  }


}
