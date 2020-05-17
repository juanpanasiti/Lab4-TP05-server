package com.jpanasiti.lab4tp5server.controller;

import com.jpanasiti.lab4tp5server.entities.Instrumento;
import com.jpanasiti.lab4tp5server.service.InstrumentoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

@RequestMapping(path = "api/v1/instrumento")
public class InstrumentoController extends GenericController<Instrumento, InstrumentoService> {

}
