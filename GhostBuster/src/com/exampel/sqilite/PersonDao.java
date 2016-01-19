package com.exampel.sqilite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 对数据库进行各种操作
 * @author jsjxy
 *
 */
public class PersonDao {
         
	     private   Personsqlite    sqliteopener= null;
	
	     public   PersonDao(Context context){
	    	        sqliteopener =  new  Personsqlite(context);
	     }
	   //给表中添加一条记录
	    public  long   addinfo(int id, String name , int level , String power , String intelligence , String life){
	    	    SQLiteDatabase  db = sqliteopener.getWritableDatabase();
	    	    ContentValues content = new ContentValues();
	         //键值对，“”中的内容是数据库表中的属性，必须和表中的属性相同，并且类型也要相同才行
	    	    content.put("id", id);
	            content.put("name", name);
	            content.put("level", level);
	            content.put("power", power);
	            content.put("intelligence", intelligence);
	            content.put("life", life);
	            long id1 = db.insert("hero", null, content);
	            return id1;
	    }
	   //删除表中的一条记录
	    public    void  delete(String name ){
	    	SQLiteDatabase db = sqliteopener.getReadableDatabase();
	    	String  sql  =  "delete from hero where name=?";
	    	db.execSQL(sql,new Object[]{name});
	    }
	   //删除表中的所有记录
	    public   void   delete(){
	    	SQLiteDatabase  db =  sqliteopener.getReadableDatabase();
	    	String sql = "delete from hero ";
	    	db.execSQL(sql);
	    }
	 //更新特定的值
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
	    //查找
	    public  boolean   find (String name){
	    	SQLiteDatabase db = sqliteopener.getReadableDatabase();
	      Cursor cursor = db.query("hero", null, "name=?", new String[]{name}, null, null, null);
	      boolean   result = cursor.moveToNext();
	      return  result;
	    }
	//查找全部，并且获得数据库中的东西
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
