package com.example.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.ghostbuster.R;

public class dataload {


	private     List<HashMap<String ,Object>> select_view = new ArrayList<HashMap<String,Object>>();
	private   int[]  bullectphoto = new int[]{R.drawable.zidan,R.drawable.zidan1,R.drawable.zidan2};
	private    String []   zidanmingzi = new String[]{"zidan", "zidan1","zidan2"};

	public   dataload(){

	}
	//数据装载成功
	public   List<HashMap<String ,Object>>   zhuangzaidata(){

		for(int i =0 ; i < 3 ; i++){
			HashMap<String , Object> hhh = new HashMap<String , Object>();
	       hhh.put("zidanname", zidanmingzi[i]);
	      select_view.add(hhh);
		}
		return select_view;
	}


}
