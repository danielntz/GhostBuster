package com.example.UI;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.UI.GameViewGhost.ghost;
import com.example.data.Point;
import com.example.ghostbuster.R;
/**
 * ���������
 * @author jsjxy
 *
 */
   public class GameViewFall  extends  View {
    
	          private  Paint paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
	          private   Bitmap   bitmaptreasure  ;   //����
	          private   float    prize_x;
	          private    float  prize_y;
	          private   Random random  = new Random();
	
	public GameViewFall(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GameViewFall(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public GameViewFall(Context context, AttributeSet attrs) {
		super(context, attrs);
        //��ʼ��
	   bitmaptreasure  =  BitmapFactory.decodeResource(getResources(), R.drawable.prize0);
	   prize_x = (float) Math.abs(random.nextFloat()*800.0);     //��Χ0 ��800
	   prize_y =  0.0f;
	  new Thread(new jiangli()).start();
	}
	//���Ʊ��ص�����켣
	public  void   huizhixialuo( float  x , float  y, Canvas  canvas){
		      canvas.drawBitmap(bitmaptreasure, x, y, paint);
	}
   //��ͼ
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		//super.onDraw(canvas);
		  huizhixialuo(prize_x, prize_y, canvas);
	   }
	
	public  class   jiangli implements Runnable{

		@Override
		public void run() {
		     
			// TODO Auto-generated method stub
			        while(true){
			        	  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	 prize_y   +=20;
			        	 postInvalidate();     //���»���
			       }
		}
		
	}

}
