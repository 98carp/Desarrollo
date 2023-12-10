package com.banquito.core.banking.creditos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.creditos.domain.Credito;
import com.banquito.core.banking.creditos.service.CreditoService;

@RestController
@RequestMapping("/credito")
public class CreditoController {
    @Autowired
    private CreditoService creditoService;

    @GetMapping("/getall")
    public ResponseEntity<List<Credito>> GetAll() {
        return new ResponseEntity<>(creditoService.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Credito> GetById(@PathVariable("id") Integer id) {
        return creditoService.GetById(id)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Credito> Save(@RequestBody Credito credito) {
        return new ResponseEntity<>(creditoService.Save(credito), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable Integer id) {
        if (creditoService.Delete(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}