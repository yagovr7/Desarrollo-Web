import json

lista = []

objeto1 = {}
objeto1 ['nombre'] = 'Yago'
objeto1 ['edad'] = 25
objeto1 ['hijos'] = None

objeto2 = {}
objeto2 ['nombre'] = 'Claudia'
objeto2 ['edad'] = 20
objeto2 ['hijos'] = 1

lista.append(objeto1)
lista.append(objeto2)
#print(lista)
objeto1 ['nombre']=objeto2.get('nombre')
#print(lista)
objeto3={"nombre": "Bartolomé", "familia":{"padre":"Ramón", "madre":"Jimena"}}
#print(objeto3.get("familia").get("padre"))
lista.append(objeto3)
#print(lista)
lista.pop(0)
print(lista)