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

public class BlockMarbleRockC extends Block 
{
	public BlockMarbleRockC(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(geology.Geology.tabMarble);
	}
	
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon[] icons;
	
	public int subType;
	
	@SideOnly(Side.CLIENT)
	public int getSubType () {
		return subType;
	}
	
	@SideOnly(Side.CLIENT)
	/* 12 means 0 - 11 */
	public static int maxSubType = 15;

	public int getMaxSubType () {
		return maxSubType;
	}
	

	@SideOnly(Side.CLIENT)
	/* The following is only about what icons to display in the game, specifies the file name (.png is assumed) */
	public void registerIcons(IconRegister par1IconRegister)
	{
		icons = new Icon[maxSubType];
		for(int i = 0; i < maxSubType; i++)
		{
			switch (i) {
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblecreole");
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleduquesarosa");
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleemperador");
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleforestgreen");
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblegreyaliveri");
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblegriotteoeildeperdrix");
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblegriotterouge");
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblehaumontbizantine");
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblehautacamivory");
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleimperialdanby");
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleimperialpink");
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleincarna");
						break;
				case 12: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marbleirishconne");
						break;
				case 13: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblelevanto");
						break;
				case 14: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "marblemainered");
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
	    for (int var4 = 0; var4 < maxSubType; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
}
