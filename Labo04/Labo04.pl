almacenar(0, [0]).

almacenar(X, L) :-
    X > 0,
    almacenar_aux(X, L).

almacenar_aux(0, []).

almacenar_aux(X, [H|L1]) :-
    H is X mod 10,
    Y is X div 10,
    almacenar_aux(Y, L1).







