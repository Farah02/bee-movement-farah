import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bee extends Actor
{
    private int score = 0; 
    
    
    
    
    
     
    /**
     * Act - do whatever the bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(3); 
        int x = getX(); 
        int y = getY(); 
        if(x > 600) { 
          x = Greenfoot.getRandomNumber(600) ;
          y = Greenfoot.getRandomNumber(400); 
          setLocation(x,y); 
          turn (Greenfoot.getRandomNumber(20)); 
          

          
            
        }  
        
        //Check If We Hit A Flower 
        boolean contactFlower = isTouching(Flower.class); 
        //System.out.println (contactFlower); 
        if(contactFlower) { 
            Flower plant = (Flower) getOneIntersectingObject(Flower.class);
            int plantScore = plant.getScore();
            score = score + plantScore;
            removeTouching(Flower.class); 
            
        }
        
        boolean contactCactus = isTouching(Cactus.class); 
        if(contactCactus) {
        Cactus spike = (Cactus) getOneIntersectingObject(Cactus.class); 
        int spikeScore = spike.getScore(); 
        score = score + spikeScore; 
        removeTouching(Cactus.class); 
        
        }
        
         if(score>= 10){
        beewin winScreen= new beewin();
        Greenfoot.setWorld(winScreen);
    }
    if(score<=-10){
        elephantwin loseScreen= new elephantwin();
        Greenfoot.setWorld(loseScreen);
    }
    }    
} 
