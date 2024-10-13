import json

with open ('institutos.json') as archivo:
    datos = json.load(archivo)

#print(datos)

#print(datos["instituto"])
nombreAlumno="Yago Vila Rama"
contadorAlumnos=0
for instituto in datos["instituto"]:
    for planta in instituto["planta"]:
     for aula in planta["aulas"]:
         if aula["numero"]== 1:
            for equipo in aula["equipos"]:
                print(equipo["IP"])
                for alumno in aula["alumnos"]:
                    contadorAlumnos+=1
                    print(contadorAlumnos)
                    for alumno in aula["alumnos"]:
                        if alumno["nota"]==9:
                            print("Instituto:",instituto["nombre"])
                            print("Planta:",planta["nombre"])
                            print("Aula:",aula["numero"])
                


            #print(equipo)
                    #for alumno in aula["alumnos"]:
                #print(alumno)
                        #if alumno["nombre"]==nombreAlumno:
                           # print(nombreAlumno," tiene una nota de ",alumno["nota"])
                       # print(nombreAlumno," pertenece al aula:",aula["numero"])
                        #print(nombreAlumno," pertenece al instituto:",instituto["nombre"])

#print(datos["instituto"][0]["planta"][0]["aulas"][0])