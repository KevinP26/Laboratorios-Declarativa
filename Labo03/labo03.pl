
%Mi solución inicial%
sumatoria1an(1, 1).

sumatoria1an(N, X):-
   N > 1,
   C is (N-1),
   sumatoria1an(C, R),
   X is N+R.

%Solucion con condicion%

sumatoria1an_2(N, X):-
    (   N =:= 1 -> X = 1;
        N > 1,
        C is (N-1),
        sumatoria1an_2(C, R),
        X is N+R
    ).
