package hg.hg_android_client.model;

public class Car {
    private final String patent;
    private final String model;

    public Car(String patent, String model) {
        this.patent = patent;
        this.model = model;
    }

    public String getPatent() {
        return patent;
    }

    public String getModel() {
        return model;
    }

}
