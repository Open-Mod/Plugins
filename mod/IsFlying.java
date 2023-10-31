package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class IsFlying {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Mob mob = (Mob) node.getInputData("Mob <Mob>");
        if(mob == null) return;
        node.setOutputData("Is Flying? <Boolean>", mob.level().getBlockState(new BlockPos((int) this.getX(), (int) this.getY() - 1, (int) this.getZ())).isAir());
    }
}
