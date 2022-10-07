/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author elisagarciazafra
 */
public class ArbolMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArbolAVL<Integer> avl= new ArbolAVL<Integer>();
        
        avl.inserta(100);
        avl.inserta(200);
        avl.inserta(300);
        avl.inserta(250);
        avl.inserta(375);
        avl.inserta(280);
        avl.inserta(290);
        avl.inserta(295);
        
        
        System.out.println("\ninorden: ");
        avl.inOrden();
        
        avl.borra(250);
        avl.borra(280);
        avl.borra(200);
        avl.borra(100);
        
        System.out.println("\ninorden: ");
        avl.inOrden();
        
        
        
        
        
    }
    
}
