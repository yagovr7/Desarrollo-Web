import json

doc = '{"nombre": "Margarita", "idiomas": ["rumano", "chino"]}'
#está entre
# comillas, por lo que es un string no un diccionario

datos = json.loads(doc)

print(datos)
print(datos["nombre"])
print(datos["idiomas"])