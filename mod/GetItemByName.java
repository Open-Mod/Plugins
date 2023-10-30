package dev.openmod.plugins.mod;

import dev.openmod.project.init.ItemInit;
import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GetItemByName {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        java.lang.String name = (java.lang.String) node.getInputData("Name <String>");
        if(name == null) return;
        RegistryObject<Item> item = null;
        for(RegistryObject<Item> itemEntry : ItemInit.ITEMS.getEntries()) {
            if(name.equals(itemEntry.getKey().location().getPath())) {
                item = itemEntry;
                break;
            }
        }
        if(item == null) item = RegistryObject.create(new ResourceLocation(name), ForgeRegistries.ITEMS);
        if(item.isPresent()) node.setOutputData("Item <Item>", item.get());
    }
}
