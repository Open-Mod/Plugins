package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class FloatGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        Map properties = (Map) node.data.get("properties");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        mob.goalSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.FloatGoal(mob));
        node.TriggerNext("connector");
    }
}
