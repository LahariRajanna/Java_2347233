abstract class Train {
    private String trainName;
    private String trainNumber;
    private String source;
    private String destination;
    private int numberOfCoaches;

    public Train(String trainName, String trainNumber, String source, String destination, int numberOfCoaches) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.numberOfCoaches = numberOfCoaches;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getNumberOfCoaches() {
        return numberOfCoaches;
    }

    public abstract void printTrainDetails();

    public final void printTrainType() {
        System.out.println("This is a passenger train.");
    }
}

class ExpressTrain extends Train {
    private String expressType;

    public ExpressTrain(String trainName, String trainNumber, String source, String destination, int numberOfCoaches,
            String expressType) {
        super(trainName, trainNumber, source, destination, numberOfCoaches);
        this.expressType = expressType;
    }

    public void printTrainDetails() {
        System.out.println("Train Name: " + getTrainName());
        System.out.println("Train Number: " + getTrainNumber());
        System.out.println("Source: " + getSource());
        System.out.println("Destination: " + getDestination());
        System.out.println("Number of Coaches: " + getNumberOfCoaches());
        System.out.println("Express Type: " + expressType);
    }
}

public class Railways {
    public static void main(String[] args) {
        Train train = new ExpressTrain("Rajdhani Express", "12309", "New Delhi", "Mumbai", 20, "AC");
        train.printTrainDetails();
        train.printTrainType();
    }
}
