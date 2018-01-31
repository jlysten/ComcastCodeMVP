package com.example.joel.comcastcodemvp.model;

import com.google.gson.annotations.SerializedName;

public class Icon{

	@SerializedName("Height")
	private String height;

	@SerializedName("Width")
	private String width;

	@SerializedName("URL")
	private String uRL;

// --Commented out by Inspection START (1/30/2018 6:41 PM):
//	public void setHeight(String height){
//		this.height = height;
//	}
// --Commented out by Inspection STOP (1/30/2018 6:41 PM)

// --Commented out by Inspection START (1/30/2018 6:41 PM):
//	public String getHeight(){
//		return height;
//	}
// --Commented out by Inspection STOP (1/30/2018 6:41 PM)

// --Commented out by Inspection START (1/30/2018 6:41 PM):
//	public void setWidth(String width){
//		this.width = width;
//	}
// --Commented out by Inspection STOP (1/30/2018 6:41 PM)

// --Commented out by Inspection START (1/30/2018 6:41 PM):
//	public String getWidth(){
//		return width;
//	}
// --Commented out by Inspection STOP (1/30/2018 6:41 PM)

// --Commented out by Inspection START (1/30/2018 6:41 PM):
//	public void setURL(String uRL){
//		this.uRL = uRL;
//	}
// --Commented out by Inspection STOP (1/30/2018 6:41 PM)

	public String getURL(){
		return uRL;
	}

	@Override
 	public String toString(){
		return 
			"Icon{" + 
			"height = '" + height + '\'' + 
			",width = '" + width + '\'' + 
			",uRL = '" + uRL + '\'' + 
			"}";
		}
}