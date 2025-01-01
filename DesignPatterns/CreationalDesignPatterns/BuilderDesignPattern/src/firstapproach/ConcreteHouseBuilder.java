package firstapproach;

public class ConcreteHouseBuilder implements HouseBuilder{
    private House house;

    public ConcreteHouseBuilder(){
        this.house = new House();
    }

    @Override
    public void reset(){
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wood and Brick Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Shingle Roof");
    }

    @Override
    public void addGarden() {
        house.setHasGarden(true);
    }

    @Override
    public void addSwimmingPool() {
        house.setHasSwimmingPool(true);
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
