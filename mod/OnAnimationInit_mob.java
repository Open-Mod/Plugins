package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.core.animation.AnimationState;

public class OnAnimationInit_mob {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.AnimationInit_mob) {
                EntityType entity = entityObj.get();
                Mob result = (Mob) ((CustomEvent.AnimationInit_mob) event).get();
                if(!result.getName().getString().equals(entity.toString())) return;
                AnimationState state = ((CustomEvent.AnimationInit_mob) event).getAnimationState();
                node.setOutputData("Mob <Mob>", result);
                node.setOutputData("State <AnimationState>", state);
                node.TriggerNext("connector");
            }
        });
    }
}
