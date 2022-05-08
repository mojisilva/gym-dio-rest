package com.dio.gym.rest.repository;

import com.dio.gym.rest.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMatricula extends JpaRepository<Matricula, Long> {
}
