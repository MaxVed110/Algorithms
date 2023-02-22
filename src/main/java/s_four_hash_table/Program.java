package s_four_hash_table;

public class Program {
    public static void main(String[] args) {
        // Employee em1 = new Employee();
        // System.out.println(em1.hashCode());

        HashMap<String, Employee> hashMap = new HashMap<>();
        Employee e1 = hashMap.put("add", new Employee("Aaa", 23));
        Employee e2 = hashMap.put("art", new Employee("Bbb", 74));
        Employee e3 = hashMap.put("add", new Employee("Ddd", 12));
        Employee e8 = hashMap.put("adghhd", new Employee("Ggg", 24));

        Employee e4 = hashMap.remove("add");
        Employee e5 = hashMap.remove("add");
        Employee e6 = hashMap.get("add");
        Employee e7 = hashMap.get("art");
    }
}


class Employee{
    String name;
    int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
}
