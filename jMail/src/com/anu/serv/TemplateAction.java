package com.anu.serv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateAction {
	
	public Map<String,String> placeHolder = new HashMap<String, String>();
	
	public String readTemplate(String filePath) {
		placeHolder.put("user_name", "Anupam");
		placeHolder.put("user_address", "Kolkata");
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(filePath));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		String fileContent = contentBuilder.toString();
		return this.replaceString(placeHolder, fileContent);
	}
	
	public String replaceString(Map<String,String> placeHolder,String content) {
		for(Map.Entry<String, String> obj : placeHolder.entrySet()) {
			content = content.replaceAll(obj.getKey(), obj.getValue());
		}
		return content;
	}
}
