package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetamorphicBRock extends ItemBlock
{
       public ItemMetamorphicBRock(int par1)
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
                           name = "wurtzite";
                           break;
                    }
                    case 1:
                    {
                           name = "crazylaceagate";
                           break;
                    }
                    case 2:
                    {
                           name = "blueschist";
                           break;
                    }
                    case 3:
                    {
                           name = "chalcedony";
                           break;
                    }
                    case 4:
                    {
                           name = "aventurine";
                           break;
                    }
                    case 5:
                    {
                           name = "carnelian";
                           break;
                    }
                    case 6:
                    {
                           name = "sard";
                           break;
                    }
                    case 7:
                    {
                           name = "chrysoprase";
                           break;
                    }
                    case 8:
                    {
                           name = "heliotrope";
                           break;
                    }
                    case 9:
                    {
                           name = "mossagate";
                           break;
                    }
                    case 10:
                    {
                           name = "mtorolite";
                           break;
                    }
                    case 11:
                    {
                           name = "agate";
                           break;
                    }
                    case 12:
                    {
                           name = "onyx";
                           break;
                    }
                    case 13:
                    {
                           name = "fireagate";
                           break;
                    }
                    case 14:
                    {
                           name = "greenschist";
                           break;
                    }
                    case 15:
                    {
                           name = "prehnite";
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