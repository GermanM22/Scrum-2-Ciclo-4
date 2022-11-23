package REPOSITORIOS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.
import org.springframework.data.mongodb.repository.Query;

import java.util.List;.data.mongodb.repository.Query;

public interface RepoUsuario extends MongoRepository <Usuario, String>{

    @Query(value"{}",fields="{seudonimo:0, rol:0}}")
    List<Usuario> index();

    Usuario FindbyEmail(string email);

    @agregation(pipeline={
            "{'$lookup':(from:'rol', localField:'rol'.·id'.foreignfield:'_id,as:'rol')}",
            "{'$match':{'rol.tipo':70}}"
    })
    List <Usuario> findByRol(String, rol);
}
