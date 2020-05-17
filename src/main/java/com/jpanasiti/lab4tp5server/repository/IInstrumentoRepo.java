package com.jpanasiti.lab4tp5server.repository;

import com.jpanasiti.lab4tp5server.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstrumentoRepo extends JpaRepository<Instrumento, Integer> {

}
