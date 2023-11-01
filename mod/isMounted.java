package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class IsMounted {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Entity entity = (Entity) node.getInputData("Entity <Entity>");
        if(entity == null) return;
        node.setOutputData("Is Mounted? <Boolean>", entity.getFirstPassenger() != null);
    }
}
