package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnServerAiStep_mob {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.MobServerAiStep) {
                EntityType entity = entityObj.get();
                Mob result = ((CustomEvent.MobServerAiStep) event).get();
                if(!result.getName().getString().equals(entity.toString())) return;
                node.setOutputData("Mob <Mob>", result);
                node.TriggerNext("connector");
            }
        });
    }
}
