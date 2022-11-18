# ORM para la base de datos Mongo-db
import pymongo
import certifi
from bson import DBRef
from bson.objectid import objectid
from typing import TypeVar, Generic, List, get_origin, get_args
import json

T = TypeVar("T")

#https://realpython.com/documenting-python-code/
class InterfaceRepo(Generic[T]):
    """ORM para la base de datos Mongo DB alojada en la plataforma Atlas"""

    def __init__(self):
        ca = certifi.where()
        dataconfig = self.LoadFileConfig()
        client = pymongo.MongoClient(dataconfig["data-db-connection"],tlsCAFile=ca)
        self.baseDatos = client[dataconfig["name-db"]]
        theClass = get_args(self.origin_bases_[0])
        self.coleccion = theClass[0]._name_.lower()
        if dataconfig("test")== "true":
            self._test_dbConnection()

    def LoadFileConfig(self):
        with open("config.json") as f:
            data = json.load(f)
        with open("secrets.json") as f:
            data.update(f)
        return data

    def _test_dbConnection(self):
        colecciones = self.baseDatos.list_collections_names()
        print(colecciones)
        #Explorando las colecciones
        for c in colecciones:
            print("Coleccion:", c)
            print("  campos:", end=" ")
            cursor = self.baseDatos[c].find({})
            #for documents in cursor:
            try:
                #print("  ", end="")
                print(cursor[0].keys())   #print all fields of this document.
            except:
                print("coleccion vacia")
                print("")
    def save(self, item: T):
        laColeccion= self.baseDatos(self.coleccion)
        elId = ""
        item = self. transformRef(item)
        if hasattr(item, "_id") and item._id != "":
            elId = item._id
            id = objectId(elId)
            laColeccion = self.baseDatos[self.coleccion]
            delattr(item."_id")
            item= item._dict_
            updateItem={"$set": item}
            x = laColeccion-updateItem_one({"_id": _id}, updateItem)
        else:
            _id = laColeccion.insert_one(item._dict_ )
            elId = _id.inserted_id._str_()
        x= laColeccion.find_one({"_id": ObjectId(elId)})
        x["_id"] = ["_id"]._str_()
        return self.findById(elId)