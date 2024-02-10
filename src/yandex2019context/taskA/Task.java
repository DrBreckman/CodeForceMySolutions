package yandex2019context.taskA;

import java.util.*;

public class Task {
    public record DishParams(String name, int amount, ArrayList<IngredientParams> ingredients) { }
    public record IngredientParams(String name, int amount) { }
    public record CatalogIngredientParams(int cost, int amount) { }
    public record CaloriesIngredientParams(int amount, double[] calories) { }

    public static void main(String[] args) {
        ArrayList<DishParams> dishes = new ArrayList<>();
        LinkedHashMap<String, CatalogIngredientParams> ingredientCatalog = new LinkedHashMap<>();
        LinkedHashMap<String, CaloriesIngredientParams> ingredientCalories = new LinkedHashMap<>();

        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        for(int i = 0; i < amount; i++){
            dishes.add(new DishParams(in.next(), in.nextInt(), new ArrayList<>()));
            int ingredientsAmount = in.nextInt();
            for(int j = 0; j < ingredientsAmount; j++){
                dishes.getLast().ingredients.add(new IngredientParams(in.next(), massConverter(in.nextInt(), in.next())));
            }
        }
        amount = in.nextInt();
        for(int i = 0; i < amount; i++){
            ingredientCatalog.put(in.next(), new CatalogIngredientParams(in.nextInt(), massConverter(in.nextInt(), in.next())));
        }
        amount = in.nextInt();
        for(int i = 0; i < amount; i++){
            String name = in.next();
            ingredientCalories.put(name, new CaloriesIngredientParams(massConverter(in.nextInt(), in.next()), new double[] { 0, 0, 0, 0 }));
            for(int j = 0; j < 4; j++){
                ingredientCalories.get(name).calories[j] = Double.parseDouble(in.next());
            }
        }
        in.close();

        long totalCost = 0;
        LinkedHashMap<String, Long> buyingIngredients = new LinkedHashMap<>();
        for(var i : ingredientCatalog.keySet()){
            buyingIngredients.put(i, 0L);
        }
        for(var dish : dishes){
            for(var ingredient : dish.ingredients){
                int needed = ingredient.amount * dish.amount;
                buyingIngredients.replace(ingredient.name, needed + buyingIngredients.get(ingredient.name));
            }
        }
        for(var i : buyingIngredients.entrySet()){
            var ingredientParams = ingredientCatalog.get(i.getKey());
            long buying = (long) Math.ceil((double) i.getValue() / ingredientParams.amount);
            totalCost += buying * ingredientParams.cost;
            buyingIngredients.replace(i.getKey(), buying);
        }

        System.out.println(totalCost);
        for(var ingredient : buyingIngredients.entrySet()){
            System.out.println(ingredient.getKey() + " " + ingredient.getValue());
        }

        for(var dish : dishes){
            double[] calories = new double[] { 0,0,0,0 };
            for(var ingredient : dish.ingredients) {
                var ingredientParams = ingredientCalories.get(ingredient.name);
                double mass = (double) ingredient.amount / ingredientParams.amount;
                for(int i = 0; i < ingredientParams.calories.length; i++){
                    calories[i] += mass * ingredientParams.calories[i];
                }
            }
            System.out.printf("%s %f %f %f %f\n", dish.name, calories[0], calories[1], calories[2], calories[3]);
        }
    }

    public static int massConverter(int value, String mass) {
        return value * switch(mass){
            case "kg", "l" -> 1000;
            case "tens" -> 10;
            default -> 1;
        };
    }
}