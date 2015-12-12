package com.example.UI;

import java.util.Random;

import com.example.data.Point;
import com.example.data.bullet;
import com.example.ghostbuster.R;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
public class GameViewGhost  extends View   {

	private static final String TAG = null;
	private   float    width ;      //view的宽度
	private   float    height;    //view的高度
	private   Paint    screenpaint = new Paint();    //创建画笔写文字的画笔
	private   Paint    bitmappaint = new Paint(Paint.ANTI_ALIAS_FLAG);   //画bitmap的画笔
	//屏幕三个角上的属性
	private   String  time = "时间:";
	private   int  timezi = 180;
	private  String   score = "分数";
	private  int  scorezi = 0;
	private  int   count = 1000;
	private  Bitmap   zidan;                                   //子弹图片
	private  boolean Initflag  = false;             //初始化标志
	private  float    x , y;                                          //获得当前动作的x和y坐标
	//Ghost图像
	private   Bitmap  ghost ;
	private   boolean   isplay = true;
	private   Point   points[] = new Point[5];

	private     int    j = 0;                                     //用来判断是第几个幽灵



	public GameViewGhost(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GameViewGhost(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public GameViewGhost(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//	setOnClickListener(this);

		new Thread(new ghost()).start();   //初始化幽灵的出现
	}


	/**
	 * Ghost的显示消失还有各种操作
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		//	super.onDraw(canvas);    //不需要用到父类

		initscreen(canvas);
		initghost(canvas);
	}

	//初始化幽灵随机出现
	public  void   initghost(Canvas canvas){
		float   randomx ;      //随机出现的X坐标 
		float   randomy;      //随机出现的Y坐标
		float   randomx1;
		float   randomy1;

		Random random = new Random();
		randomx = (float) Math.abs(random.nextFloat()*800.0);     //范围0 到800
		randomy = (float) (Math.abs(random.nextFloat()*380.0)+32.0f);   //范围32到410
		if( j < 5){
		points [j]  = new Point(randomx, randomy)  ;  
        for(int i = j; i >= 0 ; i-- ){
		ghost = BitmapFactory.decodeResource(getResources(), R.drawable.ghost0);
		canvas.drawBitmap(ghost, points[i].ghostX, points[i].ghostY, bitmappaint);
		Log.i(TAG, points[i].ghostX + " " + points[i].ghostY +"");
        }
		j++;
        }

	}

	//初始化屏幕信息
	public   void    initscreen(Canvas canvas){

		width  = getWidth();     
		height = getHeight();
		Log.i(TAG, width+"");
		Log.i(TAG, height + "");
		zidan = BitmapFactory.decodeResource(getResources(), R.drawable.zidan);
		//设置画笔的大小，颜色和线条
		screenpaint.setColor(Color.GREEN);  //字体的颜色   
		screenpaint.setTextSize(32.0f);           //字体的大小
		screenpaint.setStyle(Style.FILL);       //线条的风格
		canvas.drawText(time, 0,30, screenpaint);              //30是上面标志的高度
		canvas.drawText(timezi+"", 70, 30, screenpaint);
		canvas.drawText(score, 0, 442-5, screenpaint);	    
		canvas.drawText(scorezi+"", 70, 442-5, screenpaint);
		canvas.drawText(count+ "", 680, 442-5,screenpaint);
		canvas.drawBitmap(zidan,760, 353, bitmappaint);   //初始子弹种类,普通子弹
	}

	public   boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {


		case MotionEvent.ACTION_DOWN:

			break;

		case MotionEvent.ACTION_MOVE:
			break;

		case MotionEvent.ACTION_UP:
			break;

		}


		return true;
	}

	/*@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		    Toast.makeText(getContext(), "sdf", 0).show();
	}*/

	//幽灵的出现
	public   class  ghost implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isplay){
				try {

					Thread.sleep(3000);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
				timezi  --;
				//判断得分，判断剩余子弹数
				postInvalidate();   //重绘画面




			}
		}

	}

}
