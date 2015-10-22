package com.ecoman.async;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecoman.jpa.Receipt;
import com.ecoman.jpa.ReceiptRepo;

@Component
public class ReceiptQueueManager implements Runnable {
	@Autowired
	private ReceiptRepo receiptRepo;

	private LinkedBlockingQueue<Map.Entry<String, Receipt>> queue = new LinkedBlockingQueue<Map.Entry<String, Receipt>>();
	private Set<String> tokens = new HashSet<String>();

	@PostConstruct
	public void launch() {
		new Thread(this).start();
	}

	public String addReceipt(Receipt receipt) throws Exception {
		String token = UUID.randomUUID().toString();

		Map.Entry<String, Receipt> e = new AbstractMap.SimpleImmutableEntry<String, Receipt>(
				token, receipt);
		this.queue.put(e);
		tokens.add(token);
		return token;
	}
	
	public boolean isFinished(String token){
		return !tokens.contains(token);
	}

	@Override
	public void run() {
		// 消费线程线程
		while (true) {
			try {
				Map.Entry<String, Receipt> e = queue.poll(10, TimeUnit.SECONDS);
				if (e == null)
					continue;
				Receipt r = receiptRepo.save(e.getValue());
				tokens.remove(e.getKey());
				System.out.println(e.getKey()+":"+r.getId());
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

}
