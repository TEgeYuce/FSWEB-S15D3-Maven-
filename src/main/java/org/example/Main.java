package org.example;
import java.util.*;
import org.example.entity.Employee;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(2, "Ayşe", "Aydın"));
        employees.add(new Employee(2, "Ayşe", "Aydın"));
        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(3, "Ahmet", "Gündüz"));
        employees.add(new Employee(4, "Ece", "Sönmez"));

        System.out.println("Listenin Orijinal Hali: \n");
        employees.forEach(System.out::println);

        System.out.println("***************************");

        System.out.println("Duplicate / Tekrar Eden Elemanlar: \n");
        findDuplicates(employees).forEach(System.out::println);

        System.out.println("***************************");

        System.out.println("Unique / Benzersiz Elemanlar: \n");
        findUniques(employees).forEach((id, emp) -> System.out.println(emp));

        System.out.println("***************************");

        System.out.println("Remove Duplicates -> Tekrar eden elemanlar kaldırıldı, sadece unique elemanlar kaldı: ");
        removeDuplicates(employees).forEach(System.out::println);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();
        for (Employee e : employees) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
            if (countMap.get(e.getId()) == 2) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> result = new HashMap<>();
        for (Employee e : employees) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }
        for (Employee e : employees) {
            if (e == null) continue;
            if (countMap.get(e.getId()) >= 1) {
                result.putIfAbsent(e.getId(), e);
            }
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> uniques = new LinkedList<>();
        for (Employee e : employees) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }
        for (Employee e : employees) {
            if (e == null) continue;
            if (countMap.get(e.getId()) == 1) {
                uniques.add(e);
            }
        }
        return uniques;
    }

}

