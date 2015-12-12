package com.example.UI;


import com.example.data.Ghost;
import com.example.ghostbuster.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gameview  extends Activity implements OnClickListener{

	private  SlidingMenu  menu;     //��ò໬�˵��ؼ�
	private   GameViewGhost  viewghost; 
	private   ImageButton   shop;
	private   int        guanka;              //�ڼ���


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//	setBehindContentView(R.layout.shangdiancehua_activity);    //�໬�˵�,�̳�SlidingFragmentActivity����
		setContentView(R.layout.gameview_activity);
		init();
		tanchucehua();

	}
	/**
	 * �ڴ˽�����κεط�����ֱ���һ���ʾ���໬�������setBehindContentView ����
	 */
	/*  public  void  cehuainit(){
		         menu = getSlidingMenu();         //��ò໬�˵�
		         menu.setMode(SlidingMenu.RIGHT);   //�һ�
		         menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //����ҳʣ��Ŀ���
		 	//   	menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //�ڴ˽����κεط������һ�
		 	   	menu.setFadeDegree(0.35f);
	  }*/
	/**
	 * �����ť���ֲ໬�˵�
	 */
	public  void  tanchucehua(){
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //�ڴ˽����κεط������һ�
		menu.setMenu(R.layout.shangdiancehua_activity);
		menu.setFadeDegree(0.35f);
		menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //����ҳʣ��Ŀ���
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		//    menu.showMenu();            // ��ʾmenu
		// menu.showContent();         //��ʾ����
	}
	public  void   init(){
	
		shop = (ImageButton)findViewById(R.id.shop);
		viewghost = (GameViewGhost)findViewById(R.id.GhostView);
		shop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shop:
		        	menu.toggle(true);      //�����໬�˵�
 
			break;


		}
	}

}