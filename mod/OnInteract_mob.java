package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomEvent;
import dev.openmod.project.util.Node;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnInteract_mob {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) ->{
            if(event instanceof CustomEvent.MobInteract) {
                EntityType entity = entityObj.get();
                Mob result = ((CustomEvent.MobInteract) event).getMob();
                Player player = ((CustomEvent.MobInteract) event).getPlayer();
                Vec3 pos = ((CustomEvent.MobInteract) event).getPos();
                InteractionHand hand = ((CustomEvent.MobInteract) event).getHand();
                if(!result.getName().getString().equals(entity.toString())) return;
                node.setOutputData("Mob <Mob>", result);
                node.setOutputData("Player <Player>", player);
                node.setOutputData("X <Number>", pos.x);
                node.setOutputData("Y <Number>", pos.y);
                node.setOutputData("Z <Number>", pos.z);
                node.setOutputData("Interaction Hand <InteractionHand>", hand);
                node.TriggerNext("connector");
            }
        });
    }
}
