/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1_ipc1__;
import java.util.Scanner;
/***
 *
 * @author BOHRKWAQ9CR
 */
public class Practica1_ipc1__ 
{
    public static String[][] productos = new String[20][2];
    public static String[][] cupones = new String[20][2];
    public static int[] almacenamientoGlobal = new int[20];
    public static int idProducto = 0;
    public static int codigoDescuento = 0;
    public static  Scanner entradaTeclado = new Scanner(System.in);
    public static String opcion = "";
    public static void main(String[] args) {
        String nombreUsuario;
        int password;
        final int hardcodedPass = 202200235;
        final String hardcodedName = "Eduardo";
        boolean matchName = false;
        boolean matchPass = false;
       
        System.out.println("Bienvenido a SUPER-25");
        while(matchName==false||matchPass==false){
            System.out.println("Ingrese su nombre de usuario:");
            nombreUsuario = entradaTeclado.next();
            System.out.println("Ingrese su Contraseña:");
            password = entradaTeclado.nextInt();
            System.out.println("Verificando...");
                if (nombreUsuario.equals(hardcodedName)){
                    matchName = true;
            }
                else{
                    matchName = false;
                System.out.println("Su Nombre de Usuario es Incorrecto:");
            }
                if (password==hardcodedPass){
                    matchPass = true;
                }
                else{
                    matchPass = false;
                    System.out.println("La Contraseña Ingresada es Incorrecta:");
                    
                }
                if (matchName&&matchPass){
                    System.out.println("Información Validada con Exito!!");
                    System.out.println("Bienvenido al Sistema!!");
                    
                }
                else {
                    System.out.println("Upps!!...Algo Salio mal, Verifique su información");
                }
                
                   
        }
        
        while(!opcion.equals("5")){
            listaOpciones();
            menu();
        }
       
    }
    public static void listaOpciones(){
        System.out.println("***************************");
        System.out.println("Que gestion desea realizar?.");
        System.out.println("Elija una de las siguientes Opciones");
        System.out.println("1. Agregar Nuevos Productos.");
        System.out.println("2. Agregar Cupondes de Descuento.");
        System.out.println("3. Realizar Ventas");
        System.out.println("4. Realizar un Reporte");
        System.out.println("5. Salir del sistema");
        System.out.println("Elija Una Opción:");
        opcion = entradaTeclado.next();
        System.out.println("****************************");
        
    }
    public static void menu(){
        switch(opcion){
                case "1":
                    registroNuevoProducto();
                    break;
                case "2":
                    registrarCuponesDescuento();
                    break;
                case "3":
                    realizarVentas();
                    break;
                case "4":
                    realizarReporte();
                    break;
                default:
                    System.out.println("Saliendo del Programa....");
        }
    }
    public static void registroNuevoProducto(){
        
        System.out.println("Agregar Productos Nuevos.");
        if(idProducto<productos.length)
        {
        System.out.println("Ingrese el nombre del producto: ");
        String articulo = entradaTeclado.next();
        System.out.println("Ingrese el precio del producto: ");
        String precio = entradaTeclado.next();
        while(precio.equals("0")){
            System.out.println("EL costo debe ser mayor a cero.");
            System.out.println("Ingrese el nuevo valor del producto:");
            precio = entradaTeclado.next();
        }
            System.out.println("Precio validado con exito");
            
   
        agregarDatosArticulos(articulo, precio);
        }
        
        else    
        {
                System.out.println("Limite alcanzado de productos que usted puede comprar. :v");
        } 
        
     
    }
    
    public static void agregarDatosArticulos(String articulo, String precio){
        if(existeProducto(articulo)==-1)
        {
            productos[idProducto][0] = articulo;
            productos[idProducto][1] = precio;
            idProducto++;
        }
        else{
            System.out.println("El articulo ingresado ya existe.");
        }
    }
    public static int existeProducto(String articulo){
        for(int fila = 0; fila<productos.length; fila++)
        {
            if(productos[fila][0]!=null)
            {
                if(productos[fila][0].equals(articulo))
                {
                    return fila;
                }
            }
            else
            {
                return -1;
                
            } 
        }
        return -1;
        
    }
    
