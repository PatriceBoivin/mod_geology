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

public class BlockMetalOreE extends Block 
{
	public BlockMetalOreE(int id, Material material)
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
	public static int maxSubType = 14;

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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "sphalerite");  /*  Zn0.95Fe2+0.05S */
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "smithsonite");  /* Zn(CO3)  */
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "hemimorphite");  /* Zn4Si2O7(OH)2•(H2O) */
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "wurtzite");   /* Zn0.9Fe2+0.1S  */
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "hydrozincite");  /* Zn5(CO3)2(OH)6 */
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "bismuthinite"); /* bismuth */
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "frohbergite");  /* FeTe2 */
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "leucite"); /* K2O + Al2O3 + SiO2 */
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "pollucite");  /* Cs(Si2Al)O6.nH2O */
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "carnallite"); /* KMgCl3·6(H2O) */
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "zinnwaldite");  /* KLiFe++Al(AlSi3)O10(F,OH)2  */
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "lepidolite");  /* K(Li,Al)3(Si,Al)4O10(F,OH)2  */
						break;
				case 12: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "rinneite");  /* K3NaFe++Cl6  */
						break;
				case 13: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "rokuhnite");  /* Fe++Cl2•(H2O)  */
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
