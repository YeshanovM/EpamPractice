package task1;

public class Runner {
    public static void run() {
        Store store = new Store("Store", 4);
        store.productsSupply(new Product[]{
                new Product("T-Shirt", "Clothes"),
                new Product("Shirt", "Clothes"),
                new Product("Hamburger", "Food"),
                new Product("Apple", "Food"),
                new Product("Meat", "Food"),
                new Product("Laptop", "Technologies")
        });
        System.out.println(store);
        store.addDepartment("FoodDep", "Food");
        System.out.println(store);
        store.addDepartment("ClothesDep", "Clothes");
        System.out.println(store);
        store.removeDepartment("FoodDep");
        System.out.println(store);
    }
}
