package com.example.Libros.services;

import com.example.Libros.entities.Libro;
import com.example.Libros.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public Libro guardarLibro (Libro libro) {
        return repo.save(libro);
    }

    public List<Libro> mostrarTodos () {
        return repo.findAll();
    }

    public Libro mostrarUno (Long id) {
        Optional<Libro> optLibro = repo.findById(id);
        if(optLibro.isPresent()) {
            Libro libro = optLibro.get();
            return libro;
        }
        return null;
    }

    public Libro modificar (Libro libro, Long id) {
        Optional<Libro> optLibro = repo.findById(id);

        if(optLibro.isPresent()) {
            Libro libro1 = optLibro.get();
            libro1.setAnio(libro.getAnio());
            libro1.setEditorial(libro.getEditorial());
            libro1.setActivo(libro.getActivo());
            libro1.setAutor(libro.getAutor());
            libro1.setPrecio(libro.getPrecio());
            return repo.save(libro1);
        }
        return null;
    }

    public Libro borradoLogico (Long id) {
        Optional<Libro> optLibro = repo.findById(id);
        if(optLibro.isPresent()) {
            Libro libro = optLibro.get();
            libro.setActivo(false);
            return repo.save(libro);
        }
        return null;
    }

    public Boolean borradoFisico (Long id) {
        Optional<Libro> optLibro = repo.findById(id);
        if (optLibro.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
