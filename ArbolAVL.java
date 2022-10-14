/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAVL;

import java.util.*;

/**
 *
 * @author elisagarciazafra
 */
public class ArbolAVL<T extends Comparable<T>>  {
    Nodo<T> raiz;
    int cont=0;

    public ArbolAVL() {
    }

    public ArbolAVL(T elem) {
        this.raiz = new Nodo(elem);
        cont++;
    }
    
    public int size(){
        return cont;
    }
    
    public int altura(Nodo<T> n) {
        if(n==null)
            return 0;
        else
            return altura(n.izq)-altura(n.der);
    }
    
    public boolean isEmpty() {
        boolean res=false;
        if(cont==0)
            res=true;
        return res;
    }

    public boolean busca(T elem) {
        return busca(elem,raiz)!=null;
    }
    
    private Nodo<T> busca(T elem,Nodo<T> n){
        Nodo<T> aux = null;
        if(n==null)
            return null;
        if(n.dato.equals(elem))
            return n;
        aux=busca(elem,n.izq);
        if(aux!=null)
            return aux;
        aux=busca(elem,n.der);
        return aux;
    }
    
    public void inserta(T elem){
        Nodo<T> nuevo=new Nodo<T>(elem);
        if(raiz==null)
            raiz=nuevo;
        Nodo<T> actual=raiz;
        Nodo<T> papa = null;
        boolean encontre = false;
        while(actual!=null && !encontre){
            papa=actual;
            if(elem.compareTo(actual.dato)<0)
                actual=actual.izq;
            else{
               if(elem.compareTo(actual.dato)==0)
                   encontre=true;
               else
                   actual=actual.der;
            }
        }
        actual=nuevo;
        boolean termine = false;
        if(!encontre){
            papa.cuelga(actual);
            cont++;
            termine=true;
        }
        while(!termine){
            if(papa==raiz){
                termine=true;
            }
            else{
                papa=actual.papa;
                if(actual==papa.izq)
                    papa.fe--;
                else
                    papa.fe++;
                if(papa.fe==0)
                    termine=true;
                if(papa.fe==2 || papa.fe==-2){
                    rota(papa);
                    if(papa == raiz)
                        raiz.setPapa(null);
                    termine=true;
                }
                actual=papa;
                papa=papa.papa;
            }
        }
        
    }
    
    private Nodo<T> rota(Nodo<T> actual) {
        Nodo<T> alfa,beta  = null,gamma = null,A,B = null,C = null,D,papa;
        if(actual.fe==-2 && (actual.izq.fe==-1 || actual.izq.fe==0)){ //izq-der
            papa=actual.papa;
            alfa=actual;
            beta=alfa.izq;
            D=alfa.der;
            A=beta.izq;
            gamma=beta.der;
            if(gamma!=null){
                B=gamma.izq;
                C=gamma.der;
                gamma.cuelga(alfa);
                gamma.cuelga(beta);
            }
            beta.cuelga(A);
            beta.cuelga(B);
            alfa.cuelga(C);
            alfa.cuelga(D);
            papa.cuelga(gamma);
            alfa.fe=altura(D)-altura(beta);
            if(gamma!=null){
                gamma.fe=altura(C)-altura(B);
                if(gamma.fe==-1){
                    alfa.fe=0;
                    gamma.fe=0;
                }
            }
        }
        return gamma;
    }
    
    public void borra(T elem){
        Nodo<T> actual=busca(elem,raiz);
        Nodo<T> papa;
        if(actual==null)
            return;
        if(actual.izq==null && actual.der==null){//una hoja
            if(actual.papa==null)
              raiz=null;
            else{
              papa=actual.papa;
              papa.eliminaSubarbol(elem);
              cont--;
            }
            return;
        }
        if(actual.izq==null || actual.der==null){//un hijo
            papa=actual.papa;
            if(actual==raiz){
                if(actual.izq==null)
                    raiz=actual.der;
                else
                    raiz=actual.izq;
            }
            else{
                if(actual.izq!=null)
                    papa.cuelga(actual.izq);
                else
                    papa.cuelga(actual.der);
            }
            cont--;
            return;
        }
        //encontrar sucesor inorden
        Nodo<T> sucesor=actual.der;
        while(sucesor.izq!=null)
            sucesor=sucesor.izq;
        actual.dato=sucesor.dato;
        if(sucesor==actual.der){
            actual.der=sucesor.der;
            if(actual.der!=null)
                actual.der.papa=actual;
        }
        else{
            sucesor.papa.izq=sucesor.der;
            if(sucesor.der!=null)
            sucesor.der.papa=sucesor.papa;
        }
        cont--;      
        //actualiza fe
        if (elem.compareTo(actual.dato)<0)
              actual.fe+=1;
        else
            actual.fe-=1;
        boolean termine = false;
        papa=actual.papa;
        while(!termine && papa!=null){
            if(actual==raiz)
                termine=true;
            else{
                if(papa.izq==actual)
                    papa.fe=+1;
                else
                    papa.fe=-1;
                if(papa.fe>=2 || papa.fe>=-2)
                    papa=rota(papa);
                if(papa.fe==1 || papa.fe==-1)
                    termine=true;
                actual=papa;
            }
        }
    }

    public void preOrden() {
        preOrden(raiz);
        System.out.println("");
        return;
    }
    
    private void preOrden(Nodo<T> n) {
        if(n==null)
            return;
        System.out.print(""+n.dato+" ");
        preOrden(n.izq);
        preOrden(n.der);
    }

    public void inOrden() {
        inOrden(raiz);
        System.out.println("");
        return;
    }
    
    public void inOrden(Nodo<T> n) {
        if(n==null)
            return;
        inOrden(n.izq);
        System.out.print(""+n.dato+" ("+n.getFe(n)+") ");
        inOrden(n.der);
    }

    public void postOrden() {
        postOrden(raiz);
        System.out.println("");
        return;
    }
    
    private void postOrden(Nodo<T> n){
        if(n==null)
            return;
        postOrden(n.izq);
        postOrden(n.der);
        System.out.print(""+n.dato+" ");
    }
    
        public String toString(){
        return this.toString(raiz);
    }
    
    private String toString(Nodo<T> n){
        StringBuilder sb = new StringBuilder();
        LinkedList<Nodo<T>> c = new LinkedList();
        c.add(n);
        Nodo<T> aux;
        while(!c.isEmpty()){
            aux = c.remove();
            sb.append(aux.dato.toString()).append("("+aux.getFe(aux)+") ");
            if(aux.izq != null)
                c.add(aux.izq);
            if(aux.der != null)
                c.add(aux.der);
        }
        return sb.toString();
    }
    

    
    
}
