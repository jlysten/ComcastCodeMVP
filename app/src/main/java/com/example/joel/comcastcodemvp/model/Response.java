package com.example.joel.comcastcodemvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("RelatedTopics")
	private List<RelatedTopicsItem> relatedTopics;

	public List<RelatedTopicsItem> getRelatedTopics(){
		return relatedTopics;
	}

	@Override
 	public String toString(){
		return 
			"Response{" +
			",relatedTopics = '" + relatedTopics + '\'' +
			"}";
		}
}