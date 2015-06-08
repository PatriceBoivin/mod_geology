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


public class BlockSoilGrass extends Block {
	public BlockSoilGrass(int id, Material material) {
		super(id, material);
		this.setCreativeTab(geology.Geology.tabSoil);
	}

	public int damageDropped(int par1) {
		return par1;
	}

	@SideOnly(Side.CLIENT)
	public Icon[] icons;

	@SideOnly(Side.CLIENT)
	public Icon[] topIcons;
	@SideOnly(Side.CLIENT)
	public Icon[] bottomIcons;
	@SideOnly(Side.CLIENT)
	public Icon[] sideIcons;

	public int subType;

	@SideOnly(Side.CLIENT)
	public int getSubType() {
		return subType;
	}

	@SideOnly(Side.CLIENT)
	/* 12 means 0 - 11 */
	public static int maxSubType = 4;

	public int getMaxSubType() {
		return maxSubType;
	}

	@SideOnly(Side.CLIENT)
	/*
	 * The following is only about what icons to display in the game, specifies
	 * the file name (.png is assumed)
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		icons = new Icon[maxSubType];
		topIcons = new Icon[maxSubType];
		bottomIcons = new Icon[maxSubType];
		sideIcons = new Icon[maxSubType];

		for (int i = 0; i < maxSubType; i++) {
			switch (i) {
			case 0: topIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "alfisolgrasstop"); 
					bottomIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "alfisol"); 
					sideIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "alfisolgrassside");
				/*icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "alfisol"); */
				break;
			case 1: topIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andisolgrasstop"); 
					bottomIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andisol"); 
					sideIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andisolgrassside");
					 
				/*icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andisol");*/
				break;
			case 2: topIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aridisolgrasstop"); 
					bottomIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aridisolgrassbottom"); 
					sideIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aridisolgrassside");
				/*icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aridisol");*/
				break;
			case 3: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "entisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "entisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "entisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "entisol");
				break;
			case 4: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "gelisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "gelisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "gelisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "gelisol");
				break;
			case 5: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "histosolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "histosolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "histosolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "histosol");
				break;
			case 6: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "inceptisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "inceptisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "inceptisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "inceptisol");
				break;
			case 7: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "molisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "molisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "molisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "molisol");
				break;
			case 8:
				topIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "oxisolgrasstop");
				bottomIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "oxisolgrassbottom");
				sideIcons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "oxisolgrassside");
				/*
				 * icons[i] = par1IconRegister.registerIcon(Geology.modid + ":"
				 * + "oxisol");
				 */
				break;
			case 9: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "spodosolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "spodosolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "spodosolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "spodosol");
				break;
			case 10: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "ultisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "ultisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "ultisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "ultisol");
				break;
			case 11: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "vertisolgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "vertisolgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "vertisolgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "vertisol");
				break;
			case 12: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "topsoilgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "topsoilgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "topsoilgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "topsoil");
				break;
			case 13: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "redclaygrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "redclaygrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "redclaygrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "redclay");
				break;
			case 14: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "drymudgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "drymudgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "drymudgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "drymud");
				break;
			case 15: /*
					 * topIcons[i] = par1IconRegister.registerIcon(Geology.modid
					 * + ":" + "saltflatgrasstop"); bottomIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "saltflatgrassbottom"); sideIcons[i] =
					 * par1IconRegister.registerIcon(Geology.modid + ":" +
					 * "saltflatgrassside");
					 */
				icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "saltflat");
				break;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int var4 = 0; var4 < maxSubType; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
