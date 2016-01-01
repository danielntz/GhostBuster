package com.example.GridViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.ghostbuster.R;
import com.example.listener.dataload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter  extends BaseAdapter {
    
	private      List<HashMap<String ,Object>> select_photo = new ArrayList<HashMap<String,Object>>();
	 private   LayoutInflater  inflater;
	 private   ViewHolder  viewholder;
	 private   Context  context;
	 private   int   []   photos = new int[]{R.drawable.zidan1,R.drawable.zidan2,R.drawable.zidan3};
	public   GridViewAdapter(){
		
		}
	
	public   GridViewAdapter(Context context){
		
		
		    this.context = context;
		     this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return new dataload().zhuangzaidata().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return new dataload().zhuangzaidata().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public  static  class ViewHolder{
		     public    ImageView   photoview;
		     public    TextView    textzi;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			     viewholder = new ViewHolder();
			     convertView = inflater.inflate(R.layout.grid_view,null);
			     viewholder.photoview = (ImageView)convertView.findViewById(R.id.xianshi);
			     viewholder.textzi = (TextView)convertView.findViewById(R.id.xianshizi);
			     convertView.setTag(viewholder);
		}
		else{
			     viewholder = (ViewHolder) convertView.getTag();
		}
	     viewholder.photoview.setImageResource(photos[position]);
		  viewholder.textzi.setText(new dataload().zhuangzaidata().get(position).get("zidanname").toString());
		   
		return convertView;
	}

}
