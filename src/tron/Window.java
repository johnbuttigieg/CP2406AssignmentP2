package tron;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Window extends JPanel implements Runnable {



    private boolean running = false;

    //Changing these variables will change the amount of tiles on the map.
    private int tileNumX = 50, tileNumY = 50;

    //the array registeres if the tiles have been covered by a light cycle.
    private int tiles[];

    // Changing the variable changes the tile size!
    private int tileSize = 10;


    //Unused code only was used for testing purposes
    private int boardSizeX = 0, boardSizeY = 0;

    //changing this variable changes the speed of the gameplay. 100milliseconds is 10frames per second


    private int myPlayerId = 2;

    private Player[] players = new Player[9];
    private Player2[] players2 = new Player2[9];




    Window() {

        this.boardSizeX = this.tileNumX * this.tileSize;
        this.boardSizeY = this.tileNumY * this.tileSize;
        setPreferredSize(new Dimension(this.boardSizeX, this.boardSizeY));
        setFocusable(true);
        KeyInput keyInput = new KeyInput();
        addKeyListener(keyInput);
        keyInput.window = this;

        //Changes the player into a specific colour. Changing myPlayerID changes the colour

        Color[] colors = {
                Color.black,
                Color.blue,
                Color.red,
                Color.green,
                Color.yellow,
                Color.cyan,
                Color.magenta,
                Color.pink,
                Color.orange};


        for(int playerId = 0; playerId < 9; playerId++){
            this.players[playerId] = new Player();
            this.players[playerId].color1 = colors[playerId];
            if(playerId != 0)
                this.players[playerId].color2 = colors[playerId - 1];
        }


        for(int playerId2 = 0; playerId2 < 9; playerId2++){
            this.players2[playerId2] = new Player2();
            this.players2[playerId2].color1 = colors[playerId2];
            if(playerId2 != 0)
                this.players2[playerId2].color2 = colors[playerId2 - 1];
        }






        this.players[this.myPlayerId].active = true;

        this.players2[this.myPlayerId].active = true;


        int totalNumTiles = this.tileNumX * this.tileNumY;
        this.tiles = new int[totalNumTiles];

        //Testing the number of tiles
        System.out.printf("\nNumber of tiles: %d\n", this.tiles.length);
        for(int i = 0; i < totalNumTiles; i++){
            System.out.printf("\nTiles[%d]: %d\n", i, this.tiles[i]);
            }




        //leads to start() method to begin the thread to begin the game
        start();

    }


    private int getTile(int x, int y) {
        return this.tiles[this.tileNumX * y + x];
    }


    private void setTile(int x, int y, int value) {
        this.tiles[this.tileNumX * y + x] = value;
    }

    //Starts the thread
    private void start() {
        Thread thread;
        running = true;
        thread = new Thread(this, "Thread Start");
        thread.start();
    }


    // inbuilt into JPanel to change graphics of the JPANEL and create the CELLS
    public void paint(Graphics graphics) {

        graphics.clearRect(0, 0, this.boardSizeX, boardSizeY);

        // draw borders
        graphics.setColor(Color.black);
        graphics.drawLine(0, 0, this.boardSizeX - 1, 0);
        graphics.drawLine(0, 0, 0, this.boardSizeY - 1);
        graphics.drawLine(this.boardSizeX - 1, 0, this.boardSizeX - 1, this.boardSizeY - 1);
        graphics.drawLine(0, this.boardSizeY - 1, this.boardSizeX - 1, this.boardSizeY - 1);

        for (int tileX = 0; tileX < this.tileNumX; tileX++) {
            for (int tileY = 0; tileY < this.tileNumY; tileY++) {
                for (int playerId = 1; playerId < 9; playerId++) {
                    int tile = this.getTile(tileX, tileY);
                    if( (tile & playerId) == playerId){

                        Color playerColor = this.players[playerId].getColor1();
                        graphics.setColor(playerColor);
                        graphics.fillRect(tileX * this.tileSize, tileY * this.tileSize, tileSize, tileSize);

                        Color playerColor2 = this.players2[playerId].getColor1();
                        graphics.setColor(playerColor2);
                        graphics.fillRect(tileX * this.tileSize, tileY * this.tileSize, tileSize, tileSize);
                    }
                }
            }
        }
        //FOR PLAYER 1: Fills the Rectangle with the specific player colour based on myPlayerID variable.
        for (int playerId = 1; playerId < 9; playerId++) {
            Player player = this.players[playerId];
            if( player.active){
                graphics.setColor(player.getColor2());
                graphics.fillRect(player.currentX * this.tileSize, player.currentY * this.tileSize, tileSize, tileSize);
            }
        }

        //FOR PLAYER 2: Fills the Rectangle with the specific player colour based on myPlayerID variable.
        for (int playerId = 1; playerId < 9; playerId++) {
            Player2 player2 = this.players2[playerId];
            if( player2.active){
                graphics.setColor(player2.getColor2());
                graphics.fillRect(player2.currentX * this.tileSize, player2.currentY * this.tileSize, tileSize, tileSize);
            }
        }



        this.paintGrids(graphics);
    }

    private void paintGrids(Graphics graphics)
    {
        graphics.setColor(Color.black);
        // draw X grids
        for (int tileX = 0; tileX < this.tileNumX; tileX++) {
            graphics.drawLine(tileX * this.tileSize - 1, 0, tileX * this.tileSize, this.boardSizeY - 1);
        }
        // draw Y grids
        for (int tileY = 0; tileY < this.tileNumY; tileY++) {
            graphics.drawLine(0, tileY * this.tileSize - 1, this.boardSizeX, tileY * this.tileSize - 1);
        }
    }


    //this method is run continuously through the run() method below
    private void update() {

        //PLAYER 1 CONTROLS
        for (int playerId = 1; playerId < 9; playerId++) {
            Player player = this.players[playerId];

            if (!player.active)
                continue;

            if (player.getKeyPressed() == KeyEvent.VK_UP) {
                player.currentY--;
            }
            if (player.getKeyPressed() == KeyEvent.VK_DOWN) {
                player.currentY++;
            }
            if (player.getKeyPressed() == KeyEvent.VK_LEFT) {
                player.currentX--;
            }
            if (player.getKeyPressed() == KeyEvent.VK_RIGHT) {
                player.currentX++;
            }

            if (player.currentX >= this.tileNumX) {
                player.currentX--;
            }
            if (player.currentX < 0) {
                player.currentX++;
            }
            if (player.currentY >= this.tileNumY) {
                player.currentY--;
            }
            if (player.currentY < 0) {
                player.currentY++;
            }

            //CODE TESTING
            System.out.printf("(%d,%d)\n", player.currentX, player.currentY);

                try {
                    int tile = this.getTile(player.currentX, player.currentY);
                    System.out.printf("\nCoordanates(%d)\n", tile);
                    // check if tile was already walked upon
                    if ((tile & playerId) == playerId) {
                        System.out.println("OUCH!!!! Light cycle has been touched! Game Over!");
                    } else {
                        // make tile walked on
                        this.setTile(player.currentX, player.currentY, tile | playerId);
                        System.out.printf("(%d,%d)\n", player.currentX, player.currentY);
                    }

                } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
                    System.out.println("OUT OF BOUNDS!");
                }

        }


            //PLAYER 2 CONTROLS
            for (int playerId2 = 1; playerId2 < 9; playerId2++) {
                Player2 player2 = this.players2[playerId2];

                if (!player2.active)
                    continue;

                if (player2.getKeyPressed() == KeyEvent.VK_UP) {
                    player2.currentY--;
                }
                if (player2.getKeyPressed() == KeyEvent.VK_DOWN) {
                    player2.currentY++;
                }
                if (player2.getKeyPressed() == KeyEvent.VK_LEFT) {
                    player2.currentX--;
                }
                if (player2.getKeyPressed() == KeyEvent.VK_RIGHT) {
                    player2.currentX++;
                }

                if (player2.currentX >= this.tileNumX) {
                    player2.currentX--;
                }
                if (player2.currentX < 0) {
                    player2.currentX++;
                }
                if (player2.currentY >= this.tileNumY) {
                    player2.currentY--;
                }
                if (player2.currentY < 0) {
                    player2.currentY++;
                }

                //CODE TESTING:
                System.out.printf("(%d,%d)\n", player2.currentX, player2.currentY);

                try {
                    int tile = this.getTile(player2.currentX, player2.currentY);
                    System.out.printf("\nCoordanates(%d)\n", tile);
                    // check if tile was already walked upon
                    if ((tile & playerId2) == playerId2) {
                        System.out.println("OUCH!!!! Light cycle has been touched!");
                    } else {
                        // make tile walked on
                        this.setTile(player2.currentX, player2.currentY, tile | playerId2);
                        System.out.printf("(%d,%d)\n", player2.currentX, player2.currentY);
                    }

                } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
                    System.out.println("OUT OF BOUNDS!");
                }


            }


            //This controls the frames per second through Thread.sleep
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception CAUGHT!");
            }
    }


    // default operation, gets run when thread.start() is initiated. Continulously calls Paint(); and Update();
    public void run() {
        while (running) {

            repaint();
            update();
        }
    }


    protected class KeyInput implements KeyListener {

        private Window window;


        @Override //Unused Function
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            this.window.players[this.window.myPlayerId].setKeyPressed(key);

            this.window.players2[this.window.myPlayerId].setKeyPressed(key);

        }


        @Override //Unused Function
        public void keyReleased(KeyEvent e) {
        }
    }




}

