
package com.example.screen.components;

import com.example.screen.Theme;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TextField extends JTextField {

    private final String ayuda;

    public TextField(String ayuda) {

        super(25);
        this.ayuda = ayuda;

        setFont(Theme.mono(Font.PLAIN, 18));
        setBackground(Theme.CARD);
        setForeground(Theme.TEXT);
        setCaretColor(Theme.TEXT);
        setBorder(crearBorde(Theme.BORDER));

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(crearBorde(Theme.BLUE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(crearBorde(Theme.BORDER));
            }
        });
    }

    private static CompoundBorder crearBorde(Color color) {
        return new CompoundBorder(
                new LineBorder(color, 1, true),
                new EmptyBorder(10, 14, 10, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (getText().isEmpty()) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(Theme.MUTED);
            g2.setFont(getFont());

            FontMetrics fm = g2.getFontMetrics();

            int y = (getHeight() + fm.getAscent()
                    - fm.getDescent()) / 2;

            g2.drawString(
                    ayuda, getInsets().left, y);

            g2.dispose();
        }
    }
}
