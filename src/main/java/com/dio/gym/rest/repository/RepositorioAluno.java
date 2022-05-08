package com.dio.gym.rest.repository;

import com.dio.gym.rest.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAluno extends JpaRepository<Aluno, Long> {
}
