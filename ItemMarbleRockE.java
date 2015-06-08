package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockE extends ItemBlock
{
       public ItemMarbleRockE(int par1)
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
                           name = "marbleroseenjugerais";
                           break;
                    }
                    case 1:
                    {
                           name = "marblerougelanguedoc";
                           break;
                    }
                    case 2:
                    {
                           name = "marblesaboamrose";
                           break;
                    }
                    case 3:
                    {
                           name = "marblesaintangelocagliansardaigne";
                           break;
                    }
                    case 4:
                    {
                           name = "marblesaintebeaumeyellow";
                           break;
                    }
                    case 5:
                    {
                           name = "marblesarrancolincamous";
                           break;
                    }
                    case 6:
                    {
                           name = "marblesavoieblue";
                           break;
                    }
                    case 7:
                    {
                           name = "marbleserpegiante";
                           break;
                    }
                    case 8:
                    {
                           name = "marbleskyros";
                           break;
                    }
                    case 9:
                    {
                           name = "marblestlaurentblack";
                           break;
                    }
                    case 10:
                    {
                           name = "marblethessosblanc";
                           break;
                    }
                    case 11:
                    {
                           name = "marbletravertinoromano";
                           break;
                    }
                    case 12:
                    {
                           name = "marbleturkishcoffeegold";
                           break;
                    }
                    case 13:
                    {
                           name = "marblevalenciarosa";
                           break;
                    }
                    case 14:
                    {
                           name = "marblevalenciayellow";
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