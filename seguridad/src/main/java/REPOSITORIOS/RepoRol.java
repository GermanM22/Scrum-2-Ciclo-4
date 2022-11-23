Import edumintic2022.ms_seguridad.modelos.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.mintic2022.ms_Seguridad.modelos.Rol;

public interface RepoRol extends MongoRepository<Usuario, String> {

    /* @Query(value="{}",fields="{seudobimo:0, rol:0}")
    List <Usuario> Index();

    List<Usuario> findByEmail(String email); */

    /*  @aggregation(pipeline={
         "{'$lookup':{from:'rol', localField:'rol.$id', foreignField:'_id', as:'rol'}}",
         "{'$match' : {'rol.tipo':70}}"
         })
         List<Usuario> findByRol(String rol);
     */
}