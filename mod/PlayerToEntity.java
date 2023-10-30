package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraftforge.eventbus.api.IEventBus;

public class PlayerToEntity {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Player player = (java.lang.String) node.getInputData("Player <Player>");
        if(player == null) return;
        node.setOutputData("Entity <Entity>", player);
    }
}
