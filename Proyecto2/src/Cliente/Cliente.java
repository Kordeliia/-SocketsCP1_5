package Cliente;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import Conexion.Conexion;
public class Cliente extends Conexion {
	//Usamos constructor de la clase Conexion para el cliente
    public Cliente() throws IOException{
    	super("cliente");
    } 
    //con este método iniciamos el cliente y la conexion con el servidor
    public void startClient() {
        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            salidaServidor.writeUTF("Suma 45,5" + "\n");
            salidaServidor.writeBytes("Resta 45,5" + "\n");
            salidaServidor.writeBytes("Multiplicacion 2,4" + "\n");
            salidaServidor.writeBytes("Division 15,5" + "\n");
            cs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}