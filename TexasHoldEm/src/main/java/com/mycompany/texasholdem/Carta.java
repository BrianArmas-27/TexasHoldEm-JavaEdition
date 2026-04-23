/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texasholdem;

/**
 * Contiene toda la información importante para las cartas.
 * @author Brian Armas
 */
public class Carta implements Comparable<Carta>
{
    //El as es de valor 12, el 2 de 0
    private int valor;
    private Palo palo;
    private final int MAX_VALOR=13;

    /**
     * Constructor que inicializa el valor y el palo de la carta.
     * @param valor Valor de la carta como numero entero. Un valor 0 representa un 2, y un valor 12 representa un As
     * @param palo Palo de la carta como enumerador. Enumerador que puede ser CORAZON,DIAMANTE,PICA o TREBOL
     */
    public Carta(int valor, Palo palo) {
        if(palo.equals(Palo.CORAZON)||palo.equals(Palo.DIAMANTE)||palo.equals(Palo.PICA)||palo.equals(Palo.TREBOL))
        {
            this.palo = palo;
        }
        if(!(valor>MAX_VALOR||valor<0))
        {
            this.valor=valor;
        }
    }

    /**
     * Accesor de valor
     * @return Devuelve el valor como número entero de la carta
     */
    public int getValor() {
        return valor;
    }

    /**
     * Accesor de palo
     * @return Devuelve el palo en forma de Enumerador de la carta
     */
    public Palo getPalo() {
        return palo;
    }
    
    /**
     * Redefinición de equals(). Dos cartas son iguales si tienen mismo valor y palo.
     * @param obj El objeto que se usará a comparar con esta clase
     * @return {@code true} Si el objeto es una carta y tiene el mismo valor y palo {@code false} Si el objeto no es una carta o no tiene mismo valor y palo
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Carta))
            return false;
        Carta car = (Carta) obj;
        return car.getValor()==(this.valor)&&car.getPalo().equals(this.palo);
    }

    /**
     * Compara las cartas por valor
     * @param c Carta de la cual cogeremos su valor para compararla de mayor a menor valor.
     * @return {@code 0} Si las dos cartas tienen el mismo valor {@code -1} Si c es mayor que esta Carta {@code 1} Si no es ninguno de estos casos
     */
    @Override
    public int compareTo(Carta c) 
    {
        if(this.valor == c.getValor())
            return 0;
        if(this.valor < c.getValor())
            return -1;
        return 1;
    }
    
    /**
     * toString(). Nada que decir.
     * @return Un String que presenta el valor y el palo de la Carta
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("valor=").append(valor);
        sb.append(", palo=").append(palo.toString());
        return sb.toString();
    }
}
