package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class MeleeAttackGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        Map properties = (Map) node.data.get("properties");
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        double movementSpeed = ((java.lang.Number) node.getInputData("Movement Speed <Number>")).doubleValue();
        mob.goalSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.MeleeAttackGoal(mob, movementSpeed, false));
        node.TriggerNext("connector");
    }
}
