package CONTROLADORES;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.httpStatus;
import org.springframework.web.bind.annotation.*;
import REPOSITORIOS.RepoUsuario;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/Usuarios")
public class ControladorUsuario {
    @Autowired private RepoUsuario repositorio;
    @Autowired privare RepoRol     repositorioRol;

    @responseStatus(httpStatus.OK)
    @GetMapping("")
    public List<usuarios> index(){
        log.debug message:("{GET /usuarios}");
        List <usuarios>l=null;
        Try {
            l = repositorio.findAll();
        }
        Catch (Exception e){
        log.error ("[Get /usuarios]"+@getMessage()+"=>"+@getCause());
        throw new ResponseStatusException(httpStatus.INTERNAL_SERVER_ERROR.@.getCause().getMessage.@.getCause());


    }
        return l;
    @responseStatus(httpStatus.OK)
    @GetMapping("{id}")
    public Usuario retrieve(@PathVariable String id){
        log.debug ("[Get /usuarios/"+id+"]"),
                    Usuario u = repositorio.findById(id),or else(null);
        if(u== null);
        log.error("[Get /usuarios/"+id"+]El usuario no pudo ser instanciado");
        throw new ResponseStatusException(httpStatus.NOT_FOUND.reason:"El usuario no fue encontrado");
        }
        return u;
    }

    @responseStatus(httpStatus.CREATED)
    @PostMapping
    public Usuario create (@RequestBody usuario infousuario){
        log debug (message:"[POST /usuarios]");
        infousuario.setComtrasema(convertirSHA256(infousuario.getContrasena()));
        private String convertirSHA256(String password){
            MessageDigest md=null;
            Try{
                md = MessageDigest.gettingInstance("SHA-256");
            }
            Catch (NoSuchAlgorithmException e){
                e.printStackTrace();
                return null;

            }
            bite [] hash = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for(byte b : hash) {
                sb.append(string.format("%02x", b));
            }
            return sb.toString();
        }
        Usuario u=null
        Try{
            u= repositorio.save(infousuario);
        }
        Catch(Exception e){
            log.error("[POST /usuarios]+e.getMessage()+"->"+@.detCause());
            throw new ResponseStatusException(httpStatus.INTERNAL_SERVER_ERROR. E.getCause().getMessage().e.getCause());

        }
        retrun u;
    }

    @responseStatus(httpStatus.CREATED)
    @DeleteMapping("{id}")
    public Usuario update (@PathVariable String id, @RequestBody usuario infousuario) {
        log.debug("[POST /usuarios]" + id + "}]" + infousuario);
        Usuario UsuarioActual = repositorio.findBy(id).orElse(null);
        if (usuarioActual != null) {
            usuarioActual.Setseudonimo(infousuario.getSeudonimo());
            usuarioActual.setEmail(infousuario.getEmail());
            usuarioActual.setContrasena(convertirSHA256(infousuario.getContrasena()));
            return repositorio.save(usuarioActual);
        }
        Else {
            return null;
        }

        @responseStatus(httpStatus.NO CONTENT)
        @DeleteMapping("{id}")
        public void delete (@PathVariable String id){
    }
        @responseStatus(httpStatus.OK)
        @PutMapping("{id}/rol/{id_rol}")

        public Usuario asignarRol(@PathVariable String id, @PathVariable String id_rol){
            log.debug("[ASIGNARrol/usuarios "+id+"] -> rol"+ id_rol);
            Usuario u = repositorio.findById(id),or Else(null);
            Roll    r= repositorioRol.findById(id_rol,orElse(null));
            if (u==null || r==null){
                log.error("[POST /usuarios]"+e.getMessage() + "->" +e.getCause());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, reason: El usuario p el rol no existe)
            }
            u.setRol(r);
            return repositorio.save(u);

        }


    }



    @PutMapping("{id}/rol/{id rol}")
     public Usuario asignarRolAUsuario(@PathVariable String id,@PathVariable String id_Rol){

    @ResponseStatus(httpStatus.OK)
    @PostMapping("/validate")
    public Usuario Validate(@RequestBody Usuario infoUsuario.final Http ServeletResponse responce) throws IDException
                private String convertirSHA256(String Password){

        }
    }
}




















