package Servidor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import Conexion.Conexion;
import java.util.StringTokenizer;
import java.io.PrintWriter;
//heredamos de la clase conexion a traves de extends Conxion para usar los sockets
public class Servidor extends Conexion {
	//Usamos constructor para servidor de Conexion
    public Servidor() throws IOException{
    	super("servidor");
    	}
  //Con este metodo se inicia el servidor
    public void startServer() {
        try {
        	System.out.println("Iniciando conexión del servidor");
        	//Acepta y espera la conexion del cliente
        	cs = ss.accept();
            System.out.println("Cliente en línea\n");
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter salida = new PrintWriter(cs.getOutputStream(), true);
            //se crea un bucle que se ejecuta mientras existan mensajes dede cliente
            while((mensajeServidor=entrada.readLine()) != null) {
            	String frase=mensajeServidor;
            	operacionesST(frase);
            }
            System.out.println("\nFin de la conexión");
            //cerramos conexion con cliente
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void operacionesST(String frase) {
    	//Imprimimos el mensaje que nos ha llegado al modulo
    	System.out.println(frase);
    	//Declaramos variables resultado para suma, resta, multiplicacion y division
    	int resultado1=0, resultado2=0, resultado3=0, resultado4=0;
    	//Declaramos variables contadores necesarias para suma, resta, multiplicacion y division
    	int i=0, j=0, k=0, l=0, m=0, n=0, p=0, q=0;
    	//Declaramos operandos para suma, resta, multiplicacion y division
    	int a1=0, b1=0, a2=0, b2=0, a3=0, b3=0, a4=0, b4=0;
    	//String partesa1 inicializado en "a" - SUMA - partesa1 tendra el valor "45,5"
    	String cadena1 = "a";
    	//int part inicializado en "a" - SUMA - partesa1 tendra el valor "45,5"
    	String cadena2 = "a";
    	//String partesa2 inicializado en "a" - RESTA - partesa2 tendra el valor "45,5"
    	String cadena3 = "a";
    	//String partesa3 inicializado en "a" - MULTIPLICACION - partesa3 tendra el valor "2,4"
    	String cadena4 = "a";
    	//String partesa4 inicializado en "a" - DIVISION - partesa4 tendra el valor "15,5"
    	String partesa4 = "a";
    	//Tokenizer para cada operacion ya que sino me daba error
    	StringTokenizer st = new StringTokenizer(frase, " ");
    	StringTokenizer st3 = new StringTokenizer(frase, " ");
    	StringTokenizer st5 = new StringTokenizer(frase, " ");
    	StringTokenizer st7 = new StringTokenizer(frase, " ");
    	if(st.nextToken().contains("Suma"))
    		{
    		//Recorre Tokenizer Suma para copiar en cadena1 el valor "45,5"
	   			while(st.hasMoreTokens()) {
	   				cadena1=st.nextToken(); 
	   			}
	   			//Genera Tokenizer2 con "," de separacion
	   			StringTokenizer st2 = new StringTokenizer(cadena1, ",");
	   			a1=0;
	   			b1=0;
	   			//Se da el valor a1
	   			a1=Integer.parseInt(st2.nextToken());
	   			i=0;
	   			while(st2.hasMoreTokens()) {
	   				//Se da valor a b1
	   				b1=Integer.parseInt(st2.nextToken());
	   				i++;	
	   			}
	   			//se calcula resultado1 que es la suma de a1+b1.
	   			resultado1=a1+b1;
	   			System.out.println("El resultado de la suma es: "+resultado1);
    		}
    	else if(st3.nextToken().contains("Resta"))
		{
    		//Recorre Tokenizer Resta para copiar en cadena2 el valor "45,5"
   			while(st3.hasMoreTokens()) {
   				cadena2=st3.nextToken();
   				}
   		//Genera Tokenizer2 con "," de separacion
   			StringTokenizer st4 = new StringTokenizer(cadena2, ",");
   			a2=0;
   			b2=0;
   		//Se da el valor a2
   			a2=Integer.parseInt(st4.nextToken());
   			l=0;
   			while(st4.hasMoreTokens()) {
   			//Se da valor a b2
   				b2=Integer.parseInt(st4.nextToken());
   				l++;	
   			}
   		//se calcula resultado2 que es la resta de a2 - b2.
   			int resultadoresta =a2-b2;
   			System.out.println("El resultado de la resta es: "+resultadoresta);
		}
    	if(st5.nextToken().contains("Multiplicacion"))
		{
    		//Recorre Tokenizer Multiplicacion para copiar en cadena3 el valor "2,4"
   			while(st5.hasMoreTokens()) {
   				cadena3=st5.nextToken(); 
   			}
   		//Genera Tokenizer2 con "," de separacion
   			StringTokenizer st6 = new StringTokenizer(cadena3, ",");
   			a3=0;
   			b3=0;
   		//Se da el valor a3
   			a3=Integer.parseInt(st6.nextToken());
   			n=0;
   			while(st6.hasMoreTokens()) {
   			//Se da valor a b3
   				b3=Integer.parseInt(st6.nextToken());
   				n++;	
   			}
   		//se calcula resultado3 que es la multiplicacion de a3*b3.
   			resultado3=a3*b3;
   			System.out.println("El resultado de la multiplicacion es: "+resultado3);
		}
    	if(st7.nextToken().contains("Division"))
		{
    		//Recorre Tokenizer Division para copiar en cadena4 el valor "15,5"
   			while(st7.hasMoreTokens()) {
   				cadena4=st7.nextToken(); 
   			}
   		//Genera Tokenizer2 con "," de separacion
   			StringTokenizer st8 = new StringTokenizer(cadena4, ",");
   			a4=0;
   			b4=0;
   	   		//Se da el valor a4
   			a4=Integer.parseInt(st8.nextToken());
   			q=0;
   			while(st8.hasMoreTokens()) {
   				//Se da el valor b4
   				b4=Integer.parseInt(st8.nextToken());
   				q++;	
   			}
   		//se calcula resultado4 que es la division de a4/b4.
   			resultado4=a4/b4;
   			System.out.println("El resultado de la multiplicacion es: "+resultado4);
		}
	}
}