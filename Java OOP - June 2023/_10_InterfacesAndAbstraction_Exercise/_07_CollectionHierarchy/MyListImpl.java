package _10_InterfacesAndAbstraction_Exercise._07_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
