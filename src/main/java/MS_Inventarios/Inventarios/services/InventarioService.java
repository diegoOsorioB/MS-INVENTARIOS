package MS_Inventarios.Inventarios.services;

import MS_Inventarios.Inventarios.entity.Inventario;
import MS_Inventarios.Inventarios.exception.Excepciones;
import MS_Inventarios.Inventarios.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    private InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> findAll() {
        try {
            return inventarioRepository.findAll();
        }catch(Exception ex) {
            throw new Excepciones.DataBaseException("Ocurrio un error: " + ex.getMessage());
        }
    }

    public Inventario findById(Integer id) {
        return inventarioRepository.findById(id)
                .orElseThrow(()->new Excepciones.itemNotFound(id));
    }

    public Inventario save(Inventario inventario) {

       try {
           return inventarioRepository.save(inventario);
       }catch(Exception ex) {
           throw  new Excepciones.DataBaseException("Ocurrio un error: " + ex.getMessage());
       }
    }

    public void delete(int inventario)
    {
        try {
            inventarioRepository.deleteById(inventario);
        }catch(Exception ex) {
            throw new Excepciones.itemNotFound(inventario);
        }
    }

    public Inventario update(int  id,Inventario inventario) {
        return inventarioRepository.findById(id).map(inventario1 ->  {
            inventario1.setNombre_item(inventario.getNombre_item());
            inventario1.setCantidad_total(inventario.getCantidad_total());
            inventario1.setCantidad_disponible(inventario.getCantidad_disponible());
            inventario1.setEstado_item(inventario.getEstado_item());
            return inventarioRepository.save(inventario1);
        }).orElseThrow(() -> new Excepciones.itemNotFound(id));
    }
}
