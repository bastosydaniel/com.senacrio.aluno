package com.senacrio.aluno;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senacrio.aluno.controller.AlunoController;

public class TesteDelete {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		AlunoController controller = new AlunoController();
		Scanner sc = new Scanner(System.in);
		
		int id;
		
		System.out.println("Insira o id do Aluno a ser apagado: ");
		id = sc.nextInt();
		controller.Delete(id);
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
