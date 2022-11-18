import pymongo
import certifi

ca = certifi.where()
clyent = pymongo.Mongoclient("mongodb+srv:usuariopruebas:prueba123@cluster0.qfgmf.mongodb.net/estudiante?retryWrites=true&w+majority",tlsCAFile=ca)
