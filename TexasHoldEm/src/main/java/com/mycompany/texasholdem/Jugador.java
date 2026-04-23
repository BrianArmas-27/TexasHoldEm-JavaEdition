/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texasholdem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Contiene las cartas a jugar, índice de jugador, dinero (en fichas), y booleanos para saber si es el dealer o si es su turno
 * @author Brian Armas
 */
public class Jugador 
{
    private int numJugador;
    private ArrayList<Carta> cartas;
    private int dinero;
    private boolean dealer;
    private boolean active;

    /**
     * Constructor. Inicializa los booleanos dealer y active, el ArrayList cartas y le da un valor especificado de indice de jugador y su dinero (Para una mejor experiencia, cada jugador deberá tener la misma cantidad de dinero e indice consecuencial)
     * @param numJugador Índice del jugador como número entero. Servirá para decidir el orden de los turnos a la hora del juego
     * @param dinero Dinero en fichas como número entero. Sirve para apostar.
     */
    public Jugador(int numJugador, int dinero) {
        this.numJugador = numJugador;
        this.dinero = dinero;
        this.cartas = new ArrayList<>();
        this.active = false;
        this.dealer = false;
    }

    /**
     * Accesor al indice de jugador
     * @return Devuelve el índice del jugador como número entero
     */
    public int getNumJugador() {
        return numJugador;
    }

    /**
     * Mutador del indice de jugador
     * @param numJugador El índice deseado para este Jugador. Servirá para cambiar el orden después de una ronda.
     */
    public void setNumJugador(int numJugador) {
        this.numJugador = numJugador;
    }

    /**
     * Accesor a las cartas
     * @return Devuelve un ArrayList de tipo Carta. Servirá para determinar jugadas.
     */
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    /**
     * Mutador de las Cartas
     * @param cartas El ArrayList de las cartas que tendrá cada Jugador.
     */
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * Accesor al dinero
     * @return Devuelve el dinero en fichas como numero entero.
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Mutador del dinero
     * @param dinero El dinero deseado para el jugador. Se recomienda que cada jugador tenga el mismo número de dinero para una mejor experiencia de juego.
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Accesor al dealer
     * @return {@code true} Si el Jugador es el "Dealer", haciendo que sus 2 compañeros a su izquierda apuesten las ciegas {@code false} Si el Jugador no es el "Dealer"
     */
    public boolean isDealer() {
        return dealer;
    }

    /**
     * Mutador del dealer
     * @param dealer Establece si el jugador será el Dealer o no.
     */
    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    /**
     * Accesor a active
     * @return {@code true} Si es el turno del Jugador {@code false} Si no es el turno del Jugador
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Mutador de active
     * @param active Establece si es el turno del jugador o no.
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
    /**
     * Apuesta una cantidad de dinero
     * @param apuesta La cantidad de dinero a apostar. Se restará el
     * @return Devuelve la apuesta por... alguna razon ambigua...
     */
    public int apostar(int apuesta)
    {
        if(this.dinero-apuesta>=0)
            this.dinero-=apuesta;
        return apuesta;
    }
    
    //Check, Raise, Fold...
    
    /**
     * Redefinición de equals. Dos Jugadores son el mismo si tienen el mismo índice de jugador
     * @param obj El objeto que se comparará al Jugador
     * @return {@code true} Si el Objeto es un Jugador y tiene su mismo índice {@code false} Si el Objeto no es un Jugador o no tiene el mismo índice.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Jugador))
            return false;
        Jugador jug = (Jugador) obj;
        return jug.getNumJugador()==this.numJugador;
    }

    /**
     * toString(). No hay mucho que decir.
     * @return String que tiene el índice del Jugador, sus cartas y su dinero
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("numJugador=").append(numJugador);
        sb.append(", cartas=").append(Arrays.toString(cartas.toArray()));
        sb.append(", dinero=").append(dinero);
        return sb.toString();
    }
    
    
}
