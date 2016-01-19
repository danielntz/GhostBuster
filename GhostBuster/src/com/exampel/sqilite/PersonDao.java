package com.exampel.sqilite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * �����ݿ���и��ֲ���
 * @author jsjxy
 *
 */
public class PersonDao {
         
	     private   Personsqlite    sqliteopener= null;
	
	     public   PersonDao(Context context){
	    	        sqliteopener =  new  Personsqlite(context);
	     }
	   //���������һ����¼
	    public  long   addinfo(int id, String name , int level , String power , String intelligence , String life){
	    	    SQLiteDatabase  db = sqliteopener.getWritableDatabase();
	    	    ContentValues content = new ContentValues();
	         //��ֵ�ԣ������е����������ݿ���е����ԣ�����ͱ��е�������ͬ����������ҲҪ��ͬ����
	    	    content.put("id", id);
	            content.put("name", name);
	            content.put("level", level);
	            content.put("power", power);
	            content.put("intelligence", intelligence);
	            content.put("life", life);
	            long id1 = db.insert("hero", null, content);
	            return id1;
	    }
	   //ɾ�����е�һ����¼
	    public    void  delete(String name ){
	    	SQLiteDatabase db = sqliteopener.getReadableDatabase();
	    	String  sql  =  "delete from hero where name=?";
	    	db.execSQL(sql,new Object[]{name});
	    }
	   //ɾ�����е����м�¼
	    public   void   delete(){
	    	SQLiteDatabase  db =  sqliteopener.getReadableDatabase();
	    	String sql = "delete from hero ";
	    	db.execSQL(sql);
	    }
	 //�����ض���ֵ
	    public   int   update(int level , String power , String intelligence , String life, String name){
	    	   SQLiteDatabase db = sqliteopener.getReadableDatabase();
	    	   ContentValues  content = new ContentValues();
	    	   content.put("level", level);
	    	   content.put("power", power);
	    	   content.put("intelligence", intelligence);
	    	   content.put("life", life);
	    	   int n = db.update("hero", content, "name=?", new String []{name});
	    		return n ;	   
	     }
	    //����
	    public  boolean   find (String name){
	    	SQLiteDatabase db = sqliteopener.getReadableDatabase();
	      Cursor cursor = db.query("hero", null, "name=?", new String[]{name}, null, null, null);
	      boolean   result = cursor.moveToNext();
	      return  result;
	    }
	//����ȫ�������һ�����ݿ��еĶ���
	    public   List<Person> findall(){
	    	    SQLiteDatabase db = sqliteopener.getReadableDatabase();
	    	    Cursor cursor = db.query("hero", new String[]{"id","name","level","power","intelligence","life"},null,null, null, null, null);
	           List<Person> list = new  ArrayList<Person>();
	           while(cursor.moveToNext()){
	        	   int id = cursor.getInt(cursor.getColumnIndex("id"));
	        	   String name = cursor.getString(cursor.getColumnIndex("name"));
	        	   int  level = cursor.getInt(cursor.getColumnIndex("level"));
	        	   String power = cursor.getString(cursor.getColumnIndex("power"));
	        	   String  intelligence = cursor.getString(cursor.getColumnIndex("intelligence"));
	        	   String   life = cursor.getString(cursor.getColumnIndex("life"));
	        	   Person   p = new Person(id,name,level,power,intelligence,life);
	        	   list.add(p);
	           }
	           db.close();
				cursor.close();
				return   list;
	    }
}
