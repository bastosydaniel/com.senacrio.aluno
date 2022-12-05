package com.senacrio.aluno;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senacrio.aluno.controller.AlunoController;
import com.senacrio.aluno.model.Aluno;

public class TesteUpdate {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		AlunoController controller = new AlunoController();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o id do aluno:");
		int id = sc.nextInt();
		System.out.println("Insira o novo nome do Aluno:");
		String nome = sc.nextLine();
		
		controller.UpdateNomeAluno(id, nome);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
