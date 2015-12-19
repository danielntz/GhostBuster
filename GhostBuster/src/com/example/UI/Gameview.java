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

	private  SlidingMenu  menu;     //获得侧滑菜单控件
	private   GameViewGhost  viewghost; 
	private   ImageButton   shop;
	private   int        guanka;              //第几关
	private   GameViewMiaoZhunJing   viewmiaozhunjing;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//	setBehindContentView(R.layout.shangdiancehua_activity);    //侧滑菜单,继承SlidingFragmentActivity才行
		setContentView(R.layout.gameview_activity);
		init();
		tanchucehua();

	}
	/**
	 * 在此界面的任何地方都能直接右滑显示出侧滑界面加上setBehindContentView 方法
	 */
	/*  public  void  cehuainit(){
		         menu = getSlidingMenu();         //获得侧滑菜单
		         menu.setMode(SlidingMenu.RIGHT);   //右滑
		         menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //内容页剩余的宽度
		 	//   	menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //在此界面任何地方都能右滑
		 	   	menu.setFadeDegree(0.35f);
	  }*/
	/**
	 * 点击按钮出现侧滑菜单
	 */
	public  void  tanchucehua(){
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //在此界面任何地方都能右滑
		menu.setMenu(R.layout.shangdiancehua_activity);
		menu.setFadeDegree(0.35f);
		menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //内容页剩余的宽度
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		//    menu.showMenu();            // 显示menu
		// menu.showContent();         //显示内容
	}
	public  void   init(){
	
		shop = (ImageButton)findViewById(R.id.shop);
		viewghost = (GameViewGhost)findViewById(R.id.GhostView);
		viewmiaozhunjing  = (GameViewMiaoZhunJing) findViewById(R.id.MiaoZhunJingView);
		shop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shop:
		        	menu.toggle(true);      //弹出侧滑菜单
 
			break;


		}
	}

}
