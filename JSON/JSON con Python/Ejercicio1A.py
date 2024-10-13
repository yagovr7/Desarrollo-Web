import json

with open('libreria.json') as f:
    datos = json.load(f)
    libros = datos.get('libreria').get('libro')
    for contenido in libros:
        print(contenido)

