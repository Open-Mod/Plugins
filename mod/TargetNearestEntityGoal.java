package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class TargetNearestEntityGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        java.lang.String type = (java.lang.String) node.getInputData("Type <String>");
        boolean mustSee = (boolean) node.getInputData("Must See? <Boolean>");
        boolean mustReach = (boolean) node.getInputData("Must Reach? <Boolean>");
        mob.targetSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal<>(mob, LivingEntity.class, 10, mustSee, mustReach, e -> e.getType().toString().toLowerCase().contains(type.toLowerCase())));
        node.TriggerNext("connector");
    }
}
