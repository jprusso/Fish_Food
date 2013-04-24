/*
 * 		Fish Food
		St. John Fisher Dining Application
		Version J.P.
	
		Created by: John Russo
	
		St. John Fisher College 
		April 2013															*/

package com.jp.fish.food;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Meal_Plan_Info extends Activity
{
	Context ctx = this;
	Button meal_options, meal_costs;
	
	String direction;
	
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_plan_info);
        
        setupVariables();
        
        final AlertDialog.Builder error_box = new AlertDialog.Builder(ctx);
              
        meal_options.setOnClickListener(new View.OnClickListener() 
        {			
			public void onClick(View v) 
			{
				try
				{
					direction = "meal_options";
					Class ourClass = Class.forName("com.jp.fish.food.Browser");
					Intent ourIntent = new Intent(ctx, ourClass);
					ourIntent.putExtra("direction", direction);
					startActivity(ourIntent);
				}
				catch(ClassNotFoundException e)
				{
					error_box.setTitle("Application Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Could not direct to desired page.\nPlease try again!");
					error_box.show();
				}
			}
        });
        
        meal_costs.setOnClickListener(new View.OnClickListener() 
        {			
			public void onClick(View v) 
			{
				try
				{
					direction = "meal_costs";
					Class ourClass = Class.forName("com.jp.fish.food.Browser");
					Intent ourIntent = new Intent(ctx, ourClass);
					ourIntent.putExtra("direction", direction);
					startActivity(ourIntent);
				}
				catch(ClassNotFoundException e)
				{
					error_box.setTitle("Application Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Could not direct to desired page.\nPlease try again!");
					error_box.show();
				}	
			}
        });
    }
	 
	private void setupVariables() 
	{
		Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/Champagne & Limousines Bold.ttf");
		meal_options = (Button) findViewById(R.id.meal_options);
		meal_options.setTypeface(tf);
		meal_costs = (Button) findViewById (R.id.meal_costs);
		meal_costs.setTypeface(tf);
	}
}
