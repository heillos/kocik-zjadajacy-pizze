import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kocik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kocik extends Actor
{
    int SIEDZACY = 0;
    int W_PRAWO_1 = 1;
    int W_PRAWO_2 = 2;
    int W_LEWO_1 = 3;
    int W_LEWO_2 = 4;
    int stan_kota = SIEDZACY;
    
    int zjedzone_pizze = 0;
    int zjedzone_pizze_2 = 0;
    
    /**
     * Act - do whatever the Kocik wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // ustawianie obrazków
        if( stan_kota == W_PRAWO_1 ) setImage("cat-walk-right.png");
        if( stan_kota == W_PRAWO_2 ) setImage("cat-walk-right2.png");        
        if( stan_kota == W_LEWO_1 ) setImage("cat-walk-left.png");
        if( stan_kota == W_LEWO_2 ) setImage("cat-walk-left2.png");        
        if( stan_kota == SIEDZACY ) setImage("cat-sit.png");        
        
        // jeżeli NIE NACIŚNIĘTO żadnego klawisza, to ustaw stan siedzący
        if( !Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") ) stan_kota = SIEDZACY; 
        
        // jeżeli klawisz W PRAWO naciśnięty, kot ma przesunąć się w prawo
        if( Greenfoot.isKeyDown("right") ) 
        {
            move(5);
            // jeżeli stan był W_PRAWO_1 to musimy ustawić W_PRAWO_2
            // a jeżeli nie był W_PRAWO_1 to musimy ustawić W_PRAWO_1
            if( stan_kota == W_PRAWO_1 ) stan_kota = W_PRAWO_2;
            else stan_kota = W_PRAWO_1;
        }
        
        // jeżeli klawisz W LEWO naciśnięty, kot ma przesunąć się w lewo
        if( Greenfoot.isKeyDown("left") ) 
        {
            move(-5);
            // jeżeli stan był W_LEWO_1 to musimy ustawić W_LEWO_2
            // a jeżeli nie był W_LEWO_1 to musimy ustawić W_LEWO_1
            if( stan_kota == W_LEWO_1 ) stan_kota = W_LEWO_2;
            else stan_kota = W_LEWO_1;

        }
        
        //jeżeli dotyka pizzy, to ma usuną tę pizzę, której dotyka
        if( isTouching( Pizza.class ) ) 
        {
            Actor dotykana = getOneObjectAtOffset(0, 0 , Pizza.class);
            // jeżeli dotykana jest , to usuń
            if( dotykana != null ) 
            {
                getWorld().removeObject( dotykana );
                // kot ma wykonać animację jedzenia
                for(int i=1; i<=10; i++)
                {
                    setImage("cat-eat.png");
                    Greenfoot.delay(8);
                    setImage("cat-eat2.png");
                    Greenfoot.delay(8);                    
                }

                setImage("cat-sit.png");
                zjedzone_pizze++;
                zjedzone_pizze_2++;                
            }
        } // koniec zjadania pizzy
        
        //jeżeli liczba zjedzonych to 3, 6 lub 9 to zatańcz
        if( (zjedzone_pizze == 3) )
        {
            zjedzone_pizze = 0;
            for(int i=1; i<=10; i++)
            {
                setImage("cat-dance.png");
                Greenfoot.delay(8);
                setImage("cat-dance-2.png");
                Greenfoot.delay(8);                    
            }
        }
        // jeżeli liczba zjedzonych to 10, to idź spać na chwilę
        if( (zjedzone_pizze_2 == 10) )
        {
            zjedzone_pizze_2 = 0;
            for(int i=1; i<=10; i++)
            {
                setImage("cat-sleep-1.png");
                Greenfoot.delay(8);
                setImage("cat-sleep-2.png");
                Greenfoot.delay(8);                    
                setImage("cat-sleep-3.png");
                Greenfoot.delay(8);
                setImage("cat-sleep-4.png");
                Greenfoot.delay(8);                    
            }
        }
        
    }    
}















