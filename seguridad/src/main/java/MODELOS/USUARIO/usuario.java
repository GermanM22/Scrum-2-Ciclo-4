package MODELOS.USUARIO;

import lombok.Data;

import lombok.AccessLevel;
import stringframework.Data.annotation.id;
import org.stringframework.data.mongodb.core.mapping.Document;
import static lombok.AccessLevel.

    @Document()
    @Data()

public class usuario {
    @id
    @setter(AccessLevel.NONE)
    private string _id;

    private string seudonimo;
    @NonNull private string correo;
    @NonNul string contrasena;
    @NonNull @DBREF private Rol rol;//clave foranea a Rol

    @json ignore
    public string getContrasena(){
    return Contrasena;
    }
    @jsonProperty
    public void setContrasena(String contrasena){
        if (contrasena != null) this.= contrasena;
    }
}



