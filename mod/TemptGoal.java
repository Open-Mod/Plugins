package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TemptGoal {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        PathfinderMob mob = (PathfinderMob) node.getInputData("Mob <Mob>");
        int priority = ((java.lang.Number) node.getInputData("Priority <Number>")).intValue();
        double movementSpeed = ((java.lang.Number) node.getInputData("Movement Speed <Number>")).doubleValue();
        Supplier<Item> item = (Supplier<Item>) node.getInputData("Item <Item>");
        boolean canScare = (boolean) node.getInputData("Can Scare? <Boolean>");
        mob.goalSelector.addGoal(priority, new net.minecraft.world.entity.ai.goal.TemptGoal(mob, movementSpeed, Ingredient.of(item.get()), canScare));
        node.TriggerNext("connector");
    }
}
