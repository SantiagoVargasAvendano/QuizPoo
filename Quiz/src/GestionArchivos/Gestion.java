/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionArchivos;
import Proceso.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class Gestion {
    private String ruta;

    public Gestion(String ruta) {
        this.ruta = ruta;
    }
    
    public boolean guardar(ArrayList<Venta> productos) throws IOException{
        File archivo = new File(this.ruta);
        if(!archivo.exists())
            archivo.createNewFile();
        PrintStream salida = new PrintStream(archivo);
        for(Venta producto: productos){
            salida.print(producto);
            salida.print("\n");
        }
        salida.flush();
        salida.close();
        return true;
    }
    
    public ArrayList<String> cargar() throws FileNotFoundException{
        ArrayList<String> productos = new ArrayList<>();
        Scanner leer = new Scanner(new File(this.ruta));
        while(leer.hasNext()){
            productos.add(leer.next());
        }
        return productos;
    }
}
