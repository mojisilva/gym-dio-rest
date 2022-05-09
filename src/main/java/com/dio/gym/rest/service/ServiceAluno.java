package com.dio.gym.rest.service;

import com.dio.gym.rest.entity.Aluno;
import com.dio.gym.rest.entity.form.AlunoUpdateForm;
import com.dio.gym.rest.repository.RepositorioAluno;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceAluno {

    @Autowired
    private RepositorioAluno repositorioAluno;

    public Aluno salvarAluno(@RequestBody Aluno aluno){
        repositorioAluno.save(aluno);
        return aluno;
    }
    public Optional<Aluno> buscarAluno(Long id){
        Optional<Aluno> aluno = repositorioAluno.findById(id);
        return aluno;
    }

    public Iterable<Aluno> listarAluno(){
        Iterable<Aluno> alunos = repositorioAluno.findAll();
        return alunos;
    }
    public Aluno atualizarAluno(@RequestBody Long id, Aluno aluno){
        repositorioAluno.findById(id).
                map(record -> {
                    record.setNome(aluno.getNome());
                    record.setBairro(aluno.getBairro());
                    record.setDataNascimento(aluno.getDataNascimento());
                    Aluno alunoAtual = repositorioAluno.save(record);
                    return ResponseEntity.ok().body(alunoAtual);
                });
        return aluno;
    }
    public void deletarAluno(Long id){
        repositorioAluno.findById(id);
        repositorioAluno.deleteById(id);
    }

}
