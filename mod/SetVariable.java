package dev.openmod.plugins.mod;

import dev.openmod.project.util.Node;
import dev.openmod.project.util.Variables;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class SetVariable {
    public static void execute(IEventBus bus, Node node, RegistryObject itemObj) {
        Map properties = (Map) node.data.get("properties");
        java.lang.String name = (java.lang.String) node.getInputData("Name <String>");
        java.lang.String value = (java.lang.String) node.getInputData("Value");
        java.lang.String scope = (java.lang.String) properties.get("Scope");
        if(scope.equals("Local"))
            Variables.setVariable(itemObj.toString(), name, value);
        else if(scope.equals("Global"))
            Variables.setVariable(scope.toLowerCase(), name, value);
        node.TriggerNext("connector");
    }
}
