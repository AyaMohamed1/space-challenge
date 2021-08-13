public class Item implements Comparable {
    public String name;
    public int weight;
    Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        int compareWeight = ((Item) o).weight;
        return weight - compareWeight;
    }
}
