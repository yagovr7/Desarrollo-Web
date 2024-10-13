import json

diccionario = {}
diccionario['nombre']='Berta'
diccionario['edad']=12
diccionario['hijos']= None

with open('persona2.json', 'w') as fichero:
    json.dump(json.dumps(diccionario,indent=4,sort_keys=True),fichero)
