package controller;

import java.util.concurrent.Semaphore;

public class ThreadBD extends Thread{
	
	public int id;
	public Semaphore transacao;

	public ThreadBD(int id, Semaphore transacao) {
		this.id = id;
		this.transacao = transacao;
	}
	
	public void run() {
		operacao();
	}

	private void operacao() {
		int i;
		long tempo1, tempo2;
		if (id%3 == 1) {
			for (i = 0;i<2;i++) {
				tempo1 = (long)((Math.random()*801)+200);
				tempo2 = 1000;
				calculo(tempo1);
				try {
					transacao.acquire();
					transacao(tempo2);
				} catch (Exception e) {
					
				} finally {
					transacao.release();
				}
			}
		}
		else if (id%3 == 2) {
			for (i=0;i<3;i++) {
				tempo1 = (long)((Math.random()*1001)+500);
				tempo2 = 1500;
				calculo(tempo1);
				try {
					transacao.acquire();
					transacao(tempo2);
				} catch (Exception e) {
					
				} finally {
					transacao.release();
				}
			}
		}
		else if (id%3 == 0) {
			for (i=0;i<3;i++) {
				tempo1 = (long)((Math.random()*1001)+1000);
				tempo2 = 1500;
				calculo(tempo1);
				try {
					transacao.acquire();
					transacao(tempo2);
				} catch (Exception e) {
					
				} finally {
					transacao.release();
				}
			}
		}
	}

	private void transacao(long tempo2) {
		System.out.println("Thread ID#"+id + " -> Transferindo");
		try {
			sleep(tempo2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void calculo(long tempo1) {
		System.out.println("Thread ID#"+id + " -> Calculando");
		try {
			sleep(tempo1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
