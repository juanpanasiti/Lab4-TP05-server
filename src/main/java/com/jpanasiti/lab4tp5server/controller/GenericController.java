package com.jpanasiti.lab4tp5server.controller;

import com.jpanasiti.lab4tp5server.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<E, S extends IGenericService<E>> {
    @Autowired //Define la inyección de dependencia
    protected S service;

    @GetMapping("/count")
    @Transactional
    public ResponseEntity<?> getCount(@RequestParam(value =  "size", defaultValue = "10") int size) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("{\"pages\": "+service.countPages(size)+"}");
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("")
    @Transactional
    public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value =  "size", defaultValue = "10") int size){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> getOne(@PathVariable int id) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"Mi mensaje get uno\": \"" + e.getMessage() + "\"}");

        }

    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity<?> post(@RequestBody E entityForm) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entityForm));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"Mi mensaje post\": \"" + e.getMessage() + "\"}");

        }

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> put(@PathVariable int id, @RequestBody E personaForm) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, personaForm));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable int id) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
        }

    }
}
