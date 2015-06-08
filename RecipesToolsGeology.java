/**
 * 
 */
package geology;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.Random;


/**
 * @author patriceboivin
 * Crafting Recipes having to do with the new tools or with new uses.
 */
public class RecipesToolsGeology
{
	private static final RecipesToolsGeology recipesToolsGeologyBase = new RecipesToolsGeology();
	
	/* list of stone block types used for recipes excludes sedimentary rock and ore blocks */
/*	private static final geology.BlockGeologyBlock[] stoneBlocksList = {
		(BlockIgneousIntrusiveRock) igneousIntrusiveRock,
		igneousExtrusiveRockBlock,	
		metamorphicRockBlock,	
		sediAggregatesBlock,	
		sediBedsRockBlock,	
		sediCarbonateRockBlock,	
		sediClasticRockBlock,	
		sediClasticRockBBlock,	
		sediCoalRockBlock,	
		sediPrecipRockBlock,	
		marbleRockABlock,	
		marbleRockBBlock,	
		marbleRockCBlock,	
		marbleRockDBlock,	
		marbleRockEBlock,	
		marbleRockFBlock,	
		marbleRockGBlock,	
		marbleRockHBlock,	
		metalOreABlock,	
		metalOreBBlock,	
		metalOreCBlock,	
		metalOreDBlock,	
		metalOreEBlock,	
		mantleBlock};

    private String[][] recipePatternsStone = new String[][] {
    		{}, 
    		{"XY", "X#", " #"}, 
    		{"XY", "Y#", " #"}, 
    		{}, 
    		{},
    		{}};
    		

    private Object[][] recipeItemsRocks;
    
    /**
     * Used to call methods addRecipes and getRecipesResult.
     */
    public static final RecipesToolsGeology cooking()
    {
        return recipesToolsGeologyBase;
    }


