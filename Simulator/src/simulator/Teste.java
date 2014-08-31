/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulator;

/**
 *
 * @author extra
 */
public class Teste {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = start;
        
        System.out.println("start "+start);
        System.out.println("end "+end);
        System.out.println("total "+(end - start));
        
        while ((end - start) < 5000l) {
            end = System.currentTimeMillis();
            System.out.println("start "+start);
            System.out.println("end "+end);
            System.out.println("total "+(end - start));
        }
        
    }
}
