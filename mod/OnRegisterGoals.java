package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnRegisterGoals {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.MobGoalsInit) {
                EntityType entity = entityObj.get();
                if(!("entity." + Project.MODID + "." + ((CustomEvent.MobGoalsInit) event).getName()).equals(entity.toString())) return;
                Mob mob = ((CustomEvent.MobGoalsInit) event).getMob();
                node.setOutputData("Mob <Mob>", mob);
                node.TriggerNext("connector");
            }
        });
    }
}
