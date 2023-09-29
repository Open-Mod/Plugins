package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.core.animation.AnimationState;

public class OnAnimationInit_block {
    public static void execute(IEventBus bus, Node node, RegistryObject<Block> blockObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.AnimationInit) {
                Block block = blockObj.get();
                if(!("block." + Project.MODID + "." + ((CustomEvent.AnimationInit) event).getName()).equals(block.getName().getString())) return;
                AnimationState state = ((CustomEvent.AnimationInit) event).getAnimationState();
                node.setOutputData("Block <Block>", block);
                node.setOutputData("State <AnimationState>", state);
                node.TriggerNext("connector");
            }
        });
    }
}
