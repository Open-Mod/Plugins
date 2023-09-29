package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.Map;

public class PlayAnimation {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        Map properties = (Map) node.data.get("properties");
        java.lang.String name = (java.lang.String) node.getInputData("Name <String>");
        AnimationState state = (AnimationState) node.getInputData("State <AnimationState>");
        java.lang.String type = (java.lang.String) properties.get("Type");
        if (type.equals("Loop")) {
            state.getController().setAnimation(RawAnimation.begin().then(name, Animation.LoopType.LOOP));
        } else if(type.equals("Play Once")) {
            state.getController().setAnimation(RawAnimation.begin().then(name, Animation.LoopType.PLAY_ONCE));
        }
        node.TriggerNext("connector");
    }
}
