package com.exampel.sqilite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Personsqlite  extends SQLiteOpenHelper{

	public Personsqlite(Context context) {
		        super(context, "Person.db", null, 1);   //���ݿ�����
		// TODO Auto-generated constructor stub
	}
    //�����ݿ��һ�α�����ʱִ�У��紴������ʼ�����ݵ�
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//������(id ��ʾΪ�������������ģ�Ҳ�ͱ���ÿ�β���ʱ��id�����ǲ�һ����)
		       String   sql = "create table  hero (id integer primary key autoincrement, name  varchar(10), level integer, power varchar(20), intelligence varchar(20), life varchar(20)) ";
	           db.execSQL(sql);
	}
     
	//�����ݿ����ʱ��ɾ���ɱ������±�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		   
	}

}
