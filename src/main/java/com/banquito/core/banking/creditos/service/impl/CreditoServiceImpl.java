package com.banquito.core.banking.creditos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.creditos.domain.Credito;
import com.banquito.core.banking.creditos.dao.CreditoRepository;
import com.banquito.core.banking.creditos.service.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService {
    @Autowired
    private CreditoRepository creditoRepository;

    @Override
    public List<Credito> getAll() {
        return (List<Credito>) creditoRepository.findAll();
    }
}
