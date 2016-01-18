package com.example.UI;


import com.example.GridViewAdapter.GridViewAdapter;
import com.example.data.Ghost;
import com.example.function.TransitData;
import com.example.ghostbuster.MainActivity;
import com.example.ghostbuster.R;
import com.example.listener.OnActionListener;
import com.example.listener.OnScoreListener;
import com.example.listener.dataload;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Gameview  extends Activity implements OnClickListener, OnItemClickListener{

	protected static final String TAG = null;
	private  SlidingMenu  menu;     //获得侧滑菜单控件
	private   GameViewGhost  viewghost; 
	private   ImageButton   shop;
	private   int        guanka;              //第几关
	private   GameViewMiaoZhunJing   viewmiaozhunjing;
	private   GameViewFall       dropprize;
	private   GridView    select_view;
	private   GridViewAdapter adapter;
	private    GameViewShow  showtitle;
	private    int  beforescore   = 0 ;     //当分数没有改变时，屏幕不做任何处理
   private    boolean   first = true;
   private   boolean    levelup = false;   //判断是否升级 ，升级弹出升级界面，没有升级不弹出升级界面
  private    boolean    jiantingcondition = true;
  private   PopupWindow   tanchu = new PopupWindow();
 //弹出等级升级界面
  private    Button    OK  ;
  private   Button   Cancel;
  private  SeekBar   power , intelligence, life;
  private   ImageView  power_plus , intelligence_plus, life_plus;
  private   TextView   name,level,skillcount;
  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//	setBehindContentView(R.layout.shangdiancehua_activity);    //侧滑菜单,继承SlidingFragmentActivity才行
		setContentView(R.layout.gameview_activity);
		init();
		tanchucehua();
		viewmiaozhunjing.setOnActionListener(new OnActionListener() {
			
			@Override
			public void ghoststate(boolean state) {
				// TODO Auto-generated method stub
				       viewghost.postInvalidate();
			}
			
			@Override
			public void bulletcondition() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addscore() {
				// TODO Auto-generated method stub
				
			}
		});
		//设置监听
	
			    	      viewghost.setOnScoreListener(new OnScoreListener() {
			    			
			    			@Override
			    			public void getcount(int score) {
			    				         //每获得150分则升一级
			    				   if(score % 150 == 0 && score != 0){
			    					           levelup = true;
			    					      //     jiantingcondition = true;
			    					//当分数每达到150分时，就会弹出升级界面
			    							if(levelup && jiantingcondition){
			    							tanchucaidan();    //显示弹出菜单
			    							jiantingcondition = false;
			    							}
			    				   }
			    				   else{
			    					    levelup = false;
			    			      }
			    				      
			    				   if(first)
			    				   {
			    				    	 showtitle.postInvalidate();
			    				    	 first = false;
			    				   }
			    		
			    				   if((  score != 0 &&beforescore != score && score %100 == 0)){
			    					     TransitData.setJudge(true);
			    					     showtitle.postInvalidate();
			    			  }
			    				   
			    				     beforescore = score;
			    			}
	            });	   
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
	
	  public void tanchucaidan(){
		              View view = getLayoutInflater().inflate(R.layout.hero_level_activity, null);
		              tanchu = new PopupWindow(view,470,270);       //后两个参数为宽度和高度
		              tanchu.showAtLocation(this.findViewById(R.id.GhostView),Gravity.TOP,30,130); //弹出的位置，后两个为横坐标和纵坐标
	                     
	  }
	/**
	 * 点击按钮出现侧滑菜单
	 */
	public  void  tanchucehua(){
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //在此界面任何地方都能右滑
		menu.setMenu(R.layout.shangdiancehua_activity);
		menu.setFadeDegree(0.35f);                                                                     //淡入淡出
		menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);       //内容页剩余的宽度
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		select_view =(GridView) findViewById(R.id.select_photo);
		adapter = new GridViewAdapter(this);
		select_view.setAdapter(adapter);
		select_view.setOnItemClickListener(this);
		
		//    menu.showMenu();            // 显示menu
		// menu.showContent();         //显示内容
		
		
	}
	public  void   init(){
	
		shop = (ImageButton)findViewById(R.id.shop);
		viewghost = (GameViewGhost)findViewById(R.id.GhostView);
		dropprize = (GameViewFall)findViewById(R.id.dropprize);
		viewmiaozhunjing  = (GameViewMiaoZhunJing) findViewById(R.id.MiaoZhunJingView);
		select_view = (GridView)findViewById(R.id.select_photo);
		showtitle = (GameViewShow)findViewById(R.id.showtitle);
		shop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shop:
		        	menu.toggle(true);      //弹出侧滑菜单
                	break;
		case R.id.ok:
			       break;
		case R.id.cancel :
			       tanchu.dismiss();
			       break;

		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		              switch (position) {
					case 0:
					menu.toggle(false);
						break;
				case 1:
						  menu.toggle(false);
							break;
			 case 2:
						 menu.toggle(false);
							break;
					
					}
	}
	/**
	 * 初始化等级升级界面的信息
	 */
	public   void   inittanchujiemian(){
		       //初始化两个按钮     
		        OK = (Button)findViewById(R.id.ok);
		        Cancel = (Button)findViewById(R.id.cancel);
		      //初始化3个进度条
		        power = (SeekBar)findViewById(R.id.powerseekbar);
		        intelligence = (SeekBar)findViewById(R.id.intelligenceseekbar);
		        life = (SeekBar)findViewById(R.id.lifeseekbar);
		       power_plus = (ImageView)findViewById(R.id.poweradd);
		       intelligence_plus = (ImageView)findViewById(R.id.intelligenceadd);
		       life_plus  = (ImageView)findViewById(R.id.lifeseekbar);
		       name = (TextView)findViewById(R.id.hero_name);
		       level = (TextView)findViewById(R.id.level);
		       skillcount = (TextView)findViewById(R.id.dotcount);
		       OK.setOnClickListener(this);
		       Cancel.setOnClickListener(this);
		       power_plus.setOnClickListener(this);
		       intelligence_plus.setOnClickListener(this);
		       life_plus.setOnClickListener(this);
		       
		        
	}
	

}
