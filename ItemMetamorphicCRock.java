package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetamorphicCRock extends ItemBlock
{
       public ItemMetamorphicCRock(int par1)
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
                           name = "sanidinite";
                           break;
                    }
                    case 1:
                    {
                           name = "anthophyllite";
                           break;
                    }
                    case 2:
                    {
                           name = "phylite";
                           break;
                    }
                    case 3:
                    {
                           name = "gwskarn";
                           break;
                    }
                    case 4:
                    {
                           name = "askarn";
                           break;
                    }
                    case 5:
                    {
                           name = "agdmsskarn";
                           break;
                    }
                    case 6:
                    {
                           name = "lskarn";
                           break;
                    }
                    case 7:
                    {
                           name = "ihskarn";
                           break;
                    }
                    case 8:
                    {
                           name = "mgskarn";
                           break;
                    }
                    case 9:
                    {
                           name = "skarn";
                           break;
                    }
                    case 10:
                    {
                           name = "hauynite";
                           break;
                    }
                    case 11:
                    {
                           name = "plasmaheliotrope";
                           break;
                    }
                    case 12:
                    {
                           name = "cordierite";
                           break;
                    }
                    case 13:
                    {
                           name = "quartzite";
                           break;
                    }
                    case 14:
                    {
                           name = "tactite";
                           break;
                    }
                    case 15:
                    {
                           name = "smithsonite";
                           break;
                    }

             }
             return getUnlocalizedName() + "." + name;
       } 
      
       public int getMetadata(int par1)
       {
             return par1;
       } 
}