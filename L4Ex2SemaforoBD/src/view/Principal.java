package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBD;

public class Principal {

	public static void main(String[] args) {
		int id = 1, permissao = 1;
		Semaphore transacao = new Semaphore(permissao);
		
		for (int i =0; i <21;i++) {
			Thread thread = new ThreadBD(id, transacao);
			thread.start();
			id++;
		}

	}

}
