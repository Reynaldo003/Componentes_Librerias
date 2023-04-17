package TDA;

public class Asistentes {

    private byte edad;
    private String nombre, estadoC, sexo;

    public Asistentes(String nombre, byte edad, String sexo, String estadoC) {
        this.edad = edad;
        this.sexo = sexo;
        this.estadoC = estadoC;
        this.nombre = nombre;
    }

    public Asistentes() {

    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(String estadoC) {
        this.estadoC = estadoC;
    }

    @Override
    public String toString() {
        return "Informacion Del Asistente:\nNombre: " + nombre + "\nSexo: " + sexo + "\nEdad: " + edad + "\nEstado Civil: " + estadoC + "\n\n";
    }
}
