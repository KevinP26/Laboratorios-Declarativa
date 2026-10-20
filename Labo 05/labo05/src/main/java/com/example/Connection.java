
package com.example;

import alice.tuprolog.Prolog;
import alice.tuprolog.Theory;
import alice.tuprolog.SolveInfo;
import java.io.InputStream;

public class Connection {

    private final Prolog engine = new Prolog();

    public Connection() throws Exception {
        try (InputStream in = getClass()
                .getResourceAsStream("/Labo05.pl")) {

            if (in == null) {
                throw new IllegalStateException(
                    "No se encontró Labo05.pl");
            }

            engine.setTheory(new Theory(in));
        }
    }

    public String consultar(String predicado,
                            String x, String y)
                            throws Exception {

        String consulta = predicado +
                "(" + x + "," + y + ",R).";

        SolveInfo info = engine.solve(consulta);

        return info.isSuccess()
                ? info.getTerm("R").toString()
                : "Sin solución";
    }
}
