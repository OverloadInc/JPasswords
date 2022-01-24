package over.controller;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * <code>Carousel</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Carousel {
    private static Vector<String> queue = new Vector<String>();
    
    static {
        Carousel.add("dashboardPanel");
        Carousel.add("kindProductsPanel");
        Carousel.add("productsPanel");
        Carousel.add("credentialsPanel");
        Carousel.add("employeesPanel");
        Carousel.add("departmentsPanel");
        Carousel.add("hierarchiesPanel");
        Carousel.add("privilegesPanel");
        Carousel.add("accessesPanel");
        Carousel.add("positionsPanel");
    }
    
    public static void add(String element) {
        queue.add(element);
    }
    
    public static void remove(String element){
        queue.remove(element);
    }
    
    public static String next(String element) {
        int index = 0;
        
        for(String current : queue) {
            if(current.equals(element)) {
                if(index == queue.size() - 1) {
                    index = 0;
                    
                    return queue.get(index);                    
                }
                else
                    return queue.get(index + 1);                             
            }
            else 
                index++;            
        }
        
        return null;
    }
    
    public static String back(String element) {
        int index = 0;
        
        for(String current : queue) {
            if(current.equals(element)) {
                if(index == 0) {
                    index = queue.size() - 1;
                    
                    return queue.get(index);
                }
                else
                    return queue.get(index - 1);
            }
            else
                index++;
        }
        
        return null;
    }
    
    public static String getActivePanel(JPanel mainPanel) {
        String panel = null;

        for(Component component : mainPanel.getComponents()){
            if(component.isVisible())
                panel = component.getName();
        }

        return panel;
    }
    
    public static void print() {
        queue.forEach((item) -> {
            System.out.print(item + ", ");
        });
        
        System.out.println();
    }
}