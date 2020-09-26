package com.git.java.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;

public class ExcutorServiceDemo {

	private ExecutorService pool = Executors.newFixedThreadPool(100);
	
	public void runTask(List<String> urlList,File file){
		pool.submit(new Runnable() {
			@Override
			public void run() {
				try {
					FileUtils.writeLines(file, urlList);
				} catch (IOException e) {
					System.out.println("将字符串集合写进文件中出错了："+e.getMessage());
				}
			}
		});
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}
	
	
}
