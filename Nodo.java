/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAVL;

/**
 *
 * @author elisagarciazafra
 */
public class Nodo<T extends Comparable <T>>{
    T dato;
    Nodo<T> izq;
    Nodo<T> der;
    Nodo<T> papa;
    int fe;

    public Nodo() {
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.izq=null;
        this.der=null;
        this.papa=null;
        this.fe=0;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getIzq() {
        return izq;
    }

    public void setIzq(Nodo<T> izq) {
        this.izq = izq;
    }

    public Nodo<T> getDer() {
        return der;
    }

    public void setDer(Nodo<T> der) {
        this.der = der;
    }

    public Nodo<T> getPapa() {
        return papa;
    }

    public void setPapa(Nodo<T> papa) {
        this.papa = papa;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public int getFe(Nodo<T> n) {
        if(n==null)
            return -1;
        else
            return getFe(n.der)-getFe(n.izq);
    }
    
    public void eliminaSubarbol(T elem){
        if(elem==null)
            return;
        if(elem.compareTo(dato)<=0)
            izq=null;
        else
            der=null;
    }
    
    public void cuelga(Nodo<T> n){
        if(n==null)
            return;
        if(n.dato.compareTo(dato)<=0)
            izq=n;
        else
            der=n;
        n.papa=this;
    }

    
    
    
    
    
}
