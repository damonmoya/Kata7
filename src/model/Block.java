package model;

public interface Block {
    Block moveRight();
    Block moveLeft();
    Block moveUp();
    Block moveDown();
    Block resetPosition();
    int blockPosX();
    int blockPosY();
}