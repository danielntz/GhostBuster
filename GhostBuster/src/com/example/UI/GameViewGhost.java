package com.example.UI;

import java.util.Random;

import com.example.data.Point;
import com.example.data.bullet;
import com.example.function.TransitData;
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

	private  final   int  Count_Ghost = 6;
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
	private   Bitmap  ghost_attack0;
	private   boolean   isplay = true;
	private   Point   pointsappear[] = new Point[Count_Ghost];
	private   Point  pointsdisappear [] = new Point[Count_Ghost];

	private     int    j = 0;                                           //用来判断是第几个幽灵出现
	private    int    k = 0 ;                                           //用来判断是第几个幽灵消失
	private    boolean   judgeappear  = true ;                //true 代表幽灵显示，flase代表幽灵消失
	private    boolean   judgedisappear = true; 
	private   boolean    firstdisappear = false ;                         //第一次消失的标记
	private   Bitmap       miaozhunqi; 
	private   int     move_action  = 0 ;                                                           // 0代表无动作，1代表按下动作， 2 代表抬起动作， 3 代表移动动作
   private   float   screenX , screenY;                                       //获得屏幕上点击的点的坐标
  private    Point[]  point = new Point [6] ;

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
    //初始化刚开始幽灵的坐标,防止空指针问题
		for( int i = 0 ; i < 6 ; i++){
			 pointsappear[i] = new Point(0, 0);
	}
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
		if(TransitData.isIsdown()){              //幽灵被击中时的刷新图画
			   isjizhong(canvas);
		}
		TransitData.setIsdown(false);
		if(TransitData.isZidanshu())          //子弹减少时的刷新图画
		{  
			 count --;               //子弹数减少
	      	canvas.drawText(count+ "", 680, 442-5,screenpaint);
	      	TransitData.setZidanshu(false);
		}
		else{
		 	canvas.drawText(count+ "", 680, 442-5,screenpaint);
		}
		
	}
	

	//初始化幽灵随机出现和消失
	public  void   initghost(Canvas canvas){
		float   randomx ;      //随机出现的X坐标 
		float   randomy;      //随机出现的Y坐标
		float   randomx1;
		float   randomy1;

		Random random = new Random();
		randomx = (float) Math.abs(random.nextFloat()*800.0);     //范围0 到800
		randomy = (float) (Math.abs(random.nextFloat()*380.0)+32.0f);   //范围32到410
		if( j < 6 && judgeappear){                                                                                                           //一次在屏幕上能够出现6个鬼魂，一秒显示一个
			pointsappear [j]  = new Point(randomx, randomy)  ;                              //保存出现幽灵的位置
			pointsdisappear[k] = new Point(randomx, randomy);                         //保存幽灵消失的位置
			TransitData.setGhostpoints(pointsappear);                                               //保存和瞄准器相同的坐标
		//   point  = TransitData.getGhostpoints();
		//    Log.i(TAG, point[j].ghostX +"" +"坐标" +point[j].ghostY +""); 
		    
			for(int i = j; i >= 0 ; i-- ){
				ghost = BitmapFactory.decodeResource(getResources(), R.drawable.ghost0);
				canvas.drawBitmap(ghost, pointsappear[i].ghostX, pointsappear[i].ghostY, bitmappaint);
			
			}
			j++;
			k++;
           firstdisappear = false;
		}
		else
		{  
			j =0;
			judgedisappear = false;
			firstdisappear = true;
			
		}
		if( !judgedisappear ){
			for( int  q = 5  ; q> j ; q --){
				ghost = BitmapFactory.decodeResource(getResources(), R.drawable.ghost0);
		        canvas.drawBitmap(ghost, pointsdisappear[q].ghostX, pointsdisappear[q].ghostY, bitmappaint);
			}
			if(firstdisappear)
			k = 0;
		}
	}
	
	//获得点击之后的反馈响应,是否击中了幽灵
	  public   void  isjizhong(Canvas canvas){
		     Point   jizhong = new Point();
		     jizhong = TransitData.getMiaozhunpoints();
		     float  x = jizhong.getGhostX();
		     float y = jizhong.getGhostY();
	
			   for(int  ghostcount = 0 ;  ghostcount < 6 ; ghostcount ++){
			           if(   Math.abs (x  -  pointsappear[ghostcount].ghostX)  < 60&& Math.abs(y - pointsappear[ghostcount].ghostY) <60)
			           {
			    	    	//目标命中
			    	  //	  Log.i(TAG, "目标命中");
			        	   ghost_attack0 = BitmapFactory.decodeResource(getResources(), R.drawable.ghost0_attcak);
			        	    canvas .drawBitmap(ghost_attack0, pointsappear[ghostcount].ghostX, pointsappear[ghostcount].ghostY, bitmappaint);
			    	  	  break;
			       }
			   }
		    
	  }
	


	//初始化屏幕信息
	public   void    initscreen(Canvas canvas){

		width  = getWidth();     
		height = getHeight();
		//Log.i(TAG, width+"");
	//	Log.i(TAG, height + "");
		zidan = BitmapFactory.decodeResource(getResources(), R.drawable.zidan);
		//设置画笔的大小，颜色和线条
		screenpaint.setColor(Color.GREEN);  //字体的颜色   
		screenpaint.setTextSize(32.0f);           //字体的大小
		screenpaint.setStyle(Style.FILL);       //线条的风格
		canvas.drawText(time, 0,30, screenpaint);              //30是上面标志的高度
		canvas.drawText(timezi+"", 70, 30, screenpaint);
		canvas.drawText(score, 0, 442-5, screenpaint);	    
		canvas.drawText(scorezi+"", 70, 442-5, screenpaint);

		canvas.drawBitmap(zidan,760, 353, bitmappaint);   //初始子弹种类,普通子弹
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

					Thread.sleep(500);

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
