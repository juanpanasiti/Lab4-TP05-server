package com.jpanasiti.lab4tp5server.controller;

import com.jpanasiti.lab4tp5server.entities.Instrumento;
import com.jpanasiti.lab4tp5server.service.InstrumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")

@RequestMapping(path = "api/v1/instrumento")
public class InstrumentoController extends GenericController<Instrumento, InstrumentoService> {
    private static final Logger logger = LoggerFactory.getLogger(InstrumentoController.class);

    @PostMapping(value= "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity post(@RequestBody Instrumento instrumento, @RequestParam("imagen") MultipartFile imagen) {
        try{
            logger.info(String.format("Imagen '%s' subida", imagen.getOriginalFilename()));

            return super.post(instrumento);

        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"Mi mensaje post\": \"" + e.getMessage() + "\"}");
        }
    }
}
