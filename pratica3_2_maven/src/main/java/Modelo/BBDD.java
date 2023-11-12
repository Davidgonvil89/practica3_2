package Modelo;

import java.io.*;
import java.sql.*;

public class BBDD {

    private static PreparedStatement pstm = null;
    private static ResultSet rs = null;
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String BBDD = "login";
    private static final String USERBD = "root";
    private static final String PASSBD = null;
    private static Connection con = null;

    private static boolean conectarBBDD() {
        try {
            con = DriverManager.getConnection(URL + BBDD, USERBD, PASSBD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
        return true;
    }

    private static void desconectarBBDD(Connection entrada) throws IOException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al desconectar de la base de datos: " + ex.getMessage());
        }
    }

    public static boolean guardarUsuario(Usuario usuario) {

        if (conectarBBDD()) {
            String query = "INSERT INTO usuario (usuario, contrasenia, nombre, apellidos, fecha_nacimiento, correo) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                pstm = con.prepareStatement(query);

                if (!usuario.getUsuario().isEmpty() && !usuario.getContrasenia().isEmpty()) {
                    pstm.setString(1, usuario.getUsuario());
                    pstm.setString(2, usuario.getContrasenia());
                } else {
                    System.out.println("El nombre de usuario y la contraseña no pueden estar vacíos.");
                    return false;
                }

//          Establece los otros campos solo si no están vacíos o son diferentes de null
                if (usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
                    pstm.setString(3, usuario.getNombre());
                } else {
                    pstm.setNull(3, Types.VARCHAR);
                }

                if (usuario.getApellidos() != null && !usuario.getApellidos().isEmpty()) {
                    pstm.setString(4, usuario.getApellidos());
                } else {
                    pstm.setNull(4, Types.VARCHAR);
                }

                if (usuario.getFecha_nac() != null && !usuario.getFecha_nac().isEmpty()) {
                    pstm.setString(5, usuario.getFecha_nac());
                } else {
                    pstm.setNull(5, Types.VARCHAR);
                }

                if (usuario.getCorreo() != null && !usuario.getCorreo().isEmpty()) {
                    pstm.setString(6, usuario.getCorreo());
                } else {
                    pstm.setNull(6, Types.VARCHAR);
                }

                int filasAfectadas = pstm.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Usuario guardado exitosamente.");
                    return true;
                } else {
                    System.out.println("Error al guardar el usuario.");
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Error al conectar con la BBDD: " + ex.getMessage());
            } finally {
                try {
                    desconectarBBDD(con);
                } catch (IOException ex) {
                    System.out.println("Error al desconectar BBDD: " + ex.getMessage());
                }
            }
        } else {
            System.out.println("No se ha podido agregar al usuario. Error al conectar con la base de datos");
        }
        return false;
    }

    public static boolean consultarUsuario(String nombre_e) {
        if (conectarBBDD()) {

            String query = "Select usuario From usuario Where usuario = ?";

            try {
                pstm = con.prepareStatement(query);
                pstm.setString(1, nombre_e);

                rs = pstm.executeQuery();
                if (rs.next()) {
                    System.out.println("El usuario existe en la tabla.==========");
                    return true;
                } else {
                    System.out.println("El usuario no existe en la tabla.********");
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Error al consultar el usuario: " + ex.getMessage());
            } finally {
                try {
                    desconectarBBDD(con);
                } catch (IOException ex) {
                    System.out.println("Error al desconectar BBDD: " + ex.getMessage());
                }
            }

        }
        return false;
    }

    public static boolean loguearse(String nombre_e, String pass_e) {
        if (conectarBBDD()) {

            String query = "Select usuario, contrasenia From usuario Where usuario = ? AND contrasenia = ?";

            try {
                pstm = con.prepareStatement(query);
                pstm.setString(1, nombre_e);
                pstm.setString(2, pass_e);

                rs = pstm.executeQuery();
                if (rs.next()) {
                    System.out.println("El usuario existe en la tabla.---------");
                    return true;
                } else {
                    System.out.println("El usuario no existe en la tabla.+++++++");
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Error al intentar loguearse: " + ex.getMessage());
            } finally {
                try {
                    desconectarBBDD(con);
                } catch (IOException ex) {
                    System.out.println("Error al desconectar BBDD: " + ex.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean actualizarContraseña(String usuario, String nuevaContraseña) {
        if (conectarBBDD()) {
            String query = "UPDATE usuario SET contrasenia = ? WHERE usuario = ?";
            try {
                pstm = con.prepareStatement(query);
                pstm.setString(1, nuevaContraseña);
                pstm.setString(2, usuario);

                int filasAfectadas = pstm.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Contraseña actualizada exitosamente.");
                    return true;
                } else {
                    System.out.println("Error al actualizar la contraseña.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al conectar con la BBDD: " + ex.getMessage());
            } finally {
                try {
                    desconectarBBDD(con);
                } catch (IOException ex) {
                    System.out.println("Error al desconectar BBDD: " + ex.getMessage());
                }
            }
        } else {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
        return false;
    }

}
