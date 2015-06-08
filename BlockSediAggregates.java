package geology;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSediAggregates extends BlockSand 
{
	public BlockSediAggregates(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(geology.Geology.tabUpperCrust);
	}
	
	public BlockSediAggregates(int id, int par2, Material material)
	{
		super(id, material);
		int subType = par2;
		this.setCreativeTab(geology.Geology.tabUpperCrust);
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
				case 0: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "gassand");
						break;
				case 1: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "greensand");
						break;
				case 2: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "bitumen");
						break;
				case 3: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "quartzpebble");
						break;
				case 4: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "redsand");
						break;
				case 5: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "peatcoal");
						break;
				case 6: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "blacksand");
						break;
				case 7: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "rocks");
						break;
				case 8: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "blackrocks");
						break;
				case 9: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "geodes");
						break;
				case 10: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "silt");
						break;
				case 11: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "placersilt");
						break;
				case 12: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "volcanicash");
						break;
				case 13: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "forestash");
						break;
				case 14: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "grassash");
						break;
				case 15: icons[i] = par1IconRegister.registerIcon(Geology.modid + ":" + "pebbles");
						break;
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
	       return icons[par2];
	}
	

    /** Do blocks fall instantly to where they stop or do they fall over time */
    public static boolean fallInstantly = false;

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
        this.tryToFall(par1World, par2, par3, par4);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
    }


    /**
     * Ticks the block if it's been scheduled
     */
    @Override
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
            byte var8 = 32;

            if (!fallInstantly && par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
            {
                if (!par1World.isRemote)
                {
                	EntityFallingMaterial var9 = new EntityFallingMaterial(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(var9);
                    par1World.spawnEntityInWorld(var9);
                }
            }
            else
            {
                /**
                 * Sets the block ID and metadata at a given location. Args: X, Y, Z, new block ID, new metadata, flags. Flag 1 will
                 * cause a block update. Flag 2 will send the change to clients (you almost always want this). Flag 4 prevents the
                 * block from being re-rendered, if this is a client world. Flags can be added together.
                 */
                par1World.setBlock(par2, par3, par4, this.blockID, subType, 2);

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
    protected void onStartFalling(EntityFallingMaterial par1EntityFallingMatl) {}

    /**
     * How many world ticks before ticking
     */
    public int tickRate()
    {
        return 5;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int var4 = par0World.getBlockId(par1, par2, par3);

        if (var4 == 0)
        {
            return true;
        }
        else if (var4 == Block.fire.blockID)
        {
            return true;
        }
        else if (var4 == Block.leaves.blockID)
        { 
        	return true;
        }
/*        else if (var4 == mod_geology.gasesBlock.blockID)
        {
        	return true;
        }
        else if (var4 == mod_geology.liquidsBlock.blockID)
        {
        	return true;
        }  */
        else
        {
            Material var5 = Block.blocksList[var4].blockMaterial;
            return var5 == Material.water ? true : var5 == Material.lava;
        }
    }

    /**
     * Called when the falling block entity for this block hits the ground and turns back into a block
     */
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
	

	
	public int damageDropped(int par1)
	{
		return par1;
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
