package MS_Inventarios.Inventarios.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio_inventario")
public class ServicioInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_servicio;
    private int id_item;
    private int cantidad;
}
