package com.john.examenpracticom5a.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direcion")
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "observacion")
    private String observacion;
    @Column(name = "dias_trabajo")
    private Integer dias_trabajo;
    @Column(name = "sueldo")
    private Integer sueldo;


}
