package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import dev.openmod.project.util.Variables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class GetVariable {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Map properties = (Map) node.data.get("properties");
        java.lang.String name = (java.lang.String) node.getInputData("Name <String>");
        java.lang.String scope = (java.lang.String) properties.get("Scope");
        Object result = null;
        if(scope.equals("Local"))
            result = Variables.getVariable(itemObj.toString(), name);
        else if(scope.equals("Global"))
            result = Variables.getVariable(scope.toLowerCase(), name);
        if(result == null) return;
        node.setOutputData("Value", result);
    }
}
