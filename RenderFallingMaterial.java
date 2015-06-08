package geology;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFallingSand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderFallingMaterial extends RenderFallingSand {

    private RenderBlocks renderBlocks = new RenderBlocks();

    public RenderFallingMaterial()
    {
        this.shadowSize = 0.5F;
    }

    @Override
    public void doRenderFallingSand(EntityFallingSand par1EntityFallingSand, double par2, double par4, double par6, float par8, float par9)
    {
        World world = par1EntityFallingSand.getWorld();
        Block block = Block.blocksList[par1EntityFallingSand.blockID];
		System.out.println("in RenderFallingMaterial now");

        if (world.getBlockId(MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ)) != par1EntityFallingSand.blockID)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)par2, (float)par4, (float)par6);
            this.func_110777_b(par1EntityFallingSand);
            GL11.glDisable(GL11.GL_LIGHTING);
            Tessellator tessellator;

            if (block instanceof BlockAnvil && block.getRenderType() == 35)
            {
                this.renderBlocks.blockAccess = world;
                tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setTranslation((double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posX)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posY)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posZ)) - 0.5F));
                this.renderBlocks.renderBlockAnvilMetadata((BlockAnvil)block, MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ), par1EntityFallingSand.metadata);
                tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                tessellator.draw();
            }
            else if (block.getRenderType() == 27)
            {
                this.renderBlocks.blockAccess = world;
                tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setTranslation((double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posX)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posY)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posZ)) - 0.5F));
                this.renderBlocks.renderBlockDragonEgg((BlockDragonEgg)block, MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ));
                tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                tessellator.draw();
            }
            else if (block != null)
            {
                this.renderBlocks.setRenderBoundsFromBlock(block);
                this.renderBlocks.renderBlockSandFalling(block, world, MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ), par1EntityFallingSand.metadata);
            }

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
		System.out.println("in RenderFallingMaterial.doRender now");
        this.doRenderFallingSand((EntityFallingSand) par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
