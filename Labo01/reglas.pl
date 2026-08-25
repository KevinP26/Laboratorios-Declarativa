mismo_lugar(X, Y):-
    se_encuentra_en(X, Z),
    se_encuentra_en(Y, Z),
    \==(X, Y).

enemigos_a_enfrentar(X, Y, R) :-
    se_encuentra_en(X, Y),
    aparecen_en(R, Y),
    enemigo(R).

tiene_dos_armas(X) :-
    armado_con(X, pistola),
    armado_con(X, cuchillo).
