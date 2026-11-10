#lang racket

(define (calcular-interes deposito)
  (cond
    [(<= deposito 40000)(exact->inexact(* deposito #e0.035))]
    [(<= deposito 260000)(exact->inexact(* deposito #e0.04))]
    [else(exact->inexact(* deposito #e0.045))]))


;Estos display son solo para probar la funcion
(displayln (calcular-interes 1000))
(displayln (calcular-interes 5000))
(displayln (calcular-interes 5555))
(displayln (calcular-interes 12345))
(displayln (calcular-interes 40000))
(displayln (calcular-interes 40001))
(displayln (calcular-interes 100000))
(displayln (calcular-interes 260000))
(displayln (calcular-interes 260001))
(displayln (calcular-interes 300000))