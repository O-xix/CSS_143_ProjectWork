import java.awt.*;
import java.util.Random;

public class Ingredient implements Comparable {
    public final String description;
    public final Money cost;
    public final int calories;

    /**
     * Variable constructor for Ingredient object.
     * @param description String representation of the description of the ingredient.
     * @param cost Money representation of the price of the Ingredient.
     * @param calories int representation of the amount of calories the Ingredient has.
     */
    public Ingredient(String description, Money cost, int calories) {
        this.description = description;
        this.cost = new Money(cost);
        this.calories = calories;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
    @Override
    public String toString() {
        return description + " || " + cost.toString() + " || " + calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient) {
            return (description.equals(((Ingredient) obj).description) && cost.equals(((Ingredient) obj).cost)) && (calories == ((Ingredient) obj).calories);
        }
        return false;
    }
}
class Base extends Ingredient {
    /**
     * Variable constructor for Base object.
     * @param description String representation of the description of the base.
     * @param cost Money representation of the price of the Base.
     * @param calories int representation of the amount of calories the Base has.
     */
    public Base(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}
class Marinara extends Base {
    /**
     * Variable constructor for Marinara object.
     * @param description String representation of the description of the marinara.
     * @param cost Money representation of the price of the Marinara.
     * @param calories int representation of the amount of calories the Marinara has.
     */
    public Marinara(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
    
}
class Alfredo extends Base {
    /**
     * Variable constructor for Alfredo object.
     * @param description String representation of the description of the Alfredo.
     * @param cost Money representation of the price of the Alfredo.
     * @param calories int representation of the amount of calories the Alfredo has.
     */
    public Alfredo(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
    
}
class Cheese extends Ingredient {
    /**
     * Variable constructor for Cheese object.
     * @param description String representation of the description of the Cheese.
     * @param cost Money representation of the price of the Cheese.
     * @param calories int representation of the amount of calories the Cheese has.
     */
    public Cheese(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}
class Mozzarella extends Cheese {
    /**
     * Variable constructor for Mozzarella object.
     * @param description String representation of the description of the Mozzarella.
     * @param cost Money representation of the price of the Mozzarella.
     * @param calories int representation of the amount of calories the Mozzarella has.
     */
    public Mozzarella(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
    
}
class Goat extends Cheese {
    /**
     * Variable constructor for Goat object.
     * @param description String representation of the description of the Goat.
     * @param cost Money representation of the price of the Goat.
     * @param calories int representation of the amount of calories the Goat has.
     */
    public Goat(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
    
}
class Vegetable extends Ingredient {
    Color myColor;
    /**
     * Variable constructor for Vegetable object.
     * @param description String representation of the description of the Vegetable.
     * @param cost Money representation of the price of the Vegetable.
     * @param calories int representation of the amount of calories the Vegetable has.
     */
    public Vegetable(String description, Money cost, int calories) {
        super(description, cost, calories);
        Random random = new Random();
        myColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    /**
     * Variable constructor for Vegetable object.
     * @param description String representation of the description of the Vegetable.
     * @param cost Money representation of the price of the Vegetable.
     * @param calories int representation of the amount of calories the Vegetable has.
     * @param myColor Color representation of the color of the Vegetable.
     */
    public Vegetable(String description, Money cost, int calories, Color myColor) {
        super(description, cost, calories);
        this.myColor = myColor;
    }

    /**
     * Retrives the value of the myColor field.
     * @return Color Object in the myColor field.
     */
    public Color getMyColor() {
        return myColor;
    }
    /**
     * Sets the value in the myColor field.
     * @param myColor Color value to set the myColor field. 
     */
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    public String toString() {
        return super.toString() + " color: " + myColor.toString();
    }
    public boolean equals(Object that) {
        if (that instanceof Vegetable) {
            Vegetable i = (Vegetable) that;
            return (this.myColor.equals(i.myColor) || super.equals(i));
        }
        return false;
    }
}
class Pepper extends Vegetable {
    /**
     * Variable constructor for Pepper object.
     * @param description String representation of the description of the Pepper.
     * @param cost Money representation of the price of the Pepper.
     * @param calories int representation of the amount of calories the Pepper has.
     */
    public Pepper(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
    
}
class Olive extends Vegetable {
    /**
     * Variable constructor for Olive object.
     * @param description String representation of the description of the Olive.
     * @param cost Money representation of the price of the Olive.
     * @param calories int representation of the amount of calories the Olive has.
     */
    public Olive(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}
class Meat extends Ingredient {
    /**
     * Variable constructor for Meat object.
     * @param description String representation of the description of the Meat.
     * @param cost Money representation of the price of the Meat.
     * @param calories int representation of the amount of calories the Meat has.
     */
    public Meat(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}
class Pepperoni extends Meat {
    /**
     * Variable constructor for Pepperoni object.
     * @param description String representation of the description of the Pepperoni.
     * @param cost Money representation of the price of the Pepperoni.
     * @param calories int representation of the amount of calories the Pepperoni has.
     */
    public Pepperoni(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}
class Sausage extends Meat {
    /**
     * Variable constructor for Sausage object.
     * @param description String representation of the description of the Sausage.
     * @param cost Money representation of the price of the Sausage.
     * @param calories int representation of the amount of calories the Sausage has.
     */
    public Sausage(String description, Money cost, int calories) {
        super(description, cost, calories);
        //TODO Auto-generated constructor stub
    }
}