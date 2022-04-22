package com.madlib.dao;

public class MadLibModel {
	public int madLibId;
	public String noun,
	adjective,
	verb,
	adverb,
	storyName;
	public int user_id;
	
	public MadLibModel(String noun, String adjective, String verb, String adverb, String storyName, int user_id){
		this.noun = noun;
		this.adjective = adjective;
		this.verb = verb;
		this.adverb = adverb;
		this.storyName = storyName;
		this.user_id = user_id;
		}
	public MadLibModel(){
	
		}
	

}
/*
CREATE TABLE Users (
id serial PRIMARY KEY,
username VARCHAR(40) UNIQUE NOT NULL,
user_Password VARCHAR(40) NOT NULL
);

CREATE TABLE Mad_Libs(
id serial PRIMARY KEY,
noun VARCHAR(40) NOT NULL,
adjective VARCHAR(40) NOT NULL,
verb VARCHAR(40) NOT NULL,
adverb VARCHAR(40 NOT NULL,
user_id INT references Users(id)
);
*/