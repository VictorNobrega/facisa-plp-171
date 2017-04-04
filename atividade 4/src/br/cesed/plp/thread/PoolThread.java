package br.cesed.plp.thread;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class PoolThread {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(new ThreadExecutor("1"));
		executorService.execute(new ThreadExecutor("2"));
		executorService.execute(new ThreadExecutor("3"));
		executorService.execute(new ThreadExecutor("4"));
		
		executorService.shutdown();
		while (!executorService.isTerminated()) {}
		
		System.out.println("Finalizado!");
	}
}

class ThreadExecutor implements Runnable {
	
	private String thread;
	
	public ThreadExecutor(String numero) {
		this.thread = numero;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + " (Iniciou: " + thread + ")");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Finalizou");
	}
}