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
	private  SlidingMenu  menu;     //��ò໬�˵��ؼ�
	private   GameViewGhost  viewghost; 
	private   ImageButton   shop;
	private   int        guanka;              //�ڼ���
	private   GameViewMiaoZhunJing   viewmiaozhunjing;
	private   GameViewFall       dropprize;
	private   GridView    select_view;
	private   GridViewAdapter adapter;
	private    GameViewShow  showtitle;
	private    int  beforescore   = 0 ;     //������û�иı�ʱ����Ļ�����κδ���
   private    boolean   first = true;
   private   boolean    levelup = false;   //�ж��Ƿ����� �����������������棬û��������������������
  private    boolean    jiantingcondition = true;
  private   PopupWindow   tanchu = new PopupWindow();
 //�����ȼ���������
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
		//	setBehindContentView(R.layout.shangdiancehua_activity);    //�໬�˵�,�̳�SlidingFragmentActivity����
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
		//���ü���
	
			    	      viewghost.setOnScoreListener(new OnScoreListener() {
			    			
			    			@Override
			    			public void getcount(int score) {
			    				         //ÿ���150������һ��
			    				   if(score % 150 == 0 && score != 0){
			    					           levelup = true;
			    					      //     jiantingcondition = true;
			    					//������ÿ�ﵽ150��ʱ���ͻᵯ����������
			    							if(levelup && jiantingcondition){
			    							tanchucaidan();    //��ʾ�����˵�
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
	 * �ڴ˽�����κεط�����ֱ���һ���ʾ���໬�������setBehindContentView ����
	 */
	/*  public  void  cehuainit(){
		         menu = getSlidingMenu();         //��ò໬�˵�
		         menu.setMode(SlidingMenu.RIGHT);   //�һ�
		         menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //����ҳʣ��Ŀ��
		 	//   	menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //�ڴ˽����κεط������һ�
		 	   	menu.setFadeDegree(0.35f);
	  }*/
	
	  public void tanchucaidan(){
		              View view = getLayoutInflater().inflate(R.layout.hero_level_activity, null);
		              tanchu = new PopupWindow(view,470,270);       //����������Ϊ��Ⱥ͸߶�
		              tanchu.showAtLocation(this.findViewById(R.id.GhostView),Gravity.TOP,30,130); //������λ�ã�������Ϊ�������������
	                     
	  }
	/**
	 * �����ť���ֲ໬�˵�
	 */
	public  void  tanchucehua(){
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);   //�ڴ˽����κεط������һ�
		menu.setMenu(R.layout.shangdiancehua_activity);
		menu.setFadeDegree(0.35f);                                                                     //���뵭��
		menu.setBehindOffsetRes(R.dimen.sliding_menuoffset);       //����ҳʣ��Ŀ��
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		select_view =(GridView) findViewById(R.id.select_photo);
		adapter = new GridViewAdapter(this);
		select_view.setAdapter(adapter);
		select_view.setOnItemClickListener(this);
		
		//    menu.showMenu();            // ��ʾmenu
		// menu.showContent();         //��ʾ����
		
		
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
		        	menu.toggle(true);      //�����໬�˵�
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
	 * ��ʼ���ȼ������������Ϣ
	 */
	public   void   inittanchujiemian(){
		       //��ʼ��������ť     
		        OK = (Button)findViewById(R.id.ok);
		        Cancel = (Button)findViewById(R.id.cancel);
		      //��ʼ��3��������
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
