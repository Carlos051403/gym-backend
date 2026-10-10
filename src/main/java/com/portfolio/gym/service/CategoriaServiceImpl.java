package com.portfolio.gym.service;

import com.portfolio.gym.entity.Categoria;
import com.portfolio.gym.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Categoría con ID " + id + " no encontrada en la base de datos."));
    }

    @Override
    public Categoria guardar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer id){
        categoriaRepository.deleteById(id);
    }

}
