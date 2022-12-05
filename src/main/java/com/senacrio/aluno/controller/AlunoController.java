package com.senacrio.aluno.controller;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.senacrio.aluno.model.Aluno;


public class AlunoController {
	
	public Aluno FindOneById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		 Aluno aluno =  entityManager.find(Aluno.class,id);
		
		return aluno;
	}
	
	public static List<Aluno> FindOneOrderByLetterName() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select a from Aluno a";
		TypedQuery<Aluno> typedQuery = entityManager.createQuery(jpql,Aluno.class);
		List<Aluno> listaAluno = typedQuery.getResultList();
		
		return listaAluno;
	}
	
	public static List<Aluno> FindAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select a from Aluno a";
		TypedQuery<Aluno> typedQuery = entityManager.createQuery(jpql,Aluno.class);
		List<Aluno> listaAluno = typedQuery.getResultList();
		return listaAluno;
	}
	
	public void Delete(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Aluno aluno =  entityManager.find(Aluno.class,id);
		
		entityManager.getTransaction().begin();
		entityManager.remove(aluno);	
		entityManager.getTransaction().commit();
	}

	
	public void InsertAluno(String nome, String email, String cpf, String data, String naturalidade, String endereco  ) {
		Aluno aluno = new Aluno();
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setCpf(cpf);
		aluno.setDataDeNascimento(data);
		aluno.setNaturalidade(naturalidade);
		aluno.setEndereco(endereco);
		
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);	
		entityManager.getTransaction().commit();
	}
	
	public void UpdateNomeAluno(int id, String nome) {
		Aluno aluno = new Aluno();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		aluno.setId(id);
		aluno.setNome(nome);
		
		entityManager.getTransaction().begin();
		entityManager.merge(aluno);	
		entityManager.getTransaction().commit();
	}
}
