package Modelo;

import UI.*;
import java.awt.*;
import javax.swing.*;

public class Metodos {

    private static JFrame ventanaAgregar = new jFAgregarUsuario();

//    public static boolean verificarUser(String user, String contra) {
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getUsuario().equals(user)) {
//                if (users.get(i).getContraseña().equals(contra)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static boolean verificaciones(String usuario_e, String pass_e) {

        String usuario = usuario_e;
        String contraseña = pass_e;
       
        //Verifica que no esten los campos vacios (obligatorios)
        if (usuario.equals("") || usuario_e == null) {
            JOptionPane.showMessageDialog(ventanaAgregar, "El usuario no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (contraseña.equals("") || contraseña == null) {
            JOptionPane.showMessageDialog(ventanaAgregar, "La contraseña no puede estar vacia.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (verificarDuplicado(usuario)) {
            JOptionPane.showMessageDialog(ventanaAgregar, "El usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return false;
    }

    public static boolean verificarCorreo(String correo) {

        if (correo.matches("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+")) {
            return true;
        }
        return false;
    }

    public static boolean verificarPassDoble(String contra1, String contra2) {
        //Verifica que coincidan las contras
        if (contra1.equals(contra2)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(ventanaAgregar, "La contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static boolean verificarDuplicado(String user) {
        //Verifica que no existan ya el usuario
        if (BBDD.consultarUsuario(user)) {
            JOptionPane.showMessageDialog(ventanaAgregar, "El usuario ya existe.//////////", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
        public static void centrarVentanaEnPantalla(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}
