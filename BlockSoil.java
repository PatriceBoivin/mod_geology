package geology;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoil extends Block 
{
    /** Do blocks fall instantly to where they stop or do they fall over time */
    public static boolean fallInstantly;

	public BlockSoil(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(geology.Geology.tabSoil);
	}
	
	public int damageDropped(int par1)
	{
		return par1;
	}
	
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
	
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }

    /**
     * If there is space to fall below will start this block falling
     */
    private void tryToFall(World par1World, int par2, int par3, int par4)
    {
        if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0)
        {
            byte b0 = 32;

            if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
            {
                if (!par1World.isRemote)
                {
                    EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(entityfallingsand);
                    par1World.spawnEntityInWorld(entityfallingsand);
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);

                while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
                {
                    --par3;
                }

                if (par3 > 0)
                {
                    par1World.setBlock(par2, par3, par4, this.blockID);
                }
            }
        }
    }

    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(EntityFallingSand par1EntityFallingSand) {}

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return 2;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int l = par0World.getBlockId(par1, par2, par3);

        if (par0World.isAirBlock(par1, par2, par3))
        {
            return true;
        }
        else if (l == Block.fire.blockID)
        {
            return true;
        }
        else
        {
            Material material = Block.blocksList[l].blockMaterial;
            return material == Material.water ? true : material == Material.lava;
        }
    }

    /**
     * Called when the falling block entity for this block hits the ground and turns back into a block
     */
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}

	@SideOnly(Side.CLIENT)
	public Icon[] icons;
	
	@SideOnly(Side.CLIENT)
	/* The following is only about what icons to display in the game, specifies the file name (.png is assumed) 
	 *  this.blockIcon = par1IconRegister.registerIcon(this.func_111023_E() + "_side");
        this.field_94382_c = par1IconRegister.registerIcon(this.func_111023_E() + "_inner");
        this.cakeTopIcon = par1IconRegister.registerIcon(this.func_111023_E() + "_top");
        this.cakeBottomIcon = par1IconRegister.registerIcon(this.func_111023_E() + "_bottom");
	 * */
	public void registerIcons(IconRegister par1IconRegister)
	{
		icons = new Icon[maxSubType];

		for(int i = 0; i < maxSubType; i++)
		{
			switch (i) {
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "alfisol"); 
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "andisol");
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "aridisol"); 
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "entisol");
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "gelisol"); 
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "histosol");
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "inceptisol");
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "molisol"); 
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "oxisol"); 
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "spodosol");
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "ultisol");
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "vertisol");
						break;
				case 12: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "topsoil");
						break;
				case 13: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "redclay");
						break;
				case 14: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "drymud");
						break;
				case 15: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "saltflat");
						break;
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
	       return icons[metadata];
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