    public static void registrarCuponesDescuento()
    {
        System.out.println("Registrar Cupones de Descuento.");
        if(codigoDescuento<cupones.length)
        {
            System.out.println("************************");
            System.out.println("Ingrese el codigó cupon:");
            String codigoCupon = entradaTeclado.next();
            System.out.println("EL codigoCupon es:" + codigoCupon + "##");
        while(!codigoCupon.isBlank()&& codigoCupon.length()!=4)
        {
                System.out.println("El codigo cupon debe poseer unicamente 4 caracteres ");
                System.out.println("Ingrese un codigo-cupon válido.");
                codigoCupon = entradaTeclado.next();
        }
            System.out.println("Ingrese el porcentaje de descuento del cupon:");
            String porcentajeDescuento = entradaTeclado.next();           
        while(Integer.parseInt(porcentajeDescuento) > 0 && Integer.parseInt(porcentajeDescuento) < 100)
        {
            System.out.println("EL porcentaje de descuento debe ser mayor a cero.");
            System.out.println("Ingrese el nuevo valor de porcentaje:");
            porcentajeDescuento = entradaTeclado.next();
        }
            System.out.println("Porcentaje Validado con éxito!!!");
            almacenarDatosCupones(codigoCupon,porcentajeDescuento);
            

        }
      
        
        
    }
    public static void almacenarDatosCupones(String codigoCupon, String porcentajeDescuento)
    {
        if(existeCupon(codigoCupon)==-1)
        {
            cupones[codigoDescuento][0] = codigoCupon;
            cupones[codigoDescuento][1] = porcentajeDescuento;
            
        }
        else
        {
            System.out.println("El Cupon ya existe");
            
        }
         
            
    }
    public static int existeCupon(String codigoCupon)
    {
        for(int filla = 0; filla<cupones.length; filla++)
        {
            if(cupones[filla][0]!=null)
            {
                if(cupones[filla][0].equals(codigoCupon))
                {
                    return filla;
                }
                
            }
            else
            {
                return -1;
                
            }
            
           
            
        }
        return -1;
    }
        
    public static void realizarVentas()
    {
        System.out.println("Realizar Ventas");
        String nombreUsuario = "";
        String nit = "";
        String confirmación = "";
        final String consumidorF = "Consumidor Final";
        System.out.println("El Usuario desea Ingrasar datos personales ?.");
        System.out.println("Ingrese 'Si' para confirmar y agregar datos");
        System.out.println("Ingrese 'No' para indicar que no se ingresaran datos al sistema.");
        confirmación = entradaTeclado.next();
        if (confirmación.equalsIgnoreCase("si"))
        {
            System.out.println("Ingrese el Nombre del Usuarios.");
            nombreUsuario = entradaTeclado.next();
            System.out.println("Ingrese el NIT del Usuario");
            nit = entradaTeclado.next();
        }
         if (confirmación.equalsIgnoreCase("no")){
            System.out.println(consumidorF);
                
        }
        System.out.println("Productos - Precios");
        for(int fila = 0; fila<productos.length; fila++)
        {
            if(productos[fila][0]!=null)
            {
                System.out.println(productos[fila][0] + " - " + productos[fila][1]);  
            }
            
        }
        String bandera = "";
        String productoComprar, precioPagar;
        int indice;
        String cantidadDeProducto = "";
        int indicelocal = 0;
        String almacenamientoProductos[][] = new String[20][3];
        System.out.println("Que productos desea comprar?...");
        while(!bandera.equalsIgnoreCase("finish"))
        {
            System.out.println("Ingrese el nombre del producto a comprar...");
            productoComprar = entradaTeclado.next();
            indice = existeProducto(productoComprar);
            System.out.println("Ingrese la cantidad del producto que desea comprar: ");
            cantidadDeProducto = entradaTeclado.next();
            almacenamientoGlobal[indice] += Integer.parseInt(cantidadDeProducto);
            almacenamientoProductos[indicelocal][0] = productos[indice][0];
            
            
            
            
           
            
            
        }
            
             
            
        
        
        
        
        
        
                
        }
        
        
    
      
        
        
        
        
        
        
    
    public static void realizarReporte(){
        System.out.println("Realizar Reporte");
        
    }
    
}


   
