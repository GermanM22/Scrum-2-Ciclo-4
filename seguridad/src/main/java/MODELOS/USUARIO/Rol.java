package MODELOS.USUARIO;

import org.springframework.data.annotation.id;
import org.stringframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Document();
@Data;

public class Rol {
    @id
    private String _id;

    private String tipo;
    private String descripcion;
}
