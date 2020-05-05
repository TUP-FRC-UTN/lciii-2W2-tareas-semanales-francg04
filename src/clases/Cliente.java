/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Calendar;

/**
 *
 * @author franc
 */
public class Cliente
{
    private int numCliente;
    private String nombre;
    private Calendar ingreso;
    private Mascota  mascota;
    
    public Cliente()
    {
       numCliente = 0;
       nombre = "";
       ingreso = Calendar.getInstance();
       mascota = new Mascota();
    }
    public Cliente(int numCliente, String nombre, int diaC, int mesC, int anioC, String nombreMascota, int diaN, int mesN, int anioN)
    {
        this.numCliente = numCliente;
        this.nombre = nombre;
        ingreso = Calendar.getInstance();
        ingreso.set(anioC, mesC, diaC);
        mascota = new Mascota(nombreMascota, diaN, mesN,anioN);
    }

    public int getNumCliente()
    {
        return numCliente;
    }

    public void setNumCliente(int numCliente)
    {
        this.numCliente = numCliente;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setIngreso(int dia, int mes, int anio)
    {
        this.ingreso.set(anio, (mes-1), dia);
    }
    public String getIngreso()
    {
        return ingreso.get(Calendar.DATE)+"/"+((ingreso.get(Calendar.MONTH))+1)+"/"+ingreso.get(Calendar.YEAR);
    }
    public int getAntiguedad()
    {
        Calendar hoy = Calendar.getInstance();
        int antiguedad = hoy.get(Calendar.YEAR) - ingreso.get(Calendar.YEAR);
        if(hoy.get(Calendar.MONTH) > ingreso.get(Calendar.MONTH))
        {
            
        }
        else
        {
            if(hoy.get(Calendar.MONTH) == ingreso.get(Calendar.MONTH))
            {
                if(hoy.get(Calendar.DATE) < ingreso.get(Calendar.DATE))
                {
                    antiguedad--;
                }
            }
            else
            {
                antiguedad--;
            }
        }
        return antiguedad;
    }
    public Mascota getMascota()
    {
        return mascota;
    }
    public void setMascota(Mascota mascota)
    {
        this.mascota = mascota;
    }
    public void setNombreMascota(String nombre)
    {
        this.mascota.setNombre(nombre);
    }
    public void setNacimientoMascota(int dia, int mes, int anio)
    {
        this.mascota.setNacimiento(dia, mes, anio);
    }
    public String datosCliente()
    {
        return "Id: "+numCliente+"\n"+
               "Cliente: "+nombre+"\n"+
               "Registro: "+getIngreso()+"\n"+
               "Antiguedad: "+getAntiguedad()+" año/s\n"+
               mascota.datosMascota();
    }
}
