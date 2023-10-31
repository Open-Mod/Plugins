package dev.openmod.plugins.mod;

import dev.openmod.project.Project;
import dev.openmod.project.custom.CustomMob;
import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class OnDismount {
    public static void execute(IEventBus bus, Node node, RegistryObject<EntityType> entityObj) {
        bus.addListener((event) -> {
            if(event instanceof EntityMountEvent) {
                if(((EntityMountEvent) event).isDismounting()) {
                    EntityType entity = entityObj.get();
                    Entity result = ((EntityMountEvent) event).getEntityBeingMounted();
                    Entity mounter = ((EntityMountEvent) event).getEntityMounting();
                    if(result.level().getEntity(result.getId()) == null || !result.level().getEntity(result.getId()).getType().equals(entity)) return;
                    CustomMob mob = (CustomMob) result.level().getEntity(result.getId());
                    Player player = (Player) result.level().getEntity(mounter.getId());
                    if (!result.getName().getString().equals(entity.toString())) return;
                    node.setOutputData("Mob <Mob>", mob);
                    node.setOutputData("Player <Player>", player);
                    node.TriggerNext("connector");
                }
            }
        });
    }
}
