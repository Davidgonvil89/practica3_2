package Modelo;

import java.util.HashMap;

public class Usuario {

    private static HashMap<String, String> usuarios;
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String apellidos;
    private String fecha_nac;
    private String correo;


    public Usuario() {
        usuarios = new HashMap<>();
        usuarios.put("david", "1234");
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contrasenia = contraseña;
    }

    public Usuario(String usuario, String contraseña, String nombre, String apellido, String fecha_nac, String correo) {
        this.usuario = usuario;
        this.contrasenia = contraseña;

    }

    public static boolean comprobarUsuario(String us, String pas) {
        return usuarios.containsKey(us) && usuarios.get(us).equals(pas);
    }

//    public static void agregarUsuario(String us, String pas) {
//        usuarios.put(us, pas);
//    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {

        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", apellido=" + apellidos + ", fecha_nac=" + fecha_nac + ", correo=" + correo + ", info=" + '}';
    }
}
