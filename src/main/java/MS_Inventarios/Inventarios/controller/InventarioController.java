package MS_Inventarios.Inventarios.controller;


import MS_Inventarios.Inventarios.entity.Inventario;
import MS_Inventarios.Inventarios.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> findAll() {

        return ResponseEntity.ok(inventarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(inventarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.save(inventario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> update(@PathVariable int id,@RequestBody Inventario inventario)
    {
        return ResponseEntity.ok(inventarioService.update(id, inventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        inventarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
