package com.example.joel.comcastcodemvp.model;

import com.google.gson.annotations.SerializedName;

public class RelatedTopicsItem{

	@SerializedName("Text")
	private String text;

	@SerializedName("Icon")
	private Icon icon;

	@SerializedName("FirstURL")
	private String firstURL;

	@SerializedName("Result")
	private String result;

	public String getText(){return text; }

	public Icon getIcon(){
		return icon;
	}

	@Override
 	public String toString(){
		return 
			"RelatedTopicsItem{" + 
			"text = '" + text + '\'' + 
			",icon = '" + icon + '\'' + 
			",firstURL = '" + firstURL + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}