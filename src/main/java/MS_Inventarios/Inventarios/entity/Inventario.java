package MS_Inventarios.Inventarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventarios")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_item;
    public String nombre_item;
    public int cantidad_total;
    public int  cantidad_disponible;
    public String estado_item;
}
