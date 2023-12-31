package com.banquito.core.banking.creditos.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.creditos.domain.TasaInteres;
import com.banquito.core.banking.creditos.service.TasaInteresService;

@RestController
@RequestMapping("/tasainteres")
public class TasaInteresController {
    @Autowired
    private TasaInteresService tasaInteresService;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<TasaInteres>> GetAll() {
        return new ResponseEntity<>(tasaInteresService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<TasaInteres> GetById(@PathVariable("id") String id) {
        return tasaInteresService.getById(id)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TasaInteres> Save(@RequestBody TasaInteres tasaInteres) {
        return new ResponseEntity<>(tasaInteresService.create(tasaInteres), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable("id") String id) {
        tasaInteresService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TasaInteres> Update(@RequestBody TasaInteres tasaInteres) {
        return new ResponseEntity<>(tasaInteresService.update(tasaInteres), HttpStatus.OK);
    }
    // @GetMapping("/bytasainteres/{tasainteres}")
    // public ResponseEntity<List<TasaInteres>>
    // GetByTipoTasaInteres(@PathVariable("tasainteres") String tasainteres) {
    // return tasaInteresService.GetByTipoTasaInteres(tasainteres).map(register -> {
    // return new ResponseEntity<>(register, HttpStatus.OK);
    // }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }
}
