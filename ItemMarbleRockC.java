package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockC extends ItemBlock
{
       public ItemMarbleRockC(int par1)
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
                           name = "marblecreole";
                           break;
                    }
                    case 1:
                    {
                           name = "marbleduquesarosa";
                           break;
                    }
                    case 2:
                    {
                           name = "marbleemperador";
                           break;
                    }
                    case 3:
                    {
                           name = "marbleforestgreen";
                           break;
                    }
                    case 4:
                    {
                           name = "marblegreyaliveri";
                           break;
                    }
                    case 5:
                    {
                           name = "marblegriotteoeildeperdrix";
                           break;
                    }
                    case 6:
                    {
                           name = "marblegriotterouge";
                           break;
                    }
                    case 7:
                    {
                           name = "marblehaumontbizantine";
                           break;
                    }
                    case 8:
                    {
                           name = "marblehautacamivory";
                           break;
                    }
                    case 9:
                    {
                           name = "marbleimperialdanby";
                           break;
                    }
                    case 10:
                    {
                           name = "marbleimperialpink";
                           break;
                    }
                    case 11:
                    {
                           name = "marbleincarna";
                           break;
                    }
                    case 12:
                    {
                           name = "marbleirishconne";
                           break;
                    }
                    case 13:
                    {
                           name = "marblelevanto";
                           break;
                    }
                    case 14:
                    {
                           name = "marblemainered";
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