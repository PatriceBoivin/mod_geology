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

public class BlockOuterMantleRock extends Block 
{
	public BlockOuterMantleRock(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(geology.Geology.tabMantle);
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
	public static int maxSubType = 16;

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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "olivine");
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "leucite");
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "phlogopite");
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "richterite");
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "diopside");
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "sanidine");
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "peridotite");
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "dunite");
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "eclogite");
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "magnesite");
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aragonite");
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "lamprophyre");
						break;
				case 12: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "clinopyroxenite");
						break;
				case 13: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "orangeite");
						break;
				case 14: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "leucitite");
						break;
				case 15: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "leucogranite");
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
