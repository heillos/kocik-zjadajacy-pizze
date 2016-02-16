import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pizza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pizza extends Actor
{
    /**
     * Act - do whatever the Pizza wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        //spadanie
        turn(90);
        move(1);
        turn(-90);
        
        // jeżeli pizza dotyka krawędzi świata, to ma zostać usunięta
        if( isAtEdge() ) 
            getWorld().removeObject( this );
            

    }    
}
