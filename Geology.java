package geology;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/*
@param modid - This is the ID of your mod; it is usually a shortened version of your mod name ("EE3" by Pahimar) and must be unique.
@param name - This is the full name of your mod, which is displayed in the Mods section of the client ("Equivalent Exchange 3" by Pahimar)
@param version - This is the version of your mod; typically, it is a set of numbers ("3.1.0") but can be any string you want ("MyTutorialMod")
*/
@Mod(modid = "geology", name = "Geology", version = "0.1")
/* next if you want your mod to be multiplayer compatible, set server=true */
/* 
@param channels - These are the channel(s), listed in an array, that the client and server will use to relay information regarding your mod to each other
@param clientSideRequired - The easiest way to think about this is: if a server is running this particular mod, does the client need it to be able to join? (This is false for mods such as NEI, but true for any mods that add blocks to the world, so that the client will render their textures)
@param serverSideRequired - The easiest way to think about this is: if a server is not running this mod, does the client have to uninstall it to join? (This is also false for mods such as NEI. but true for any mods that add blocks to the world, because the server needs to know of their existence for the client to place the blocks). 
*/
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Geology
{
	public static final String modid = "geology";
	
	public static final CreativeTabs tabMantle = new TabMantle(CreativeTabs.getNextID(), "Mantle");
	public static final CreativeTabs tabLowerCrust = new TabLowerCrust(CreativeTabs.getNextID(), "Lower Crust");
	public static final CreativeTabs tabOre = new TabOre(CreativeTabs.getNextID(), "Ores");
	public static final CreativeTabs tabMiddleCrust = new TabMiddleCrust(CreativeTabs.getNextID(), "Middle Crust");
	public static final CreativeTabs tabMarble = new TabMarble(CreativeTabs.getNextID(), "Marble");
	public static final CreativeTabs tabUpperCrust = new TabUpperCrust(CreativeTabs.getNextID(), "Upper Crust");
	public static final CreativeTabs tabSoil = new TabSoil(CreativeTabs.getNextID(), "Soil");

	
	/* the main metadata-based block template for Geology block subclasses */
	/*public static Block geologyBlock;*/
	public static Block mantleRockBlock;
	public static Block outerMantleRockBlock;
	public static Block outerMantleBRockBlock;
	public static Block mohoRockBlock;
	public static Block igneousIntrusiveRockBlock;
	public static Block igneousExtrusiveRockBlock;	
	public static Block metamorphicRockBlock;	
	public static Block metamorphicBRockBlock;	
	public static Block metamorphicCRockBlock;	
	public static Block metamorphicDRockBlock;	
	public static Block sediAggregatesBlock;	
	public static Block sediAggregatesBBlock;	
	public static Block sediBedsRockBlock;	
	public static Block sediCarbonateRockBlock;	
	public static Block sediClasticRockBlock;	
	public static Block sediClasticRockBBlock;	
	public static Block sediCoalRockBlock;	
	public static Block sediPrecipRockBlock;	
	public static Block marbleRockABlock;	
	public static Block marbleRockBBlock;	
	public static Block marbleRockCBlock;	
	public static Block marbleRockDBlock;	
	public static Block marbleRockEBlock;	
	public static Block marbleRockFBlock;	
	public static Block marbleRockGBlock;	
	public static Block marbleRockHBlock;	
	public static Block metalOreABlock;	
	public static Block metalOreBBlock;	
	public static Block metalOreCBlock;	
	public static Block metalOreDBlock;	
	public static Block metalOreEBlock;	
	public static Block soilBlock;
	public static Block soilBBlock;
	public static Block soilGrassBlock;

	public static int mantleRockBlockID = 501;
	public static int outerMantleRockBlockID = 502;
	public static int outerMantleBRockBlockID = 503;
	public static int mohoRockBlockID = 504;
	
	public static int igneousInstrusiveRockBlockID = 505;
	public static int igneousExtrusiveRockBlockID = 506;
	public static int metamorphicRockBlockID = 507;
	public static int metamorphicBRockBlockID = 508;
	public static int metamorphicCRockBlockID = 509;
	public static int metamorphicDRockBlockID = 510;

	public static int sediAggregatesBlockID = 511;
	public static int sediAggregatesBBlockID = 512;
	public static int sediBedsRockBlockID = 513;
	public static int sediCarbonateRockBlockID = 514;
	public static int sediClasticRockBlockID = 515;
	public static int sediClasticRockBBlockID = 516;
	public static int sediCoalRockBlockID = 517;
	public static int sediPrecipRockBlockID = 518;
	public static int marbleRockABlockID = 519;
	public static int marbleRockBBlockID = 520;
	public static int marbleRockCBlockID = 521;
	public static int marbleRockDBlockID = 522;
	public static int marbleRockEBlockID = 523;
	public static int marbleRockFBlockID = 524;
	public static int marbleRockGBlockID = 525;
	public static int marbleRockHBlockID = 526;
	public static int metalOreABlockID = 527;
	public static int metalOreBBlockID = 528;
	public static int metalOreCBlockID = 529;
	public static int metalOreDBlockID = 530;
	public static int metalOreEBlockID = 531;
	public static int soilBlockID = 532;
	public static int soilBBlockID = 533;
	public static int soilGrassBlockID = 534;


	/* subblocks for gases */
/*	public static BlockGeologyBlock gasBlock;*/
/*	public static gasBlock steamBlock;
	public static gasBlock hBlock;
	public static gasBlock heBlock;
	
	/* subblocks for fluids */
/*	public static geologyBlock fluidBlock;
	public static fluidBlock waterBlock;
	public static fluidBlock slurryBlock;
	public static fluidBlock mudBlock;
	public static fluidBlock lavaBlock;
	public static lavaBlock fluidlavaBlock;
	public static lavaBlock viscouslavaBlock;
	public static fluidBlock moltenmetalBlock;
	public static fluidBlock moltenglassBlock;
	
	/* rock subblocks */
/*	public static geologyBlock meteoriteBlock;
	public static oreBlock gemstoneBlock;
	
	/* gemstone subblocks */

	/* constructon material blocks */
/*	public static geologyBlock mudBrick;
	public static geologyBlock mudBrickWall;
	public static geologyBlock mudBrickStair;
	public static geologyBlock cuzcoStone;
	public static geologyBlock cuzcoStoneWall;
	public static geologyBlock cuzcoStoneStair;
	public static geologyBlock egyptianStone;
	public static geologyBlock egyptianStoneWall;
	public static geologyBlock egyptianStoneStair;
	public static geologyBlock mossyBoulder;
	public static geologyBlock mossyBoulderWall;
	public static geologyBlock mossyBoulderStair;
	public static geologyBlock creteStone;
	public static geologyBlock creteStoneWall;
	public static geologyBlock creteStoneStair;
	public static geologyBlock stainedGlass;

	
	/* "fantasy" (made-up) blocks for the Nether, weapons, etc. */
/*	public static geologyBlock glyphstoneBlock;
 * 
 */

/*	public static Item gem;
	public static Item mineral;
	public static Item hammer;
	public static Item nugget;
	public static Item ingot;
	public static Item coin;
	public static Item jewelry;
*/

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Tool materials (e.g.  wood, chert, obsidian, bronze, copper, silver, steel,  */
	/* add bronze as a tool material using Forge's facility for this. */
    /* (String, int, int, float, int, int)
     * String -- the material name
     * int -- the harvest level of this tool.  Obsidian=3, diamond=2, iron=1
     * int -- the number of times before it breaks.  wood=59, diamond=1561
     * float -- the block breaking speed.  wood=2.0F, diamond=8.0F
     * int -- enchantability.  stone=5, diamond=10, gold=22
     */
    static EnumToolMaterial BRONZE = net.minecraftforge.common.EnumHelper.addToolMaterial("BRONZE", 1, 200, 3.5F, 2, 18);
    static EnumToolMaterial COPPER = net.minecraftforge.common.EnumHelper.addToolMaterial("COPPER", 1, 200, 3.5F, 2, 15);
    static EnumToolMaterial SILVER = net.minecraftforge.common.EnumHelper.addToolMaterial("SILVER", 1, 35, 9.5F, 1, 25);
    static EnumToolMaterial STEEL = net.minecraftforge.common.EnumHelper.addToolMaterial("STEEL", 3, 600, 3.5F, 2, 10);
	
	
	
	
	/*public static Item geologyItem;  */
    public static Item ingotAluminium = (new Item(4001)).setUnlocalizedName("ingotAluminium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotaluminium");
    public static Item ingotBeryllium = (new Item(4002)).setUnlocalizedName("ingotBeryllium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotberyllium");
    public static Item ingotBismuth = (new Item(4003)).setUnlocalizedName("ingotBismuth").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotbismuth");
    public static Item ingotBrass = (new Item(4004)).setUnlocalizedName("ingotBrass").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotbrass");
    public static Item ingotBronze = (new Item(4005)).setUnlocalizedName("ingotBronze").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotbronze");
    public static Item ingotCesium = (new Item(4006)).setUnlocalizedName("ingotCesium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotcesium");
    public static Item ingotCobalt = (new Item(4007)).setUnlocalizedName("ingotCobalt").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotcobalt");
    public static Item ingotCopper = (new Item(4008)).setUnlocalizedName("ingotCopper").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotcopper");
    public static Item ingotElectrum = (new Item(4009)).setUnlocalizedName("ingotElectrum").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotelectrum");
    public static Item ingotLead = (new Item(4010)).setUnlocalizedName("ingotLead").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotlead");
    public static Item ingotMagnesium = (new Item(4011)).setUnlocalizedName("ingotMagnesium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotmagnesium");
    public static Item ingotNickel  = (new Item(4012)).setUnlocalizedName("ingotNickel").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotnickel");
    public static Item ingotPalladium = (new Item(4013)).setUnlocalizedName("ingotPalladium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotpalladium");
    public static Item ingotPlatinum = (new Item(4014)).setUnlocalizedName("ingotPlatinum").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotplatinum");
    public static Item ingotPotassium  = (new Item(4015)).setUnlocalizedName("ingotPotassium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotpotassium");
    public static Item ingotSilver = (new Item(4016)).setUnlocalizedName("ingotSilver").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotsilver");
    public static Item ingotSteel  = (new Item(4017)).setUnlocalizedName("ingotSteel").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotsteel");
    public static Item ingotTellurium = (new Item(4018)).setUnlocalizedName("ingotTellurium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingottellurium");
    public static Item ingotTin = (new Item(4019)).setUnlocalizedName("ingotTin").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingottin");
    public static Item ingotTitanium  = (new Item(4020)).setUnlocalizedName("ingotTitanium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingottitanium");
    public static Item ingotUranium  = (new Item(4021)).setUnlocalizedName("ingotUranium").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingoturanium");
    public static Item ingotZinc  = (new Item(4022)).setUnlocalizedName("ingotZinc").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d(Geology.modid + ":" + "ingotzinc");
		
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup." + "geology", "en_US", "Geology");
		GameRegistry.registerWorldGenerator(new GeologyWorldGenerator());

		mantleRockBlock = new BlockMantleRock(mantleRockBlockID, Material.rock).setUnlocalizedName("mantleRockBlock").setHardness(-1.0F).setResistance(100F);
		GameRegistry.registerBlock(mantleRockBlock, ItemMantleRock.class, modid + (mantleRockBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(mantleRockBlock, 1, 0), "Dolomite II");
		LanguageRegistry.addName(new ItemStack(mantleRockBlock, 1, 1), "Wadsleyite");
		LanguageRegistry.addName(new ItemStack(mantleRockBlock, 1, 2), "Ringwoodite");
		LanguageRegistry.addName(new ItemStack(mantleRockBlock, 1, 3), "Perovskite");
		LanguageRegistry.addName(new ItemStack(mantleRockBlock, 1, 4), "Magnesiowustite");

		outerMantleRockBlock = new BlockOuterMantleRock(outerMantleRockBlockID, Material.rock).setUnlocalizedName("outerMantleRockBlock").setHardness(10.0F).setResistance(50F);
		GameRegistry.registerBlock(outerMantleRockBlock, ItemOuterMantleRock.class, modid + (outerMantleRockBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 0), "Olivine");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 1), "Leucite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 2), "Phlogopite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 3), "Richterite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 4), "Diopside");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 5), "Sanidine");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 6), "Peridotite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 7), "Dunite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 8), "Eclogite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 9), "Magnesite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 10), "Aragonite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 11), "Lamprophyre");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 12), "Clinopyroxenite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 13), "Orangeite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 14), "Leucitite");
		LanguageRegistry.addName(new ItemStack(outerMantleRockBlock, 1, 15), "Leucogranite");

		outerMantleBRockBlock = new BlockOuterMantleBRock(outerMantleBRockBlockID, Material.rock).setUnlocalizedName("outerMantleBRockBlock").setHardness(10.0F).setResistance(50F);
		GameRegistry.registerBlock(outerMantleBRockBlock, ItemOuterMantleBRock.class, modid + (outerMantleBRockBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 0), "Orthopyroxenite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 1), "Obsidian");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 2), "Rhyolite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 3), "Carbonatite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 4), "Serpentinite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 5), "Jadeite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 6), "Nephrite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 7), "Wadsleyite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 8), "Ringwoodite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 9), "Wehrlite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 10), "Harzburgite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 11), "Lherzolite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 12), "Kimberlite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 13), "Lamproite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 14), "Serpentinite");
		LanguageRegistry.addName(new ItemStack(outerMantleBRockBlock, 1, 15), "Periclase");



		mohoRockBlock = new BlockMohoRock(mohoRockBlockID, Material.rock).setUnlocalizedName("mohoRockBlock").setHardness(10.0F).setResistance(50F);
		GameRegistry.registerBlock(mohoRockBlock, ItemMohoRock.class, modid + (mohoRockBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(mohoRockBlock, 1, 0), "Orthopyroxenite");
		LanguageRegistry.addName(new ItemStack(mohoRockBlock, 1, 1), "Obsidian");
		LanguageRegistry.addName(new ItemStack(mohoRockBlock, 1, 2), "Rhyolite");
		LanguageRegistry.addName(new ItemStack(mohoRockBlock, 1, 3), "Carbonatite");
		LanguageRegistry.addName(new ItemStack(mohoRockBlock, 1, 4), "Serpentinite");



		igneousIntrusiveRockBlock = new BlockIgneousIntrusiveRock(igneousInstrusiveRockBlockID, Material.rock).setUnlocalizedName("igneousIntrusiveRockBlock").setHardness(3.0F).setResistance(30F);
		GameRegistry.registerBlock(igneousIntrusiveRockBlock, ItemIgneousIntrusiveRock.class, modid + (igneousIntrusiveRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 0), "Diorite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 1), "Gabbro");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 2), "Granite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 3), "Pegmatite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 4), "Anorthosite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 5), "Orthoclase");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 6), "Anorthoclase");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 7), "Oligoclase");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 8), "Syenite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 9), "Labradorite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 10), "Bytownite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 11), "Albite");
		LanguageRegistry.addName(new ItemStack(igneousIntrusiveRockBlock, 1, 12), "Intrusive Breccia");


		igneousExtrusiveRockBlock = new BlockIgneousExtrusiveRock(igneousExtrusiveRockBlockID, Material.rock).setUnlocalizedName("igneousExtrusiveRockBlock").setHardness(1.5F).setResistance(30F);
		GameRegistry.registerBlock(igneousExtrusiveRockBlock, ItemIgneousExtrusiveRock.class, modid + (igneousExtrusiveRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousExtrusiveRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 0), "Andesite");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 1), "Basalt");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 2), "Pumice");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 3), "Rhyolite");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 4), "Scoria");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 5), "Tuff");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 6), "Sanidine");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 7), "Amazonite");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 8), "Trachyte");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 9), "Anorthite");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 10), "Extrusive Breccia");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 11), "Basalt Breccia");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 12), "Aegerine");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 13), "Salmon Microcline");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 14), "Perthite");
		LanguageRegistry.addName(new ItemStack(igneousExtrusiveRockBlock, 1, 15), "Moonstone");


		metamorphicRockBlock = new BlockMetamorphicRock(metamorphicRockBlockID, Material.rock).setUnlocalizedName("metamorphicRockBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(metamorphicRockBlock, ItemMetamorphicRock.class, modid + (metamorphicRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 0), "Amphibolite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 1), "Anatectite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 2), "Calcsilicate");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 3), "Cataclasite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 4), "Cordierite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 5), "Garnetite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 6), "Glaucophanite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 7), "Gneiss");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 8), "Granofels");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 9), "Hornfel");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 10), "Jadeitite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 11), "Migmatite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 12), "Pegmatite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 13), "Charnockite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 14), "Pyroxenite");
		LanguageRegistry.addName(new ItemStack(metamorphicRockBlock, 1, 15), "Bismuthinite");


		metamorphicBRockBlock = new BlockMetamorphicBRock(metamorphicBRockBlockID, Material.rock).setUnlocalizedName("metamorphicBRockBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(metamorphicBRockBlock, ItemMetamorphicRock.class, modid + (metamorphicBRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 0), "Wurtzite");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 1), "Crazy Lace Agate");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 2), "Blueschist");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 3), "Chalcedony");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 4), "Aventurine");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 5), "Carnelian");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 6), "Sard");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 7), "Chrysoprase");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 8), "Heliotrope");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 9), "Moss Agate");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 10), "Mtorolite");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 11), "Agate");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 12), "Onyx");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 13), "Fire Agate");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 14), "Greenschist");
		LanguageRegistry.addName(new ItemStack(metamorphicBRockBlock, 1, 15), "Prehnite");
		

		
		metamorphicCRockBlock = new BlockMetamorphicCRock(metamorphicCRockBlockID, Material.rock).setUnlocalizedName("metamorphicCRockBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(metamorphicCRockBlock, ItemMetamorphicRock.class, modid + (metamorphicCRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 0), "Sanidinite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 1), "Anthophyllite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 2), "Phylite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 3), "Garnet-Wollastonite Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 4), "Andradite Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 5), "Andradite-Garnet-Diopside-Molybdenite-Scheelite Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 6), "Limestone Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 7), "Ilvaite-Hedenbergite Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 8), "Molybdenum-Garnetite Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 9), "Skarn");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 10), "Hauynite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 11), "Plasma Heliotrope");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 12), "Cordierite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 13), "Quartzite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 14), "Tactite");
		LanguageRegistry.addName(new ItemStack(metamorphicCRockBlock, 1, 15), "Smithsonite");


		metamorphicDRockBlock = new BlockMetamorphicDRock(metamorphicDRockBlockID, Material.rock).setUnlocalizedName("metamorphicDRockBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(metamorphicDRockBlock, ItemMetamorphicRock.class, modid + (metamorphicDRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metamorphicDRockBlock, 1, 0), "Slate");
		LanguageRegistry.addName(new ItemStack(metamorphicDRockBlock, 1, 1), "Ironstone");
		
		sediAggregatesBlock = new BlockSediAggregates(sediAggregatesBlockID, Material.rock).setUnlocalizedName("sediAggregatesBlock") .setHardness(0.3F) .setResistance(3F) .setStepSound(Block.soundGravelFootstep);
		GameRegistry.registerBlock(sediAggregatesBlock, ItemSediAggregates.class, modid + (sediAggregatesBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block sediAggregatesBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 0), "Gas Sand");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 1), "Green Sand");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 2), "Bitumen");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 3), "Quartz Pebbles");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 4), "Red Sand");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 5), "Peat Coal");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 6), "Black Sand");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 7), "Rocks");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 8), "Black Rocks");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 9), "Geodes");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 10), "Silt");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 11), "Placer Silt");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 12), "Volcanic Ash");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 13), "Forest Ash");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 14), "Grass Ash");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBlock, 1, 15), "Pebbles");


		sediAggregatesBBlock = new BlockSediAggregatesB(sediAggregatesBBlockID, Material.rock).setUnlocalizedName("sediAggregatesBBlock") .setHardness(0.3F) .setResistance(3F) .setStepSound(Block.soundGravelFootstep);
		GameRegistry.registerBlock(sediAggregatesBBlock, ItemSediAggregatesB.class, modid + (sediAggregatesBBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block sediAggregatesBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 0), "Bank Gravel");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 1), "Bench Gravel");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 2), "Creek Rock");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 3), "Crushed Rock");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 4), "Pea Gravel");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 5), "River Run Gravel");
		LanguageRegistry.addName(new ItemStack(sediAggregatesBBlock, 1, 6), "Crushed Stone");


		sediBedsRockBlock = new BlockSediBedsRock(sediBedsRockBlockID, Material.rock).setUnlocalizedName("sediBedsRockBlock").setHardness(0.5F) .setResistance(4F);
		GameRegistry.registerBlock(sediBedsRockBlock, ItemSediBedsRock.class, modid + (sediBedsRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block sediBedsRockBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 0), "Alabaster");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 1), "Anhydrite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 2), "Calcrete");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 3), "Bonebed");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 4), "Caustobiolith");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 5), "Contourite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 6), "Flysch");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 7), "Molasse");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 8), "Oolite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 9), "Shellbed");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 10), "Tempestite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 11), "Sulfur Bed");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 12), "Beige Anhydrite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 13), "Green Anhydrite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 14), "Pink Anhydrite");
		LanguageRegistry.addName(new ItemStack(sediBedsRockBlock, 1, 15), "Blue Anhydrite");


		sediCarbonateRockBlock = new BlockSediCarbonateRock(sediCarbonateRockBlockID, Material.rock).setUnlocalizedName("sediCarbonateRockBlock").setHardness(1.5F).setResistance(4F);
		GameRegistry.registerBlock(sediCarbonateRockBlock, ItemSediCarbonateRock.class, modid + (sediCarbonateRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 0), "Calcite Rock");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 1), "Encrinite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 2), "Bauxite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 3), "Beachrock");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 4), "Algal Bindstone");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 5), "Crinoid Biomicrite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 6), "Bioparite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 7), "Boundstone");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 8), "Calcarenite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 9), "Calcilutite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 10), "Chalk");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 11), "Coquina");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 12), "Micrite");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 13), "Dolostone");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 14), "Grainstone");
		LanguageRegistry.addName(new ItemStack(sediCarbonateRockBlock, 1, 15), "Limestone");


		sediClasticRockBlock = new BlockSediClasticRock(sediClasticRockBlockID, Material.rock).setUnlocalizedName("sediClasticRockBlock").setHardness(2.0F).setResistance(4F);
		GameRegistry.registerBlock(sediClasticRockBlock, ItemSediClasticRockB.class, modid + (sediClasticRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 0), "Alum Shale");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 1), "Arenite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 2), "Argillite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 3), "Arkose");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 4), "Bentonite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 5), "Black Shale");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 6), "Cinerite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 7), "Claystone");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 8), "Conglomerate");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 9), "Diamictite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 10), "Diatomite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 11), "Eolianite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 12), "Fanglomerate");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 13), "Shale");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 14), "Sedimentary Breccia");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBlock, 1, 15), "Siltstone");


		sediClasticRockBBlock = new BlockSediClasticRockB(sediClasticRockBBlockID, Material.rock).setUnlocalizedName("sediClasticRockBBlock").setHardness(1.5F).setResistance(4F);
		GameRegistry.registerBlock(sediClasticRockBBlock, ItemSediClasticRockB.class, modid + (sediClasticRockBBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 0), "Greywacke");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 1), "Green Sandstone");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 2), "Kukersite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 3), "Litharenite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 4), "Marl");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 5), "Mudstone");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 6), "Novacullite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 7), "Oil Shale");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 8), "Orthoquartzite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 9), "Porcellanite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 10), "Quartzarenite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 11), "Radiolarite");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 12), "Red Sandstone");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 13), "Red Siltstone");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 14), "Red Shale");
		LanguageRegistry.addName(new ItemStack(sediClasticRockBBlock, 1, 15), "Sandstone");



		sediCoalRockBlock = new BlockSediCoalRock(sediCoalRockBlockID, Material.rock).setUnlocalizedName("sediCoalRockBlock").setHardness(1.0F).setResistance(15F);
		GameRegistry.registerBlock(sediCoalRockBlock, ItemSediCoalRock.class, modid + (sediCoalRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 0), "Anthracite");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 1), "Bituminous Coal");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 2), "Brown Coal");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 3), "Lignite");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 4), "Graphite");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 5), "Peacock Coal");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 6), "Marlstone");
		LanguageRegistry.addName(new ItemStack(sediCoalRockBlock, 1, 7), "Grey Marlstone");


		sediPrecipRockBlock = new BlockSediPrecipRock(sediPrecipRockBlockID, Material.rock).setUnlocalizedName("sediPrecipRockBlock").setHardness(1.5F).setResistance(4F);
		GameRegistry.registerBlock(sediPrecipRockBlock, ItemSediPrecipRock.class, modid + (sediPrecipRockBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block igneousIntrusiveBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 0), "Banded Iron");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 1), "Chert");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 2), "Duricrust");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 3), "Ferncrete");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 4), "Petrified Wood");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 5), "Ironstone");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 6), "Jasperoid");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 7), "Phosphorite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 8), "Halite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 9), "Silcrete");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 10), "Geyserite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 11), "Pink Sylvinite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 12), "Blue Sylvinite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 13), "Taconite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 12), "Tan Halite");
		LanguageRegistry.addName(new ItemStack(sediPrecipRockBlock, 1, 13), "Green Halite");


		marbleRockABlock = new BlockMarbleRockA(marbleRockABlockID, Material.rock).setUnlocalizedName("marbleRockABlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockABlock, ItemMarbleRockA.class, modid + (marbleRockABlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 0), "Alp Green Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 1), "Amarante Basque Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 2), "Anitch Griotte Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 3), "Antique Cipolin Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 4), "Arudy Henry 4 Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 5), "Balacet Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 6), "Bardiglio Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 7), "Barzilian Arabescato Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 8), "Belgian Blue Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 9), "Bois Jourdan Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 10), "Botticino Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 11), "Breccia Pontificia Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 12), "Breche de Benou Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 13), "Brocatelle de Sienne Italian Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockABlock, 1, 14), "Brocatelle Jaune du Jura French Marble");


		marbleRockBBlock = new BlockMarbleRockB(marbleRockBBlockID, Material.rock).setUnlocalizedName("marbleRockBBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockBBlock, ItemMarbleRockB.class, modid + (marbleRockBBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block marbleRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 0), "Brocatelle Rouge Tortosa Spanish Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 1), "Brocatelle Violette du Jura French Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 2), "Brocatelle Violette Spanish Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 3), "Campan Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 4), "Campane Rubane Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 5), "Campan Verde Rosa Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 6), "Carrare Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 7), "Carrare Blue Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 8), "Cazavet Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 9), "Cette Eygun Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 10), "Cihige Black Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 11), "Cipolin Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 12), "Cipolin Mont Cenis Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 13), "Coquillerde de Bilbao Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockBBlock, 1, 14), "Crema Valencia Marble");


		marbleRockCBlock = new BlockMarbleRockC(marbleRockCBlockID, Material.rock).setUnlocalizedName("marbleRockCBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockCBlock, ItemMarbleRockC.class, modid + (marbleRockCBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 0), "Creole Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 1), "Duquesa Rosa Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 2), "Emperador Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 3), "Forest Green Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 4), "Grey Aliveri Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 5), "Griotte Oeil de Perdrix French Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 6), "Griotte Rouge French Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 7), "Haumont Bizantine Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 8), "Hautacam Ivory Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 9), "Imperial Pink Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 10), "Imperial Danby Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 11), "Incarna Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 12), "Irish Conne Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 13), "Levanto Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockCBlock, 1, 14), "Maine Red Marble");


		marbleRockDBlock = new BlockMarbleRockD(marbleRockDBlockID, Material.rock).setUnlocalizedName("marbleRockDBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockDBlock, ItemMarbleRockD.class, modid + (marbleRockDBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 0), "Chinese Ming Green Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 1), "Greek Naxos Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 2), "Greek Naxos Gold Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 3), "Nero Africano Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 4), "Newgialo Antiquo Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 5), "Greek Naxos White Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 6), "Norwegian Pink Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 7), "Opera Fantastico Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 8), "Pakistani Green Onyx Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 9), "Palissandro Nuvolato Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 10), "Pietradierfoud Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 11), "Pink Cipolin Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 12), "Pintaverde Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 13), "Rance Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockDBlock, 1, 14), "French Red Campan Griotte Marble");


		marbleRockEBlock = new BlockMarbleRockE(marbleRockEBlockID, Material.rock).setUnlocalizedName("marbleRockEBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockEBlock, ItemMarbleRockE.class, modid + (marbleRockEBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 0), "French Rose Enjugerais Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 1), "French Rouge Languedoc Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 2), "Saboam Rose Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 3), "Sardinian Saint Angelo Caglian Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 4), "French Saint Beaume Yellow Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 5), "French Sarrancolin Camous Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 6), "French Savoie Blue Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 7), "Serpegiante Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 8), "Greek Skyros Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 9), "Quebec St. Laurent Black Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 10), "Greek Thessos White Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 11), "Roman Travertine Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 12), "Persian Red Travertine Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 13), "Turkish Coffee Gold Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 14), "Valencia Rosa Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockEBlock, 1, 15), "Valencia Amarillo Marble");


		marbleRockFBlock = new BlockMarbleRockF(marbleRockFBlockID, Material.rock).setUnlocalizedName("marbleRockFBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockFBlock, ItemMarbleRockF.class, modid + (marbleRockFBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 0), "Pink Granite Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 1), "Bianco Carrara Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 2), "Numidia Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 3), "Botticino Fiorito Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 4), "Chinese Red Porphyry Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 5), "Corchia Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 6), "Cremodelicato Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 7), "Damasco Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 8), "Gaul Grey Granite Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 9), "Diaspro Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 10), "Domician Numidian Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 11), "Fiodi Pesco Classico Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 12), "Brown Fossil Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 13), "Giallo Antico Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 14), "Giallo Sienna Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockFBlock, 1, 15), "Imperial Red Porphyry Marble");


		marbleRockGBlock = new BlockMarbleRockG(marbleRockGBlockID, Material.rock).setUnlocalizedName("marbleRockGBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockGBlock, ItemMarbleRockG.class, modid + (marbleRockGBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 0), "Red Porphyry Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 1), "Roman Red Granite Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 2), "Porphyry Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 3), "Moroccan Yellow Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 4), "Malachite Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 5), "White Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 6), "Moroccan Volubitis Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 7), "Imperial Maroon Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 8), "Calacatta Carrara Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 9), "Calacatta Vagli Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 10), "Bardiglio Capella Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 11), "Giallo Elisa Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 12), "Giallo Reale Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 13), "Crema Valencia Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 14), "Pentelicon Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockGBlock, 1, 15), "Casablanca White Marble");


		marbleRockHBlock = new BlockMarbleRockH(marbleRockHBlockID, Material.rock).setUnlocalizedName("marbleRockHBlock").setHardness(2.0F).setResistance(15F);
		GameRegistry.registerBlock(marbleRockHBlock, ItemMarbleRockH.class, modid + (marbleRockHBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 0), "Numidiana Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 1), "Palissandro Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 2), "Paros Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 3), "Rosa Portogallo Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 4), "Rosso Alicante Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 5), "Rosso Erica Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 6), "Rosso Verona Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 7), "Rosso Levanto Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 8), "Salome Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 9), "Palissandro Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 10), "Statuario Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 11), "Roman Travertine Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 12), "Antique Travertine Marble");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 13), "---");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 14), "---");
		LanguageRegistry.addName(new ItemStack(marbleRockHBlock, 1, 15), "---");


		/* Fe, Au ore blocks (other: Anitch Griotte in BlockMarbleRockA) */
		metalOreABlock = new BlockMetalOreA(metalOreABlockID, Material.rock).setUnlocalizedName("metalOreABlock").setHardness(1.5F).setResistance(15F);
		GameRegistry.registerBlock(metalOreABlock, ItemMetalOreA.class, modid + (metalOreABlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 0), "Siderite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 1), "Ankerite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 2), "Minnesotaite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 3), "Greenalite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 4), "Grunerite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 5), "Magnetite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 6), "Hematite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 7), "Titanomagnetite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 8), "Calaverite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 9), "Sylvanite");
		LanguageRegistry.addName(new ItemStack(metalOreABlock, 1, 10), "Nagyagite");


		/* Ag, Ni, Cu ore blocks */		
		metalOreBBlock = new BlockMetalOreB(metalOreBBlockID, Material.rock).setUnlocalizedName("metalOreBBlock").setHardness(1.5F).setResistance(15F);
		GameRegistry.registerBlock(metalOreBBlock, ItemMetalOreB.class, modid + (metalOreBBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block metamorphicRockBBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 0), "Argentite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 1), "Chlorargyrite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 2), "Petzite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 3), "Pentlandite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 4), "Millerite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 5), "Nickeline");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 6), "Galena");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 7), "Kamacite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 8), "Taenite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 9), "Klockmannite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 10), "Chalcopyrite");
		LanguageRegistry.addName(new ItemStack(metalOreBBlock, 1, 11), "Chalcocite");



		/* Cu, tin/Sn  ore blocks */
		metalOreCBlock = new BlockMetalOreC(metalOreCBlockID, Material.rock).setUnlocalizedName("metalOreCBlock").setHardness(1.5F).setResistance(15F);
		GameRegistry.registerBlock(metalOreCBlock, ItemMetalOreC.class, modid + (metalOreCBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 0), "Covellite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 1), "Bornite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 2), "Tetrahedrite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 3), "Azurite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 4), "Cuprite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 5), "Chrysocolla");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 6), "Tennantite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 7), "Cassiterite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 8), "Stannite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 9), "Cylindrite");
		LanguageRegistry.addName(new ItemStack(metalOreCBlock, 1, 10), "Franckeite");


		/* tin/Sn, U, Ti, Pt, Be, Pb, Al  ore blocks */
		metalOreDBlock = new BlockMetalOreD(metalOreDBlockID, Material.rock).setUnlocalizedName("metalOreDBlock").setHardness(1.5F).setResistance(15F);
		GameRegistry.registerBlock(metalOreDBlock, ItemMetalOreD.class, modid + (metalOreDBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 0), "Canfieldite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 1), "Teallite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 2), "Uraninite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 3), "Carnotite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 4), "Margaritasite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 5), "Tyuyamunite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 6), "Rutile");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 7), "Ilmenite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 8), "Sperrylite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 9), "Bertrandite");
		LanguageRegistry.addName(new ItemStack(metalOreDBlock, 1, 10), "Aikinite");


		/* Zn, Bi, Te, Pb  ore blocks */
		metalOreEBlock = new BlockMetalOreE(metalOreEBlockID, Material.rock).setUnlocalizedName("metalOreEBlock").setHardness(1.5F).setResistance(15F);
		GameRegistry.registerBlock(metalOreEBlock, ItemMetalOreE.class, modid + (metalOreEBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 0), "Sphalerite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 1), "Smithsonite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 2), "Hemimorphite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 3), "Wurtzite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 4), "Hydrozincite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 5), "Bismuthinite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 6), "Frohbergite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 7), "Leucite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 8), "Pollucite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 9), "Carnallite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 10), "Zinnwaldite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 11), "Lepidolite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 12), "Rinneite");
		LanguageRegistry.addName(new ItemStack(metalOreEBlock, 1, 13), "Rokuhnite");



		soilBlock = new BlockSoil(soilBlockID, Material.ground).setUnlocalizedName("soilBlock") .setHardness(0.3F) .setResistance(2.5F) .setStepSound(Block.soundGravelFootstep);
		GameRegistry.registerBlock(soilBlock, ItemSediAggregates.class, modid + (soilBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block sediAggregatesBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 0), "Alfisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 1), "Andisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 2), "Aridisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 3), "Entisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 4), "Gelisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 5), "Histosol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 6), "Inceptisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 7), "Molisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 8), "Oxisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 9), "Spodosol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 10), "Ultisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 11), "Vertisol");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 12), "Topsoil");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 13), "Red Clay");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 14), "Dry Mud");
		LanguageRegistry.addName(new ItemStack(soilBlock, 1, 15), "Salt Flat");


		soilBBlock = new BlockSoilB(soilBBlockID, Material.ground).setUnlocalizedName("soilBBlock") .setHardness(0.3F) .setResistance(2.5F) .setStepSound(Block.soundGravelFootstep);
		GameRegistry.registerBlock(soilBBlock, ItemSediAggregates.class, modid + (soilBBlock.getUnlocalizedName().substring(5)));
		/*System.out.println("this is how the block sediAggregatesBlock was registered");*/
		LanguageRegistry.addName(new ItemStack(soilBBlock, 1, 0), "Niter");
		LanguageRegistry.addName(new ItemStack(soilBBlock, 1, 1), "Swamp Grass");
		LanguageRegistry.addName(new ItemStack(soilBBlock, 1, 2), "Field Dry Grass");
		LanguageRegistry.addName(new ItemStack(soilBBlock, 1, 3), "Field Grass");
		LanguageRegistry.addName(new ItemStack(soilBBlock, 1, 4), "Field Grass Flowers");


		soilGrassBlock = new BlockSoil(soilGrassBlockID, Material.grass).setUnlocalizedName("soilGrassBlock") .setHardness(0.3F) .setResistance(2.5F) .setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(soilGrassBlock, ItemSoilGrass.class, modid + (soilGrassBlock.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 0), "Alfisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 1), "Andisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 2), "Aridisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 3), "Entisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 4), "Gelisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 5), "Histosol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 6), "Inceptisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 7), "Molisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 8), "Rainforest Undergrowth");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 9), "Spodosol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 10), "Ultisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 11), "Vertisol");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 12), "Topsoil");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 13), "Red Clay");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 14), "Dry Mud");
		LanguageRegistry.addName(new ItemStack(soilGrassBlock, 1, 15), "Salt Flat");


		
		
		/* geologyItem = new ItemGeology(5000).setUnlocalizedName("geologyItem"); */
		LanguageRegistry.addName(ingotAluminium,  "Aluminium Ingot");
		LanguageRegistry.addName(ingotBeryllium,  "Beryllium Ingot");
		LanguageRegistry.addName(ingotBismuth,  "Bismuth Ingot");
		LanguageRegistry.addName(ingotBrass,  "Brass Ingot");
		LanguageRegistry.addName(ingotBronze,  "Bronze Ingot");
		LanguageRegistry.addName(ingotCesium,  "Cesium Ingot");
		LanguageRegistry.addName(ingotCobalt,  "Cobalt Ingot");
		LanguageRegistry.addName(ingotCopper,  "Copper Ingot");
		LanguageRegistry.addName(ingotElectrum,  "Electrum Ingot");
		LanguageRegistry.addName(ingotLead,  "Lead Ingot");
		LanguageRegistry.addName(ingotMagnesium,  "Magnesium Ingot");
		LanguageRegistry.addName(ingotNickel,  "Nickel Ingot");
		LanguageRegistry.addName(ingotPalladium,  "Palladium Ingot");
		LanguageRegistry.addName(ingotPotassium,  "Potassium Ingot");
		LanguageRegistry.addName(ingotSilver,  "Silver Ingot");
		LanguageRegistry.addName(ingotSteel,  "Steel Ingot");
		LanguageRegistry.addName(ingotTellurium,  "Tellurium Ingot");
		LanguageRegistry.addName(ingotTin,  "Tin Ingot");
		LanguageRegistry.addName(ingotTitanium,  "Titanium Ingot");
		LanguageRegistry.addName(ingotUranium,  "Uranium Ingot");
		LanguageRegistry.addName(ingotZinc,  "Zinc Ingot");
	
		
		GeologyCrafting.loadRecipes();
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		/* Recipes */
		/* e.g. 9 dirt blocks produce stone */
		GameRegistry.addRecipe(new ItemStack(Block.stone, 1), new Object [] {"DDD","DDD","DDD",	'D', Block.dirt	});
		/* e.g. use the Crafting Manager to produce a gold ingot using 9 cobblestone blocks */
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.ingotGold, 1),"CCC","CCC","CCC",Character.valueOf('C'), Block.cobblestone);
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		/* Smelting Recipes for ores */
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 0, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 1, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 2, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 3, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 4, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 5, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 6, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 7, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 8, new ItemStack(Item.ingotIron), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 9, new ItemStack(Item.ingotGold), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 10, new ItemStack(Item.ingotGold), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreABlock.blockID, 11, new ItemStack(Item.ingotGold), 0.7F);
 		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 0, new ItemStack(ingotSilver), 0.7F); /* silver */
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 1, new ItemStack(ingotSilver), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 2, new ItemStack(ingotSilver), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 3, new ItemStack(ingotNickel), 0.7F); /* nickel */
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 4, new ItemStack(ingotNickel), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 5, new ItemStack(ingotNickel), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 6, new ItemStack(ingotNickel), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 7, new ItemStack(ingotNickel), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 8, new ItemStack(ingotNickel), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 9, new ItemStack(ingotCopper), 0.7F);  /* copper */
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 10, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreBBlock.blockID, 11, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 0, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 1, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 2, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 3, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 4, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 5, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 6, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 7, new ItemStack(ingotCopper), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 8, new ItemStack(ingotTin), 0.7F);  /* tin  */
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 9, new ItemStack(ingotTin), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 10, new ItemStack(ingotTin), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreCBlock.blockID, 11, new ItemStack(ingotTin), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 0, new ItemStack(ingotTin), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 1, new ItemStack(ingotTin), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 2, new ItemStack(ingotUranium), 0.7F);  /*  uranium  */ 
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 3, new ItemStack(ingotUranium), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 4, new ItemStack(ingotUranium), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 5, new ItemStack(ingotUranium), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 6, new ItemStack(ingotTitanium), 0.7F);  /* titanium  */
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 7, new ItemStack(ingotTitanium), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 8, new ItemStack(ingotPlatinum), 0.7F);  /* platinum  */
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 9, new ItemStack(ingotBeryllium), 0.7F);  /* beryllium  */
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 10, new ItemStack(ingotLead), 0.7F);  /* lead  */
		FurnaceRecipes.smelting().addSmelting(metalOreDBlock.blockID, 11, new ItemStack(ingotAluminium), 0.7F);  /* aluminium  */
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 0, new ItemStack(ingotZinc), 0.7F);  /* zinc  */
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 1, new ItemStack(ingotZinc), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 2, new ItemStack(ingotZinc), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 3, new ItemStack(ingotZinc), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 4, new ItemStack(ingotZinc), 0.7F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 5, new ItemStack(ingotBismuth), 0.7F);  /* bismuth  */
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 6, new ItemStack(ingotTellurium), 1.0F); /* rare metals here not in game yet */
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 7, new ItemStack(ingotAluminium), 1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 8, new ItemStack(ingotCesium), 1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 9, new ItemStack(ingotMagnesium), 1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 10, new ItemStack(ingotAluminium),1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 11, new ItemStack(ingotAluminium), 1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 12, new ItemStack(ingotPotassium),1.0F);
		FurnaceRecipes.smelting().addSmelting(metalOreEBlock.blockID, 13, new ItemStack(Item.ingotIron), 1.0F);
		
		/* baking clay bricks */
		FurnaceRecipes.smelting().addSmelting(soilBlock.blockID, 13, new ItemStack(Block.brick), 0.1F);

/* http://euromin.w3sites.net/mineraux/ */
		}
	}

