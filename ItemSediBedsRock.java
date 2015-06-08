package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSediBedsRock extends ItemBlock
{
       public ItemSediBedsRock(int par1)
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
                           name = "alabaster";
                           break;
                    }
                    case 1:
                    {
                           name = "anhydrite";
                           break;
                    }
                    case 2:
                    {
                           name = "calcrete";
                           break;
                    }
                    case 3:
                    {
                           name = "bonebed";
                           break;
                    }
                    case 4:
                    {
                           name = "caustobiolith";
                           break;
                    }
                    case 5:
                    {
                           name = "contourite";
                           break;
                    }
                    case 6:
                    {
                           name = "flysch";
                           break;
                    }
                    case 7:
                    {
                           name = "molasse";
                           break;
                    }
                    case 8:
                    {
                           name = "oolite";
                           break;
                    }
                    case 9:
                    {
                           name = "shellbed";
                           break;
                    }
                    case 10:
                    {
                           name = "tempestite";
                           break;
                    }
                    case 11:
                    {
                           name = "sulfurbed";
                           break;
                    }
                    case 12:
                    {
                           name = "beigeanhydrite";
                           break;
                    }
                    case 13:
                    {
                           name = "greenanhydrite";
                           break;
                    }
                    case 14:
                    {
                           name = "pinkanhydrite";
                           break;
                    }
                    case 15:
                    {
                           name = "blueanhydrite";
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