
package com.example.screen;

import com.example.Connection;
import com.example.screen.components.Buttons;
import com.example.screen.components.TextField;
import com.example.screen.components.PanelResult;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window extends JFrame {

    private final TextField txtX =
            new TextField("Ej: 8");

    private final TextField txtY =
            new TextField("Ej: 3");

    private final PanelResult panelResultado =
            new PanelResult();

    private final JLabel lblEstado =
            new JLabel(" ");

    public Window(Connection motor) {

        super("Calculadora en Prolog");

        JPanel contenido = new JPanel();
        contenido.setLayout(
                new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setOpaque(false);

        agregar(contenido, etiqueta("Primer número"), 6);
        agregar(contenido, txtX, 14);

        agregar(contenido, etiqueta("Segundo número"), 6);
        agregar(contenido, txtY, 18);

        agregar(contenido, crearBotones(motor), 18);
        agregar(contenido, panelResultado, 12);

        lblEstado.setFont(Theme.sans(Font.PLAIN, 12));
        lblEstado.setForeground(Theme.MUTED);
        agregar(contenido, lblEstado, 0);

        JPanel raiz = new JPanel(
                new BorderLayout(0, 20));

        raiz.setBackground(Theme.BG);
        raiz.setBorder(
                new EmptyBorder(24, 28, 24, 28));

        raiz.add(crearEncabezado(), BorderLayout.NORTH);
        raiz.add(contenido, BorderLayout.CENTER);

        setContentPane(raiz);
        setMinimumSize(new Dimension(500, 500));
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel crearEncabezado() {

        JLabel titulo = new JLabel("Calculadora");
        titulo.setFont(Theme.sans(Font.BOLD, 24));
        titulo.setForeground(Theme.TEXT);

        JLabel subtitulo = new JLabel(
                "Suma y resta utilizando Prolog");

        subtitulo.setFont(
                Theme.sans(Font.PLAIN, 13));
        subtitulo.setForeground(Theme.MUTED);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setOpaque(false);

        p.add(titulo);
        p.add(Box.createVerticalStrut(4));
        p.add(subtitulo);

        return p;
    }

    private JPanel crearBotones(Connection motor) {

        Buttons btnSumar = new Buttons(
                "Sumar", Theme.BLUE, Theme.BG,
                26, 11, 14);

        Buttons btnRestar = new Buttons(
                "Restar", Theme.GREEN, Theme.BG,
                26, 11, 14);

        btnSumar.addActionListener(
                e -> ejecutar(motor, "suma"));

        btnRestar.addActionListener(
                e -> ejecutar(motor, "resta"));

        JPanel p = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 10, 0));

        p.setOpaque(false);
        p.add(btnSumar);
        p.add(btnRestar);

        return p;
    }

    private void ejecutar(Connection motor, String pred) {

        String x = txtX.getText().trim();
        String y = txtY.getText().trim();

        panelResultado.setTitulo(
                pred.equals("suma") ? "Suma" : "Resta");

        if (x.isEmpty() || y.isEmpty()) {
            mostrar("", "Ingresa ambos números",
                    Theme.AMBER);
            return;
        }

        try {
            // Comprobamos que ambos sean números
            double numeroX = Double.parseDouble(x);
            double numeroY = Double.parseDouble(y);

            if (!Double.isFinite(numeroX)
                    || !Double.isFinite(numeroY)) {
                throw new NumberFormatException();
            }

            // Enviamos los números a Prolog
            String resultado =
                    motor.consultar(pred, x, y);

            if (resultado.equals("Sin solución")) {
                mostrar("", resultado, Theme.AMBER);
            } else {
                mostrar(resultado, "Listo", Theme.GREEN);
            }

        } catch (NumberFormatException ex) {
            mostrar("", "Ingresa números válidos",
                    Theme.RED);

        } catch (Exception ex) {
            mostrar("", "Error: " + ex.getMessage(),
                    Theme.RED);
        }
    }

    private void mostrar(
            String resultado, String estado, Color color) {

        panelResultado.setTexto(resultado);
        lblEstado.setText(estado);
        lblEstado.setForeground(color);
    }

    private static void agregar(
            JPanel panel, JComponent componente,
            int espacioDespues) {

        componente.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(componente);

        if (espacioDespues > 0) {
            panel.add(Box.createVerticalStrut(
                    espacioDespues));
        }
    }

    private static JLabel etiqueta(String texto) {

        JLabel l = new JLabel(texto);
        l.setFont(Theme.sans(Font.BOLD, 12));
        l.setForeground(Theme.MUTED);

        return l;
    }
}
