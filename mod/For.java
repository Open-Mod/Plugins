package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class For {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        int first = ((java.lang.Number) node.getInputData("First <Number>")).intValue();
        int last = ((java.lang.Number) node.getInputData("Last <Number>")).intValue();
		int step = first;
		
		for (; step < last; step++){
			node.TriggerNext("body");
		}
		
        node.TriggerNext("exit");
    }
}
