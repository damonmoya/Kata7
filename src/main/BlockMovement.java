package main;

import model.Block;

public class BlockMovement {
    
    private int posX;
    private int posY;
    
    public BlockMovement(){
        this.posX = 300;
        this.posY = 300;
    }
    
    public Block origin() {
        return BlockAt(this.posX, this.posY);
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void setPosX(int pos){
        this.posX = pos;
    }
    
    public void setPosY(int pos){
        this.posY = pos;
    }
    
    private Block BlockAt(int posX, int posY) {
        return new Block() {
            @Override
            public Block moveRight() {
                int localPosX = posX;
                if (posX < 600) localPosX = posX + 100;
                setPosX(localPosX);
                return BlockAt(localPosX, posY);
            }

            @Override
            public Block moveLeft() {
                int localPosX = posX;
                if (posX > 0) localPosX = posX - 100;
                setPosX(localPosX);
                return BlockAt(localPosX, posY);
            }
            
            @Override
            public Block moveUp() {
                int localPosY = posY;
                if (posY > 0) localPosY = posY - 100;
                setPosY(localPosY);
                return BlockAt(posX, localPosY);
            }
            
            @Override
            public Block moveDown() {
                int localPosY = posY;
                if (posY < 600) localPosY = posY + 100;
                setPosY(localPosY);
                return BlockAt(posX, localPosY);
            }
            
            @Override
            public Block resetPosition() {
                setPosX(300);
                setPosY(300);
                return BlockAt(300, 300);
            }
            
            @Override
            public int blockPosX() {
                return getPosX();
            }
            
            @Override
            public int blockPosY() {
                return getPosY();
            }

        };
    }
    
}
  