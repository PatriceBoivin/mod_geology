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

public class BlockMetalOreD extends Block 
{
	public BlockMetalOreD(int id, Material material)
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
	public static int maxSubType = 11;

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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "canfieldite");  /* Ag8SnS6  */
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "teallite");  /* PbSnS2  */
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "uraninite");  /* UO2  */
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "carnotite");  /* K2(UO2)2(VO4)2•3(H2O)  */
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "margaritasite");  /*  Cs1.2K0.6(H3O)0.2(UO2)2V5+2O8•(H2O) */
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "tyuyamunite");  /* Ca(UO2)2(VO4)2•6(H2O)  */
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "rutile");  /* TiO2  */
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "ilmenite");  /* Fe2+TiO3  */
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "sperrylite");  /* PtAs2  */
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "bertrandite");  /* Be4(Si2O7)(OH)2  */
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aikinite");  /* PbCuBiS3  */
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
