package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class RandomStrollGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        PathfinderMob mob = (PathfinderMob) node.getInputData("Mob <Mob>");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        double movementSpeed = ((java.lang.Number) node.getInputData("Movement Speed <Number>")).doubleValue();
        mob.goalSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.RandomStrollGoal(mob, movementSpeed));
        node.TriggerNext("connector");
    }
}
