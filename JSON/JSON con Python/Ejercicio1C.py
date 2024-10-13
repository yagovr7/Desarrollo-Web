import json

with open ('libreria.json') as f:
    datos=json.load(f)
    print(datos['idioma'])
