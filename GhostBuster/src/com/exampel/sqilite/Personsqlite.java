package com.exampel.sqilite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Personsqlite  extends SQLiteOpenHelper{

	public Personsqlite(Context context) {
		        super(context, "Person.db", null, 1);   //数据库名称
		// TODO Auto-generated constructor stub
	}
    //当数据库第一次被建立时执行，如创建表，初始化数据等
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//建立表(id 标示为主键且是自增的，也就表明每次插入时的id必须是不一样的)
		       String   sql = "create table  hero (id integer primary key autoincrement, name  varchar(10), level integer, power varchar(20), intelligence varchar(20), life varchar(20)) ";
	           db.execSQL(sql);
	}
     
	//当数据库更新时，删除旧表，创建新表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		   
	}

}