    public RecipesToolsGeology()
    {
    	
    }


    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipesRock(CraftingManager par1CraftingManager)
   {   /* shovel only uses one stone block */
 /*   	for (int a=0; a<7; ++a) {
			/* do every subblock of a */
/*			for (int d=0; d< stoneBlocksList[a].getMaxSubType(); ++d) {
    			par1CraftingManager.addRecipe(new ItemStack(Item.shovelStone), new Object[] {"X", "#", "#", 'X', new ItemStack(stoneBlocksList[a],1,d),'#', Item.stick});
             }
        }
    	/* hoe, hammer, sword each use two stone blocks */
 /*    	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
				/* do every subblock of a */
/*				for (int d=0; d< stoneBlocksList[a].getMaxSubType(); ++d) {
					/* do every subblock of b */
/*					for (int e=0; e< stoneBlocksList[b].getMaxSubType(); ++e) {
  	    					par1CraftingManager.addRecipe(new ItemStack(Item.hoeStone), new Object[] {"XY", " #", " #", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), '#', Item.stick});
	    					par1CraftingManager.addRecipe(new ItemStack(Item.swordStone), new Object[] {"X", "Y", "#", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), '#', Item.stick});
 	    					par1CraftingManager.addRecipe(new ItemStack(Geology.hammerStone), new Object[] {" X ", " #Y", "#  ", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), '#', Item.stick});
 
    				}
    			}
            }
        }
     	
     	/* axe, pickaxe and bec each use three stone blocks */
 /*   	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
    			for (int c=0; c<7; ++c) 
    			{
    				/* do every subblock of a */
  /*  				for (int d=0; d< stoneBlocksList[a].getMaxSubType(); ++d) {
    					/* do every subblock of b */
/*    					for (int e=0; e< stoneBlocksList[b].getMaxSubType(); ++e) {
    						/* do every subblock of c */
 /*   						for (int f=0; f< stoneBlocksList[c].getMaxSubType(); ++f) {
    	    					par1CraftingManager.addRecipe(new ItemStack(Item.pickaxeStone), new Object[] {"XYZ", " # ", " # ", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), 'Z', new ItemStack(stoneBlocksList[c],1,f), '#', Item.stick});
    	    					par1CraftingManager.addRecipe(new ItemStack(Item.axeStone), new Object[] {"XY", "Z#", " #", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), 'Z', new ItemStack(stoneBlocksList[c],1,f), '#', Item.stick});
     	    					par1CraftingManager.addRecipe(new ItemStack(Geology.becStone), new Object[] {" XY", " #Z", "#  ", 'X', new ItemStack(stoneBlocksList[a],1,d), 'Y', new ItemStack(stoneBlocksList[b],1,e), 'Z', new ItemStack(stoneBlocksList[c],1,f), '#', Item.stick});
     						}
    					}
    				}
    			}
            }
        }
    	
     	/* scythe uses four stone blocks */
 /*   	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
    			for (int c=0; c<7; ++c) 
    			{
    				for (int d=0; d<7; ++d) 
    				{
	    				/* do every subblock of a */
	/*    				for (int e=0; e< stoneBlocksList[a].getMaxSubType(); ++e) 
	    				{
	    					/* do every subblock of b */
	/*    					for (int f=0; f< stoneBlocksList[b].getMaxSubType(); ++f) 
	    					{
	    						/* do every subblock of c */
	/*    						for (int g=0; g< stoneBlocksList[c].getMaxSubType(); ++g) 
	    						{
	        						/* do every subblock of d */
	/*        						for (int h=0; h< stoneBlocksList[d].getMaxSubType(); ++h) 
	        						{
		    	    					par1CraftingManager.addRecipe(new ItemStack(Geology.scytheStone), new Object[] {"XYZ", " #A", "#  ", 'X', new ItemStack(stoneBlocksList[a],1,e), 'Y', new ItemStack(stoneBlocksList[b],1,f), 'Z', new ItemStack(stoneBlocksList[c],1,g), 'A', new ItemStack(stoneBlocksList[d],1,h), '#', Item.stick});
	        						}
	    						}
	    					}
	    				}
    				}
    			}
            }
        }
  */  	
   	/* add metal alloy recipes */
    	/* electrum = Au + Si */
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.metalOreABlock, 1, 7), new Object[] {new ItemStack(Item.ingotGold), new ItemStack(Geology.metalOreABlock, 1, 8)});

    	/* bronze = Cu + Sn */
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.metalOreBBlock, 1, 4), new Object[] {new ItemStack(Item.ingotGold, 1, 10), new ItemStack(Geology.metalOreABlock, 1, 13)});

    	/* brass = Cu + Zn */
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.metalOreBBlock, 1, 6), new Object[] {new ItemStack(Item.ingotGold, 1, 10), new ItemStack(Geology.metalOreBBlock, 1, 5)});

    	/* steel = Fe + C */
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.metalOreABlock, 1, 11), new Object[] {new ItemStack(Item.ingotIron), new ItemStack(Item.coal)});

    	/* sterling silver = Si + Cu */
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.metalOreABlock, 3, 8), new Object[] {new ItemStack(Item.ingotIron), new ItemStack(Geology.metalOreBBlock, 1, 6)});

    	/* bitumen --> crude */
 /*   	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.aggregatesBlock, 3, 0), new Object[] {new ItemStack(Geology.liquidsBlock,1,7)});
    	
    	/* limestone --> bonemeal */
/*    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.sedimentaryBlock, 1, 5), new Object[] {new ItemStack(Item.dyePowder, 1, 0)});

    	/* sulfur + white dye powder + coal/charcoal --> gunpowder */
  /*  	par1CraftingManager.addShapelessRecipe(new ItemStack(Item.gunpowder, 1), new Object[] {new ItemStack(Geology.mineralsA, 1,1), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.coal), });

    	/* bitumen + wool + stick = torch */
