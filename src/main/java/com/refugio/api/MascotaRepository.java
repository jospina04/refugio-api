package com.refugio.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository ya trae save, findAll, findById, deleteById, existsById...
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Consulta personalizada: Spring la genera a partir del nombre del metodo
    List<Mascota> findByEspecieIgnoreCase(String especie);
}
