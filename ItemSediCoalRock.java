package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediCoalRock extends ItemBlock
{
       public ItemSediCoalRock(int par1)
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
                           name = "anthracite";
                           break;
                    }
                    case 1:
                    {
                           name = "bituminouscoal";
                           break;
                    }
                    case 2:
                    {
                           name = "browncoal";
                           break;
                    }
                    case 3:
                    {
                           name = "lignite";
                           break;
                    }
                    case 4:
                    {
                           name = "graphite";
                           break;
                    }
                    case 5:
                    {
                           name = "peacockcoal";
                           break;
                    }
                    case 6:
                    {
                           name = "marlstone";
                           break;
                    }
                    case 7:
                    {
                           name = "greymarlstone";
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