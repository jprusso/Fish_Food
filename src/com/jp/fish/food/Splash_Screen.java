/*
 * 		Fish Food
		St. John Fisher Dining Application
		Version J.P.
	
		Created by: John Russo
	
		St. John Fisher College 
		April 2013															*/

package com.jp.fish.food;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

public class Splash_Screen extends Activity 
{
	Context ctx = this;
	
	final File path = Environment.getExternalStorageDirectory(); 
	final File ward_haffey_menu = new File(path + "/ward_haffey.pdf");
	final File murphy_menu = new File(path + "/murphy.pdf");
	final File cyber_menu = new File(path + "/cyber.pdf");
	final File cardinal_menu = new File(path + "/cardinal.pdf");
	final File fishbowl_menu = new File(path + "/fishbowl.pdf");
	final File promo_calendar = new File(path + "/promo.pdf");
	
	URL url = null;
	HttpURLConnection c = null;
	String fileName;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
        final AlertDialog.Builder error_box = new AlertDialog.Builder(ctx);
        
        if(isOnline() == true)
	    {
	         new downloadfile().execute("");
	    }
        else
        {
            error_box.setTitle("Internet Connection Error");
    		error_box.setIcon(R.drawable.app_icon);
    		error_box.setNeutralButton("OK!", null);
    		error_box.setMessage("No internet connection detected.\n\n" +
    					                   "**Menus may be unavailable or out-of-date.");
    		error_box.show();
        }
        
		Thread timer = new Thread() 
		{
			public void run()
			{
				try
				{
					sleep(4000);
				} 
				catch(InterruptedException e) 
				{
					error_box.setTitle("Application Error");
					error_box.setIcon(R.drawable.app_icon);
					error_box.setNeutralButton("OK!", null);
					error_box.setMessage("Could not direct to desired page.\nPlease try again!");
					error_box.show();
				} 
				finally
				{
					Intent intent = new Intent("com.jp.fish.food.Main_Menu");	
					startActivity(intent);
				}		
			}			
		};
	
		timer.start();
	}
	
	protected void onPause() 
	{
		super.onPause();
		finish();
	}
	
	private class downloadfile extends AsyncTask<String, Void, String>
	{
		String s;
		
		@Override
		protected String doInBackground(String... arg0) 
		{
			final AlertDialog.Builder error_box = new AlertDialog.Builder(ctx);
			
			try 
	        {
			    BufferedInputStream inStream;
			    BufferedOutputStream outStream;
			    FileOutputStream fileStream;
	    		
			    url = new URL("http://www.sjfc.edu/dotAsset/86815.pdf");
		        HttpURLConnection c = (HttpURLConnection)  url.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.connect();	
		        fileName = "ward_haffey.pdf";
		        
		        inStream = new BufferedInputStream(c.getInputStream());
			    fileStream = new FileOutputStream(ward_haffey_menu);
			    outStream = new BufferedOutputStream(fileStream, 1024);
			    
			    byte[] data = new byte[1024];
			    int bytesRead = 0;
			    
			    while((bytesRead = inStream.read(data, 0, data.length)) >= 0)
		        {
		            outStream.write(data, 0, bytesRead);
		        }
			    
			    outStream.flush();
			    outStream.close();
		        fileStream.close();
		        inStream.close(); 
		        
		        url = new URL("http://www.sjfc.edu/dotAsset/86823.pdf");
		        c = (HttpURLConnection)  url.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.connect();	
		        fileName = "murphy.pdf";
		        
		        inStream = new BufferedInputStream(c.getInputStream());
			    fileStream = new FileOutputStream(murphy_menu);
			    outStream = new BufferedOutputStream(fileStream, 1024);
			    
			    byte[] data2 = new byte[1024];
			    bytesRead = 0;
			    
			    while((bytesRead = inStream.read(data2, 0, data2.length)) >= 0)
		        {
		            outStream.write(data2, 0, bytesRead);
		        }
			    
			    outStream.flush();
			    outStream.close();
		        fileStream.close();
		        inStream.close();
		        
		        url = new URL("http://www.sjfc.edu/dotAsset/86819.pdf");
		        c = (HttpURLConnection)  url.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.connect();	
		        fileName = "cyber.pdf";
		        
		        inStream = new BufferedInputStream(c.getInputStream());
			    fileStream = new FileOutputStream(cyber_menu);
			    outStream = new BufferedOutputStream(fileStream, 1024);
			    
			    byte[] data3 = new byte[1024];
			    bytesRead = 0;
			    
			    while((bytesRead = inStream.read(data3, 0, data3.length)) >= 0)
		        {
		            outStream.write(data3, 0, bytesRead);
		        }
			    
			    outStream.flush();
			    outStream.close();
		        fileStream.close();
		        inStream.close();
		        
		        url = new URL("http://www.sjfc.edu/dotAsset/86817.pdf");
		        c = (HttpURLConnection)  url.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.connect();	
		        fileName = "cardinal.pdf";
		        
		        inStream = new BufferedInputStream(c.getInputStream());
			    fileStream = new FileOutputStream(cardinal_menu);
			    outStream = new BufferedOutputStream(fileStream, 1024);
			    
			    byte[] data4 = new byte[1024];
			    bytesRead = 0;
			    
			    while((bytesRead = inStream.read(data4, 0, data4.length)) >= 0)
		        {
		            outStream.write(data4, 0, bytesRead);
		        }
			    
			    outStream.flush();
			    outStream.close();
		        fileStream.close();
		        inStream.close();
		        
		        url = new URL("http://www.sjfc.edu/dotAsset/86821.pdf");
		        c = (HttpURLConnection)  url.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.connect();	
		        fileName = "fishbowl.pdf";
		        
		        inStream = new BufferedInputStream(c.getInputStream());
			    fileStream = new FileOutputStream(fishbowl_menu);
			    outStream = new BufferedOutputStream(fileStream, 1024);
			    
			    byte[] data5 = new byte[1024];
			    bytesRead = 0;
			    
			    while((bytesRead = inStream.read(data5, 0, data5.length)) >= 0)
		        {
		            outStream.write(data5, 0, bytesRead);
		        }
			    
			    outStream.flush();
			    outStream.close();
		        fileStream.close();
		        inStream.close();
		        
			} 
	        catch (MalformedURLException e) 
			{
				error_box.setTitle("Server Connection Error");
				error_box.setIcon(R.drawable.app_icon);
				error_box.setNeutralButton("OK!", null);
				error_box.setMessage("Server is unavailable.\n\n" +
						                   "**Menus may be unavailable or out-of-date.");
				error_box.show();
			} 
	        catch (IOException e) 
	        {
				error_box.setTitle("Server Connection Error");
				error_box.setIcon(R.drawable.app_icon);
				error_box.setNeutralButton("OK!", null);
				error_box.setMessage("Server is unavailable.\n\n" +
						                   "**Menus may be unavailable or out-of-date.");
				error_box.show();
			}   	
 
			return s;
		}

	}

    public boolean isOnline()
	{
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		
		if(netinfo != null && netinfo.isConnectedOrConnecting())
		{
			return true;
		}
		
		return false;
	}

}


