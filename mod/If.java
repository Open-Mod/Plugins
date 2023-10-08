package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class If {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        java.lang.Boolean result = (java.lang.Boolean) node.getInputData("Condition <Boolean>");
        if (result) {
            node.TriggerNext("true");
        } else {
            node.TriggerNext("false");
        }
    }
}
