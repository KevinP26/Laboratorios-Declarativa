% Ocupación:
ocupacion(leon, agente).
ocupacion(ashley, agente).
ocupacion(ada, espia).
ocupacion(luis, investigador).

% Edades:

edad(leon, 27).
edad(ashley, 20).
edad(ada, 26).
edad(luis, 32).

% Armamento:

arma(pistola).
arma(cuchillo).

armado_con(leon, pistola).
armado_con(leon, cuchillo).
armado_con(ada, pistola).
armado_con(luis, cuchillo).
no_lleva_armas_de_fuego(luis).

% Enemigos:

enemigo(ganados).
enemigo(regeneradores).

infectados_por(ganados, las_plagas).
infectados_por(regeneradores, las_plagas).

% Ubicación enemigos:

aparecen_en(ganados, pueblo).
aparecen_en(ganados, castillo).
aparecen_en(regeneradores, isla).

% Dificultad:

dificultad(pueblo, alta).
dificultad(castillo, alta).
dificultad(isla, muy_alta).


% Ubicacion personajes:

se_encuentra_en(leon, pueblo).
se_encuentra_en(luis, pueblo).
se_encuentra_en(ada, pueblo).
se_encuentra_en(ada, castillo).








