import java.util.Random;


public class Pizza implements PizzaComparable {
    ArrayList<Ingredient> ingredients;
    Shape shape;
    Money cost;
    static int calorieTotal;
    Fraction remainingPizza;

    public Pizza() {
        ingredients = new ArrayList<>();
        cost = new Money(0.0);

        //Fraction setting
        this.remainingPizza = new Fraction(1, 1);

        //Random Shape shape
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            shape = new Square(random.nextInt(10) + 1, random.nextInt(10) + 1);
        }
        else {
            shape = new Circle(random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1);
        }

        //Random calorieTotal 
        int continueIngredient = 0;
        int bound = 0;
        int ingredientChoice;
        while (continueIngredient == 0) {
            ingredientChoice = random.nextInt(8);

            switch (ingredientChoice) {
                case 0: ingredientChoice = 0;
                    addIngredient(new Marinara("a sauce made from tomatoes, onions, and herbs", new Money(0.50), 20));
                case 1: ingredientChoice = 1;
                    addIngredient(new Alfredo("a sauce incorporating butter, cream, garlic, and Parmesan cheese", new Money(0.75), 50));
                case 2: ingredientChoice = 2;
                    addIngredient(new Mozzarella("a mild, semisoft white Italian cheese", new Money(1.00), 80));
                case 3: ingredientChoice = 3;
                    addIngredient(new Goat("cheese made from goat's milk", new Money(1.50), 75));
                case 4: ingredientChoice = 4;
                    addIngredient(new Pepperoni("beef and pork sausage seasoned with pepper", new Money(1.25), 100));
                case 5: ingredientChoice = 5;
                    addIngredient(new Sausage("minced and seasoned pork meat", new Money(1.20), 90));
                case 6: ingredientChoice = 6;
                    addIngredient(new Pepper("a variety of capsicum which has a mild or sweet flavor", new Money(0.30), 10));
                case 7: ingredientChoice = 7;
                    addIngredient(new Olive("a small oval fruit with a hard pit and bitter flesh", new Money(0.40), 25));
                default:
                    break;
            }

            bound++;
            continueIngredient = random.nextInt(bound);
        }
    }
    /**
     * To add Ingredient Objects to Ingredients ArrayList.
     * @param a Ingredient Object to add.
     */
    public void addIngredient(Ingredient a) {
        ingredients.add(a);
        cost.add(a.cost);
        calorieTotal += a.calories;
    }
    /**
     * To reduce the Fraction remainingPizza by a Fraction object representating the portion to be eaten.
     * @param amt Fraction object representating the amount to be eaten.
     * @throws PizzaException Exception to throw.
     */
    public void eatSomePizza(Fraction amt) throws PizzaException {
        if (amt.numerator == 0) {
            throw new PizzaException("Subtracting 0 from the Pizza Size.");
        }
        else if (amt.numerator < 0 || amt.denominator < 0) {
            throw new PizzaException("Subtracting less than 0 from the Pizza Size.");
        }
        remainingPizza = new Fraction(remainingPizza.subtract(amt));
        
        //subtract cost
        cost = new Money(cost.getMoney() * remainingPizza.valueOf());

        //subtract calories

    }

    /**
     * Getter for calorieTotal.
     * @return int value of calorieTotal.
     */
    public int getCalorieTotal() {
        return calorieTotal;
    }
    /**
     * Getter for cost.
     * @return Money value of cost.
     */
    public Money getCost() {
        return cost;
    }
    /**
     * Getter for ingredients.
     * @return ArrayList<Ingredient> value of ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    /**
     * Getter for remainingPizza.
     * @return Fraction value of remainingPizza.
     */
    public Fraction getRemainingPizza() {
        return remainingPizza;
    }
    /**
     * Getter for shape.
     * @return Shape value of shape.
     * @throws CloneNotSupportedException
     */
    public Shape getShape() throws CloneNotSupportedException {
        return (Shape) shape.clone();
    }
    /**
     * Getter for remainingArea.
     * @return double value of remainingArea.
     */
    public double getRemainingArea() {
        return (shape.getArea() * remainingPizza.numerator / remainingPizza.denominator);
    }

    /**
     * Setter for calorieTotal.
     * @param calorieTotal new int value for field calorieTotal
     */
    public void setCalorieTotal(int calorieTotal) {
        this.calorieTotal = calorieTotal;
    }
    /**
     * Setter for cost.
     * @param cost new Money value for field cost. 
     */
    public void setCost(Money cost) {
        this.cost = cost;
    }
    /**
     * Setter for ingredients.
     * @param ingredients new ArrayList<Ingredient> value for field ingredients.
     */
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     * Setter for remainingPizza.
     * @param remainingPizza new Fraction value for field remainingPizza.
     */
    public void setRemainingPizza(Fraction remainingPizza) {
        this.remainingPizza = remainingPizza;
    }
    /**
     * Setter for shape.
     * @param shape new Shape value for field shape.
     * @throws CloneNotSupportedException
     */
    public void setShape(Shape shape) throws CloneNotSupportedException {
        this.shape = (Shape) shape.clone();
    }


    @Override
    public String toString() {
        return ("Ingredients: \n" + ingredients.toString() + "\n\nCost: " + cost + "\nCalorieTotal: " + calorieTotal + "\nRemainingPizza: " + remainingPizza.toString() + "\n\n\n");
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Pizza) {
            Pizza that = (Pizza) o;
            return (cost).compareTo(that.cost);
        }
        return -5;
    }

    @Override
    public int compareToBySize(Object o) {
        if (o instanceof Pizza) {
            Pizza that = (Pizza) o;
            return (Double.valueOf(this.shape.getArea())).compareTo(Double.valueOf(that.shape.getArea()));
        }
        return -5;
    }

    @Override
    public int compareToByCalories(Object o) {
        if (o instanceof Pizza) {
            Pizza that = (Pizza) o;
            return (Integer.valueOf(calorieTotal)).compareTo(Integer.valueOf(that.calorieTotal));
        }
        return -5;
    }
    
}
