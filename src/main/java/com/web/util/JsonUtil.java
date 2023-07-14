package com.web.util;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jayway.jsonpath.JsonPath;

public class JsonUtil {
	private static final Gson gson = new Gson();
	public static String readJsonTestDataFile(String fileName) throws Exception, ParseException {
		Object jsonObject = null;
		JSONParser jsonParser = new JSONParser(); 
		String filePath= "src/main/resources/data/testdata/"+ fileName;
		FileReader file= new FileReader(filePath);
		jsonObject = jsonParser.parse(file);
		return jsonObject.toString();
	}
	public static boolean isValidJson(String jsonInput) {
		try {
			gson.fromJson(jsonInput, Object.class);
		}
		catch(JsonSyntaxException e) {
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	public static String getJsonValue(String jsonFile,String jsonPath) throws ParseException {
		isValidJson(jsonFile);
		JSONParser jsonparser = new JSONParser();
		Object jsonObject = jsonparser.parse(jsonFile);
		return JsonPath.read(jsonObject, jsonPath).toString();
		
	}

}

