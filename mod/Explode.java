package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class Explode {
    public static void execute(IEventBus bus, Node node, RegistryObject<Item> itemObj) {
        Map properties = (Map) node.data.get("properties");
        Level level = (Level) node.getInputData("Level <Level>");
        if(level.isClientSide()) return;
        double X = ((java.lang.Number) node.getInputData("X <Number>")).doubleValue();
        double Y = ((java.lang.Number) node.getInputData("Y <Number>")).doubleValue();
        double Z = ((java.lang.Number) node.getInputData("Z <Number>")).doubleValue();
        float radius = ((java.lang.Number) node.getInputData("Radius <Number>")).floatValue();
        boolean withFire = (boolean) node.getInputData("With Fire?");
        boolean destroyBlocks = (boolean) node.getInputData("Destroy Blocks?");
        if(destroyBlocks) level.explode(null, X, Y, Z, radius, withFire, Level.ExplosionInteraction.TNT);
        else level.explode(null,X, Y, Z, radius, withFire, Level.ExplosionInteraction.NONE);
        node.TriggerNext("connector");
    }
}
