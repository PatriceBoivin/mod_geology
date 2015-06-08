/**
 * 
 */
package geology;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import geology.CommonProxy;

/**
 * @author patriceboivin
 *
 */
public class ClientProxy extends CommonProxy {
	@Override
    public void registerRenderers() {
		EntityRegistry.registerModEntity(EntityFallingMaterial.class, "EntityFallingMaterial", 199, this, 160, 20, true); 
       
       RenderingRegistry.registerEntityRenderingHandler(EntityFallingMaterial.class, new RenderFallingMaterial()); 
    }  
}
