package _10_InterfacesAndAbstraction_Exercise._07_CollectionHierarchy;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        super.items.add(item);
        return items.size() - 1;
    }
}
