package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class GetEntityPosition {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Entity entity = (Entity) node.getInputData("Entity <Entity>");
        if(entity == null) return;
        Vec3 pos = entity.position();
        node.setOutputData("X <Number>", pos.x);
        node.setOutputData("Y <Number>", pos.y);
        node.setOutputData("Z <Number>", pos.z);
    }
}
