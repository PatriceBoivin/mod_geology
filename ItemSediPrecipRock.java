package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediPrecipRock extends ItemBlock
{
       public ItemSediPrecipRock(int par1)
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
                           name = "bandediron";
                           break;
                    }
                    case 1:
                    {
                           name = "chert";
                           break;
                    }
                    case 2:
                    {
                           name = "duricrust";
                           break;
                    }
                    case 3:
                    {
                           name = "ferncrete";
                           break;
                    }
                    case 4:
                    {
                           name = "petrifiedwood";
                           break;
                    }
                    case 5:
                    {
                           name = "ironstone";
                           break;
                    }
                    case 6:
                    {
                           name = "jasperoid";
                           break;
                    }
                    case 7:
                    {
                           name = "phosphorite";
                           break;
                    }
                    case 8:
                    {
                           name = "halite";
                           break;
                    }
                    case 9:
                    {
                           name = "silcrete";
                           break;
                    }
                    case 10:
                    {
                           name = "geyserite";
                           break;
                    }
                    case 11:
                    {
                           name = "pinksylvinite";
                           break;
                    }
                    case 12:
                    {
                           name = "bluesylvinite";
                           break;
                    }
                    case 13:
                    {
                           name = "taconite";
                           break;
                    }
                    case 14:
                    {
                           name = "tanhalite";
                           break;
                    }
                    case 15:
                    {
                           name = "greenhalite";
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