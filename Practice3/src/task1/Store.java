package task1;

import java.util.*;

public class Store {

    private String name;
    private int departmentsCount;
    private Department[] departments;
    private LinkedList<Product> products;

    public Store(String name, int departmentsCount) {
        this.name = name;
        this.departmentsCount = departmentsCount;
        this.departments = new Department[departmentsCount];
        this.products = new LinkedList<>();
    }

    public void productsSupply(Product[] products) {
        for(Product product : products) {
            boolean toStock = true;
            for(Department department : departments) {
                if(department != null && department.productType.equals(product.getType())) {
                    department.addProduct(product);
                    toStock = false;
                    break;
                }
            }
            if(toStock)
                this.products.add(product);
        }
    }

    public void addDepartment(String name, String productType) {
        for(Department department : departments) {
            if(department != null && (
               department.name.equals(name) ||
               department.productType.equals(productType))) {
                return;
            }
        }
        int index = -1;
        for(int i = 0; i < departmentsCount; i++) {
            if(departments[i] == null) {
                departments[i] = new Department(name, productType);
                index = i;
                break;
            }
        }
        if(index == -1)
            return;
        for(Product product : products) {
            if(product.getType().equals(productType)) {
                departments[index].addProduct(product);
            }
        }
        for(Product product : departments[index].products) {
            products.remove(product);
        }
    }

    public void removeDepartment(String name) {
        for(int i = 0; i < departmentsCount; i++) {
            if(departments[i] != null && departments[i].name.equals(name)) {
                for(Product product : departments[i].products) {
                    products.add(product);
                }
                departments[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", departmentsCount=" + departmentsCount +
                ", departments=" + Arrays.toString(departments) +
                ", products=" + products +
                '}';
    }

    private class Department {
        private String name;
        private String productType;
        private LinkedList<Product> products;

        public Department(String name) {
            this.name = name;
            products = new LinkedList<>();
        }

        public Department(String name, String productType) {
            this(name);
            this.productType = productType;
        }

        public void addProduct(Product newProduct) {
            products.add(newProduct);
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", productType='" + productType + '\'' +
                    ", products=" + products +
                    '}';
        }
    }
}
