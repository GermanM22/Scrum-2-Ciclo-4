


class ControladorAdmonCandidatos():
    """Clase que implementa el controlador para los endpoints relacionados con AdmonCandidatos"""
    def __init__(self):
        self.repositorio = CandidatosRepo()
     def index(self):
     x =    self.repositorio.findAll()
     def create(self, data):
         print(">Crear un candidato")
         elCandidato = Candidato(data)
         elCandidato = self.repositorio.save(elCandidato(data))
         return elCandidato._dict_

     def retrieve(self, id):
         print(">mostrando un candidato con id", id)
         elCandidato= self.repositorio.findById(id)
         return elCandidato

     def update(self, id, data):
         print(">actualizando Candidato con id",id)
         candidatoActual = Candidatos(self.repositorioCandidatos.findById(id))
         candidatoActual = .cedula  = data["cedula"]
         candidatoActual = .nombre  = data["nombre"]
         candidatoActual = .apellido = data["apellido"]
         candidatoActual = .resolucion = data["resolucion"]
         return self.repositorioCandidatos.save("candidatoActual")



     def delete(self, id):
         print("eliminando Candidato con id", id)
         return self.repositorio.delete(id)

