package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class MobToEntity {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        if(mob == null) return;
        node.setOutputData("Entity <Entity>", mob);
    }
}
