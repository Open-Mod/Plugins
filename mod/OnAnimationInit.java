package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.core.animation.AnimationState;

public class OnAnimationInit {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.AnimationInit) {
                Item item = itemObj.get();
                if(!("item." + Project.MODID + "." + ((CustomEvent.AnimationInit) event).getName()).equals(item.getName(new ItemStack(item)).getString())) return;
                AnimationState state = ((CustomEvent.AnimationInit) event).getAnimationState();
                node.setOutputData("Item <Item>", item);
                node.setOutputData("State <AnimationState>", state);
                node.TriggerNext("connector");
            }
        });
    }
}
