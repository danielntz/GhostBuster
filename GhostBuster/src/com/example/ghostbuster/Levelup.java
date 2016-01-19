package com.example.ghostbuster;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.function.TransitData;
import com.example.ghostbuster.R;
/**
 * ������ɫ������������
 * @author jsjxy
 *
 */
public class Levelup   extends Activity  implements OnClickListener,OnSeekBarChangeListener{
             
	   private static final String TAG = null;
	//  PopupWindow  tanchu  = new PopupWindow();
	 //�����ȼ���������
	   private    Button    OK  ;
	   private   Button   Cancel;
	   private  SeekBar   power , intelligence, life;
	   private   ImageView  power_plus , intelligence_plus, life_plus;
	   private   TextView   name,level,skillcount;
	
	    
	   
      @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.hero_level_activity);
		initlevel();
	}
	
      public  void  initlevel()
      {
    	//��ʼ��������ť     
	        OK = (Button)findViewById(R.id.ok);
	        Cancel = (Button)findViewById(R.id.cancel);
	      //��ʼ��3��������
	        power = (SeekBar)findViewById(R.id.powerseekbar);
	        intelligence = (SeekBar)findViewById(R.id.intelligenceseekbar);
	        life = (SeekBar)findViewById(R.id.lifeseekbar);
	       power_plus = (ImageView)findViewById(R.id.poweradd);
	       intelligence_plus = (ImageView)findViewById(R.id.intelligenceadd);
	       life_plus  = (ImageView)findViewById(R.id.lifeadd);
	       name = (TextView)findViewById(R.id.hero_name);
	       level = (TextView)findViewById(R.id.level);
	       skillcount = (TextView)findViewById(R.id.dotcount);
	       OK.setOnClickListener(this);
	       Cancel.setOnClickListener(this);
	       power_plus.setOnClickListener(this);
	       intelligence_plus.setOnClickListener(this);
	       life_plus.setOnClickListener(this);
	       life.setOnSeekBarChangeListener(this);
      }
/*	//��ʾ��ɫ������������
	 public    void levelupshow(){
		   View view =  inflater.inflate(R.layout.hero_level_activity, null);
           tanchu = new PopupWindow(view,470,270);       //����������Ϊ��Ⱥ͸߶�
           tanchu.showAtLocation(((Activity) context).findViewById(R.id.GhostView),Gravity.TOP,30,130); //������λ�ã�������Ϊ�������������
      }*/
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		      switch (v.getId()) {
		      case    R.id.cancel:
		    	             TransitData.setjianting(true);
		    	             finish();
		    	             break;
			case R.id.ok :
				      TransitData.setjianting(true);
				      finish();
				       break;
		
			}
	}

@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
	// TODO Auto-generated method stub
	       
}

@Override
public void onStartTrackingTouch(SeekBar seekBar) {
	// TODO Auto-generated method stub
	           Toast.makeText(getApplicationContext(), "fefw", 0).show();
	            
}

@Override
public void onStopTrackingTouch(SeekBar seekBar) {
	// TODO Auto-generated method stub
	  Toast.makeText(getApplicationContext(), "tttt", 0).show();
}
	
	
}
