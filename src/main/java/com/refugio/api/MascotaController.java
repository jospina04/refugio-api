package com.refugio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    // Lista en memoria (sin base de datos)
    private final List<MascotaDTO> mascotas = new ArrayList<>(List.of(
            new MascotaDTO("Luna", "perro", 3),
            new MascotaDTO("Michi", "gato", 2),
            new MascotaDTO("Nube", "conejo", 1)
    ));

    // GET: devuelve todas las mascotas
    @GetMapping
    public ResponseEntity<List<MascotaDTO>> listar() {
        return ResponseEntity.ok(mascotas);
    }

    // GET con PathVariable: /mascotas/0 -> mascota en esa posicion
    @GetMapping("/{posicion}")
    public ResponseEntity<MascotaDTO> obtener(@PathVariable int posicion) {
        if (posicion < 0 || posicion >= mascotas.size()) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(mascotas.get(posicion)); // 200
    }

    // GET con RequestParam: /mascotas/buscar?especie=perro
    @GetMapping("/buscar")
    public ResponseEntity<List<MascotaDTO>> buscar(@RequestParam String especie) {
        List<MascotaDTO> resultado = mascotas.stream()
                .filter(m -> m.especie().equalsIgnoreCase(especie))
                .toList();
        return ResponseEntity.ok(resultado);
    }

    // POST con RequestBody: recibe JSON y lo convierte al DTO
    @PostMapping
    public ResponseEntity<MascotaDTO> agregar(@RequestBody MascotaDTO mascota) {
        mascotas.add(mascota);
        return ResponseEntity.status(201).body(mascota); // 201 Created
    }
}
