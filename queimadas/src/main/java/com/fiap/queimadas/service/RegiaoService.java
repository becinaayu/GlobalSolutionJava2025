package com.fiap.queimadas.service;

import com.fiap.queimadas.model.Regiao;
import com.fiap.queimadas.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {
    @Autowired
    private RegiaoRepository regiaoRepository;

    public List<Regiao> listarTodas() {
        return regiaoRepository.findAll();
    }

    public Optional<Regiao> buscarPorId(Long id) {
        return regiaoRepository.findById(id);
    }

    public Regiao salvar(Regiao regiao) {
        return regiaoRepository.save(regiao);
    }

    public void deletar(Long id) {
        regiaoRepository.deleteById(id);
    }
}