package com.sanmina.listener;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * 调度类，实现定时执行任务的功能
 * @author cat
 *
 */
public class DemoMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		try {
			doReceive(message);
		} catch (Exception e) {
			System.out.println("对方不想跟你说话，并向你抛出了一个异常");
			e.printStackTrace();
		}
	}
	
	protected void doReceive(Message message) throws Exception{
		System.out.println("信息打印：");
		System.out.println(message);
	}

}
