package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.core.animation.AnimationState;

public class OnAnimationInit_mob {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.AnimationInit) {
                EntityType entity = entityObj.get();
                if(!("entity." + Project.MODID + "." + ((CustomEvent.AnimationInit) event).getName()).equals(entity.toString())) return;
                AnimationState state = ((CustomEvent.AnimationInit) event).getAnimationState();
                node.setOutputData("Mob <EntityType>", entity);
                node.setOutputData("State <AnimationState>", state);
                node.TriggerNext("connector");
            }
        });
    }
}
