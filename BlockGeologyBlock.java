package geology;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGeologyBlock extends Block 
{
	public BlockGeologyBlock(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon[] icons;
	
	@SideOnly(Side.CLIENT)
	/* The following is only about what icons to display in the game, specifies the file name (.png is assumed) */
	public void registerIcons(IconRegister par1IconRegister)
	{
		icons = new Icon[5];
		for(int i = 0; i < 5; i++)
		{
			switch (i) {
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "basalt");
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andesite");
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "diorite");
				break;
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
	       return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int var4 = 0; var4 < 5; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
}
