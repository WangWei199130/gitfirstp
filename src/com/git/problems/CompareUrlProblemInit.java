package com.git.problems;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.git.java.base.ExcutorServiceDemo;

/**
 * 文件中url比对问题初始化类
 * @author wangwei
 *
 */
public class CompareUrlProblemInit {
	
	private String urlTemplate = "http://www.wangwei1991.com/index.html?";
	
	
	public void threadDeal(){
//		int threadPerSize = 10000;
//		List<String> urlList = null;
//		int startOffSet = 0;
//		for(int startOffSet){
//			urlList = new ArrayList<String>();
//		}
//		
//		int urlMaxSize = 1000*1000*1000;
//		String urlTemplate = "http://www.wangwei1991.com/index.html?";
//		CompareUrlProblemInit init = new CompareUrlProblemInit();
//		init.setUrlTemplate(urlTemplate);
//		// 初始化a文件
//		String aFilePath = "E:/A.txt";
//		String aFileTag = "A";
//		try {
//			init.init(urlMaxSize, aFilePath, aFileTag);
//		} catch (IOException e) {
//			System.out.println("初始化A文件异常："+e.getMessage());
//		}
//		
//		String bFilePath = "E:/B.txt";
//		String bFileTag = "B";
//		try {
//			init.init(urlMaxSize, bFilePath, bFileTag);
//		} catch (IOException e) {
//			System.out.println("初始化B文件异常："+e.getMessage());
//		}
//		
		File aFile = initFile("E:/A.txt");
		//File bFile = initFile("E:/B.txt");
		ExcutorServiceDemo demo = new ExcutorServiceDemo();
		int urlFlag = 0;
		for(int i=0;i<100;i++){
			List<String> urlList = new ArrayList<String>(10000);
			int endUrlFlag = urlFlag+10000;
			for(;urlFlag<endUrlFlag;urlFlag++){
				urlList.add(createUrl(urlFlag, "A"));
				demo.runTask(urlList, aFile);
			}
		}
	}
	
	public File initFile(String path){
		File afile = new File(path);
		try {
			if(afile.exists()){
				afile.delete();
			}else{
				afile.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("初始化文件出错了");
		}
		return afile;
	}

	/**
	 * 存储url的文件初始化方法，初始化后文件中将包含100W条url
	 * @param aFilePath
	 */
	public void init(int size,String filePath,String fileTag) throws IOException{
		File afile = new File(filePath);
		if(afile.exists()){
			afile.delete();
		}else{
			afile.createNewFile();
		}
		List<String> aFileUrlList = new ArrayList<String>();
		for(int i=0;i<size;i++){
			aFileUrlList.add(createUrl(i, fileTag));
		}
		FileUtils.writeLines(afile, aFileUrlList);
	}
	
	private String createUrl(int i,String fileTag){
		return this.urlTemplate+fileTag+"="+i;
	}

	public String getUrlTemplate() {
		return urlTemplate;
	}

	public void setUrlTemplate(String urlTemplate) {
		this.urlTemplate = urlTemplate;
	}
	
	
}
