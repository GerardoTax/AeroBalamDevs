/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases.estructuraDeArchivo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Pasaporte implements Serializable{
    private int noPasaporte;
    private String  contrasella;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String estadoCivil;
    private String nombre;
    private String apellido;
    private String Sexo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaEmision;
    private String paisActual;
    private int millasrecoridas;

    public Pasaporte(int noPasaporte, String contrasella, LocalDate fechaNacimiento, String nacionalidad, String estadoCivil, String nombre, String apellido, String Sexo, LocalDate fechaVencimiento, LocalDate fechaEmision, String paisActual, int millasrecoridas) {
        this.noPasaporte = noPasaporte;
        this.contrasella = contrasella;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Sexo = Sexo;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEmision = fechaEmision;
        this.paisActual = paisActual;
        this.millasrecoridas = millasrecoridas;
    }

    public int getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(int noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public String getContrasella() {
        return contrasella;
    }

    public void setContrasella(String contrasella) {
        this.contrasella = contrasella;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getPaisActual() {
        return paisActual;
    }

    public void setPaisActual(String paisActual) {
        this.paisActual = paisActual;
    }

    public int getMillasrecoridas() {
        return millasrecoridas;
    }

    public void setMillasrecoridas(int millasrecoridas) {
        this.millasrecoridas = millasrecoridas;
    }

    
}
