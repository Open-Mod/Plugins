package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class PlayerToEntity {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Player player = (Player) node.getInputData("Player <Player>");
        if(player == null) return;
        node.setOutputData("Entity <Entity>", player);
    }
}
