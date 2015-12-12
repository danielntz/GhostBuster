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
	private   float    width ;      //view�Ŀ��
	private   float    height;    //view�ĸ߶�
	private   Paint    screenpaint = new Paint();    //��������д���ֵĻ���
	private   Paint    bitmappaint = new Paint(Paint.ANTI_ALIAS_FLAG);   //��bitmap�Ļ���
	//��Ļ�������ϵ�����
	private   String  time = "ʱ��:";
	private   int  timezi = 180;
	private  String   score = "����";
	private  int  scorezi = 0;
	private  int   count = 1000;
	private  Bitmap   zidan;                                   //�ӵ�ͼƬ
	private  boolean Initflag  = false;             //��ʼ����־
	private  float    x , y;                                          //��õ�ǰ������x��y����
	//Ghostͼ��
	private   Bitmap  ghost ;
	private   boolean   isplay = true;
	private   Point   points[] = new Point[5];

	private     int    j = 0;                                     //�����ж��ǵڼ�������



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

		new Thread(new ghost()).start();   //��ʼ������ĳ���
	}


	/**
	 * Ghost����ʾ��ʧ���и��ֲ���
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		//	super.onDraw(canvas);    //����Ҫ�õ�����

		initscreen(canvas);
		initghost(canvas);
	}

	//��ʼ�������������
	public  void   initghost(Canvas canvas){
		float   randomx ;      //������ֵ�X���� 
		float   randomy;      //������ֵ�Y����
		float   randomx1;
		float   randomy1;

		Random random = new Random();
		randomx = (float) Math.abs(random.nextFloat()*800.0);     //��Χ0 ��800
		randomy = (float) (Math.abs(random.nextFloat()*380.0)+32.0f);   //��Χ32��410
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

	//��ʼ����Ļ��Ϣ
	public   void    initscreen(Canvas canvas){

		width  = getWidth();     
		height = getHeight();
		Log.i(TAG, width+"");
		Log.i(TAG, height + "");
		zidan = BitmapFactory.decodeResource(getResources(), R.drawable.zidan);
		//���û��ʵĴ�С����ɫ������
		screenpaint.setColor(Color.GREEN);  //�������ɫ   
		screenpaint.setTextSize(32.0f);           //����Ĵ�С
		screenpaint.setStyle(Style.FILL);       //�����ķ��
		canvas.drawText(time, 0,30, screenpaint);              //30�������־�ĸ߶�
		canvas.drawText(timezi+"", 70, 30, screenpaint);
		canvas.drawText(score, 0, 442-5, screenpaint);	    
		canvas.drawText(scorezi+"", 70, 442-5, screenpaint);
		canvas.drawText(count+ "", 680, 442-5,screenpaint);
		canvas.drawBitmap(zidan,760, 353, bitmappaint);   //��ʼ�ӵ�����,��ͨ�ӵ�
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

	//����ĳ���
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
				//�жϵ÷֣��ж�ʣ���ӵ���
				postInvalidate();   //�ػ滭��




			}
		}

	}

}
