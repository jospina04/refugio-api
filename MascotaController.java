package com.refugio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaRepository repositorio;

    // Inyeccion de dependencias por constructor: Spring entrega el repositorio
    public MascotaController(MascotaRepository repositorio) {
        this.repositorio = repositorio;
    }

    // CREATE -> 201
    @PostMapping
    public ResponseEntity<Mascota> crear(@RequestBody Mascota mascota) {
        mascota.setId(null); // el id lo genera la base de datos
        Mascota guardada = repositorio.save(mascota);
        return ResponseEntity.status(201).body(guardada);
    }

    // READ todas -> 200
    @GetMapping
    public ResponseEntity<List<Mascota>> listar() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    // READ por id -> 200 / 404
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtener(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Consulta personalizada: /mascotas/buscar?especie=perro -> 200
    @GetMapping("/buscar")
    public ResponseEntity<List<Mascota>> buscar(@RequestParam String especie) {
        return ResponseEntity.ok(repositorio.findByEspecieIgnoreCase(especie));
    }

    // UPDATE -> 200 / 404
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota datos) {
        return repositorio.findById(id)
                .map(existente -> {
                    existente.setNombre(datos.getNombre());
                    existente.setEspecie(datos.getEspecie());
                    existente.setEdad(datos.getEdad());
                    existente.setEstado(datos.getEstado());
                    return ResponseEntity.ok(repositorio.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE -> 204 / 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
