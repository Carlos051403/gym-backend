package com.portfolio.gym.service;

import com.portfolio.gym.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> buscarTodas();

    Categoria buscarPorId(Integer id);

    Categoria guardar(Categoria categoria);

    void eliminar(Integer id);
}
