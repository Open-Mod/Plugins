package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class RandomLookAroundGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        mob.goalSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.RandomLookAroundGoal(mob));
        node.TriggerNext("connector");
    }
}
