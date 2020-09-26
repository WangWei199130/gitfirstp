package com.git.problems;



/**
 * 问题解决类
 * @author 15001
 *
 */
public class ProblemIssueTest {

	public static void main(String[] args){
		// 1.初始化A、B文件
//		long diffTime = 0L;
//		long initBeginTime = System.currentTimeMillis();
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
//		long initEndTime = System.currentTimeMillis();
//		diffTime = initEndTime-initBeginTime;
//		System.out.println("初始化文件共耗时："+(diffTime / 1000)+"秒");
		CompareUrlProblemInit init = new CompareUrlProblemInit();
		init.threadDeal();
		// 2. 将文件分割成小文件
	}
}
