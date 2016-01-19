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
 * ע����Ϣ(���������Լ�д֮�⣬�ȼ�����������������������ϵͳ�Լ�����)
 * @author jsjxy
 *
 */

public class RegisterView  extends Activity  implements  OnClickListener{
    
	  private  EditText    hero_name;
	  private  Button       ok;
	  private  TextView    showattribute;
	  private    Personsqlite  personhelper = null;    
	 private      static  int    id = 1;        //ע��ĵڼ�����
	 PersonDao   dao = null;                                //PersonDao�к��ж����ݿ���������з���
	 private    int  level ;                                   //�ȼ�
	 private   String power,intelligence ,life;      //����������������(���������������ʱ��)
	 private    TextView  show_xuhao,show_level;
	 private  TextView show_power,show_intelligence,show_life,show_name;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		personhelper = new Personsqlite(this);
		//�������һ�����ݿ⣬���в���
		SQLiteDatabase  db = personhelper.getWritableDatabase();    //�Զ�д�ķ�ʽ���һ�����ݿ�ʵ����Ȼ����Զ������в������ݿ�����Ҫ�ر�
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
			    	    //д�����ݿ�
			    	    writetosqlite(name,id);
			    	    id++;
			     }
			      else{
			    	   
			      }
		         break;

	
		}
	}
	//ϵͳ��������������
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
