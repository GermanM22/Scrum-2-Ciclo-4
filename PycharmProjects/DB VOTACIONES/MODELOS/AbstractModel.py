from abc import ABCMeta


class AbstractModel(metaclass=ABCMeta):
    def _init_(self, data):
        for llave, valor in data.items():
            setattr(self, llave, valor)