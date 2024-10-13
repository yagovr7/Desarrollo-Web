import json

diccionario = {}
diccionario['nombre']='Berta'
diccionario['edad']=12
diccionario['hijos']= None

with open('persona2.json', 'w') as fichero:
    json.dump(diccionario, fichero)