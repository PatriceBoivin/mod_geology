package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMohoRock extends ItemBlock
{
       public ItemMohoRock(int par1)
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
                           name = "orthopyroxenite";
                           break;
                    }
                    case 1:
                    {
                           name = "obsidian";
                           break;
                    }
                    case 2:
                    {
                           name = "rhyolite";
                           break;
                    }
                    case 3:
                    {
                           name = "carbonatite";
                           break;
                    }
                    case 4:
                    {
                           name = "serpentinite";
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