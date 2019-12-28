package control;

import view.BlockDisplay;

public class ResetPositionCommand implements Command{
    
    private final BlockDisplay display;
    
    public ResetPositionCommand(BlockDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.show(display.block().resetPosition());
    }
    
}