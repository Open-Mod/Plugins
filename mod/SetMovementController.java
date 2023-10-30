package dev.openmod.plugins.mod;

import dev.openmod.project.custom.CustomMob;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class SetMovementController {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        Map properties = (Map) node.data.get("properties");
        CustomMob mob = (CustomMob) node.getInputData("Mob <Mob>");
        java.lang.String controller = (java.lang.String) properties.get("Controller");
        if(controller.equals("Walking")) {
            mob.setWalking();
        } else if(controller.equals("Flying")) {
            mob.setFlying();
        }
        node.TriggerNext("connector");
    }
}
