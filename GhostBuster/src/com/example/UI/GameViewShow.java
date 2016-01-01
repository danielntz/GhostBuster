package com.example.UI;

import com.example.function.PlayVoice;
import com.example.function.TransitData;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameViewShow  extends View{
   
	   private static final String TAG = null;
	private  Paint  middlepaint = new Paint();   
	  private   String   roundcount = "R o u n d ";
	  private   int     count = 0;                                          //Ĭ�Ϲ���
	 private   final   int   scorecount = 100;             //ÿһ�ٷ����һ�� 
	 private   int     currentscore = 0 ;                         //��ǰ�ķ���
	 private    boolean    flag = true;
	private     int     disappear ;
	public GameViewShow(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@SuppressLint("NewApi")
	public GameViewShow(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
	}

	public GameViewShow(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public GameViewShow(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//��ʼ��
	   middlepaint.setTextSize(50.0f);
	   middlepaint.setColor(Color.GREEN);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
	   //��ͼ����
		if(flag)
		{
			canvas.drawText(roundcount + count +"", 260, 220, middlepaint);
			count++;
	    }
		if(TransitData.isJudge()){
			 canvas.drawText(roundcount + count +"", 260, 220, middlepaint);
			 count++;
		}
	  //����ʹ����Ļ�ϵ�������ʧ
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				      try {
						Thread.sleep(2000);
					    flag = false;
					    TransitData.setJudge(false);
						postInvalidate();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();
		
				
			
		
		
		
	}


}



