package com.git.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DownLoader {

	public static List<String> download() throws IOException{
		List<String> lines = new ArrayList<String>();
		HttpURLConnection connection = (HttpURLConnection)new URL("https://www.baidu.com").openConnection();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))){
			String line = "";
			while((line = reader.readLine()) != null){
				lines.add(line);
			}
		}
		return lines;
	}
	
	public static void main(String[] args){
		try {
			for(String line:DownLoader.download()){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
