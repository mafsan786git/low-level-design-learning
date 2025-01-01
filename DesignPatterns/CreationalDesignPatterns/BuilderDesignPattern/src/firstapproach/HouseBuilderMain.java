package firstapproach;

public class HouseBuilderMain {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector(new ConcreteHouseBuilder());
        House basicHouse = houseDirector.constructBasicHouse();
        System.out.println("Basic firstapproach.House: " + basicHouse.toString());

        House luxuryHouse = houseDirector.constructLuxuryHouse();
        System.out.println("Luxury firstapproach.House: " + luxuryHouse.toString());
    }
}
