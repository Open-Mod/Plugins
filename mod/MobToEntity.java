package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraftforge.eventbus.api.IEventBus;

public class MobToEntity {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Mob mob = (java.lang.String) node.getInputData("Mob <Mob>");
        if(mob == null) return;
        node.setOutputData("Entity <Entity>", mob);
    }
}
