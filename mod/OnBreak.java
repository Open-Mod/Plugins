package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnBreak {
    public static void execute(IEventBus bus, Node node, RegistryObject<Block> blockObj) {
        bus.addListener((event) ->{
            if(event instanceof BlockEvent.BreakEvent) {
                Block block = blockObj.get();
                BlockEvent.BreakEvent ev = ((BlockEvent.BreakEvent) event);
                java.lang.String name = ev.getState().getBlock().getName().getString();
                if(!block.getName().getString().equals(name)) return;
                node.setOutputData("Block <Block>", block);
                node.setOutputData("Level <Level>", ev.getPlayer().getCommandSenderWorld());
                node.setOutputData("Player <Player>", ev.getPlayer());
                node.setOutputData("X <Number>", ev.getPos().getX());
                node.setOutputData("Y <Number>", ev.getPos().getY());
                node.setOutputData("Z <Number>", ev.getPos().getZ());
                node.TriggerNext("connector");
            }
        });
    }
}
