package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class multiprocess extends Thread {

	int Thread;
	Semaphore farol;

	public multiprocess(int Thread, Semaphore farol) {
		this.Thread = Thread;
		this.farol = farol;
	}

	public void run() {
		Verifica();
	}

	// Verifica em qual metodo a Thread irá entrar
	private void Verifica() {
		if (Thread % 3 == 0) {
			ResultadoZero();
		}
		if (Thread % 3 == 1) {
			ResultadoUm();
		}
		if (Thread % 3 == 2) {
			ResultadoDois();
		}
	}

	private void ResultadoZero() {
		
		// Faz o primeiro calculo
			Random gerador = new Random();
			double tempo = gerador.nextDouble(0.8000) + .02000;
			System.out.printf(" A " + Thread + "º Thread esta fazendo o 1º calculo, tempo de espera(segundos): %.2f %n", tempo);
			try {
				sleep((long) (tempo * 1000));
				System.out.println(" A " + Thread + "º Thread finalizou o 1º calculo");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Faz a Primeira Transação (1 por vez)
				try {
					farol.acquire();
					System.out.println(" A " + Thread + "º Thread esta fazendo a 1º transação, tempo de espera(segundos): 1");
					transacaoRestoUm();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(" A " + Thread + "º Thread finalizou 1º transação, tempo de espera(segundos): 1");
					farol.release();
				}
				
			// Faz o segundo calculo
				Random gerador2 = new Random();
				double tempo2 = gerador.nextDouble(0.8000) + .02000;
				System.out.printf(" A " + Thread + "º Thread esta fazendo o 2º calculo, tempo de espera(segundos): %.2f %n", tempo2);
				try {
					sleep((long) (tempo * 1000));
					System.out.println(" A " + Thread + "º Thread finalizou o 2º calculo");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			// Faz a segunda Transação (1 por vez)
				try {
					farol.acquire();
					System.out.println(" A " + Thread + "º Thread esta fazendo a 2º transação, tempo de espera(segundos): 1");
					transacaoRestoUm();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(" A " + Thread + "º Thread finalizou 2º transação, tempo de espera(segundos): 1");
					farol.release();
				}
				
				
	}

	private void ResultadoUm() {
				// Faz o primeiro calculo
					Random gerador = new Random();
					double tempo = gerador.nextDouble(1.0) + 0.500;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 1º calculo, tempo de espera(segundos): %.2f %n", tempo);
					try {
						sleep((long) (tempo * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 1º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				// Faz a Primeira Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 1º transação, tempo de espera(segundos): 1,5");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 1º transação, tempo de espera(segundos): 1,5");
						farol.release();
					}
						
				// Faz o segundo calculo
					Random gerador2 = new Random();
					double tempo2 = gerador.nextDouble(1.0) + 0.500;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 2º calculo, tempo de espera(segundos): %.2f %n", tempo2);
					try {
						sleep((long) (tempo2 * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 2º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						
				// Faz a segunda Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 2º transação, tempo de espera(segundos): 1");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 2º transação, tempo de espera(segundos): 1");
						farol.release();
					}
					
					// Faz o Tercerio calculo
					Random gerador3 = new Random();
					double tempo3 = gerador.nextDouble(1.0) + 0.500;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 3º calculo, tempo de espera(segundos): %.2f %n", tempo3);
					try {
						sleep((long) (tempo3 * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 3º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						
				// Faz a Terceiro Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 3º transação, tempo de espera(segundos): 1");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 3º transação, tempo de espera(segundos): 1");
						farol.release();
					}
	}
	
	private void ResultadoDois() {
				// Faz o primeiro calculo
					Random gerador = new Random();
					double tempo = gerador.nextDouble(1.0) + 1.0;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 1º calculo, tempo de espera(segundos): %.2f %n", tempo);
					try {
						sleep((long) (tempo * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 1º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		
				// Faz a Primeira Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 1º transação, tempo de espera(segundos): 1,5");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 1º transação, tempo de espera(segundos): 1,5");
						farol.release();
					}
			
				// Faz o segundo calculo
					Random gerador2 = new Random();
					double tempo2 = gerador.nextDouble(1.0) + 1.0;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 2º calculo, tempo de espera(segundos): %.2f %n", tempo2);
					try {
						sleep((long) (tempo2 * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 2º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			
				// Faz a segunda Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 2º transação, tempo de espera(segundos): 1");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 2º transação, tempo de espera(segundos): 1");
						farol.release();
					}
		
				// Faz o Tercerio calculo
					Random gerador3 = new Random();
					double tempo3 = gerador.nextDouble(1.0) + 1.0;
					System.out.printf(" A " + Thread + "º Thread esta fazendo o 3º calculo, tempo de espera(segundos): %.2f %n", tempo3);
					try {
						sleep((long) (tempo3 * 1000));
						System.out.println(" A " + Thread + "º Thread finalizou o 3º calculo");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			
				// Faz a Terceiro Transação (1 por vez)
					try {
						farol.acquire();
						System.out.println(" A " + Thread + "º Thread esta fazendo a 3º transação, tempo de espera(segundos): 1");
						transacaoRestodoiseZero();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println(" A " + Thread + "º Thread finalizou 3º transação, tempo de espera(segundos): 1");
						farol.release();
					}	
	}

	private void transacaoRestoUm() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void transacaoRestodoiseZero() {
		try {
			sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
