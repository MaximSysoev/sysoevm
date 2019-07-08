package ru.job4j.productStorage;
import java.text.SimpleDateFormat;

public class RControllQuality extends ControllQuality {

    public RControllQuality(Actions actions) {
        super(actions);
    }

    public void execute(RFood rfood) {
        super.execute(rfood);
    }

    public static void main(String[] args) throws Exception {
        RControllQuality rControllQuality1 = new RControllQuality(new AdditionalWarehouse());
        rControllQuality1.execute(new RFood("Sugar", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"),10,0,false));

        RControllQuality rControllQuality2 = new RControllQuality(new LowTemperatureWarehouse());
        rControllQuality2.execute(new RFood("Potato", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true));

        RControllQuality rControllQuality3 = new RControllQuality(new TrashReproduct());
        rControllQuality3.execute(new RFood("Apple", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2019"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true));
    }
}
