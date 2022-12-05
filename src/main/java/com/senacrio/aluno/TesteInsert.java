package com.senacrio.aluno;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senacrio.aluno.controller.AlunoController;

public class TesteInsert {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		String nome;
		String email;
		String cpf;
		String data;
		String naturalidade;
		String endereco;
		
		AlunoController controller = new AlunoController();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**********SISTEMA ACADEMICO DE ALUNOS*********");
			System.out.println("Insira o Nome: ");
			nome = sc.nextLine();
			System.out.println("Insira o Email: ");
			email = sc.nextLine();
			System.out.println("Insira o Cpf: ");
			cpf = sc.nextLine();
			System.out.println("Insira o Data de Nascimento: ");
			data= sc.nextLine();
			System.out.println("Insira o Naturalidade: ");
			naturalidade = sc.nextLine();
			System.out.println("Insira o Endereco: ");
			endereco = sc.nextLine();
			controller.InsertAluno(nome, email, cpf, data, naturalidade, endereco);
		
			
			entityManager.close();
			entityManagerFactory.close();
	}

}

