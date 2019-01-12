import java.awt.*;

/**
* A class that draws multiple tile pattens, with and without mortar
*
* @author Alieu Sanneh
* @version Tiling
*/
public class Tiles{
   //Width of the window 
   private static final int WIDTH = 200;
   //Height of window 
   private static final int HEIGHT = 150;
    
   /**
   * A helper method to the draw rectangles
   * @param g The Graphics component
   * @param x The x coordinate of the upper left corner
   * @param y The y coordinate of the upper left corner
   * @param width The width of the rectangle
   * @param height The height of the rectangle 
   * @param c The color of the rectangle
   */
   private void drawRect(java.awt.Graphics g, int x, int y, int width, int height, Color c)
   {
      //set the color for the rectangle
      g.setColor(c);
      g.fillRect(x, y, width, height);
      //Draw lines around the rectangle
      g.setColor(Color.black);
      //Draw the rectangle
      g.drawRect(x, y, width, height);
   }
   
   /**
   * This method draws the BasketWeave tile.  
   * it makes use of two interwinding tiles
   *
   * @param mortarWidth The width of the mortar
   */ 
   public void BasketWeave(int mortarWidth){
      // the width of the tile
      final int tileWidth = 80;
      int mortar = mortarWidth;
      // create a new window drawing panel
      DrawingPanel win = new DrawingPanel(WIDTH,HEIGHT);
      //checks if the user requested a version with mortar
      if(mortar <= 0){
         win.setTitle("Basket Weave");
      } else {
         win.setTitle("Basket Weave with Mortar");
         //sets the location of the window
         win.setLocation(220,0);
      };
      
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // loop through the total the total number of tiles needed.
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
         // Draws the tile
         // Define rectangle sides
         int longSide = tileWidth / 2 - mortar * 2;
         int shortSide = longSide / 2 - mortar;
         // Define colors
         Color honey = new Color(255, 201, 14);
         Color clay = new Color(185, 122, 87);
         // Draw mortar background
         drawingSurface.setColor(Color.lightGray);
         drawingSurface.fillRect(x, y, tileWidth, tileWidth);
         // Draw rectangles with variable mortar to make a complete tile
         drawRect(drawingSurface, x + mortar, y + mortar, shortSide, longSide, honey);
         drawRect(drawingSurface, x + shortSide + mortar * 3, y + mortar, shortSide, longSide, honey);
         drawRect(drawingSurface, x + mortar * 3 + longSide, y + mortar, longSide, shortSide, clay);
         drawRect(drawingSurface, x + mortar * 3 + longSide, y + mortar * 3 + shortSide, longSide, shortSide, clay);
         drawRect(drawingSurface, x + mortar, y + mortar * 3 + longSide, longSide, shortSide, clay);
         drawRect(drawingSurface, x + mortar, y + mortar * 5 + longSide + shortSide, longSide, shortSide, clay);
         drawRect(drawingSurface, x + mortar * 3 + longSide, y + mortar * 3 + longSide, shortSide, longSide, honey);
         drawRect(drawingSurface, x + mortar * 5 + longSide + shortSide, y + mortar * 3 + longSide, shortSide, longSide, honey);
      }
   }
   /**
   * This method draws the Mediterranean 1 tile.  
   * it doesnt have a version with mortar
   */
   public void Med1(){
      // define tile width and height
      final int tileWidth = 24;
            // draw the drawing panel
      DrawingPanel win= new DrawingPanel(WIDTH,HEIGHT);
      win.setTitle("Mediterranean 1");
      win.setLocation(0,250);
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // we know how many tiles to draw, so loop through the total.
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
      
      // Fill in red background
      drawingSurface.setColor(Color.red);
      drawingSurface.fillRect(x, y, tileWidth, tileWidth);
   
      // Setup points to draw an octagon
      int diamondRadius = (int) (tileWidth * (7 / 24.0));
      int octagonLong = (int) (tileWidth * (10 / 24.0));
      int[] xPoints = new int[] {
                x + diamondRadius,
                x + diamondRadius + octagonLong,
                x + tileWidth,
                x + tileWidth,
                x + diamondRadius + octagonLong,
                x + diamondRadius,
                x,
                x
         };
   
      int[] yPoints = new int[] {
                y,
                y,
                y + diamondRadius,
                y + diamondRadius + octagonLong,
                y + tileWidth,
                y + tileWidth,
                y + diamondRadius + octagonLong,
                y + diamondRadius
         };
   
       // draw octagon
      drawingSurface.setColor(new Color(255, 255, 64));
      drawingSurface.fillPolygon(xPoints, yPoints, xPoints.length);
   
      // draw lines around octagon
      drawingSurface.setColor(Color.BLACK);
      drawingSurface.drawPolygon(xPoints, yPoints, xPoints.length);
   
   }
   
   }
   
   /**
   * This method draws the Mediterranean 2 tile.  
   * it doesnt have a version with mortar
   */
   public void Med2(){
      // define tile width and height
      final int tileWidth = 34;
            // draw the drawing panel
      DrawingPanel win = new DrawingPanel(WIDTH,HEIGHT);
      win.setTitle("Mediterranean 2");
      win.setLocation(0,450);
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // we know how many tiles to draw, so loop through the total.
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
         // Fill in red background
         drawingSurface.setColor(new Color(192, 192, 128));
         drawingSurface.fillRect(x, y, tileWidth, tileWidth);

         // Setup points to draw an octagon
         int octagonShort = (int) (tileWidth * (7 / 34.0));
         int octagonLong = (int) (tileWidth * (10 / 34.0));
         int octagonWidth = octagonShort * 2 + octagonLong;

         int[] xPoints = new int[] {
                x + octagonShort,
                x + octagonShort + octagonLong,
                x + octagonWidth,
                x + octagonWidth,
                x + octagonShort + octagonLong,
                x + octagonShort,
                x,
                x
        };

        int[] yPoints = new int[] {
                y,
                y,
                y + octagonShort,
                y + octagonShort + octagonLong,
                y + octagonShort * 2 + octagonLong,
                y + octagonShort * 2 + octagonLong,
                y + octagonShort + octagonLong,
                y + octagonShort
        };

        // draw octagon
        drawingSurface.setColor(Color.black);
        drawingSurface.drawPolygon(xPoints, yPoints, xPoints.length);

        // draw blues squares
        Color blue = new Color(0, 112, 192);
        drawRect(drawingSurface, x + octagonWidth, y + octagonShort, octagonLong, octagonLong, blue);
        drawRect(drawingSurface, x + octagonShort, y + octagonWidth, octagonLong, octagonLong, blue);


   }
   }
   
   /**
   * This method draws the OpenWeave tile.  
   *
   * @param mortarWidth The width of the mortar
   */
   public void OpenWeave(int mortarWidth){
      // define tile width and height
      final int tileWidth = 40;
      int mortar = mortarWidth;
      // draw the drawing panel
      DrawingPanel win = new DrawingPanel(WIDTH,HEIGHT);
      if(mortar <= 0){
         win.setTitle("Open Weave");
         win.setLocation(220,400);
      } else {
         win.setTitle("Open Weave with Mortar");
         win.setLocation(450,0);
      };
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // so loop through the total number of files
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
         
         // Define measures
         int longSide = (int) (tileWidth * (2 / 3.0));
         int shortSide = (int) (tileWidth * (1 / 3.0)) - mortar * 4;
         int squareSide = (int) (tileWidth * (1 / 6.0));

        // Define colors
        Color pink = new Color(204, 136, 204);
        Color maroon = new Color(154, 32, 64);

        // Draw mortar background
        drawingSurface.setColor(Color.lightGray);
        drawingSurface.fillRect(x, y, tileWidth, tileWidth);

        // Draw rectangles with variable mortar to make a complete tile
        drawRect(drawingSurface, x + mortar, y + mortar, longSide, shortSide, pink);
        drawRect(drawingSurface, x + mortar * 3 + longSide, y - mortar - squareSide, shortSide, longSide, pink);
        drawRect(drawingSurface, x + mortar, y + mortar * 3 + shortSide, squareSide, squareSide, maroon);
        drawRect(drawingSurface, x + mortar * 3 + squareSide, y + mortar * 3 + shortSide, shortSide, longSide, pink);
        drawRect(drawingSurface, x + mortar * 5 + squareSide + shortSide, y + mortar * 3 + shortSide, squareSide, squareSide, maroon);
        drawRect(drawingSurface, x + mortar, y + mortar * 7 + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(drawingSurface, x + mortar * 5 + squareSide + shortSide, y + mortar * 7 + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(drawingSurface, x - mortar * 3 - shortSide - squareSide, y + mortar * 5 + shortSide + squareSide, longSide, shortSide, pink);


   }
   }
   /**
   * This method draws the Pythagorean tile.  
   *
   * @param mortarWidth The width of the mortar
   */
   public void Pythagorean(int mortarWidth){
      // define tile width and height
      final int tileWidth = 40;
      int mortar = mortarWidth;
      // draw the drawing panel
      DrawingPanel win = new DrawingPanel(WIDTH,HEIGHT);
      if(mortar <= 0){
         win.setTitle("Pythagorean");
         win.setLocation(220,210);
      } else {
         win.setTitle("Pythagorean with Mortar");
         //sets the location of the window
         win.setLocation(690,0);
      };
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // we know how many tiles to draw, so loop through the total.
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
         
         // Define measures
        int longSide = (int) (tileWidth * (2 / 5.0)) - mortar * 2;
        int shortSide = longSide / 2 - mortar;

        // Define colors
        Color blue = new Color(64, 64, 192);
        Color aqua = new Color(136, 204, 204);

        // Draw mortar background
        drawingSurface.setColor(Color.lightGray);
        drawingSurface.fillRect(x, y, tileWidth, tileWidth);

        // Draw rectangles with variable mortar to make a complete tile
        drawRect(drawingSurface, x + mortar, y + mortar, longSide, longSide, aqua);
        drawRect(drawingSurface, x + mortar * 3 + longSide, y + mortar * 3 + shortSide, longSide, longSide, aqua);
        drawRect(drawingSurface, x + mortar * 3 + longSide, y + mortar, shortSide, shortSide, blue);
        drawRect(drawingSurface, x - mortar - shortSide, y + mortar * 3 + longSide, longSide, longSide, aqua);
        drawRect(drawingSurface, x + mortar * 5 + longSide + shortSide, y - mortar - shortSide, longSide, longSide, aqua);
        drawRect(drawingSurface, x + mortar * 3 + shortSide, y + mortar * 3 + longSide, shortSide, shortSide, blue);
        drawRect(drawingSurface, x + mortar * 5 + longSide * 2, y + mortar * 3 + shortSide, shortSide, shortSide, blue);
        drawRect(drawingSurface, x + mortar, y + mortar * 5 + longSide * 2, shortSide, shortSide, blue);
        drawRect(drawingSurface, x + mortar * 3 + shortSide, y + mortar * 5 + longSide + shortSide, longSide, longSide, aqua);
        drawRect(drawingSurface, x + mortar * 5 + longSide + shortSide, y + mortar * 5 + shortSide + longSide, shortSide, shortSide, blue);



      }
   }
   
   /**
   * This method draws the Brick tile.  
   * it only has one version with mortar
   *
   * @param mortarWidth The width of the mortar
   */
   public void Brick(int mortarWidth){
      // define tile width and height
      final int tileWidth = 40;
      int mortar = mortarWidth;
      // draw the drawing panel
      DrawingPanel win = new DrawingPanel(WIDTH,HEIGHT);
      win.setTitle("Brick with Mortar");
      win.setLocation(950,0);
      // Get drawing surface
      Graphics drawingSurface = win.getGraphics();
      // identify how many tiles will be needed.
      // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
      int tileCountAcross = WIDTH / tileWidth + 2;
      int tileCountDown = HEIGHT / tileWidth + 2;
      int totalTiles = tileCountAcross * tileCountDown;
      // we know how many tiles to draw, so loop through the total.
      for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
      {
         // Get column and row of current tiles index
         int currentColumn = tileIndex % tileCountAcross;
         int currentRow = tileIndex / tileCountAcross;
         // Calculates x and y coordinate of next drawing tiles
         int x = currentColumn * tileWidth;
         int y = currentRow * tileWidth;
         // Define base measurements
         int longSide = tileWidth - mortar * 2;
         int shortSide = longSide / 2 - mortar;

         // Define colors
         Color brick = new Color(136, 0, 21);

         // Draw background mortar
         drawingSurface.setColor(Color.lightGray);
         drawingSurface.fillRect(x, y, tileWidth, tileWidth);

         // Draw rectangles with variable mortar to make a complete tile
         drawRect(drawingSurface, x + mortar, y + mortar, longSide, shortSide, brick);
         drawRect(drawingSurface, x - shortSide - mortar, y + shortSide + mortar * 3, longSide, shortSide, brick);

   }
   }
   
   /**
   * The application method that runs the program
   *
   * @param args The command-line arguments
   */
   public static void main(String[] args){
      Tiles tiles = new Tiles();
      //regular tiles
      tiles.BasketWeave(0);
      tiles.Med1();
      tiles.Med2();
      tiles.OpenWeave(0);
      tiles.Pythagorean(0);
      
      // tiles with mortar
      tiles.BasketWeave(1);
      tiles.Brick(1);
      tiles.OpenWeave(1);
      tiles.Pythagorean(1);
   
      
   }
}
