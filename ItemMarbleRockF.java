package geology;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMarbleRockF extends ItemBlock
{
       public ItemMarbleRockF(int par1)
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
                           name = "marblepinkgranite";
                           break;
                    }
                    case 1:
                    {
                           name = "marblebiancocarrara";
                           break;
                    }
                    case 2:
                    {
                           name = "marblenumidia";
                           break;
                    }
                    case 3:
                    {
                           name = "marblebotticinofiorito";
                           break;
                    }
                    case 4:
                    {
                           name = "marblechineseredporphyry";
                           break;
                    }
                    case 5:
                    {
                           name = "marblecorchia";
                           break;
                    }
                    case 6:
                    {
                           name = "marblecremodelicato";
                           break;
                    }
                    case 7:
                    {
                           name = "marbledamasco";
                           break;
                    }
                    case 8:
                    {
                           name = "marblegaulgreygranite";
                           break;
                    }
                    case 9:
                    {
                           name = "marblediaspro";
                           break;
                    }
                    case 10:
                    {
                           name = "marbledomiciannumidian";
                           break;
                    }
                    case 11:
                    {
                           name = "marblefiordipescoclassico";
                           break;
                    }
                    case 12:
                    {
                           name = "marblebrownfossil";
                           break;
                    }
                    case 13:
                    {
                           name = "marblegialloantico";
                           break;
                    }
                    case 14:
                    {
                           name = "marblegiallosienna";
                           break;
                    }
                    case 15:
                    {
                           name = "marbleimperialredporphyry";
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