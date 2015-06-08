package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockA extends ItemBlock
{
       public ItemMarbleRockA(int par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
      public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
                    case 0:
                    {
                           name = "marblealpgreen";
                           break;
                    }
                    case 1:
                    {
                           name = "marbleamarantebasque";
                           break;
                    }
                    case 2:
                    {
                           name = "marbleanitchgriotte";
                           break;
                    }
                    case 3:
                    {
                           name = "marbleantiquecipolin";
                           break;
                    }
                    case 4:
                    {
                           name = "marblearudyhenri4";
                           break;
                    }
                    case 5:
                    {
                           name = "marblebalacet";
                           break;
                    }
                    case 6:
                    {
                           name = "marblebardiglio";
                           break;
                    }
                    case 7:
                    {
                           name = "marblebarzilianarabescato";
                           break;
                    }
                    case 8:
                    {
                           name = "marblebleubelge";
                           break;
                    }
                    case 9:
                    {
                           name = "marbleboisjourdan";
                           break;
                    }
                    case 10:
                    {
                           name = "marblebotticino";
                           break;
                    }
                    case 11:
                    {
                           name = "marblebrecciapontificia";
                           break;
                    }
                    case 12:
                    {
                           name = "marblebrechedebenou";
                           break;
                    }
                    case 13:
                    {
                           name = "marblebrocatelledesienne";
                           break;
                    }
                    case 14:
                    {
                           name = "marblebrocatellejaunedujura";
                           break;
                    }
                    default: name = "broken";
             }
             return getUnlocalizedName() + "." + name;
       } 
      
       public int getMetadata(int par1)
       {
             return par1;
       } 
}