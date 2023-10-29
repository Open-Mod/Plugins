package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class SendChatMessage {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        java.lang.String text = (java.lang.String) node.getInputData("Text <String>");
        Minecraft.getInstance().player.sendSystemMessage(Component.literal(text));
        node.TriggerNext("connector");
    }
}
