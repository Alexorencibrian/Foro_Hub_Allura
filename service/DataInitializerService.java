package com.Allura.Foro_Hub_Allura.service;

import com.Allura.Foro_Hub_Allura.model.*;
import com.Allura.Foro_Hub_Allura.repository.*;
// ... (resto del código igual)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.Scanner;

@Service
public class DataInitializerService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @PostConstruct
    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Desea generar datos de prueba? (S/N)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            generarDatosPrueba();
        }
    }

    public void generarDatosPrueba() {
        // Crear usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario 1");
        usuario1.setCorreoElectronico("usuario1@example.com");
        usuario1.setContrasena("password1");
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario 2");
        usuario2.setCorreoElectronico("usuario2@example.com");
        usuario2.setContrasena("password2");
        usuarioRepository.save(usuario2);

        // Crear cursos
        Curso curso1 = new Curso();
        curso1.setNombre("Curso de Java");
        curso1.setCategoria("Programación");
        cursoRepository.save(curso1);

        Curso curso2 = new Curso();
        curso2.setNombre("Curso de Spring");
        curso2.setCategoria("Frameworks");
        cursoRepository.save(curso2);

        // Crear tópicos
        Topico topico1 = new Topico();
        topico1.setTitulo("Duda sobre Java");
        topico1.setMensaje("¿Cómo funciona la herencia en Java?");
        topico1.setStatus("PENDIENTE");
        topico1.setAutor(usuario1);
        topico1.setCurso(curso1);
        topicoRepository.save(topico1);

        Topico topico2 = new Topico();
        topico2.setTitulo("Pregunta sobre Spring");
        topico2.setMensaje("¿Qué es la inyección de dependencias?");
        topico2.setStatus("PENDIENTE");
        topico2.setAutor(usuario2);
        topico2.setCurso(curso2);
        topicoRepository.save(topico2);

        System.out.println("Datos de prueba generados con éxito.");
    }

    public void borrarDatos() {
        topicoRepository.deleteAll();
        usuarioRepository.deleteAll();
        cursoRepository.deleteAll();
        System.out.println("Todos los datos han sido borrados.");
    }
}