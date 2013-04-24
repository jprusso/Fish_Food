/*
		Lackmann Mobile Android Application
		Version 1.0
	
		Created by: John Russo, Wade Kline, Matthew Staples, and Nathan Sunseri
	
		St. John Fisher College 
		Fall 2012																	*/

package com.jp.fish.food;

import java.io.File;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Location_Select extends Activity 
{
	Context ctx = this;
	
	TextView title;
	Button ward_haffey_button, murphy_button, cyber_button, cardinal_button, fishbowl_button;
	
	final File path = Environment.getExternalStorageDirectory();
	final File ward_haffey_menu = new File (path + "/ward_haffey.pdf");
	final File murphy_menu = new File(path + "/murphy.pdf");
	final File cyber_menu = new File(path + "/cyber.pdf");
	final File cardinal_menu = new File(path + "/cardinal.pdf");
	final File fishbowl_menu = new File(path + "/fishbowl.pdf");

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_select);
        
        setupVariables();
        
        final AlertDialog.Builder error_box = new AlertDialog.Builder(ctx);

        ward_haffey_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{				
				if(ward_haffey_menu.exists())
				{
					Intent ourIntent = new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.fromFile(ward_haffey_menu);
	        		ourIntent.setDataAndType(uri,"application/pdf");
		            startActivity(ourIntent); 
				}
				else
				{
					error_box.setTitle("Menu Retrieval Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Menus are unavailable at this time.");
					error_box.show();
				}
			} 
		});
        
        murphy_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{				
				if(murphy_menu.exists())
				{
					Intent ourIntent = new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.fromFile(murphy_menu);
	        		ourIntent.setDataAndType(uri,"application/pdf");
		            startActivity(ourIntent); 
				}
				else
				{
					error_box.setTitle("Menu Retrieval Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Menus are unavailable at this time.");
					error_box.show();
				}
			} 
		});
        
        cyber_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{				
				if(cyber_menu.exists())
				{
					Intent ourIntent = new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.fromFile(cyber_menu);
	        		ourIntent.setDataAndType(uri,"application/pdf");
		            startActivity(ourIntent); 
				}
				else
				{
					error_box.setTitle("Menu Retrieval Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Menus are unavailable at this time.");
					error_box.show();
				}
			} 
		});
        
        cardinal_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{				
				if(cardinal_menu.exists())
				{
					Intent ourIntent = new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.fromFile(cardinal_menu);
	        		ourIntent.setDataAndType(uri,"application/pdf");
		            startActivity(ourIntent); 
				}
				else
				{
					error_box.setTitle("Menu Retrieval Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Menus are unavailable at this time.");
					error_box.show();
				}
			} 
		});
        
        fishbowl_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{				
				if(fishbowl_menu.exists())
				{
					Intent ourIntent = new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.fromFile(fishbowl_menu);
	        		ourIntent.setDataAndType(uri,"application/pdf");
		            startActivity(ourIntent); 
				}
				else
				{
					error_box.setTitle("Menu Retrieval Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Menus are unavailable at this time.");
					error_box.show();
				}
			} 
		}); 
       

    }
     
    private void setupVariables() 
    {
		Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/Champagne & Limousines Bold.ttf");
		
		title = (TextView) findViewById(R.id.locations_label);
		title.setTypeface(tf);
		ward_haffey_button = (Button) findViewById(R.id.ward_haffey_button);
		ward_haffey_button.setTypeface(tf);
		murphy_button = (Button) findViewById(R.id.murphy_button);
		murphy_button.setTypeface(tf);
		cyber_button = (Button) findViewById(R.id.cyber_button);
		cyber_button.setTypeface(tf);
		cardinal_button = (Button) findViewById(R.id.cardinal_button);
		cardinal_button.setTypeface(tf);
		fishbowl_button = (Button) findViewById(R.id.fishbowl_button);
		fishbowl_button.setTypeface(tf);
	} 
}