
package com.example;

import com.example.screen.Window;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) throws Exception {

        Connection motor = new Connection();

        SwingUtilities.invokeLater(() ->
                new Window(motor).setVisible(true));
    }
}
