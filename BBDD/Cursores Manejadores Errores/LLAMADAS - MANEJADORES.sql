CALL alumnos();

-- Probando CURSORES

CALL CURSOR1();
CALL CURSOR2();
CALL CURSOR2_REPEAT_UNTIL();
CALL CURSOR2_WHILE();
CALL cursor3(100);



-- Probando ERRORES

SELECT * FROM ALUMNOS;

CALL ERROR1(7,'Alberto Carrera'); -- Clave duplicada
CALL ERROR1(7,'Alberto Carrera');



CALL ERROR2(7,'David López');

CALL ERROR2(NULL,'María López');

CALL ERROR3(NULL,'David López');

CALL ERROR4(12,'David López',@R);
SELECT @R;

CALL ERROR5();

CALL ERROR6(9,'Fernando Carrera');

CALL ERROR7(11,'Pablo Martinez');

CALL ERROR8();

CALL ERROR13(null,'Olga Cuervo',@n,@t);
SELECT @N,@T;