package firstapproach;

public interface HouseBuilder {
    void reset();

    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void addGarden();
    void addSwimmingPool();

    House getHouse();
}
