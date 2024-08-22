public class Parkhaus {
    private int capacity = 5;
    private int stockwerk;

    public int getStockwerk() {
        return stockwerk;
    }

    public void setStockwerk(int stockwerk) {
        this.stockwerk = stockwerk;
    }

    public int getCapacity() {
        return capacity;

    }

    public void carEnters(){
        this.capacity = capacity - 1;
        System.out.println("");
    }

    public void carLeaves(){
        this.capacity = capacity + 1;
    }
}
