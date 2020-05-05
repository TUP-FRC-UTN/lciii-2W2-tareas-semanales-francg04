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
public class Mascota
{
    private String nombre;
    private Calendar nacimiento;
    
    public Mascota()
    {
        nombre = "";
        nacimiento = Calendar.getInstance();
    }
    public Mascota(String nombre, int dia,  int mes, int anio)
    {
        this.nombre = nombre;
        nacimiento = Calendar.getInstance();
        nacimiento.set(anio, (mes-1), dia);
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setNacimiento(int dia, int mes, int anio)
    {
        this.nacimiento.set(anio, (mes-1), dia);
    }
    public String getNacimiento()
    {
        return nacimiento.get(Calendar.DATE)+"/"+((nacimiento.get(Calendar.MONTH))+1)+"/"+nacimiento.get(Calendar.YEAR);
    }
    public int getEdad()
    {
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR)-nacimiento.get(Calendar.YEAR);
        if(hoy.get(Calendar.MONTH)>nacimiento.get(Calendar.MONTH))
        {
            
        }
        else
        {
            if(hoy.get(Calendar.MONTH)==nacimiento.get(Calendar.MONTH))
            {
                if(hoy.get(Calendar.DATE)<nacimiento.get(Calendar.DATE))
                {
                     edad--;
                }
            }
            else
            {
                edad--;
            }
        }
        return edad;
    }
    public String datosMascota()
    {
        return "Nombre: "+nombre+"\n"+
               "Nacimiento: "+getNacimiento()+"\n"+
               "Edad: "+getEdad()+" año/s";
    }
}
