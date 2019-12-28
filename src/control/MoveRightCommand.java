package control;

import view.BlockDisplay;

public class MoveRightCommand implements Command{
    
    private final BlockDisplay display;
    
    public MoveRightCommand(BlockDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.show(display.block().moveRight());
    }
    
}