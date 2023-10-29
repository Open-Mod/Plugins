package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class IsMoving {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        software.bernie.geckolib.core.animation.AnimationState animationState = (software.bernie.geckolib.core.animation.AnimationState) node.getInputData("Animation State <AnimationState>");
        if(animationState == null) return;
        node.setOutputData("Is Moving? <Boolean>", animationState.isMoving());
    }
}
