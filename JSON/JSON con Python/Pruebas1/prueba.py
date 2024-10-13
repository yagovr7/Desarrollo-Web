import json
# cargamos el fichero en una variable llamada “datos”
with open('lista.json') as f:
 datos = json.load(f)

for persona in datos:
 print(persona) # mostramos su contenido

 with open('diccionario.json') as f:
     datos = json.load(f)
print(datos)

