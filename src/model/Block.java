package model;

public interface Block {
    Block moveRight();
    Block moveLeft();
    Block moveUp();
    Block moveDown();
    int blockPosX();
    int blockPosY();
}