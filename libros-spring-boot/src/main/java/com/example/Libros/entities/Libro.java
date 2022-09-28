package com.example.Libros.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="editorial")
    private String editorial;

    @Column(name="autor")
    private String autor;

    @Column(name="anio")
    private Integer anio;

    @Column(name="activo")
    private Boolean activo;

    @Column(name="precio_en_pesos")
    private Double precio;

    @Transient
    Double precioDolar;
}
