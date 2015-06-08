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

public class BlockMetalOreA extends Block 
{
	public BlockMetalOreA(int id, Material material)
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

	@SideOnly(Side.CLIENT)
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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "siderite");  /* Fe2+(CO3)  */
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "ankerite");  /* CaFe2+0.6Mg0.3Mn2+0.1(CO3)2  */
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "minnesotaite");  /* Fe2+2.5Mg0.5Si4O10(OH)2  */
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "greenalite");  /* Fe2+2.3Fe3+0.5Si2.2O5(OH)3.3  */
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "grunerite");  /* Fe2+7(Si8O22)(OH)2  */
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "magnetite");  /* Fe3+2Fe2+O4  */
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "hematite");  /* Fe3+2O3  */
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "titanomagnetite");  /* TiFe2+2O4 ulvospinel */
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "calaverite");  /* AuTe2  */
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "sylvanite");  /* Au0.75Ag0.25Te2  */
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "nagyagite");  /* AuPbSb0.75Bi0.25Te2.5S6  */
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
