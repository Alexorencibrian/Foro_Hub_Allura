package com.Allura.Foro_Hub_Allura.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfiles = new ArrayList<>();
}