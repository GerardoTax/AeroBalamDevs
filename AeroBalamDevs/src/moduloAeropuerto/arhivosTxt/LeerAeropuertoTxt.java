/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.arhivosTxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import moduloAeropuerto.Manejadores.ManejadorCargaDatos;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
import moduloAeropuerto.clases.estructuraDeArchivo.Distancia;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.RenovacionPasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Reservacion;
import moduloAeropuerto.clases.estructuraDeArchivo.Tarjeta;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;
import moduloPasajero.manejadores.ManejadorDeUsuario;
import moduloPasajero.manejadores.ManejadorTarjeta;

/**
 *
 * @author dell
 */
public class LeerAeropuertoTxt {
    
    public ArrayList<Aeropuerto> leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Aeropuerto> lisAeropuerto = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"AEROPUERTO");
            //pasamos el texto a objeto
            Aeropuerto aeropuerto=ManejadorCargaDatos.construirAeropuerto(campos);
            if(aeropuerto!=null){
                lisAeropuerto.add(aeropuerto);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisAeropuerto;
    }
         //metodo Generico para separar campos
        private String[] separarCampos(String linea,String tipo) {
        String inicioVehiculo = tipo+"(";
        String lineaDeCampos = linea.substring(inicioVehiculo.length(), linea.length() - 2);
        System.out.println(lineaDeCampos);
        String[] campos = lineaDeCampos.split(",");
        return campos;
    }
    
    //metodo para leer Aerolinea
         public ArrayList<Aerolinea> leerFicheroAerolinea(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Aerolinea> lisAerolinea = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"AEROLINEA");
            //pasamos el texto a objeto
            Aerolinea aerolinea=ManejadorCargaDatos.construirAerolinea(campos);
            if(aerolinea!=null){
                lisAerolinea.add(aerolinea);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisAerolinea;
    }
     
       //metodo para leer  pasaporte
    public ArrayList<Pasaporte> leerFicheroPasaporte(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Pasaporte> lisPasaporte = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"PASAPORTE");
            //pasamos el texto a objeto
            Pasaporte  pasaporte=ManejadorDeUsuario.construirpasaporte(campos);
            if(pasaporte!=null){
                lisPasaporte.add(pasaporte);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisPasaporte;
    }
     
    //metodo para leer Aviones
     public ArrayList<Aviones> leerFicheroAviones(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Aviones> lisAviones = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"AVIONES");
            //pasamos el texto a objeto
            Aviones  aviones=ManejadorCargaDatos.construirAviones(campos);
            if(aviones!=null){
                lisAviones.add(aviones);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisAviones;
    }
    
     //metodo para leer Tarjeta
     public ArrayList<Tarjeta> leerFicheroTarjeta(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Tarjeta> lisTarjeta = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"TARJETA");
            //pasamos el texto a objeto
            Tarjeta  tarjeta=ManejadorTarjeta.construirTrajeta(campos);
            if(tarjeta!=null){
                lisTarjeta.add(tarjeta);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisTarjeta;
    }
     //metodo para leer distancia
     public ArrayList<Distancia> leerFicheroDistancia(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Distancia> lisDistancia = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"DISTANCIA");
            //pasamos el texto a objeto
            Distancia  distancia=ManejadorCargaDatos.construirDistancica(campos);
            if(distancia!=null){
                lisDistancia.add(distancia);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisDistancia;
    }
    //leerr vuelos
      public ArrayList<Vuelo> leerFicheroVuelo(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Vuelo> lisVuelo = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"VUELOS");
            //pasamos el texto a objeto
            Vuelo  vuelos=ManejadorDeUsuario.construirvuelos(campos);
            if(vuelos!=null){
                lisVuelo.add(vuelos);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisVuelo;
    }
   
  // leer reservacion 
      public ArrayList<Reservacion> leerFicheroReservacion(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Reservacion> lisReservacion = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"RESERVACION");
            //pasamos el texto a objeto
            Reservacion  reservacion=ManejadorDeUsuario.construirReservacion(campos);
            if(reservacion!=null){
                lisReservacion.add(reservacion);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisReservacion;
    }
    
   //leer Renovacion Pasaporte 
       public ArrayList<RenovacionPasaporte> leerFicheroRenovacionPasaporte(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<RenovacionPasaporte> lisRenovacion = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"RENOVACION");
            //pasamos el texto a objeto
            RenovacionPasaporte  renovacion=ManejadorDeUsuario.contruirRenovacion(campos);
            if(renovacion!=null){
                lisRenovacion.add(renovacion);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisRenovacion;
    }
}
