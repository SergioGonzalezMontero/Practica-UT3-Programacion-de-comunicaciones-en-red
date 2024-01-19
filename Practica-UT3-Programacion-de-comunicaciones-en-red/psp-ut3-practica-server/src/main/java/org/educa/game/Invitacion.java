package org.educa.game;

import java.io.*;
import java.net.Socket;

public class Invitacion implements Runnable{
    Socket socket;
    Server server;

    /**
     * Constructor de invitación, recibe socket y server
     * @param socket
     * @param server
     */
    Invitacion(Socket socket, Server server){
        this.socket=socket;
        this.server=server;
    }
    //Recibimos una String; nickNameOponente, host, puerto, anfitrion, idPartida

    /**
     * Metodo run para iniciar la invitación
     */
    @Override
    public void run() {
        StringBuilder datos = new StringBuilder();
        try(
            PrintWriter envioInfo = new PrintWriter(socket.getOutputStream());
            BufferedReader reciboInfo= new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            Jugador jugador = new Jugador(reciboInfo.readLine(),
                    reciboInfo.readLine(),
                    Integer.parseInt(reciboInfo.readLine()));
            server.getSala().getListaJugadores().add(jugador);
            server.comprobarPartida(jugador);
            /*datos.append(jugador.getNombre()).append(",").append("localhost").append(",").append(5555+server.obtenerIdPartida(jugador));
            boolean anfitrion = server.comprobarNumJugador(jugador);
            if(anfitrion){
                datos.append(",").append("anfitrion").append(",").append(server.obtenerIdPartida(jugador));
            }else{
                datos.append(",").append("invitado");
            }*/
            
            ///////////////////////////////////////////////
            ///////////////////////////////////////////////
            /////////////////TODO
            ///////////////////////////////////////////////
            ///////////////////////////////////////////////

            while(!server.comprobarPartidaLlena(jugador)){

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
