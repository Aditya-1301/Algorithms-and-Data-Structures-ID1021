package HP35_Assignment2;

public class Item {
    private ItemType type;
    private int value;

    Item(ItemType type){
        if(type != ItemType.VALUE ){
            this.type = type;
        }
    }
    Item(ItemType itemType, int value){
        this.type = itemType;
        this.value = value;
    }

    ItemType getType(){
        return this.type;
    }

    int getValue(){
        return this.value;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
