package com.dio.gym.rest.controller;

import com.dio.gym.rest.entity.Aluno;
import com.dio.gym.rest.entity.form.AlunoUpdateForm;
import com.dio.gym.rest.service.ServiceAluno;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/gym/api/cadastrarAluno")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerAluno {

    private ServiceAluno serviceAluno;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvarAluno(@RequestBody @Valid Aluno aluno){
        return serviceAluno.salvarAluno(aluno);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarAluno(@PathVariable Long id){
        return serviceAluno.buscarAluno(id);
    }

    @GetMapping
    public Iterable<Aluno> listarAluno(){
        return serviceAluno.listarAluno();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno){
        return serviceAluno.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Long id){
        serviceAluno.deletarAluno(id);
    }
}
