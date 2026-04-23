/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texasholdem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Se recopilan los jugadores, el mazo de cartas, las cartas comunitarias, el bote... Y es donde se juega.
 * @author Brian Armas
 */
public class Mesa 
{
    private ArrayList<Jugador> jugadores;
    private ArrayList<Carta> mazo;
    private ArrayList<Carta> comunitarias;
    private int maxJugadores;
    private int bote;
    private boolean full;

    /**
     * Constructor. Inicializa todas las listas (Mazo, Jugadores, cartas comunitarias) y recibe el número máximo de jugadores
     * @param maxJugadores Numero máximo de jugadores como número entero.
     */
    public Mesa(int maxJugadores)
    {
        this.maxJugadores = maxJugadores;
        this.mazo = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.comunitarias = new ArrayList<>();
        this.bote =  0;
        this.full = false;
        createMazo();
    }
    
    /**
     * Crea el mazo con 52 cartas y lo baraja
     */
    private void createMazo()
    {
        mazo.clear();
        for (Palo p : Palo.values())
        {
            for (int i = 0; i < 13; i++)
            {
                Carta car = new Carta(i, p);
                mazo.add(car);
            }
        }
        Collections.shuffle(mazo);
    }
    
    /**
     * Añade todos los jugadores automáticamente con la misma cantidad de dinero.
     * @param dinero El dinero deseado que tenga cada jugador.
     */
    public void addJugadores(int dinero)
    {
        if(!full)
        {
            for(int i=0;i<maxJugadores;i++)
            {
                jugadores.add(new Jugador(i,dinero));
            }
        }
        full = true;
    }
    
    /**
     * Método manual para añadir un jugador a la mesa mientras no esté en la mesa y la mesa tenga espacio para este.
     * @param newJug El nuevo Jugador a añadir
     */
    public void addJugadorManual(Jugador newJug)
    {
        if(!full&&!(jugadores.contains(newJug))&&jugadores.size()<maxJugadores)
        {
            jugadores.add(newJug);
        }
    }
    
    /**
     * Coge el número de cartas especificadas. Función global para las rondas y para dar cartas a los jugadores.
     * @param maxCartas El número de cartas que se cogerán del mazo.
     * @return Devuelve un ArrayList de tipo Carta de las Cartas sacadas del mazo.
     */
    private ArrayList<Carta> repartir(int maxCartas)
    {
        ArrayList<Carta> cartas = new ArrayList<>();
        for(int i=0;i<maxCartas;i++)
        {
            cartas.add(mazo.remove(mazo.size()-1));
        }
        return cartas;
    }
    
    /**
     * Primera ronda. Cada jugador consigue 2 cartas, se establece un dealer y se apuestan las ciegas.
     */
    public void preflop()
    {
        comunitarias.clear();
        for(Jugador jug : jugadores)
        {
            jug.setCartas(repartir(2));
            //Dar ciegas a 2 jugadores, establecer un dealer...
        }
    }
    
    /**
     * Segunda ronda. Se ponen 3 cartas en la mesa y cada jugador decide si apostar, checkear o foldear.
     */
    public void flop()
    {
        comunitarias.addAll(repartir(3));
        //jugadores apuestan y hacen sus cosas...
    }
    
    /**
     * Tercera ronda. Se añade una carta a la mesa y cada jugador decide si apostar, checkear o foldear.
     */
    public void turn()
    {
        comunitarias.addAll(repartir(1));
        //jugadores apuestan y hacen sus cosas...
    }
    
    /**
     * Cuarta ronda. Se añade una carta a la mesa y cada jugador decide si apostar, checkear o foldear.
     */
    public void river()
    {
        comunitarias.addAll(repartir(1));
        //jugadores apuestan y hacen sus cosas...
    }
    
    /**
     * Última ronda. Se mira quién de los jugadores tiene la mejor mano y este se quedará con el bote.
     */
    public void showdown()
    {
        //Mirar las jugadas de cada jugador, ver cual es la mejor, ver si hay empate, etc.
        //Definir un ganador
        Jugadas checker = new Jugadas(jugadores, comunitarias);
        createMazo();
    }
}
