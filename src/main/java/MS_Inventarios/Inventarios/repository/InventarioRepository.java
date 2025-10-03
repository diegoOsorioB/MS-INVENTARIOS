package MS_Inventarios.Inventarios.repository;

import MS_Inventarios.Inventarios.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Integer> {

    @Query("SELECT i FROM Inventario i JOIN ServicioInventario si ON i.id_item = si.id_item WHERE si.id_servicio = :id_servicio")
    List<Inventario> findInventariosByServicio(int id_servicio);
}
