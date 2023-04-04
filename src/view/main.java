package view;

import java.util.concurrent.Semaphore;

import controller.multiprocess;

public class main {

	public static void main(String[] args) {
		
		Semaphore farol = new Semaphore(1);
		
		for(int Thread = 1; Thread < 22; Thread++) {
			Thread multiprocess = new multiprocess(Thread, farol);
			multiprocess.start();
		}

	}

}
