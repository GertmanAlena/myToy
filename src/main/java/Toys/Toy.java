package Toys;

public class Toy implements Toy_Interf {

    private int id;
    private String name;
    private int count;
    private double weight;
    private double probability;

    public Toy() {
    }
    public Toy(String name, int count, double weight) {
        this.name = name;
        this.count = count;
        this.weight = weight;

    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getCount() {
        return count;
    }
    @Override
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public double getProbability() {
        return probability;
    }
    @Override
    public void setProbability(double weight) {

        this.probability = weight / 100 * weight;
    }

    @Override
    public String toString() {
//        return "id=" + id +
//                ", name='" + name + '\'' +
//                ", count=" + count +
//                ", weight=" + weight +
//                ", probability=" + probability;
        return "ID:" + id + ", name: " + name + ", count: " + count + ", weight: " + weight + ", probability: " + probability + "]";
    }
}
