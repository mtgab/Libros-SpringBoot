package com.example.Libros.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="Libro")
//@ApiModel("Entidad libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @ApiModelProperty("Clave principal autoincremental")
    private Long id;

    @Column(name="editorial")
    private String editorial;

    @Column(name="autor")
    private String autor;

    @Column(name="anio")
    private Integer anio;

    @Column(name="activo")
    private Boolean activo;

    @ApiModelProperty("Precio en pesos")
    @Column(name="precio_en_pesos")
    private Double precio;

    @ApiModelProperty("Precio en dólares. Se calcula cada vez que se realiza búsqueda por id a partir del precio" +
            " en pesos y el valor del dólar en el momento de la consulta. No se almacena en base de datos")
    @Transient
    Double precioDolar;
}