/*		par1CraftingManager.addRecipe(new ItemStack(Block.torchWood), new Object[] {"X", "Y", "#", 'X', new ItemStack(Geology.aggregatesBlock, 3, 0), 'Y', Block.cloth, '#', Item.stick});


    	/* add new copper tool recipes */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.pickaxeCopper), new Object[] {"XXX", " # ", " # ", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.shovelCopper), new Object[] {"X", "#", "#", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeCopper), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hoeCopper), new Object[] {" XX", " # ", " # ", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.swordCopper), new Object[] {" X", " X", " #", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
*/		
    	/* add new diamonds tool recipes */
		/* shovel only uses one stone block */
/*    	for (int a=0; a<7; ++a) {
			/* do every subblock of a */
/*			for (int d=0; d<12; ++d) {
    			par1CraftingManager.addRecipe(new ItemStack(Item.shovelDiamond), new Object[] {"X", "#", "#", 'X', new ItemStack(Geology.diamonds,1,d),'#', Item.stick});
				/* add itesm where one might want to use the original diamond along with the new diamonds */
/*				par1CraftingManager.addRecipe(new ItemStack(Item.hoeDiamond), new Object[] {"XY", " #", " #", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', Item.diamond, '#', Item.stick});
				par1CraftingManager.addRecipe(new ItemStack(Item.swordDiamond), new Object[] {"X", "Y", "#", 'X', new ItemStack(Geology.diamonds,1,d), 'Y',  Item.diamond, '#', Item.stick});
				par1CraftingManager.addRecipe(new ItemStack(Geology.hammerDiamond), new Object[] {" X ", " #Y", "#  ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y',  Item.diamond, '#', Item.stick});
             }
        }
    	/* hoe, hammer, sword each use two stone blocks */
/*     	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
				/* do every subblock of a */
/*				for (int d=0; d< 12; ++d) {
					/* do every subblock of b */
/*					for (int e=0; e< 12; ++e) {
  	    					par1CraftingManager.addRecipe(new ItemStack(Item.hoeDiamond), new Object[] {"XY", " #", " #", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), '#', Item.stick});
	    					par1CraftingManager.addRecipe(new ItemStack(Item.swordDiamond), new Object[] {"X", "Y", "#", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), '#', Item.stick});
 	    					par1CraftingManager.addRecipe(new ItemStack(Geology.hammerDiamond), new Object[] {" X ", " #Y", "#  ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), '#', Item.stick});
 	    					/* add itesm where one might want to use the original diamond along with the new diamonds */
/*	    					par1CraftingManager.addRecipe(new ItemStack(Item.pickaxeDiamond), new Object[] {"XYZ", " # ", " # ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', Item.diamond, '#', Item.stick});
	    					par1CraftingManager.addRecipe(new ItemStack(Item.axeDiamond), new Object[] {"XY", "Z#", " #", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', Item.diamond, '#', Item.stick});
 	    					par1CraftingManager.addRecipe(new ItemStack(Geology.becDiamond), new Object[] {" XY", " #Z", "#  ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', Item.diamond, '#', Item.stick});
					}
    			}
            }
        }
     	
     	/* axe, pickaxe and bec each use three stone blocks */
 /*   	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
    			for (int c=0; c<7; ++c) 
    			{
    				/* do every subblock of a */
/*    				for (int d=0; d<12; ++d) {
    					/* do every subblock of b */
/*    					for (int e=0; e<12; ++e) {
    						/* do every subblock of c */
/*    						for (int f=0; f<12; ++f) {
    	    					par1CraftingManager.addRecipe(new ItemStack(Item.pickaxeDiamond), new Object[] {"XYZ", " # ", " # ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', new ItemStack(Geology.diamonds,1,f), '#', Item.stick});
    	    					par1CraftingManager.addRecipe(new ItemStack(Item.axeDiamond), new Object[] {"XY", "Z#", " #", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', new ItemStack(Geology.diamonds,1,f), '#', Item.stick});
     	    					par1CraftingManager.addRecipe(new ItemStack(Geology.becDiamond), new Object[] {" XY", " #Z", "#  ", 'X', new ItemStack(Geology.diamonds,1,d), 'Y', new ItemStack(Geology.diamonds,1,e), 'Z', new ItemStack(Geology.diamonds,1,f), '#', Item.stick});
     						}
    					}
    				}
    			}
            }
        }
    	
    	/* add new flint/chert, obsidian axe recipes */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XX", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XY", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XY", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 24),  '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YX", "X#", " #", 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'X', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YX", "Y#", " #", 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YY", "X#", " #", 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'X', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YY", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YZ", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YZ", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZY", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZY", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZZ", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZZ", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZX", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZX", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XZ", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XZ", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XX", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XY", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XZ", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZY", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YX", "Z#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YZ", "X#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"ZX", "Y#", " #", 'X', new ItemStack(Geology.igneousGlassBlock, 1, 23), 'Y', new ItemStack(Geology.igneousGlassBlock, 1, 24), 'Z', new ItemStack(Geology.igneousGlassBlock, 1, 25), '#', Item.stick});

		par1CraftingManager.addRecipe(new ItemStack(Geology.axeFlint), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Item.flint), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Geology.sedimentaryBlock, 1, 3), '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XY", "X#", " #", 'X', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'Y', Block.obsidian, '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YX", "X#", " #", 'X', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'Y', Block.obsidian, '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YY", "X#", " #", 'X', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'Y', Block.obsidian, '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"XY", "X#", " #", 'Y', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'X', Block.obsidian, '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YX", "X#", " #", 'Y', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'X', Block.obsidian, '#', Item.stick});  /* chert */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.axeObsidian), new Object[] {"YY", "X#", " #", 'Y', new ItemStack(Geology.sedimentaryBlock, 1, 3), 'X', Block.obsidian, '#', Item.stick});  /* chert */

    	/* add bronze tool recipes */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.pickaxeBronze), new Object[] {"XXX", " # ", " # ", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.shovelBronze), new Object[] {"X", "#", "#", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.axeBronze), new Object[] {"XX", "X#", " #", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hoeBronze), new Object[] {" XX", " # ", " # ", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.swordBronze), new Object[] {" X", " X", " #", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		
    	/* add recipes for the new tools, bec, scythe and hammer */
/*		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheStone), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Block.cobblestone), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becStone), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Block.cobblestone), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheIron), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Item.ingotIron), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becIron), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Item.ingotIron), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheGold), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Item.ingotGold), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becGold), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Item.ingotGold), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheDiamond), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Item.diamond), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becDiamond), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Item.diamond), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheBronze), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becBronze), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheCopper), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becCopper), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheSilver), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 8), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becSilver), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 8), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.scytheSteel), new Object[] {"XXX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 11), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.becSteel), new Object[] {" XX", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 11), '#', Item.stick});

		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerStone), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Block.cobblestone), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerIron), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Item.ingotIron), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerGold), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Item.ingotGold), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerDiamond), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Item.diamond), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerBronze), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Geology.metalB, 1, 4), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerCopper), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 10), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerSilver), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 8), '#', Item.stick});
		par1CraftingManager.addRecipe(new ItemStack(Geology.hammerSteel), new Object[] {" X ", " #X", "#  ", 'X', new ItemStack(Geology.metalA, 1, 11), '#', Item.stick});


		/* recipes for minerals and gemstones */
		/* rnd type of gemstone from a geode would be */
/*		int crystalID = 0;
		private Random rnd = new Random();
		int dieRoll = rnd.nextInt(100);
		if (dieRoll < 6) { break;}
		else if (dieRoll < 11) { break;}
		else if (dieRoll < 16) { ; break;}
		else if (dieRoll < 21) { ; break;}
		else if (dieRoll < 26) { ; break;}
		else if (dieRoll < 31) { ; break;}
		else if (dieRoll < 36) { ; break;}
		else if (dieRoll < 41) { ; break;}
		else if (dieRoll < 100) { ; break;}
		
    	par1CraftingManager.addShapelessRecipe(new ItemStack(Geology.aggregatesBlock, 3, 8), new Object[] {new ItemStack(Item.ingotIron), new ItemStack(Geology.metalB, 1, 6)});
*/
		/* Making a furnace from any type of rock block */
		/* many permutations */
		/*       par1CraftingManager.addRecipe(new ItemStack(Block.stoneOvenIdle), new Object[] {"###", "# #", "###", '#', Block.cobblestone});
        	for (int a=0; a<7; ++a) 
    	{
    		for (int b=0; b<7; ++b) 
    		{
    			for (int c=0; c<7; ++c) 
    			{
    		    	for (int d=0; d<7; ++d) 
    		    	{
    		    		for (int e=0; e<7; ++e) 
    		    		{
    		    			for (int f=0; f<7; ++f) 
    		    			{
    		    		    	for (int g=0; g<7; ++g) 
    		    		    	{
    		    		    		for (int h=0; h<7; ++h) 
    		    		    		{
    		    		    			par1CraftingManager.addRecipe(new ItemStack(Block.stoneOvenIdle), new Object[] {"ABC", "D E", "FGH", 'A', stoneBlocksList[a], 'B', stoneBlocksList[b], 'C', stoneBlocksList[c],'D', stoneBlocksList[d], 'E', stoneBlocksList[e], 'F', stoneBlocksList[f], 'G', stoneBlocksList[g], 'H', stoneBlocksList[h]});
    		    		    		}
    		    		    	}
    		    			}
    		    		}
    		    	}
    			}
            }
        }  */
		
/*        par1CraftingManager.addRecipe(new ItemStack(Geology.mudBrickWall), new Object[] {"###", "#X#", "###", '#', new ItemStack(Geology.soilBBlock, 1, 2), 'X', new ItemStack(Geology.aggregatesBlock, 1, 0)});
 /*       par1CraftingManager.addRecipe(new ItemStack(Block.stoneBrick, 4), new Object[] {"##", "##", '#', Block.stone}); */

    }

 }
