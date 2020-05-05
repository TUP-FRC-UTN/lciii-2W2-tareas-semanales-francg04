/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author franc
 */
public class Veterinaria
{
    private Scanner teclado = new Scanner(System.in);
    private Cliente[] clientes;
    private int cantidad, dia, mes, anio;
    private double promEdadMascotas;
    public Veterinaria()
    {
        promEdadMascotas=0;
        dia = 0;
        mes = 0;
        anio = 0;
        setCantidad();
        InitializeArray();
        Excecute();
        ShowResult();
    }
    public void setCantidad()
    {
        System.out.println("Ingrese la canitdad de clientes a cargar: ");
        cantidad = teclado.nextInt();
        clientes = new Cliente[cantidad];
    }
    public void InitializeArray()
    {
        for (int i = 0; i < clientes.length; i++)
        {
            clientes[i] = new Cliente();
        }
    }
    public void Excecute()
    {
        int i = 1;
        for(Cliente x : clientes)
        {
            System.out.println("\n--------------------------------------\n"+
                               "              Cliente Nro: "+i+
                               "\n--------------------------------------\n");
            i++;
            System.out.println("Ingrese el Id del Cliente: ");
            x.setNumCliente(teclado.nextInt());
            System.out.println("Ingrese el nombre del cliente: ");
            x.setNombre(teclado.next());
            System.out.println("Ingrese la fecha de ingreso del cliente\n"+
                               "(Hagalo con el formato dd/mm/aaaa) \n"+
                               "[REFERENCIA: [dd = dia][mm = mes][aaaa = año]]");
            String ingreso = teclado.next();
            setFecha(ingreso);
            x.setIngreso(dia, mes, anio);
            System.out.println("Ingrese el nombre de la mascota: ");
            x.setNombreMascota(teclado.next());
            System.out.println("Ingrese la fecha de nacimiento de la mascota: "+x.getMascota().getNombre()+"\n"+
                               "(Hagalo con el formato dd/mm/aaaa) \n"+
                               "[REFERENCIA: [dd = dia][mm = mes][aaaa = año]]");
            String nacimiento = teclado.next();
            setFecha(nacimiento);
            x.setNacimientoMascota(dia, mes, anio);
            promEdadMascotas += x.getMascota().getEdad();
        }
    }
    public int getAniguedadMasDe5()
    {
        int result = 0;
        for (Cliente x:clientes)
        {
            if(x.getAntiguedad()>5)
            {
                result++;
            }
        }
        return result;
    }
    public void ShowResult()
    {
        promEdadMascotas = promEdadMascotas/cantidad;
        System.out.println("\n--------------------------------------\n"+
                           "              RESULTADOS:\n"+
                           "--------------------------------------\n"+
                           "Cantidad de Clientes: "+cantidad);
        System.out.println("Edad promedio de las mascotas: "+promEdadMascotas);
        System.out.println("Clientes con antiguedad mayor a 5 años: "+getAniguedadMasDe5());
        System.out.println("\n¿Mostrar los datos cargados? [1 - SI] | [2 - NO]");
        int op = teclado.nextInt();
        if(op==1)
        {
            for(Cliente x: clientes)
            {
                System.out.println("\n--------------------------------------");
                System.out.println(x.datosCliente());
                System.out.println("--------------------------------------");
            }
        }
        else
        {
            System.exit(0);
        }
    }
    public void setFecha(String fecha)
    {
        String[] DMA = fecha.split("/");
        dia = Integer.parseInt(DMA[0]);
        mes = Integer.parseInt(DMA[1]);
        anio = Integer.parseInt(DMA[2]);
    }
    
}
