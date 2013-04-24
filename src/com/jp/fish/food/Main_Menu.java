/*
 * 		Fish Food
		St. John Fisher Dining Application
		Version J.P.
	
		Created by: John Russo
	
		St. John Fisher College 
		April 2013															*/

package com.jp.fish.food;

import java.io.File;
import java.util.List;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.util.TimeSpanConverter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Main_Menu extends Activity
{
	Context ctx = this;
	
	TextView title, menu_label, calculator_label, hours_label, baglunch_label, contact_label, mealplan_label;
	ImageButton twitter_button, facebook_button;
	ImageView menu_button, calculator_button, clock_button, bag_lunch_button, contact_button, meal_button;
	
	SharedPreferences someData;
	File f = new File("/data/data/com.jp.fish.food/shared_prefs/MySharedString.xml");
	
	final File path = Environment.getExternalStorageDirectory();
	final File promo_calendar = new File(path + "/promo.pdf");
	
	final String user_name = "@Lackmann_Fisher";
	
	String tweet, direction;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.main_menu);
	    
	    setupVariables();
	    
	    final AlertDialog.Builder error_box = new AlertDialog.Builder(ctx);
	    
	    menu_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
			    try
				{
					Class ourClass = Class.forName("com.jp.fish.food.Location_Select");
					Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
	    
	    calculator_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
				if(f.exists())
				{
					try
					{
						Class ourClass = Class.forName("com.jp.fish.food.Calculator");
						Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
				else
				{
					try
					{
						Class ourClass = Class.forName("com.jp.fish.food.First_Time");
						Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
			}
		});
	    
	    clock_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
			    try
				{
			    	direction = "hours";
					Class ourClass = Class.forName("com.jp.fish.food.Browser");
					Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
	    
	    meal_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
			    try
				{
					Class ourClass = Class.forName("com.jp.fish.food.Meal_Plan_Info");
					Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
	    
	    contact_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
			    try
				{
			    	direction = "contact";
					Class ourClass = Class.forName("com.jp.fish.food.Browser");
					Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
	    
	    bag_lunch_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
				try
				{
					direction = "baglunch";
					Class ourClass = Class.forName("com.jp.fish.food.Browser");
					Intent ourIntent = new Intent(Main_Menu.this, ourClass);
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
	    
	    twitter_button.setOnClickListener(new View.OnClickListener() 
	    {
			public void onClick(View v) 
			{
				new twitterfeed().execute("");
			} 
		});
	    
	    facebook_button.setOnClickListener(new View.OnClickListener() 
	    {
	    	public void onClick(View v) 
			{
				Uri uriUrl = Uri.parse("https://www.facebook.com/fisherdining");
				Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
				startActivity(launch);		
			}
		});
	    
	}
	
	private class twitterfeed extends AsyncTask<String, Void, String>
    {
    	String createdAt;
			
		@Override
		protected String doInBackground(String... arg0) 
		{
			String consumerkey = "PbPsNkG4TlqUwuJNmVmyAA";  
		    String consumersecret = "q3II4rs0JDIyWU18FAesT6M9pNAQX7RrZCXMainpSU4";
		    String accesstoken = "983766331-sWk2cadUq6PnTMJtiPNF7G50IU3C1GAtxO05EqYO";
		    String accesstokensecret = "FalpL8B8cGEztL02pCMn9t8bBw68EeQ60O1Gh1AGY";
		        
		    ConfigurationBuilder cd = new ConfigurationBuilder();
		        
		    cd.setDebugEnabled(true)
		     .setOAuthConsumerKey(consumerkey)
		     .setOAuthConsumerSecret(consumersecret)
		     .setOAuthAccessToken(accesstoken)
		     .setOAuthAccessTokenSecret(accesstokensecret);
		        
		     TwitterFactory t1 = new TwitterFactory(cd.build());
		     Twitter twitter = t1.getInstance(); 
		     
		     TimeSpanConverter converter = new TimeSpanConverter();	    
		     
		     try 
		     {
		         List<twitter4j.Status> statuses;
		         statuses = twitter.getUserTimeline(user_name);
		         
		         for (twitter4j.Status status : statuses) 
		         {
		        	 tweet = status.getText();
		        	 createdAt = converter.toTimeSpanString(status.getCreatedAt());		
		             break;
		         } 
		      } 
		      catch (TwitterException te) 
		      {
		    	  tweet = "Failed to get timeline: " + te.getMessage();
		      }
		          
		      return tweet;
		}
			
    	protected void onPostExecute(String result)
    	{	
			AlertDialog.Builder twitter1 = new AlertDialog.Builder(ctx);
			twitter1.setTitle(user_name);
			twitter1.setIcon(R.drawable.lackmann_twitterpic);
				
			twitter1.setMessage(tweet + "\n" + createdAt);
			 
			twitter1.setPositiveButton("Tweet!", new DialogInterface.OnClickListener() {
					
				public void onClick(DialogInterface dialog,int id) 
				{
					Uri uriUrl = Uri.parse("https://twitter.com/Lackmann_Fisher");
					Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
					startActivity(launch);
				}
			});
			 
			twitter1.setNeutralButton("Cancel", null);				
			 
			twitter1.show();
		}
    }
	
	private void setupVariables() 
	{
		Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/Champagne & Limousines Bold.ttf");
		title = (TextView) findViewById(R.id.title);
		title.setTypeface(tf);
		menu_label = (TextView) findViewById(R.id.menu_label);
		menu_label.setTypeface(tf);
		calculator_label = (TextView) findViewById(R.id.calculator_label);
		calculator_label.setTypeface(tf);
		hours_label = (TextView) findViewById(R.id.hours_label);
		hours_label.setTypeface(tf);
		baglunch_label = (TextView) findViewById(R.id.order_label);
		baglunch_label.setTypeface(tf);
		contact_label = (TextView) findViewById(R.id.contact_label);
		contact_label.setTypeface(tf);
		mealplan_label = (TextView) findViewById(R.id.mealplan_label);
		mealplan_label.setTypeface(tf);
		
		menu_button = (ImageView) findViewById(R.id.menu_button);
		calculator_button = (ImageView) findViewById(R.id.calculator_button);
		clock_button = (ImageView) findViewById(R.id.clock_button);
		bag_lunch_button = (ImageView) findViewById(R.id.bag_lunch_button);
		contact_button = (ImageView) findViewById(R.id.contact_button);
		meal_button = (ImageView) findViewById(R.id.meal_button);
		
		twitter_button = (ImageButton) findViewById(R.id.twitter_button);
		facebook_button = (ImageButton) findViewById(R.id.facebook_button);
	}
}