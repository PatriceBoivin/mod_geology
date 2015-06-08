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

public class BlockMetalOreB extends Block 
{
	public BlockMetalOreB(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(geology.Geology.tabOre);
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
	public static int maxSubType = 12;

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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "argentite");  /*  Ag2S */
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "chlorargyrite");  /* AgCl  */
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "petzite");  /* Ag3AuTe2  */
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "pentlandite");  /* Fe2+4.5Ni4.5S8  */
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "millerite");  /* NiS  */
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "nickeline");  /* NiAs  */
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "galena");  /*  PbS */
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "kamacite");  /* Fe0+0.9Ni0.1  */
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "taenite");  /* Fe0+0.8Ni0.2  */
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "klockmannite");  /* CuSe  */
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "chalcopyrite");  /* CuFe2+S2  */
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "chalcocite");  /* Cu2S  */
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
