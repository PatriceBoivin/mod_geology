package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetamorphicRock extends ItemBlock
{
       public ItemMetamorphicRock(int par1)
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
                           name = "amphibolite";
                           break;
                    }
                    case 1:
                    {
                           name = "anatectite";
                           break;
                    }
                    case 2:
                    {
                           name = "calcsilicate";
                           break;
                    }
                    case 3:
                    {
                           name = "cataclasite";
                           break;
                    }
                    case 4:
                    {
                           name = "cordierite";
                           break;
                    }
                    case 5:
                    {
                           name = "garnetite";
                           break;
                    }
                    case 6:
                    {
                           name = "glaucophanite";
                           break;
                    }
                    case 7:
                    {
                           name = "gneiss";
                           break;
                    }
                    case 8:
                    {
                           name = "granofels";
                           break;
                    }
                    case 9:
                    {
                           name = "hornfel";
                           break;
                    }
                    case 10:
                    {
                           name = "jadeitite";
                           break;
                    }
                    case 11:
                    {
                           name = "migmatite";
                           break;
                    }
                    case 12:
                    {
                           name = "pegmatite";
                           break;
                    }
                    case 13:
                    {
                           name = "charnockite";
                           break;
                    }
                    case 14:
                    {
                           name = "pyroxenite";
                           break;
                    }
                    case 15:
                    {
                           name = "bismuthinite";
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