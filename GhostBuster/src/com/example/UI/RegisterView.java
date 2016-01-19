package com.example.UI;

import com.exampel.sqilite.PersonDao;
import com.exampel.sqilite.Personsqlite;
import com.example.ghostbuster.R;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 注册信息(除了名字自己写之外，等级，力量，智力，生命，由系统自己分配)
 * @author jsjxy
 *
 */

public class RegisterView  extends Activity  implements  OnClickListener{
    
	  private  EditText    hero_name;
	  private  Button       ok;
	  private  TextView    showattribute;
	  private    Personsqlite  personhelper = null;    
	 private      static  int    id = 1;        //注册的第几个人
	 PersonDao   dao = null;                                //PersonDao中含有对数据库操作的所有方法
	 private    int  level ;                                   //等级
	 private   String power,intelligence ,life;      //力量，智力，生命(打击次数，分数，时间)
	 private    TextView  show_xuhao,show_level;
	 private  TextView show_power,show_intelligence,show_life,show_name;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		personhelper = new Personsqlite(this);
		//创建或打开一个数据库，进行操作
		SQLiteDatabase  db = personhelper.getWritableDatabase();    //以读写的方式获得一个数据库实例，然后可以对它进行操作数据库用完要关闭
         init();
	
	}
	  public  void   init(){
		             hero_name = (EditText)findViewById(R.id.name);
		             ok = (Button)findViewById(R.id.ok);
		           show_xuhao = (TextView)findViewById(R.id.okxuhao);
		           show_level = (TextView)findViewById(R.id.oklevel);
		           show_name  = (TextView)findViewById(R.id.okname);
		           show_power = (TextView)findViewById(R.id.okpower);
		           show_intelligence = (TextView)findViewById(R.id.okintelligence);
		           show_life = (TextView)findViewById(R.id.oklife);
		           ok.setOnClickListener(this);
	  }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		   switch (v.getId()) {
		case R.id.ok:
			      //deleteallinfo();
		   if(hero_name.getText() != null){ 
			            String name = hero_name.getText().toString();
			    	    //写入数据库
			    	    writetosqlite(name,id);
			    	    id++;
			     }
			      else{
			    	   
			      }
		         break;

	
		}
	}
	//系统给定的属性设置
     public   void writetosqlite(String name , int  xuhao) {
		// TODO Auto-generated method stub
		               dao = new PersonDao(this);
		               level = 1;
		               power = "10";
		               intelligence ="10";
		               life = "5";
		             dao.addinfo(xuhao, name, level, power, intelligence, life);
		           
		            show_xuhao.setText(String.valueOf(xuhao));
		             show_level.setText(String.valueOf(level));
		             show_name.setText(name);
		             show_power.setText(power);
                    show_intelligence.setText(intelligence);
                    show_life.setText(life);
     }
			public   void   deleteallinfo(){
				dao = new PersonDao(this);
				dao.delete();
			}
     
	   
}
