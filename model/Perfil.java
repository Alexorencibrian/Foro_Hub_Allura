package com.Allura.Foro_Hub_Allura.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}