package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class Boolean {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        Map properties = (Map) node.data.get("properties");
        java.lang.Boolean bool = (java.lang.Boolean) properties.get("Boolean");
        node.setOutputData("Boolean <Boolean>", bool);
    }
}
