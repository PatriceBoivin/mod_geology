package geology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIngotCopper extends Item
{
	public ItemIngotCopper(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Geology.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
}