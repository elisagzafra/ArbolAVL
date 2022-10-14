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
public class AVLMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
//        ArbolAVL<Character> avl= new ArbolAVL<Character>('A');
//        avl.raiz.izq=new Nodo('B');
//        avl.raiz.der=new Nodo('C');
//        avl.raiz.izq.izq=new Nodo('D');
//        avl.raiz.izq.der=new Nodo('E');
//        avl.raiz.der.izq=new Nodo('F');
//        avl.raiz.der.der=new Nodo('G');
//        avl.raiz.izq.izq.izq=new Nodo('H');
//        avl.raiz.der.izq.der=new Nodo('I');
//        System.out.println("\npre:");
//        avl.preOrden();
//        System.out.println("\nin:");
//        avl.inOrden();
//        System.out.println("\npost:");
//        avl.postOrden();
//        System.out.println("\npor niveles: "+"\n"+avl.toString());
        
        
        ArbolAVL<Integer> avl= new ArbolAVL<Integer>();

        avl.inserta(100);
        avl.inserta(200);
        avl.inserta(300);
        avl.inserta(250);
        avl.inserta(375);
        avl.inserta(280);
        avl.inserta(270);
        avl.inserta(260);
        System.out.println("\npor niveles: "+"\n"+avl.toString());
        
//        System.out.println("\nin:");
//        avl.inOrden();
        
        avl.borra(250);
        avl.borra(270);
        avl.borra(200);
        avl.borra(100);
        System.out.println("\npor niveles: "+"\n"+avl.toString());
        
        
//        System.out.println("\nin:");
//        avl.inOrden();

        
        
        
    }
    
}
