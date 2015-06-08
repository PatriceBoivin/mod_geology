package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockG extends ItemBlock
{
       public ItemMarbleRockG(int par1)
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
                           name = "marbleredporphyry";
                           break;
                    }
                    case 1:
                    {
                           name = "marbleromanredgranite";
                           break;
                    }
                    case 2:
                    {
                           name = "marbleporphyry";
                           break;
                    }
                    case 3:
                    {
                           name = "marblemoroccanyellow";
                           break;
                    }
                    case 4:
                    {
                           name = "marblemalachite";
                           break;
                    }
                    case 5:
                    {
                           name = "marblewhite";
                           break;
                    }
                    case 6:
                    {
                           name = "marblemoroccanvolubitis";
                           break;
                    }
                    case 7:
                    {
                           name = "marbleimperialmaroon";
                           break;
                    }
                    case 8:
                    {
                           name = "marblecalacattacarrara";
                           break;
                    }
                    case 9:
                    {
                           name = "marblecalacattavagli";
                           break;
                    }
                    case 10:
                    {
                           name = "marblebardigliocapella";
                           break;
                    }
                    case 11:
                    {
                           name = "marblegialloelisa";
                           break;
                    }
                    case 12:
                    {
                           name = "marblegialloreale";
                           break;
                    }
                    case 13:
                    {
                           name = "marblecremavalencia";
                           break;
                    }
                    case 14:
                    {
                           name = "marblepentelicon";
                           break;
                    }
                    case 15:
                    {
                           name = "marblecasablancawhite";
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