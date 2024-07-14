package com.Allura.Foro_Hub_Allura.repository;

import com.Allura.Foro_Hub_Allura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}