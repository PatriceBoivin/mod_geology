package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediClasticRockB extends ItemBlock
{
       public ItemSediClasticRockB(int par1)
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
                           name = "greywacke";
                           break;
                    }
                    case 1:
                    {
                           name = "greensandstone";
                           break;
                    }
                    case 2:
                    {
                           name = "kukersite";
                           break;
                    }
                    case 3:
                    {
                           name = "litharenite";
                           break;
                    }
                    case 4:
                    {
                           name = "marl";
                           break;
                    }
                    case 5:
                    {
                           name = "mudstone";
                           break;
                    }
                    case 6:
                    {
                           name = "novacullite";
                           break;
                    }
                    case 7:
                    {
                           name = "oilshale";
                           break;
                    }
                    case 8:
                    {
                           name = "orthoquartzite";
                           break;
                    }
                    case 9:
                    {
                           name = "porcellanite";
                           break;
                    }
                    case 10:
                    {
                           name = "quartzarenite";
                           break;
                    }
                    case 11:
                    {
                           name = "radiolarite";
                           break;
                    }
                    case 12:
                    {
                           name = "redsandstone";
                           break;
                    }
                    case 13:
                    {
                           name = "redsiltstone";
                           break;
                    }
                    case 14:
                    {
                           name = "redshale";
                           break;
                    }
                    case 15:
                    {
                           name = "sandstone";
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