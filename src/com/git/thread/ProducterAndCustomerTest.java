package com.git.thread;

import java.util.LinkedList;

/**
 * 生产者消费者模式
 * @author 15001
 *
 */
public class ProducterAndCustomerTest {

	public static void main(String[] args) {
		MessageQune qune = new MessageQune(3);
		for(int i=0;i<4;i++){
			int id = i;
			new Thread(() -> {
				qune.put(new Message(id,"value-"+id));
			},"生产者-"+i).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<5;i++){
			new Thread(() -> {
				qune.take();
			},"消费者-"+i).start();
		}
	}
	
}

/**
 * 消息队列
 * @author 15001
 *
 */
class MessageQune{
	
	LinkedList<Message> messageList = new LinkedList<>();
	
	private int capcity;
	
	public MessageQune(int capcity){
		this.capcity = capcity;
	}
	
	public void put(Message message){
		synchronized (messageList) {
			while(messageList.size() >= capcity){
				try {
					System.out.println(Thread.currentThread().getName()+"消息已满，生产者等待");
					messageList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"生产者生成消息："+message.getValue());
			messageList.addLast(message);
			messageList.notifyAll();
		}
		
	}
	
	public Message take(){
		synchronized (messageList) {
			while(messageList.isEmpty()){
				try {
					System.out.println(Thread.currentThread().getName()+"队列为空，消费者等待");
					messageList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Message returnMessage = messageList.removeFirst();
			System.out.println(Thread.currentThread().getName()+"消费者消费消息："+returnMessage.getValue());
			messageList.notifyAll();
			return returnMessage;
		}
	}
	
}

/**
 * 消息
 * @author 15001
 *
 */
final class Message{
	private int id;
	
	private String value;

	public Message(int id,String value){
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
