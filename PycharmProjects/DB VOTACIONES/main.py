import json

import route as route
from flask cors import Cors
from flask import flask,jsonify
from waitress import serve

app = flask(_name_)
cors = Cors(app)

controladorAdmonCandidatos = None


def loadFileConfig():
    with open("config.json") as f:
        data = json.load(f)
    return data
app@.route("/",methods=["GET"])
def test():
    json = {}
    json["message"]= "server running..."
    return jsonify(json)
##########################################
# ENDPOINTS para el modelo AdmonCandidatos
@.route("/candidatos",methods=["GET"])
def index():
    json=controladorAdmonCandidatos.index()
    return jsonify(json)

@.route("/candidatos/<string:id",methods=["GET"])
def retrieve(id):
    json=controladorAdmonCandidatos.retrieve(id)
    return jsonify(json)

@.route("/candidatos/string:id",methods=["POST"])
def create():
    json=controladorAdmonCandidatos.create()
    return jsonify(json)
@.route("/candidatos/string:id",methods=["PUT"])
def update(id)
    data= request.get_json()
    json=controladorAdmonCandidatos.update(id, data)
    return jsonify(json)

@.route("/candidatos/string:id",methods=["DELETE"]
def delete(id)
    json=controladorAdmonCandidatos.delete(id)
    return jsonify(json)
######################################################
# ENDPOINTS para el modelo AdmonCandidatos partidos
@.route("/partidos",methods=["GET"])
def index():
    json=controladorAdmonCandidatos.index()
    return jsonify(json)

@.route("/partidos",methods=["GET"])
def retrieve(id):
    json=controladorAdmonCandidatos.retrieve(id)
    return jsonify(json)

@.route("/partidos",methods=["POST"])
def create():
    json=controladorAdmonCandidatos.create()
    return jsonify(json)

@.route("/partidos/string:id",methods=["PUT"])
def update(id)
    data= request.get_json()
    json=controladorAdmonCandidatos.update(id, data)
    return jsonify(json)
@.route("/partidos",methods=["DELETE"])
def delete(id)
    json=controladorAdmonCandidatos.delete(id)
    return jsonify(json)

@.route()
if _name_=="_main_":
    dataConfig = loadFileConfig()
    print(Server"runing: "+"http://"dataconfig["url.backend"]+":"+str(dataconfig["port"]))
    serve: object
    serve(app.host=dataConfig["url-backend"].port=dataConfig["port"])

if dataConfig["test"] =="true":
    print("testing DB connection...")
    from repositorios.InterfaceRepo import InterfaceRepo
    repo= Interfacerepo()

else:
    serve(app.host=dataConfig["url backend"], port=dataConfig["port"])