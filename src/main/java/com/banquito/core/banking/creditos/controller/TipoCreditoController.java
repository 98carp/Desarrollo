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
import com.banquito.core.banking.creditos.domain.TipoCredito;
import com.banquito.core.banking.creditos.service.TipoCreditoService;

@RestController
@RequestMapping("/tipocredito")
public class TipoCreditoController {
    @Autowired
    private TipoCreditoService tipoCreditoService;

    @GetMapping("/getall")
    public ResponseEntity<List<TipoCredito>> GetAll() {
        return new ResponseEntity<>(tipoCreditoService.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<TipoCredito> GetById(@PathVariable("id") Integer id) {
        return tipoCreditoService.GetById(id)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TipoCredito> Save(@RequestBody TipoCredito tipoCredito) {
        return new ResponseEntity<>(tipoCreditoService.Save(tipoCredito), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable("id") Integer id) {
        if (tipoCreditoService.Delete(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}