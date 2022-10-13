package com.example.Libros.controllers;

import com.example.Libros.entities.Libro;
import com.example.Libros.entities.DolarAPI;
import com.example.Libros.services.DolarService;
import com.example.Libros.services.LibroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class LibroController {

    @Autowired
    private LibroService libroService;

    DolarService servicioDolar = new DolarService();
    DolarAPI precioDolar = servicioDolar.libroDolar();

    public LibroController() throws IOException {
    }

    @ApiOperation("Obtener todos los libros")
    @GetMapping("/libros")
    public List<Libro> mostrarTodos () {
        return libroService.mostrarTodos();
    }

    @ApiOperation("Buscar un libro por id")
    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> mostrarUno ( @ApiParam("Id: ") @PathVariable Long id ) {
        Libro libro = libroService.mostrarUno(id);
        if(libro != null) {
            libro.setPrecioDolar(libro.getPrecio() / precioDolar.getVenta());
            return ResponseEntity.ok(libro);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation("Guardar un nuevo libro")
    @PostMapping("/libros")
    public ResponseEntity guardarLibro (@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }

    @ApiOperation("Modificar un libro")
    @PutMapping("/libros/{id}")
    public ResponseEntity modificarLibro(@RequestBody Libro libro, @PathVariable Long id) {
        Libro libro1 = libroService.modificar(libro,id);
        if(libro1 != null) {
            libroService.modificar(libro1,id);
            return ResponseEntity.ok(libro1);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation("Borrado lógico de un libro por id")
    @PutMapping("/libros/borradoLogico/{id}")
    public ResponseEntity borradoLogico (@PathVariable Long id) {
        Libro libro = libroService.borradoLogico(id);
        if(libro != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
    Borrado físico de un libro por id
    */
    @ApiIgnore
    @DeleteMapping("/libros/borradoFisico/{id}")
    public ResponseEntity borradoFisico (@PathVariable Long id) {
        Boolean borradoSatisfactorio = libroService.borradoFisico(id);
        if(borradoSatisfactorio)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
