/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texasholdem;

import java.util.ArrayList;

/**
 * Aquí, según las cartas de los jugadores y las cartas comunitarias, se calculan los valores de las manos de cada jugador.
 * @author Brian Armas
 */
public class Jugadas 
{
    private ArrayList<Carta> comunitarias;
    private ArrayList<Jugador> jugadores;

    /**
     * Constructor. Recoge listas de jugadores y de las cartas comunitarias
     * @param jugadores Los jugadores que están jugando
     * @param comunitaria Las cartas en la mesa
     */
    public Jugadas(ArrayList<Jugador> jugadores, ArrayList<Carta> comunitaria) 
    {
        this.jugadores = jugadores;
        this.comunitarias = comunitaria;
    }
    
    /**
     * Resultados de la ronda. Devuelve una lista de una lista de Enteros, representando el valor de la carta alta y el valor de la jugada respectivamente de cada jugador.
     * @return Devuelve... Algo...
     */
    public ArrayList<ArrayList<Integer>> resultados()
    {
        ArrayList<Integer> valores = new ArrayList<>();
        ArrayList<ArrayList<Integer>> valoresJugadores = new ArrayList<>();
        for(Jugador jug : jugadores)
        {
            valores.add(getCartaAlta(jug));
            valores.add(getValorJugada(jug));
            
            valoresJugadores.add(valores);
        }
        return valoresJugadores;
    }
    
    /**
     * Devuelve una lista de 7 cartas del jugador especificado, estas cartas siendo las 2 del jugador y las 5 de las comunitarias
     * @param jug El jugador del cual se quiere saber sus 7 cartas
     * @return Devuelve un ArrayList tipo Carta de las Cartas comunitarias y las del jugador especificado
     */
    private ArrayList<Carta> getCartas(Jugador jug)
    {
        ArrayList<Carta> cartasJugador = new ArrayList<>();
        cartasJugador.addAll(comunitarias);
        cartasJugador.addAll(jug.getCartas());
        return cartasJugador;
    }

    /**
     * Calcula el valor de la jugada de la mano de un jugador especificado. 
     * @param jug Jugador del cual se quiere saber el valor de su jugada
     * @return Devuelve el valor de la jugada del Jugador. 1 es Carta Alta, 10 es Escalera Real, 0 es que algo anda mal.
     */
    private int getValorJugada(Jugador jug)
    {
        int valor = 0;
        ArrayList<Carta> cartasJugador = getCartas(jug);
        //Calcula la jugada...
        return valor;
    }

    /**
     * Devuelve la carta con más valor del jugador.
     * @param jug El jugador del cual se quiere saber su mejor carta
     * @return Devuelve el valor de la carta más alta del jugador especificado
     */
    private int getCartaAlta(Jugador jug)
    {
        int maxValor = 0 ;
        ArrayList<Carta> cartasJugador = getCartas(jug);
        cartasJugador.addAll(jug.getCartas());
        for(Carta car : cartasJugador)
        {
            if(car.getValor() > maxValor)
                maxValor=car.getValor();
        }
        return maxValor;
    }
}
