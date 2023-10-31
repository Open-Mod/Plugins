package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.util.Node;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnMount_mob {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) -> {
            if(event instanceof EntityMountEvent) {
                if(((EntityMountEvent) event).isDismounting()) {
                    EntityType entity = entityObj.get();
                    Mob result = ((EntityMountEvent) event).getEntityBeingMounted();
                    Entity player = ((EntityMountEvent) event).getEntityMounting();
                    if (!result.getName().getString().equals(entity.toString())) return;
                    node.setOutputData("Target <Entity>", result);
                    node.setOutputData("Entity <Entity>", player);
                    node.TriggerNext("connector");
                }
            }
        });
    }
}
