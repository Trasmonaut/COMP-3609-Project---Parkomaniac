import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
   A component that displays all the game entities
*/

public class GamePanel extends JPanel implements Runnable {
      
    
      private SoundManager soundManager;

      private Thread gameThread;
      private boolean isStarted;
      private boolean isRunning;
     
      private BufferedImage image;
      
      public GamePanel () {
      
   }


   public void createGameEntities() {
      
   }

   // public void drawGameEntities() {
   //     if (player != null) {
   //     	  player.draw();
   //     }
   // }


   public void updateGameEntities(int direction) {

      if (player == null)
         return;

      if (isRunning){
         player.move(direction);
         // player.drawPlayerBox();
         // player.facingSide();
      }
   }
   
   
   public void swung(){ 
      
   }


   public void run(){
      try{
      while (isRunning){
        
            updateGameEntities();
            


            gameRender();
            Thread.sleep(100);

            
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      
   }

   public void updateGameEntities(){
      
   }

   public void gameRender(){
      
      Graphics2D imageContext = (Graphics2D) image.getGraphics();
      
      if (player != null){

         if(!player.shield){
         player.draw(imageContext);
         } 
         
   
   
                
         
      
      Graphics2D g2 = (Graphics2D) getGraphics();	// get the graphics context for the panel
		g2.drawImage(image, 0, 0, 600, 400, null);

		imageContext.dispose();
		g2.dispose();
         
      
   }
}
   
   

   public void startGame(){
      if (isStarted){
      System.out.println("Game already Started. Reopen application to start again");
      return;
      }
      if (isRunning) return;

      isStarted = true;
      isRunning = true;

     
      gameThread = new Thread(this);
      gameThread.start();
      createGameEntities();
      //drawGameEntities();

		System.out.println("Number of threads: " + Thread.activeCount());
      
   }

}